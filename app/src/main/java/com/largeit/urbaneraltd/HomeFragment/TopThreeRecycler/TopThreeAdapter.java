package com.largeit.urbaneraltd.HomeFragment.TopThreeRecycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.largeit.urbaneraltd.HomeFragment.HomeFragment;
import com.largeit.urbaneraltd.HomeFragment.ViewHolder;
import com.largeit.urbaneraltd.ProductActivity.ProductActivity;
import com.largeit.urbaneraltd.R;
import com.largeit.urbaneraltd.SingleProductDetailsActivity.SingleProductDetailsActivity;
import com.largeit.urbaneraltd.main.model.TopOneModel;


import java.util.List;

public class TopThreeAdapter extends RecyclerView.Adapter<TopThreeViewHolder> {

    Context mContext;
    ProductActivity productActivity;
    HomeFragment homeFragment;
    //HomeActivity homeActivity;
    public List<TopOneModel> posts;

    public TopThreeAdapter(HomeFragment homeFragment, List<TopOneModel> posts, Context mContext) {

        //this.homeActivity = homeActivity;
        this.posts = posts;
        this.homeFragment = homeFragment;
        this.mContext = mContext;
    }

    public void setDataa(List<TopOneModel> posts){
        this.posts = posts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TopThreeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topthree, parent, false);

        TopThreeViewHolder viewHolder = new TopThreeViewHolder(itemView);

        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                //Toast.makeText(mContext, "clicked", Toast.LENGTH_SHORT).show();

                Integer categoryID = posts.get(position).getProductID();
                //Intent to start activity
                String id = String.valueOf(categoryID);
                String product_name = posts.get(position).getProductName();
                String sale_price = posts.get(position).getSalePrice();

                String single_product_image = posts.get(position).getImage();


                Intent intent = new Intent(mContext, SingleProductDetailsActivity.class);
                //put data in intent
                intent.putExtra("product_id", id);
                intent.putExtra("product_name", product_name);
                intent.putExtra("sale_price", sale_price);
                intent.putExtra("single_product_image", single_product_image);

                mContext.startActivity(intent);


            }
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TopThreeViewHolder holder, int position) {
        TopOneModel post = posts.get(position);
        String dress_name = post.getProductName();
        String product_price = post.getSalePrice();
        String dress_image_url = post.getImage();


        holder.product_name_top_one.setText(dress_name);
        holder.product_price_top_one.setText("৳"+product_price);

                //holder.monako_detils.setText(monako_details);

        String IMAGE_BASE_URL = "https://urbaneraltd.com/frontend_assets/upload_assets/images/product/";
        String imageUrl = IMAGE_BASE_URL + dress_image_url;

        Glide
                .with(mContext)
                .load(imageUrl)
                .override(150, 150)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .into(holder.category_thum_top_one);

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

}
