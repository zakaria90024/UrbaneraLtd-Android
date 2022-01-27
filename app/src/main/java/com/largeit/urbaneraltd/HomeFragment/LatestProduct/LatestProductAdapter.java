package com.largeit.urbaneraltd.HomeFragment.LatestProduct;

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
//import com.largeit.urbaneraltd.SingleProductDetailsActiviry.SingleProductDetailsActivity;
import com.largeit.urbaneraltd.R;
import com.largeit.urbaneraltd.SingleProductDetailsActivity.SingleProductDetailsActivity;
import com.largeit.urbaneraltd.main.model.LatestProductModel;

import java.util.List;

public class LatestProductAdapter extends RecyclerView.Adapter<LatestProductViewHolder> {

    Context mContext;
    ProductActivity productActivity;
    HomeFragment homeFragment;
    //HomeActivity homeActivity;
    public List<LatestProductModel> posts;

    public LatestProductAdapter(HomeFragment homeFragment, List<LatestProductModel> posts, Context mContext) {

        //this.homeActivity = homeActivity;
        this.posts = posts;
        this.homeFragment = homeFragment;
        this.mContext = mContext;
    }

    public void setDataa(List<LatestProductModel> posts){
        this.posts = posts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LatestProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_latest_product, parent, false);

        LatestProductViewHolder viewHolder = new LatestProductViewHolder(itemView);

        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {

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
                //start activity
                intent.putExtra("sale_price", sale_price);
                intent.putExtra("single_product_image", single_product_image);

                mContext.startActivity(intent);


            }
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LatestProductViewHolder holder, int position) {
        LatestProductModel post = posts.get(position);
        String dress_name = post.getProductName();
        String product_price = post.getSalePrice();
        String dress_image_url = post.getImage();


        holder.item_latest_product_name_id.setText(dress_name);
        holder.item_latest_product_price_id.setText("৳"+product_price);

                //holder.monako_detils.setText(monako_details);

        String IMAGE_BASE_URL = "https://urbaneraltd.com/frontend_assets/upload_assets/images/product/";
        String imageUrl = IMAGE_BASE_URL + dress_image_url;

        Glide
                .with(mContext)
                .load(imageUrl)
                .override(150, 150)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .into(holder.item_latest_product_image_id);

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

}
