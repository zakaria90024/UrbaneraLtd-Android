package com.largeit.urbaneraltd.MoreProductActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.largeit.urbaneraltd.R;


public class ViewHolder extends RecyclerView.ViewHolder {

    TextView product_name;
    TextView product_price;
    ImageView product_image;
    View mView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        mView = itemView;
        product_name = itemView.findViewById(R.id.related_product_name_id);
        product_price = itemView.findViewById(R.id.related_price_id);
        product_image = itemView.findViewById(R.id.related_item_image_id);


       itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               mClickListener.onItemClick(v, getAdapterPosition());
           }
       });
    }
    private ClickListener mClickListener;

    public interface ClickListener{
        void  onItemClick(View view, int position);
    }

    public void setOnClickListener(ClickListener clickListener){
        mClickListener = clickListener;
    }


}
