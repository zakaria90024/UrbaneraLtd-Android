package com.largeit.urbaneraltd.SingleProductDetailsActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.largeit.urbaneraltd.CategoryFragment.CategoryActivity;
import com.largeit.urbaneraltd.SingleProductDetailsActivity.ViewHolder;
import com.largeit.urbaneraltd.SingleProductDetailsActivity.SingleProductDetailsActivity;
import com.largeit.urbaneraltd.R;
import com.largeit.urbaneraltd.main.model.RelateProductModel;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<ViewHolder> {

    Context mContext;
    //HomeFragment homeFragment;
    SingleProductDetailsActivity productActivity;

    SingleProductDetailsActivity homeActivity;
    public List<RelateProductModel> posts;

    public CustomAdapter(SingleProductDetailsActivity homeActivity, List<RelateProductModel> posts, Context mContext) {

        //this.homeActivity = homeActivity;
        this.posts = posts;
        this.homeActivity = homeActivity;
        this.mContext = mContext;
    }

    public void setData(List<RelateProductModel> posts){
        this.posts = posts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_related_product, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemView);
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


                Intent intent = new Intent(homeActivity, SingleProductDetailsActivity.class);
                //put data in intent
                intent.putExtra("product_id", id);
                intent.putExtra("product_name", product_name);
                intent.putExtra("sale_price", sale_price);
                intent.putExtra("single_product_image", single_product_image);

                homeActivity.startActivity(intent);


//                Integer categoryID = posts.get(position).getCategoryID();
//                //Intent to start activity
//                String id = String.valueOf(categoryID);
//
//                String categoryName = posts.get(position).getCategoryName();
//
//
//                Intent intent = new Intent(homeActivity, SingleProductDetailsActivity.class);
//                //put data in intent
//                intent.putExtra("category_id", id);
//                //start activity
//                intent.putExtra("category_name", categoryName);
//
//
//                homeActivity.startActivity(intent);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RelateProductModel post = posts.get(position);
        String dress_name = post.getProductName();
        String dress_price = post.getSalePrice();
        String dress_image_url = post.getImage();

        holder.product_name.setText(dress_name);
        holder.product_price.setText(dress_price);


        String IMAGE_BASE_URL = "https://urbaneraltd.com/frontend_assets/upload_assets/images/product/";
        String imageUrl = IMAGE_BASE_URL + dress_image_url;

        Glide
                .with(homeActivity)
                .load(imageUrl)
                .override(350, 350)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .into(holder.product_thum);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

}
