package com.largeit.urbaneraltd.HomeFragment.LatestProduct;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.largeit.urbaneraltd.HomeFragment.ViewHolder;
import com.largeit.urbaneraltd.R;


public class LatestProductViewHolder extends RecyclerView.ViewHolder {
    TextView item_latest_product_name_id, item_latest_product_price_id;
    ImageView item_latest_product_image_id;
    View mmView;

    public LatestProductViewHolder(@NonNull View itemView) {
        super(itemView);

        mmView = itemView;
        item_latest_product_name_id = itemView.findViewById(R.id.related_product_name_id);
        item_latest_product_price_id = itemView.findViewById(R.id.related_price_id);
        item_latest_product_image_id = itemView.findViewById(R.id.related_item_image_id);


       itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               mClickListener.onItemClick(v, getAdapterPosition());
           }
       });



    }

    private ViewHolder.ClickListener mClickListener;



    public interface ClickListener{
        void  onItemClick(View view, int position);
    }

    public void setOnClickListener(ViewHolder.ClickListener clickListener) {
        mClickListener = clickListener;
    }


}
