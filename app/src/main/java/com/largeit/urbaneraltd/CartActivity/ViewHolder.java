package com.largeit.urbaneraltd.CartActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.largeit.urbaneraltd.R;


public class ViewHolder extends RecyclerView.ViewHolder {
    TextView product_name, price, quantity, productCartQuantity,productCartQuantity1 ;
    Button deleteItem, cartDecrement,cartIncrement;
    ImageView product_thum;

    View mView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        mView = itemView;
        product_name = itemView.findViewById(R.id.related_product_name_id);
        price = itemView.findViewById(R.id.related_price_id);
        quantity = itemView.findViewById(R.id.cart_quantity_id);
        product_thum = itemView.findViewById(R.id.related_item_image_id);


        deleteItem = itemView.findViewById(R.id.cart_item_delete_button_id);
        productCartQuantity = itemView.findViewById(R.id.cart_quantity_texview_id);
        productCartQuantity1 = itemView.findViewById(R.id.textView_quantity_id);
        cartDecrement = itemView.findViewById(R.id.cart_item_muinas_btn_id);
        cartIncrement = itemView.findViewById(R.id.cart_item_plus_btn_id);


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
