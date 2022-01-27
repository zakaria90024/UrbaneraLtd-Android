package com.largeit.urbaneraltd.MoreProductActivity;

import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.largeit.urbaneraltd.CartActivity.CartListActivity;
import com.largeit.urbaneraltd.MoreProductActivity.CustomAdapter;
import com.largeit.urbaneraltd.ProductActivity.ProductActivity;
import com.largeit.urbaneraltd.R;
import com.largeit.urbaneraltd.main.data.remote.ApiUtils;
import com.largeit.urbaneraltd.main.model.Product;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoreProductActivity extends AppCompatActivity {
    int page = 1, limit = 10;
    CustomAdapter adapter;
    RecyclerView recyclerView;
    List<Product> modelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_product);
        recyclerView = findViewById(R.id.more_recycler_id);


        //pd = new ProgressDialog(this);
        //loadingDialog = new LoadingDialog(this);
        recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new CustomAdapter(MoreProductActivity.this, modelList);

        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        //recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        //for animation



        String id = getIntent().getStringExtra("category_id");
        Integer c_id = Integer.valueOf(id);

        ShowCategoryWise(c_id,  page,  limit );

        layoutAnimation(recyclerView);

    }
    private void layoutAnimation(RecyclerView recyclerView){
        Context context = recyclerView.getContext();
        LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_fall_down);
        recyclerView.setLayoutAnimation(layoutAnimationController);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }

    private void ShowCategoryWise(Integer c_id, int page, int limit ){

        //loadingDialog.startLoadingActivity();
        //pd.setMessage("Loading...");
        //pd.show();



        Call<List<Product>> userList = ApiUtils.getAPIService().CategoryWisePost(c_id, page, limit);

        userList.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {

                List<Product> posts = response.body();
                adapter.setData(posts);
                recyclerView.setAdapter(adapter);

                //loadingDialog.dismissDialog();
                //pd.dismiss();

            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });

    }


    public void BackClicked11(View view) {
        super.onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void CartClicked(View view) {
        Intent intent = new Intent(MoreProductActivity.this, CartListActivity.class);
        startActivity(intent);

    }
}