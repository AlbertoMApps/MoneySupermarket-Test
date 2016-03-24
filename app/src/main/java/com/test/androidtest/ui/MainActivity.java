package com.test.androidtest.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import com.test.androidtest.Presenter.MainPresenter;
import com.test.androidtest.Presenter.MainView;
import com.test.androidtest.R;
import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * @author Android Developer
 * @version 1.0.0
 * @date 1/25/2016
 */
public class MainActivity extends AppCompatActivity implements MainView {

    @Bind(R.id.fruit_recycler_view) RecyclerView mFruitRecyclerView;
    @Bind(R.id.toolbar) Toolbar mToolbar;
    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configViews();
        mPresenter = new MainPresenter(this);
        //setRealm
        mPresenter.setRealm();
        mPresenter.createFoodTable();
        //setAdapter
        mPresenter.setAdapter();
       // FruitService service = new RestApiManager().getFruitService(); //api
        //Getting the api FruitService...
        injectionRX();
    }

    private void injectionRX() {
        //First inject the api
         mPresenter.injectAPI();
        //Secondly, we will injectRX, modelApi to the db and adapter
         mPresenter.injectionRX();
    }

    private void configViews() {
        //butterknife
        ButterKnife.bind(this);
        //toolbar
        //mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setSubtitleTextColor(getResources().getColor(R.color.white));
        mToolbar.setTitle("Android Test");
        setSupportActionBar(mToolbar);
        //recycler view conf
        mFruitRecyclerView = (RecyclerView) findViewById(R.id.fruit_recycler_view);
        mFruitRecyclerView.setHasFixedSize(true);
        mFruitRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mFruitRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        mFruitRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public RecyclerView getRecyclerView() {
        return mFruitRecyclerView;
    }
}
