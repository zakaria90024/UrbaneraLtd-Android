package com.largeit.urbaneraltd.MultiplaImage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.largeit.urbaneraltd.R;


public class ViewHolder extends RecyclerView.ViewHolder {

    ImageView category_thum;
    View mView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        mView = itemView;
        category_thum = itemView.findViewById(R.id.itemImageId);


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
