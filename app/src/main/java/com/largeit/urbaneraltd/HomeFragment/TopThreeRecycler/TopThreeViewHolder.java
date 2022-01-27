package com.largeit.urbaneraltd.HomeFragment.TopThreeRecycler;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.largeit.urbaneraltd.HomeFragment.ViewHolder;
import com.largeit.urbaneraltd.R;


public class TopThreeViewHolder extends RecyclerView.ViewHolder {
    TextView product_name_top_one, product_price_top_one;
    ImageView category_thum_top_one;
    View mmView;

    public TopThreeViewHolder(@NonNull View itemView) {
        super(itemView);

        mmView = itemView;
        product_name_top_one = itemView.findViewById(R.id.related_product_name_id);
        product_price_top_one = itemView.findViewById(R.id.related_price_id);
        category_thum_top_one = itemView.findViewById(R.id.related_item_image_id);


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
