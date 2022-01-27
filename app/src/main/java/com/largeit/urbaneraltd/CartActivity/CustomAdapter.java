package com.largeit.urbaneraltd.CartActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.largeit.urbaneraltd.HomeFragment.HomeFragment;
import com.largeit.urbaneraltd.HomeFragment.ViewHolder;
import com.largeit.urbaneraltd.ProductActivity.ProductActivity;
import com.largeit.urbaneraltd.R;
import com.largeit.urbaneraltd.main.model.Category;
import com.largeit.urbaneraltd.main.model.ProductImage;
import com.largeit.urbaneraltd.main.model.Word;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

import static com.largeit.urbaneraltd.CartActivity.CartListActivity.grandTotal;

import static com.largeit.urbaneraltd.CartActivity.CartListActivity.grandTotalplus;

public class CustomAdapter extends RecyclerView.Adapter<com.largeit.urbaneraltd.CartActivity.ViewHolder> {

    Context mContext;
    CartListActivity cartListActivity;
    public static ArrayList<ProductImage> temparraylist;
    HomeFragment homeFragment;

    //HomeActivity homeActivity;
    //public List<Word> posts;


    private ArrayList<Word> productDetails;
    private RecyclerView mRecyclerView;

    public CustomAdapter(CartListActivity cartListActivity, RecyclerView recyclerView,  ArrayList<Word> listitem) {

        this.cartListActivity = cartListActivity;
        mRecyclerView = recyclerView;
        productDetails = listitem;
        this.mContext = mContext;
    }

    public void setData(ArrayList<Word> listitem){
        productDetails = listitem;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public com.largeit.urbaneraltd.CartActivity.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_cartlist_item, parent, false);

        com.largeit.urbaneraltd.CartActivity.ViewHolder viewHolder = new com.largeit.urbaneraltd.CartActivity.ViewHolder(itemView);


        viewHolder.setOnClickListener(new com.largeit.urbaneraltd.CartActivity.ViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {

//                Word word = new Word();
//
//                Integer pID = word.getTotalCash();
                //Toast.makeText(mContext, ""+pID , Toast.LENGTH_LONG).show();

//                Integer categoryID = posts.get(position).getCategoryID();
//                //Intent to start activity
//                String id = String.valueOf(categoryID);
//
//                String categoryName = posts.get(position).getCategoryName();
//
//
//                Intent intent = new Intent(mContext, ProductActivity.class);
//                //put data in intent
//                intent.putExtra("category_id", id);
//                //start activity
//                intent.putExtra("category_name", categoryName);
//                mContext.startActivity(intent);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull com.largeit.urbaneraltd.CartActivity.ViewHolder holder, int position) {


        //final Uri uri = Uri.parse(mCartlistImageUri.get(position));
        //holder.product_thum.setImageURI(uri);

        holder.product_name.setText(productDetails.get(position).getProductName());
        holder.quantity.setText("Qty:"+productDetails.get(position).getProductQty());
        holder.price.setText("৳"+productDetails.get(position).getProductPrice());

        final String name = productDetails.get(position).getProductName();
        final int price = productDetails.get(position).getProductPrice();


        //final String desc = productDetails.get(position).getWordDesc();
        //Word post = posts.get(position);
        //String dress_name = post.getCategoryName();


        String dress_image_url = productDetails.get(position).getProductImage();

        //holder.productname.setText(dress_name);

        //holder.monako_detils.setText(monako_details);


        String IMAGE_BASE_URL = "https://urbaneraltd.com/frontend_assets/upload_assets/images/product/";
        String imageUrl = IMAGE_BASE_URL + dress_image_url;

        Glide
                .with(cartListActivity)
                .load(imageUrl)
                .override(350, 350)
                .centerCrop()
                //.placeholder(R.drawable.ic_spinner)
                .into(holder.product_thum);



        //for first start total

        grandTotalplus = 0;
        //holder.cartDecrement.setEnabled(true);

        int cartUpdateCounter = (productDetails.get(position).getProductQty());
        //Log.d("counterthegun", String.valueOf(productDetails.get(position).getProductQty()));

        //holder.cartIncrement.setEnabled(true);
        //cartUpdateCounter += 1;

        productDetails.get(position).setProductQty((cartUpdateCounter));
        int cash = (productDetails.get(position).getProductPrice()) * (productDetails.get(position).getProductQty());

        holder.productCartQuantity.setText(""+productDetails.get(position).getProductQty());
        holder.productCartQuantity1.setText(""+productDetails.get(position).getProductQty());

        productDetails.get(position).setTotalCash(cash);

        holder.price.setText("৳ "+cash);


        for (int i = 0; i < productDetails.size(); i++) {
            grandTotalplus = grandTotalplus + productDetails.get(i).getTotalCash();
        }
        //Log.d("totalcashthegun", String.valueOf(grandTotalplus));
        //grandTotal.setText(String.valueOf(grandTotalplus));

        //Log.d("totalcashthegun", String.valueOf(grandTotalplus));
        grandTotal.setText("Total - "+grandTotalplus);




        //for remove single item in cart and update the total value and list
        holder.deleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(cartListActivity);
                builder.setMessage("Do you want to remove this item from your cart?");
                builder.setCancelable(true);
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.cancel();
                    }
                });
                builder.setPositiveButton("YES!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (productDetails.size() == 1) {

                            productDetails.remove(position);
                            notifyItemRemoved(position);
                            notifyItemRangeChanged(position, productDetails.size());
                            grandTotalplus = 0;
                            grandTotal.setText("Total - "+grandTotalplus);
                        }

                        if (productDetails.size() > 0) {
                            productDetails.remove(position);
                            notifyItemRemoved(position);
                            notifyItemRangeChanged(position, productDetails.size());
                            grandTotalplus = 0;
                            for (int j = 0; j < productDetails.size(); j++) {
                                grandTotalplus = grandTotalplus + productDetails.get(j).getTotalCash();
                            }

                            //Log.d("totalcashthegun", String.valueOf(grandTotalplus));
                            grandTotal.setText("Total - "+grandTotalplus);

                        } else {
                            //Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();


            }
        });

        // increment quantity and update quamtity and total cash
        holder.cartIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //total_cash=0;\
                //Log.d("posthegun", String.valueOf(productDetails.get(position).getStocks()));

                grandTotalplus = 0;
                holder.cartDecrement.setEnabled(true);

                int cartUpdateCounter = (productDetails.get(position).getProductQty());
                //Log.d("counterthegun", String.valueOf(productDetails.get(position).getProductQty()));

                holder.cartIncrement.setEnabled(true);
                cartUpdateCounter += 1;

                productDetails.get(position).setProductQty((cartUpdateCounter));
                int cash = (productDetails.get(position).getProductPrice()) * (productDetails.get(position).getProductQty());

                holder.productCartQuantity.setText(""+productDetails.get(position).getProductQty());
                holder.productCartQuantity1.setText(""+productDetails.get(position).getProductQty());

                productDetails.get(position).setTotalCash(cash);

                holder.price.setText("৳ "+cash);


                for (int i = 0; i < productDetails.size(); i++) {
                    grandTotalplus = grandTotalplus + productDetails.get(i).getTotalCash();
                }
                //Log.d("totalcashthegun", String.valueOf(grandTotalplus));
                //grandTotal.setText(String.valueOf(grandTotalplus));

                //Log.d("totalcashthegun", String.valueOf(grandTotalplus));
                grandTotal.setText("Total - "+grandTotalplus);


                //Toast.makeText(cartListActivity, "Total - Inc "+grandTotalplus, Toast.LENGTH_LONG).show();

            }
        });


        // decrement quantity and update quamtity and total cash
        holder.cartDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //total_cash=0;
                grandTotalplus = 0;
                holder.cartIncrement.setEnabled(true);

                int cartUpdateCounter = (productDetails.get(position).getProductQty());
                Log.d("counterthegun", String.valueOf(productDetails.get(position).getProductQty()));


                if (cartUpdateCounter == 1) {
                    holder.cartDecrement.setEnabled(false);
                    Toast.makeText(cartListActivity, "quantity can't be zero", Toast.LENGTH_SHORT).show();
                } else {
                    holder.cartDecrement.setEnabled(true);
                    cartUpdateCounter -= 1;
                    productDetails.get(position).setProductQty((cartUpdateCounter));
                    holder.productCartQuantity.setText(String.valueOf(productDetails.get(position).getProductQty()));
                    holder.productCartQuantity1.setText(String.valueOf(productDetails.get(position).getProductQty()));
                    int cash = (productDetails.get(position).getProductPrice()) * (productDetails.get(position).getProductQty());

                    productDetails.get(position).setTotalCash(cash);
                    holder.price.setText("৳ "+cash);

                    for (int i = 0; i < productDetails.size(); i++) {
                        grandTotalplus = grandTotalplus + productDetails.get(i).getTotalCash();
                    }

                    Toast.makeText(cartListActivity, "Total - "+grandTotalplus, Toast.LENGTH_LONG).show();

                    //Log.d("totalcashthegun", String.valueOf(grandTotalplus));
                    grandTotal.setText("Total - "+grandTotalplus);

                }
            }
        });

        
    }

    @Override
    public int getItemCount() {
        return productDetails.size();
    }

}
