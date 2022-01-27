package com.largeit.urbaneraltd.ProductActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.largeit.urbaneraltd.CartActivity.CartListActivity;
import com.largeit.urbaneraltd.LoadingDialog.LoadingDialog;
import com.largeit.urbaneraltd.MainActivity;
import com.largeit.urbaneraltd.R;
import com.largeit.urbaneraltd.main.data.remote.ApiUtils;
import com.largeit.urbaneraltd.main.model.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductActivity extends AppCompatActivity {

    //for pagination

    NestedScrollView nestedScrollView;
    ProgressBar progressBar;
    int page = 1, limit = 10;
    ImageView cartImage;


    //LoadingDialog loadingDialog;
    TextView hedertxt;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    CustomAdapter adapter;
    ProgressDialog pd;
    Context context;

    List<Product> modelList = new ArrayList<>();
    SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        //maping xml
        recyclerView = findViewById(R.id.product_recycler_id);
        hedertxt = findViewById(R.id.header_title_id);

        //nestedScrollView = findViewById(R.id.nestedscoral_id);
        progressBar = findViewById(R.id.progress_custom_id);
        cartImage = findViewById(R.id.imageView5);
        refreshLayout = findViewById(R.id.swipe_container);


        //pd = new ProgressDialog(this);
        //loadingDialog = new LoadingDialog(this);
        recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new CustomAdapter(ProductActivity.this, modelList, context);

        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        //recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);



        String categoryName = getIntent().getStringExtra("category_name");
        hedertxt.setText(categoryName);

        String id = getIntent().getStringExtra("category_id");
        Integer c_id = Integer.valueOf(id);




        progressBar.setVisibility(View.VISIBLE);
        ShowCategoryWise(c_id, page, limit);



//        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                if(scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()){
//                    page++;
//                    progressBar.setVisibility(View.VISIBLE);
//
//                    ShowCategoryWise(c_id, page, limit);
//
//                }
//            }
//        });

        cartImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductActivity.this, CartListActivity.class);
                startActivity(intent);
            }
        });
        sweeprefresh();

    }

    private void sweeprefresh()
    {
        refreshLayout.setColorSchemeResources(R.color.primarycolor,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                String id = getIntent().getStringExtra("category_id");
                Integer c_id = Integer.valueOf(id);
                ShowCategoryWise(c_id, page, limit);
                //refreshLayout.setRefreshing(false);
            }
        });
    }


    private void ShowCategoryWise(Integer c_id, int page, int limit ){

        //loadingDialog.startLoadingActivity();
        //pd.setMessage("Loading...");
        //pd.show();





        Call<List<Product>> userList = ApiUtils.getAPIService().CategoryWisePost(c_id, page, limit);

        userList.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {




                if(response.isSuccessful() && response.body() != null){
                    progressBar.setVisibility(View.GONE);

                    JSONArray jsonArray = new JSONArray(response.body());
                    parseResut(jsonArray);


                    List<Product> posts = response.body();
                    adapter.setData(posts);

                    if(posts.isEmpty()){
                        //for diaglog show
                        final Dialog myDialog  = new Dialog(ProductActivity.this);
                        myDialog.setContentView(R.layout.empty_product_layout);
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


//            myDialog.findViewById(R.id.btn_accept_shoping).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    //myDialog.dismiss();
//                    Intent intent = new Intent(CartListActivity.this, MainActivity.class);
//                    startActivity(intent);
////                    Word word = new Word();
////                    ArrayList<Word> list = word.getMyCard();
////                    list.clear();
//
//                }
//            });
                    }


                    //recyclerView.setAdapter(adapter);
                    refreshLayout.setRefreshing(false);

                }

                //loadingDialog.dismissDialog();
                //pd.dismiss();

            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });

    }

    private void parseResut(JSONArray jsonArray) {
        for(int i = 0; i < jsonArray.length(); i++){
            try {
                JSONObject object = jsonArray.getJSONObject(i);
//                Product data = new Product();
//                data.setProductName(object.getString("ProductName"));
//                data.setSalePrice(object.getString("SalePrice"));

                //modelList.add(data);
                recyclerView.setAdapter(adapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void BackClicked1(View view) {
        super.onBackPressed();
    }
}