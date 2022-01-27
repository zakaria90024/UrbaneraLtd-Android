package com.largeit.urbaneraltd.HomeFragment.TopTwoRecycler;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.largeit.urbaneraltd.HomeFragment.ViewHolder;
import com.largeit.urbaneraltd.R;


public class TopTwoViewHolder extends RecyclerView.ViewHolder {
    TextView product_name_top_two, product_price_top_two;
    ImageView category_thum_top_two;
    View mmView;

    public TopTwoViewHolder(@NonNull View itemView) {
        super(itemView);

        mmView = itemView;
        product_name_top_two = itemView.findViewById(R.id.related_product_name_id);
        product_price_top_two = itemView.findViewById(R.id.related_price_id);
        category_thum_top_two = itemView.findViewById(R.id.related_item_image_id);


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
