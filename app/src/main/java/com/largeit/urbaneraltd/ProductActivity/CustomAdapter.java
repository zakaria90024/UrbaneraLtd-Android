package com.largeit.urbaneraltd.ProductActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.largeit.urbaneraltd.HomeFragment.HomeFragment;
import com.largeit.urbaneraltd.R;
import com.largeit.urbaneraltd.SingleProductDetailsActivity.SingleProductDetailsActivity;
import com.largeit.urbaneraltd.main.model.Product;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<ViewHolder> {

    Context mContext;
    ProductActivity productActivity;
    //HomeActivity homeActivity;
    public List<Product> posts;

    public CustomAdapter(ProductActivity productActivity,  List<Product> posts, Context mContext) {

        //this.homeActivity = homeActivity;
        this.posts = posts;
        this.productActivity = productActivity;
        this.mContext = mContext;
    }

    public void setData(List<Product> posts){
        this.posts = posts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemView);

        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Integer categoryID = posts.get(position).getProductID();
                //Intent to start activity
                String id = String.valueOf(categoryID);

                String product_name = posts.get(position).getProductName();
                String sale_price = posts.get(position).getSalePrice();
                String single_product_image = posts.get(position).getImage();


                Intent intent = new Intent(productActivity, SingleProductDetailsActivity.class);


                intent.putExtra("product_id", id);
                intent.putExtra("product_name", product_name);
                intent.putExtra("sale_price", sale_price);
                intent.putExtra("single_product_image", single_product_image);


             productActivity.startActivity(intent);


            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product post = posts.get(position);
        String dress_name = post.getProductName();
        String product_price = post.getSalePrice();
        String dress_image_url = post.getImage();

        holder.product_name.setText(dress_name);
        holder.product_price.setText(product_price);

        //holder.monako_detils.setText(monako_details);


        String IMAGE_BASE_URL = "https://urbaneraltd.com/frontend_assets/upload_assets/images/product/";
        String imageUrl = IMAGE_BASE_URL + dress_image_url;

        Glide
                .with(productActivity)
                .load(imageUrl)
                .override(200, 200)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .into(holder.product_image);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

}
