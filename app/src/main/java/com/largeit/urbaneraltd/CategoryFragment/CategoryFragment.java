package com.largeit.urbaneraltd.CategoryFragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.largeit.urbaneraltd.HomeFragment.CustomAdapter;
import com.largeit.urbaneraltd.HomeFragment.HomeFragment;
import com.largeit.urbaneraltd.R;
import com.largeit.urbaneraltd.main.data.remote.ApiUtils;
import com.largeit.urbaneraltd.main.model.Category;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryFragment extends Fragment {
    ProgressDialog pd;

    //for category show
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    com.largeit.urbaneraltd.HomeFragment.CustomAdapter adapter;
    List<Category> modelList = new ArrayList<>();
    HomeFragment touristFragment;
    Context context;
    ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View View = inflater.inflate(R.layout.fragment_category, container, false);

        //for category shoe recycler
        recyclerView = View.findViewById(R.id.recycler_fragment_category_id);
        recyclerView.setHasFixedSize(true);
        adapter = new CustomAdapter( touristFragment, modelList, View.getContext());
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        //recyclerView.setLayoutManager(new LinearLayoutManager(View.getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        return View;
    }

    private void getData() {

//        pd.setMessage("Loading...");
//        pd.show();


        Call<List<Category>> categoryList = ApiUtils.getAPIService().getCategory();

        categoryList.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                List<Category> posts = response.body();
                adapter.setData(posts);
                recyclerView.setAdapter(adapter);
                //pd.dismiss();
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
}