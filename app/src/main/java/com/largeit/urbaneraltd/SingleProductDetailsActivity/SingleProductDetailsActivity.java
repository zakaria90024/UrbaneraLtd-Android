package com.largeit.urbaneraltd.SingleProductDetailsActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.largeit.urbaneraltd.CartActivity.CartListActivity;
import com.largeit.urbaneraltd.MoreProductActivity.MoreProductActivity;
import com.largeit.urbaneraltd.R;
import com.largeit.urbaneraltd.main.data.remote.APIService;
import com.largeit.urbaneraltd.main.data.remote.ApiUtils;
import com.largeit.urbaneraltd.main.model.CartModel;
import com.largeit.urbaneraltd.main.model.Product;
import com.largeit.urbaneraltd.main.model.ProductDiscriptionModel;
import com.largeit.urbaneraltd.main.model.RelateProductModel;
import com.largeit.urbaneraltd.main.model.Word;

import org.json.JSONException;
import org.json.JSONObject;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.largeit.urbaneraltd.main.data.remote.ApiUtils.getAPIService;

public class SingleProductDetailsActivity extends AppCompatActivity implements Callback<CartModel> {



    //for string
    private String name;
    private String price;
    private String desc;
    private Word word;

    CartModel cartModel;


    HtmlTextView shortDes, longDes;
    TextView single_product_name;
    TextView single_product_price;
    PhotoView single_product_image;

    Button btn_add_toCart, btn_bye_now;

    private APIService mAPIService;

    private static final String LOG_TAG = "Hello" ;
    TextView textView;
    SingleProductDetailsActivity singleProductDetailsActivity;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ProgressDialog pd;
    List<ProductDiscriptionModel> modelList = new ArrayList<>();

    private APIService jsonPlaceHolderApi;

    //for related product
    CustomAdapter adapterRelated;
    RecyclerView recyclerViewRelated;
    List<RelateProductModel> modelListReated = new ArrayList<>();
    Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_product_details);

        //maping component
        single_product_name = findViewById(R.id.single_product_nameId);
        single_product_price = findViewById(R.id.single_product_priceid);
        single_product_image = findViewById(R.id.single_product_image_id);
        shortDes = findViewById(R.id.single_product_shortdes_id);
        longDes = findViewById(R.id.single_product_longdesId);
        btn_add_toCart = findViewById(R.id.add_to_cart_btn_id);
        btn_bye_now = findViewById(R.id.buy_now_btn_id);

        recyclerViewRelated = findViewById(R.id.recycler_related_product_id);
        //pd = new ProgressDialog(this);
        //loadingDialog = new LoadingDialog(this);
        recyclerViewRelated.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapterRelated = new com.largeit.urbaneraltd.SingleProductDetailsActivity.CustomAdapter(SingleProductDetailsActivity.this, modelListReated, context);


        recyclerViewRelated.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        //recyclerViewRelated.setLayoutManager(new GridLayoutManager(this,3));
        //recyclerView.setLayoutManager(layoutManager);
        recyclerViewRelated.setAdapter(adapterRelated);



        mAPIService = ApiUtils.getAPIService();

        //mAPIService = ApiUtils.getAPIService();





//        // prepare call in Retrofit 2.0
//        try {
//            JSONObject paramObject = new JSONObject();
//            paramObject.put("ProductID", 414);
//            paramObject.put("ProductName", "fghfhfghfg");
//            paramObject.put("SalePrice", 255);
//            paramObject.put("quantity", 2);
//
//            Call<CartModel> userCall = jsonPlaceHolderApi.getaddToCart(paramObject.toString());
//            userCall.enqueue(this);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }



        String ids = getIntent().getStringExtra("product_id");
        int product_id = Integer.valueOf(ids);
        String p = getIntent().getStringExtra("sale_price");
        double d = Double.parseDouble(p);
        int product_price = (int) d;
        int product_quantity = 1;

        String product_name = getIntent().getStringExtra("product_name");
        String product_image = getIntent().getStringExtra("single_product_image");



        //Toast.makeText(SingleProductDetailsActivity.this, ""+sl_price, Toast.LENGTH_LONG).show();

        //Integer sl = Integer.valueOf(String.valueOf(sl_price));




        word = new Word(product_id,product_name, product_price,product_quantity,product_image);


        //cartModel = new CartModel(id, product_name,sl, quantity);


        //float sale_price  =  Float.valueOf(sl_price);



//        int id = 414;
//        String product_name = "ljsjfkldjslkfj";
//        int sale_price = 1555;
//        int quantity = 2;


        //section of Related Product ===============================================================
        Call<List<RelateProductModel>> listCallRelated = getAPIService().getRelatedProduct(product_id);
        listCallRelated.enqueue(new Callback<List<RelateProductModel>>() {
            @Override
            public void onResponse(Call<List<RelateProductModel>> call, Response<List<RelateProductModel>> response) {
                //RelateProductModel relateProductModel = response.body();
                List<RelateProductModel> posts = response.body();
                adapterRelated.setData(posts);
                recyclerViewRelated.setAdapter(adapterRelated);
            }

            @Override
            public void onFailure(Call<List<RelateProductModel>> call, Throwable t) {

            }
        });
        //end section of Relate product ============================================================










        Call<ProductDiscriptionModel> listCall = getAPIService().getDescription(product_id);

        listCall.enqueue(new Callback<ProductDiscriptionModel>()
        {
            @Override
            public void onResponse(Call<ProductDiscriptionModel> call, Response<ProductDiscriptionModel> response)
            {
                if (response.isSuccessful())
                {
                    ProductDiscriptionModel apiResponse = response.body();
                    //API response
                    //System.out.println(apiResponse);
                    //textView.setText(apiResponse.getProductName());

                    single_product_name.setText(apiResponse.getProductName());
                    single_product_price.setText("৳"+apiResponse.getSalePrice());
                    shortDes.setHtml(apiResponse.getShortDescription());
                    longDes.setHtml(apiResponse.getLongDescription());
                    String dress_image_url = apiResponse.getImage();

                    String IMAGE_BASE_URL = "https://urbaneraltd.com/frontend_assets/upload_assets/images/product/";
                    String imageUrl = IMAGE_BASE_URL + dress_image_url;

                    //single_product_image.setImageURI(Uri.parse(imageUrl));
                    Glide
                            .with(getApplicationContext())
                            .load(imageUrl)
                            .override(280, 320)
                            .centerCrop()
                            .placeholder(R.drawable.placeholder)
                            .into(single_product_image);
                }
                else
                {
                    System.out.println("Request Error :: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ProductDiscriptionModel> call, Throwable t)
            {
                System.out.println("Network Error :: " + t.getLocalizedMessage());
            }
        });

        //getDataFromIntent(id);


        btn_add_toCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                word.SetMyCard(word);


                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toast,
                        (ViewGroup) findViewById(R.id.toast_layout_root));


                //FOR CUSTOM TOAST
                ImageView image = (ImageView) layout.findViewById(R.id.image);
                image.setImageResource(R.drawable.ic_check_circle_24);
                TextView text = (TextView) layout.findViewById(R.id.text);
                text.setText("Added to Cart");

                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.BOTTOM, 0, 150);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(layout);
                toast.show();
                //FOR CUSTOM TOAST

                //Toast.makeText(SingleProductDetailsActivity.this,"Added Successfull",Toast.LENGTH_SHORT).show();


//                Intent intent = new Intent(SingleProductDetailsActivity.this, CartListActivity.class);
//                startActivity(intent);



//                Integer ProductID = 161;
//                String ProductName = "new product 404";
//                Integer SalePrice = 4000;
//                Integer quantity = 2;
//
//                postAddToCart(ProductID, ProductName, SalePrice, quantity);


//                final Dialog dialog = new Dialog(SingleProductDetailsActivity.this);
//                // Include dialog.xml file
//                dialog.setContentView(R.layout.dialog_item_quantity_update);
//                // Set dialog title
//                dialog.setTitle("Custom Dialog");
//                final ImageView cartDecrement = dialog.findViewById(R.id.cart_decrement);
//                ImageView cartIncrement = dialog.findViewById(R.id.cart_increment);
//                ImageView closeDialog = dialog.findViewById(R.id.imageView_close_dialog_cart);
//                TextView updateQtyDialog = dialog.findViewById(R.id.update_quantity_dialog);
//                TextView viewCartDialog = dialog.findViewById(R.id.view_cart_button_dialog);
//                final TextView quantity = dialog.findViewById(R.id.cart_product_quantity_tv);
//
//                quantity.setText(String.valueOf(0));//quantity default
//                final int[] cartCounter = {0};//{(arrayListImage.get(position).getStocks())};
//
//
//                cartDecrement.setEnabled(false);
//                cartDecrement.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        if (cartCounter[0] == 1) {
//                            Toast.makeText(SingleProductDetailsActivity.this, "cant add less than 0", Toast.LENGTH_SHORT).show();
//                        } else {
//                            cartCounter[0] -= 1;
//                            quantity.setText(String.valueOf(cartCounter[0]));
//                        }
//
//                    }
//                });
//
//



            }
        });

        btn_bye_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                word.SetMyCard(word);

                Intent intent = new Intent(SingleProductDetailsActivity.this, CartListActivity.class);
                startActivity(intent);
            }
        });




    }

    public void BackClicked(View view) {
        super.onBackPressed();
    }



//    private void postAddToCart(Integer  ProductID, String ProductName, Integer SalePrice, Integer quantity) {
//
//        Toast.makeText(this, "id = "+ProductID+"\n product_name = "+ProductName+"\nsale_price ="+SalePrice+"quantity = "+quantity, Toast.LENGTH_LONG).show();
//
//
//
////        CartModel cartModel = new CartModel(, product_name, sale_price, quantity);
////
////        Call<CartModel> call = mAPIService.createUser(cartModel);
////
////        call.enqueue(new Callback<CartModel>() {
////            @Override
////            public void onResponse(Call<CartModel> call, Response<CartModel> response) {
////                Toast.makeText(SingleProductDetailsActivity.this, "success", Toast.LENGTH_SHORT).show();
////            }
////
////            @Override
////            public void onFailure(Call<CartModel> call, Throwable t) {
////                Toast.makeText(SingleProductDetailsActivity.this, " not success"+t.getMessage(), Toast.LENGTH_SHORT).show();
////            }
////        });
//
//        //Toast.makeText(SingleProductDetailsActivity.this, "id = "+id+"\npro name = "+product_name+"\n sale price = "+sale_price+"quantity\n"+quantity+"\n", Toast.LENGTH_SHORT).show();
//
////        mAPIService.getaddToCart(id, product_name, sale_price, quantity).enqueue(new Callback<CartModel>() {
////            @Override
////            public void onResponse(Call<CartModel> call, Response<CartModel> response) {
////
////                Toast.makeText(SingleProductDetailsActivity.this, "success"+response.body(), Toast.LENGTH_SHORT).show();
////            }
////            @Override
////            public void onFailure(Call<CartModel> call, Throwable t) {
////                 Toast.makeText(SingleProductDetailsActivity.this, " not success"+t.getMessage(), Toast.LENGTH_SHORT).show();
////
////            }
////        });
//
////        mAPIService.getaddToCart(id, product_name, sale_price, quantity).enqueue(new Callback<CartModel>() {
////            @Override
////            public void onResponse(Call<CartModel> call, Response<CartModel> response) {
////                Toast.makeText(SingleProductDetailsActivity.this, "success"+response.body(), Toast.LENGTH_SHORT).show();
////            }
////
////            @Override
////            public void onFailure(Call<CartModel> call, Throwable t) {
////                Toast.makeText(SingleProductDetailsActivity.this, " not success"+t.getMessage(), Toast.LENGTH_SHORT).show();
////            }
////        });
//
//
//
////        Call<RequestBody> call = jsonPlaceHolderApi.getaddToCart(id, product_name,sale_price, quantity);
////        call.enqueue(new Callback<RequestBody>() {
////            @Override
////            public void onResponse(Call<RequestBody> call, Response<RequestBody> response) {
////                Toast.makeText(SingleProductDetailsActivity.this, "success"+response.body(), Toast.LENGTH_SHORT).show();
////
////            }
////
////            @Override
////            public void onFailure(Call<RequestBody> call, Throwable t) {
////                Toast.makeText(SingleProductDetailsActivity.this, "not success"+t.getMessage(), Toast.LENGTH_SHORT).show();
////            }
////        });
//
//        //Post post = new Post("414","ds", "4000", "2");
////        Map<String, String> fields = new HashMap<>();
////        fields.put("id", "414");
////        fields.put("name", "New Title");
////        fields.put("price", "4000");
////        fields.put("quantity", "2");
//
//
////        mAPIService.createPost(414, "gjhghg", 4000, 1).enqueue(new Callback<CartModel>() {
////            @Override
////            public void onResponse(Call<CartModel> call, Response<CartModel> response) {
////                Toast.makeText(SingleProductDetailsActivity.this, "success = ", Toast.LENGTH_SHORT).show();
////            }
////
////            @Override
////            public void onFailure(Call<CartModel> call, Throwable t) {
////                Toast.makeText(SingleProductDetailsActivity.this, "not success"+t.getMessage(), Toast.LENGTH_SHORT).show();
////            }
////        });
//
//
////        Call<CartModel> call = mAPIService.getaddToCart(id, product_name,sale_price, quantity);
////        call.enqueue(new Callback<CartModel>() {
////            @Override
////            public void onResponse(Call<CartModel> call, Response<CartModel> response) {
////                Toast.makeText(SingleProductDetailsActivity.this, "success = "+response.body().getCartCount(), Toast.LENGTH_SHORT).show();
////            }
////
////            @Override
////            public void onFailure(Call<CartModel> call, Throwable t) {
////                Toast.makeText(SingleProductDetailsActivity.this, "not success"+t.getMessage(), Toast.LENGTH_SHORT).show();
////            }
////        });


    //}


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Word word = new Word();
        ArrayList<Word> list = word.getMyCard();

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
//        Word word = new Word();
//        ArrayList<Word> list = word.getMyCard();
    }

    @Override
    public void onResponse(Call<CartModel> call, Response<CartModel> response) {
        Toast.makeText(SingleProductDetailsActivity.this, "success"+response.body(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(Call<CartModel> call, Throwable t) {

    }

    public void whenCartViewClicked(View view) {
        Intent intent = new Intent(SingleProductDetailsActivity.this, CartListActivity.class);
        startActivity(intent);
    }
}