package com.largeit.urbaneraltd.CategoryFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.largeit.urbaneraltd.HomeFragment.HomeFragment;
import com.largeit.urbaneraltd.R;
import com.largeit.urbaneraltd.main.data.remote.ApiUtils;
import com.largeit.urbaneraltd.main.model.Category;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryActivity extends AppCompatActivity {

    public ProgressBar pd;
    //for category show
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    com.largeit.urbaneraltd.CategoryFragment.CustomAdapter adapter;
    List<Category> modelList = new ArrayList<>();
    HomeFragment touristFragment;
    SwipeRefreshLayout refreshLayout;
    Context context;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        recyclerView = findViewById(R.id.product_recycler_id);
        refreshLayout = findViewById(R.id.swipe_container);
        recyclerView.setHasFixedSize(true);
        adapter = new com.largeit.urbaneraltd.CategoryFragment.CustomAdapter( CategoryActivity.this, modelList, context);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 5));
        //recyclerView.setLayoutManager(new LinearLayoutManager(View.getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        pd = findViewById(R.id.progress_custom_id);



        getData();
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
                getData();
                //refreshLayout.setRefreshing(false);
            }
        });
    }


    private void getData() {

        //pd.setMessage("Loading...");
        pd.setVisibility(View.VISIBLE);

        Call<List<Category>> categoryList = ApiUtils.getAPIService().getCategory();

        categoryList.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                List<Category> posts = response.body();
                adapter.setData(posts);
                recyclerView.setAdapter(adapter);
                pd.setVisibility(View.GONE);
                refreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {

            }
        });

//        touristList.enqueue(new Callback<List<Category>>() {
//            @Override
//            public void onResponse(Call<List<Tourist>> call, Response<List<Tourist>> response) {
//                List<Tourist> posts = response.body();
//                adapter.setData(posts);
//                recyclerView.setAdapter(adapter);
//            }
//
//            @Override
//            public void onFailure(Call<List<Tourist>> call, Throwable t) {
//
//            }
//        });
    }

    public void BackClicked1(View view) {
        super.onBackPressed();
    }
}