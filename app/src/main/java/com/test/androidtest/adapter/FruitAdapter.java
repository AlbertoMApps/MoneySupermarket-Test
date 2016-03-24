package com.test.androidtest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.test.androidtest.R;
import com.test.androidtest.model.FoodModel.Hit;
import com.test.androidtest.model.FruitModel.Fruit;
import com.test.androidtest.utilities.Constant;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Android Developer
 * @version 1.0.0
 * @date 1/25/2016
 */
public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.Holder> {

    //private List<Fruit> mFruitList;
    private List<Hit> mHitList;

    public FruitAdapter() {
        mHitList = new ArrayList<>();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        //Fruit currentFruit = mFruitList.get(position);
        Hit currentItem = mHitList.get(position);
        holder.mFruitName.setText(currentItem.getFields().getItemName());
        holder.mFruitPrice.setText("Calories: " + currentItem.getFields().getNfCalories());

        //Picasso.with(holder.itemView.getContext()).load("http://" + Constant.HOST + ":" + Constant.PORT + "/simple-fruit-api/api/image/" + currentFruit.getId()).placeholder(R.mipmap.ic_launcher).into(holder.mFruitImage);
    }

    public void addFruit(Hit hit) {
//        mFruitList.add(hit);
        this.mHitList.add(hit);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return this.mHitList.size();
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //@Bind(R.id.fruit_picture) ImageView mFruitImage; --no image in my api...
        @Bind(R.id.fruit_name) TextView mFruitName;
        @Bind(R.id.fruit_price) TextView mFruitPrice;

        public Holder(View itemView) {
            super(itemView);
            //butterknife
            ButterKnife.bind(this, itemView);
//            mFruitImage = (ImageView) itemView.findViewById(R.id.fruit_picture);
//            mFruitName = (TextView) itemView.findViewById(R.id.fruit_name);
//            mFruitPrice = (TextView) itemView.findViewById(R.id.fruit_price);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //Fruit selectedFruit = mFruitList.get(getAdapterPosition());
            Hit selectedHit = mHitList.get(getAdapterPosition());
            Toast.makeText(v.getContext(), "You clicked on " + selectedHit.getFields().getItemName(), Toast.LENGTH_SHORT).show();
            //Toast.makeText(v.getContext(), "You clicked on " + selectedFruit.getName(), Toast.LENGTH_SHORT).show();
        }
    }
}
