package com.largeit.urbaneraltd.FinalCheckOutActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.largeit.urbaneraltd.MainActivity;
import com.largeit.urbaneraltd.R;
import com.largeit.urbaneraltd.TestServer.model.CartList;
import com.largeit.urbaneraltd.TestServer.model.ListOrder;
import com.largeit.urbaneraltd.TestServer.model.Post;
import com.largeit.urbaneraltd.TestServer.remote.APIService;
import com.largeit.urbaneraltd.TestServer.remote.ApiUtils;
import com.largeit.urbaneraltd.main.model.Word;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FinalCheckOutActivity extends AppCompatActivity {

    TextView Name, phoneNumber, Email, fullAddress;
    RadioButton InsideDhaka, OutSideDhaka;
    Button ConfirmOrderBtn;
    private APIService mAPIService;
    ArrayList<Word> list = new ArrayList<>();
    ListOrder listOrder;
    Word word;

    public static int insideOrOutside  = 0;
    public static int GrandTotalWithDeleveryCharge  = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_check_out);

        InsideDhaka = (RadioButton)findViewById(R.id.radioMale);
        OutSideDhaka = (RadioButton)findViewById(R.id.radioFemale);
        ConfirmOrderBtn = findViewById(R.id.final_confirm_btn_id);

        Name = findViewById(R.id.final_chack_out_name_id);
        phoneNumber = findViewById(R.id.final_chack_out_phone_number_id);
        Email = findViewById(R.id.final_chack_out_email_id);
        fullAddress = findViewById(R.id.full_address_id);
        mAPIService = ApiUtils.getAPIServices();


//        intent.putExtra("OrderIdint", OrderIdint);
//        intent.putExtra("grandTotalplus", price);
//        intent.putExtra("totalQty", totalqty);

        String grandTotal = getIntent().getStringExtra("grandTotalplus");
        //String OrderIdint = getIntent().getStringExtra("OrderIdint");
        String totalQty = getIntent().getStringExtra("totalQty");



        //type cast
        Integer FinalGrandTotal = Integer.parseInt(grandTotal);
        //Integer FinalOrderID = Integer.parseInt(OrderIdint);
        Integer FinaltotalQty = Integer.parseInt(totalQty);



        //Toast.makeText(this, "Total - "+grandTotal, Toast.LENGTH_SHORT).show();

        InsideDhaka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(FinalCheckOutActivity.this, "Grand Total - "+grandTotal+"\nOrderID - "+OrderIdint+"\n t", Toast.LENGTH_LONG).show();

                GrandTotalWithDeleveryCharge = FinalGrandTotal;

                insideOrOutside = 100;
            }
        });

        OutSideDhaka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(FinalCheckOutActivity.this, "Outside" , Toast.LENGTH_LONG).show();
                GrandTotalWithDeleveryCharge = FinalGrandTotal;
                insideOrOutside = 150;
            }
        });




        ConfirmOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String OrderName = Name.getText().toString();
                String OrderPhoneNumber = phoneNumber.getText().toString();
                String OrderEmail = Email.getText().toString();
                String OrderFulladdress = fullAddress.getText().toString();

                if(OrderName.isEmpty() && OrderPhoneNumber.isEmpty() && OrderEmail.isEmpty() && OrderFulladdress.isEmpty() ){
                    Toast.makeText(FinalCheckOutActivity.this, "Fill Up All Field" , Toast.LENGTH_SHORT).show();
                }
                else {
                    submitOrder(OrderName,OrderPhoneNumber, OrderEmail, OrderFulladdress, GrandTotalWithDeleveryCharge, insideOrOutside,  FinaltotalQty);
                    Name.setText("");
                    phoneNumber.setText("");
                    Email.setText("");
                    fullAddress.setText("");
                    Toast.makeText(FinalCheckOutActivity.this, "Please Wait...", Toast.LENGTH_LONG).show();




//                    });
                }
                //String grandTotal = getIntent().getStringExtra("grandTotalplus");

                //submitOrder(OrderID, TotalPrice, TotalQty, Phone, CustomerName, ShippingAddress, delivery_charge, Comments);

            }
        });
    }

    private void submitOrder(String orderName, String orderPhoneNumber, String orderEmail, String orderFulladdress, int grandTotalWithDeleveryCharge, int insideOrOutside, Integer finaltotalQty) {

//        Map<String, String> parameters = new HashMap<>();
//        parameters.put("pID", "127");
//        parameters.put("pName", "PNAME");
//        parameters.put("pPrice", "550");
//        parameters.put("pQty", "2");
//        parameters.put("pImage", "1.jpg");

        //ArrayList<ListOrder> arrayList = new ArrayList<>();

        //Word word = new Word(127);
        Word word = new Word();
        ArrayList<Word> list = word.getMyCard();






//        JSONArray jsonArray = new JSONArray(list);
//        for (int i = 0; i < list.size(); i++){
//
//
//
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("pID", list.get(i).getProductID());
//            jsonObject.put("pName", list.get(i).getProductName());
//            jsonObject.put("pPrice", list.get(i).getProductPrice());
//            jsonObject.put("pQty", list.get(i).getProductQty());
//            jsonObject.put("pImage", list.get(i).getProductImage());
//
//            jsonArray.put(jsonObject);
//        }


//            final JSONArray jsonArray = new JSONArray();
//            for (int i = 0; i < list.size(); i++){
//
//                JSONObject jsonObject = new JSONObject();
//                try {
//                    jsonObject.put("pID", list.get(i).getProductID());
//                    jsonObject.put("pName", list.get(i).getProductName());
//                    jsonObject.put("pPrice", list.get(i).getProductPrice());
//                    jsonObject.put("pQty", list.get(i).getProductQty());
//                    jsonObject.put("pImage", list.get(i).getProductImage());
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                jsonArray.put(jsonObject);
//
//            }



//        int pID = list.get(0).getProductID();
//        String pName = list.get(0).getProductName();
//        int pPrice = list.get(0).getProductPrice();
//        int pQty = list.get(0).getProductQty();
//        String pImage = list.get(0).getProductImage();
//



        ArrayList<ListOrder>  arrayList1 = new ArrayList<>();

        for (int i = 0; i < list.size(); i++){

            arrayList1.add(new ListOrder(list.get(i).getProductID(), list.get(i).getProductName(), list.get(i).getProductPrice(), list.get(i).getProductQty(), list.get(i).getProductImage()));

        }

        //listOrder = new ListOrder(127, "watch", 550, 2, "1.jpg");



        CartList cartList = new CartList(orderName, orderPhoneNumber,orderEmail, orderFulladdress, grandTotalWithDeleveryCharge, insideOrOutside, finaltotalQty, arrayList1);

        mAPIService.postWithObject(cartList).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {


                //Toast.makeText(FinalCheckOutActivity.this, "submited", Toast.LENGTH_LONG).show();
                //for diaglog show
                final Dialog myDialog  = new Dialog(FinalCheckOutActivity.this);
                myDialog.setContentView(R.layout.dialog_contact);
                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                myDialog.setCancelable(false);


                //for gif load
                ImageView imageView = myDialog.findViewById(R.id.dialogImageId);
                Glide.with(FinalCheckOutActivity.this).load(R.drawable.success).listener(new RequestListener<Drawable>() {

                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        if (resource instanceof GifDrawable) {
                            ((GifDrawable)resource).setLoopCount(1);
                        }
                        return false;

                    }
                }).into(imageView);
                myDialog.show();




                myDialog.findViewById(R.id.btn_accept).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //myDialog.dismiss();
                        Intent intent = new Intent(FinalCheckOutActivity.this, MainActivity.class);
                        startActivity(intent);
                        Word word = new Word();
                        ArrayList<Word> list = word.getMyCard();
                        list.clear();
                    }
                });

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {


                    //for diaglog show
                    final Dialog myDialog  = new Dialog(FinalCheckOutActivity.this);
                    myDialog.setContentView(R.layout.dialog_contact);
                    myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    myDialog.setCancelable(false);

                    //for gif load
                    ImageView imageView = myDialog.findViewById(R.id.dialogImageId);
                    Glide.with(FinalCheckOutActivity.this).load(R.drawable.success).listener(new RequestListener<Drawable>() {

                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            if (resource instanceof GifDrawable) {
                                ((GifDrawable)resource).setLoopCount(1);
                            }
                            return false;

                        }
                    }).into(imageView);


                    myDialog.show();


                    myDialog.findViewById(R.id.btn_accept).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //myDialog.dismiss();
                            Intent intent = new Intent(FinalCheckOutActivity.this, MainActivity.class);
                            startActivity(intent);
                                    Word word = new Word();
                                    ArrayList<Word> list = word.getMyCard();
                                    list.clear();

                        }
                    });


            }
        });



        //Toast.makeText(FinalCheckOutActivity.this, "Order name = "+orderName+"\nGrand totalcharge "+grandTotalWithDeleveryCharge+"\ntotal Qty ="+finaltotalQty+"\norderPhoneNumber"+orderPhoneNumber, Toast.LENGTH_LONG).show();
//
//        mAPIService.PostFinalOrder(orderName, orderPhoneNumber, orderEmail, orderFulladdress, grandTotalWithDeleveryCharge, insideOrOutside, finaltotalQty,list).enqueue(new Callback<Order>() {
//            @Override
//            public void onResponse(Call<Order> call, Response<Order> response) {
//                Toast.makeText(FinalCheckOutActivity.this, "submited", Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onFailure(Call<Order> call, Throwable t) {
//                Toast.makeText(FinalCheckOutActivity.this, "not submited"+t.getMessage(), Toast.LENGTH_LONG).show();
//
//            }
//        });
    }

//    private void submitOrder( int grandTotalWithDeleveryCharge, Integer finaltotalQty, String orderPhoneNumber, String orderName, String orderFulladdress, int insideOrOutside, String comments) {
//        //Toast.makeText(FinalCheckOutActivity.this, "Order Id = "+finalOrderID+"\nGrand totalcharge "+grandTotalWithDeleveryCharge+"\ntotal Qty ="+finaltotalQty+"\norderPhoneNumber"+orderPhoneNumber+"")
//        mAPIService.putPostProductOrder(finalOrderID, grandTotalWithDeleveryCharge, finaltotalQty, orderPhoneNumber, orderName, orderFulladdress, insideOrOutside, comments).enqueue(new Callback<Order>() {
//            @Override
//            public void onResponse(Call<Order> call, Response<Order> response) {
//
//
//                Toast.makeText(FinalCheckOutActivity.this, "Order Placed Successfully", Toast.LENGTH_LONG).show();
//
////                Word word = new Word();
////                ArrayList<Word> list = word.getMyCard();
////
////                list.clear();
////                textViewCart.setText(""+list.size());
//
//                Word word = new Word();
//                ArrayList<Word> list = new ArrayList<>();
//                list.clear();
//
//                Intent intent = new Intent(FinalCheckOutActivity.this, MainActivity.class);
//                startActivity(intent);
//
//
//            }
//
//            @Override
//            public void onFailure(Call<Order> call, Throwable t) {
//                Toast.makeText(FinalCheckOutActivity.this, "Order Placed Successfully", Toast.LENGTH_LONG).show();
//
//                Word word = new Word();
//                ArrayList<Word> list = new ArrayList<>();
//                list.clear();
//
//                Intent intent = new Intent(FinalCheckOutActivity.this, MainActivity.class);
//                startActivity(intent);
//
//
//            }
//        });
//    }

    @Override
    protected void onStart() {
        super.onStart();
//        Word word = new Word();
//        ArrayList<Word> list = word.getMyCard();
//        list.clear();

    }
}