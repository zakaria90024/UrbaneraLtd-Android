package com.largeit.urbaneraltd.CartActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.largeit.urbaneraltd.FinalCheckOutActivity.FinalCheckOutActivity;
import com.largeit.urbaneraltd.MainActivity;
import com.largeit.urbaneraltd.ProductActivity.ProductActivity;
import com.largeit.urbaneraltd.R;
import com.largeit.urbaneraltd.SingleProductDetailsActivity.SingleProductDetailsActivity;
import com.largeit.urbaneraltd.TestServer.model.CartList;
import com.largeit.urbaneraltd.TestServer.model.Order;
import com.largeit.urbaneraltd.TestServer.model.Post;
import com.largeit.urbaneraltd.TestServer.remote.APIService;
import com.largeit.urbaneraltd.TestServer.remote.ApiUtils;
import com.largeit.urbaneraltd.main.data.remote.ApiUtils1;
import com.largeit.urbaneraltd.main.model.CartModel;
import com.largeit.urbaneraltd.main.model.LatestProductModel;
import com.largeit.urbaneraltd.main.model.ProductImage;
import com.largeit.urbaneraltd.main.model.Test;
import com.largeit.urbaneraltd.main.model.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CartListActivity extends AppCompatActivity {
    public static TextView grandTotal;
    public static int grandTotalplus;
    public static int totalQty;
    private static Context mContext;
    CartListActivity cartListActivity;
    public static ArrayList<Word> productDetails;
    public static ArrayList<ProductImage> temparraylist1;
    private APIService mAPIService;
    public static ArrayList<Post> listforGetOrderID;
    public static Integer OrderIDCallback;
    Button btnCheckOut;

    com.largeit.urbaneraltd.CartActivity.CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);


        grandTotal = findViewById(R.id.grand_total_textview_id);
        btnCheckOut = findViewById(R.id.btn_check_out_id);

        mAPIService = ApiUtils.getAPIServices();

        Word word = new Word();
        ArrayList<Word> list = word.getMyCard();


        productDetails = new ArrayList<>();
        listforGetOrderID = new ArrayList<>();


        // from these lines of code we remove the duplicacy of cart and set last added quantity in cart
        // for replace same item
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getProductImage().equals(list.get(j).getProductImage())) {
                    list.get(i).setProductQty(list.get(j).getProductQty());
                    list.get(i).setTotalCash(list.get(j).getTotalCash());
                    list.remove(j);
                    j--;
                    //Log.d("remove", String.valueOf(list.size()));

                }
            }

        }

        //temparraylist1.addAll(list);


        if(list.isEmpty()){
            //for diaglog show
            final Dialog myDialog  = new Dialog(CartListActivity.this);
            myDialog.setContentView(R.layout.empty_cart_layout);
            myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            myDialog.setCancelable(true);

//            ImageView imageView = myDialog.findViewById(R.id.dialogImageId);
//
//
//            Glide.with(this).load(R.drawable.success).listener(new RequestListener<Drawable>() {
//                @Override
//                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
//                    return false;
//                }
//
//                @Override
//                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
//                    if (resource instanceof GifDrawable) {
//                        ((GifDrawable)resource).setLoopCount(1);
//                    }
//                    return false;
//
//                }
//            }).into(imageView);
            myDialog.show();


            myDialog.findViewById(R.id.btn_accept_shoping).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //myDialog.dismiss();
                    Intent intent = new Intent(CartListActivity.this, MainActivity.class);
                    startActivity(intent);
//                    Word word = new Word();
//                    ArrayList<Word> list = word.getMyCard();
//                    list.clear();

                }
            });
        }

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.cart_recyclerview_id);
        RecyclerView.LayoutManager recylerViewLayoutManager = new LinearLayoutManager(mContext);
        adapter = new CustomAdapter(CartListActivity.this,recyclerView,list);
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        recyclerView.setAdapter(adapter);


        //for get last order id forom database table ==========================================================================

//        Call<List<Post>> listCall = ApiUtils.getAPIServices().getLastOrderId();
//        listCall.enqueue(new Callback<List<Post>>() {
//            @Override
//            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//
//
//                List<Post> latestProductModels = response.body();
//
//
//                OrderIDCallback =  latestProductModels.get(latestProductModels.size() - 1).getOrderID();
//
//                //Toast.makeText(CartListActivity.this, "id "+OrderIDCallback, Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onFailure(Call<List<Post>> call, Throwable t) {
//
//            }
//        });

        //end for get last order id forom database table =======================================================================

        //list.size();
        grandTotalplus = 0;
        for (int i = 0; i < list.size(); i++) {
            grandTotalplus = grandTotalplus + list.get(i).getTotalCash();
        }

        //list.get(1).
        //grandTotalplus = productDetails.get(1).getTotalCash();
        //grandTotal.setText("Total - "+grandTotalplus);

        for (int i = 0; i < list.size(); i++){
            final int a = list.get(i).getProductQty();

        }


        btnCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                int min = 414 ;
//                int max = 999999 ;
//                int OrderId = ThreadLocalRandom.current().nextInt( min , max + 1 );

                if(list.size() == 0){
                    Toast.makeText(CartListActivity.this, "Cart is Empty", Toast.LENGTH_SHORT).show();
                }else {

                    //int OrderId = OrderIDCallback + 1;

//                    for(int i = 0;  i <list.size(); i++){
//
//                        createPost(OrderId, list.get(i).getProductID(), list.get(i).getProductQty(), list.get(i).getProductPrice());
//                        //createPost(216, 414, 2, 1000 );
//                    }

                    grandTotalplus = 0;
                    for (int i = 0; i < list.size(); i++) {
                        grandTotalplus = grandTotalplus + list.get(i).getTotalCash();
                    }

                    totalQty = 0;
                    for (int i = 0; i < list.size(); i++) {
                        totalQty = totalQty + list.get(i).getProductQty();
                    }

                    //String OrderIdint = String.valueOf(OrderId);
                    String totalqty = String.valueOf(totalQty);
                    String price = String.valueOf(grandTotalplus);

                    //Toast.makeText(CartListActivity.this, ""+grandTotalplus, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(CartListActivity.this, FinalCheckOutActivity.class);


                    //intent.putExtra("OrderIdint", OrderIdint);
                    intent.putExtra("grandTotalplus", price);
                    intent.putExtra("totalQty", totalqty);

                    startActivity(intent);
                }


//                intent.putExtra("product_name", product_name);
//                //start activity
//                intent.putExtra("sale_price", sale_price);
//                intent.putExtra("single_product_image", single_product_image);
//                mContext.startActivity(intent);

                //Intent intent = new Intent(CartListActivity.this, FinalCheckOutActivity.class);
                //startActivity(intent);


//                for(int j = 0; j < 3; j++){
//                    sendData(list.get(j).getProductID(), list.get(j).getProductName(), list.get(j).getProductPrice(), list.get(j).getProductQty(), list.get(j).getProductImage());
//
//
//                }

//                String Ids = UUID.randomUUID().toString();
//                Integer OrderId = Integer.parseInt(Ids);
//                ThreadLocalRandom



                //createPost("10000", "banglatest", "111111");


            }
        });

        //sendData(1, "gghj", 20, 2, "u");




    }

//    private void createPost(int i, int i1, int i2, int i3) {
//        mAPIService.putPostProductMaping(i, i1, i2, i3).enqueue(new Callback<Post>() {
//            @Override
//            public void onResponse(Call<Post> call, Response<Post> response) {
//                //Toast.makeText(CartListActivity.this, "inserted", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<Post> call, Throwable t) {
//                //Toast.makeText(CartListActivity.this, "not inserted"+t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }

//    private void sendData(Integer pID, String pName, Integer pPrice, Integer pQty, String pImage) {
//
//        Toast.makeText(CartListActivity.this, "call", Toast.LENGTH_SHORT).show();
//
//        mAPIService.createPost(pID,pName,pPrice,pQty,pImage).enqueue(new Callback<Test>() {
//            @Override
//            public void onResponse(Call<Test> call, Response<Test> response) {
//                Toast.makeText(CartListActivity.this, "inserted", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<Test> call, Throwable t) {
//
//            }
//        });
//    }


    public void BackClicked1(View view) {
        super.onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}