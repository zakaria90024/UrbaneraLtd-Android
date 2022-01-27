package com.largeit.urbaneraltd.HomeFragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.largeit.urbaneraltd.R;


public class ViewHolder extends RecyclerView.ViewHolder {
    TextView productname;
    public ImageView category_thum;
    View mView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        mView = itemView;
        //productname = itemView.findViewById(R.id.item_product_name_id_view);
        category_thum = itemView.findViewById(R.id.itemImageId);


       itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               mClickListener.onItemClick(v, getAdapterPosition());
           }
       });
    }


    private com.largeit.urbaneraltd.HomeFragment.ViewHolder.ClickListener mClickListener;

    public interface ClickListener{
        void  onItemClick(View view, int position);
    }

    public void setOnClickListener(com.largeit.urbaneraltd.HomeFragment.ViewHolder.ClickListener clickListener){
        mClickListener = clickListener;
    }


}
