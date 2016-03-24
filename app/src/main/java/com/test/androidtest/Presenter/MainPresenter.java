package com.test.androidtest.Presenter;

import android.util.Log;
import com.test.androidtest.MyApp;
import com.test.androidtest.adapter.FruitAdapter;
import com.test.androidtest.api.FruitService;
import com.test.androidtest.model.FoodModel.Food;
import com.test.androidtest.model.FoodModel.Hit;
import com.test.androidtest.model.dbModel.FoodRealm;
import com.test.androidtest.ui.MainActivity;
import java.security.SecureRandom;
import javax.inject.Inject;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by alber on 23/03/2016.
 */
public class MainPresenter {

    private FruitAdapter mFruitAdapter;
    @Inject FruitService mService;
    private MainView mMainView; //view
    private FoodRealm mFoodRealm; //model
    private static final String TAG = MainActivity.class.getSimpleName();
//db
    @Inject Realm realm;
    private RealmConfiguration realmConfiguration;

//Constructor
    public MainPresenter(MainView v) {
        mMainView = v;
    }
//Methods
    public MainActivity getContext(){
        return (MainActivity) mMainView;
    }

    public void setRealm(){
        realmConfiguration = new RealmConfiguration.Builder(getContext()).build();

        try{

            //((MyApp) getContext().getApplicationContext()).getNetComponent().inject(getContext());//we wont need it if we use @inject
             realm = ((MyApp)  getContext().getApplicationContext()).getNetComponent().provideRealm();
            Log.i(TAG, " We set realm first ");

        } catch (RealmMigrationNeededException e) {
            try {
                //Encryption generating a key...
                byte[] key = new byte[64];
                new SecureRandom().nextBytes(key);
                RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(getContext())
                        .encryptionKey(key)
                        .build();
                Realm.deleteRealm(realmConfiguration);
                //Realm file has been deleted.
                Realm.getInstance(realmConfiguration);
            } catch (Exception ex) {
                throw ex;
                //No Realm file to remove.
            }
        }

    }
    public void createFoodTable(){
        try {
            realm.beginTransaction();
            mFoodRealm = new FoodRealm();
            mFoodRealm = realm.createObject(FoodRealm.class);
            Log.i(TAG, " We created a food table ");

        }catch( RealmPrimaryKeyConstraintException e){
            e.printStackTrace();
        }finally{
            realm.commitTransaction();
        }
    }

    private void insertIntoFoodRealm(final FoodRealm pFoodRealm, final String foodName, final double foodCalories) {
        try {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) { //do the beginTransaction, cancel in case of error and commit automatically.
                    int pos = realm.where(FoodRealm.class).max("foodKey").intValue() + 1;
                    if (pos >= 0) {
                        pFoodRealm.setFoodKey(pos);
                        pFoodRealm.setFoodName(foodName);
                        pFoodRealm.setFoodCalories(foodCalories);
                        Log.i(TAG, " We added to the db: " + pFoodRealm.getFoodName());
                    }
                    realm.copyToRealm(pFoodRealm);

                }
            });
        }catch (Exception e ){
            Log.e(" Realm Error ", " error " + e);
        } finally {
        }
    }

    public void setAdapter(){
        mFruitAdapter = new FruitAdapter();
        mMainView.getRecyclerView().setAdapter(mFruitAdapter);
        Log.i(TAG, " We set the adapter ");
    }

    public void injectAPI(){
        //((MyApp) getContext().getApplicationContext()).getNetComponent().inject(getContext()); //we wont need it if we use @inject
        mService = ((MyApp)  getContext().getApplicationContext()).getNetComponent().provideFruitService();
    }

    public void injectionRX(){
        //Observable<Fruits> observable = service.getFruits();  //--- Inital api
        Observable<Food> observable = mService.getFood(); //My api of food

        observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Food>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError " + e.getMessage());
                    }

                    @Override
                    public void onNext(Food food) {

                        Log.d(TAG, "onNext " + food.getHits().get(0).getFields().getItemName());

                        for (Hit hit : food.getHits()) {
                            //Add to the db
                            insertIntoFoodRealm(mFoodRealm, hit.getFields().getItemName(), hit.getFields().getNfCalories());
                            //add to the adapter
                            mFruitAdapter.addFruit(hit);
                        }
                    }
                });
    }

}
