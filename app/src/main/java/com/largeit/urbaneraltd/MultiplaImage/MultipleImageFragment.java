package com.largeit.urbaneraltd.MultiplaImage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.largeit.urbaneraltd.R;
import com.largeit.urbaneraltd.main.data.remote.ApiUtils;
import com.largeit.urbaneraltd.main.model.MultipleImageModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MultipleImageFragment extends Fragment {


    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    CustomAdapter adapter;
    List<MultipleImageModel> modelList = new ArrayList<>();
    MultipleImageFragment multipleImageFragment;
    Context context;
    ImageView imageView;


    public MultipleImageFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = this.getArguments();
        String product_id = getArguments().getString("product_id");
        final Integer product_id_int = Integer.valueOf(product_id);
        //Toast.makeText(getActivity(),"Text!"+product_id_int,Toast.LENGTH_SHORT).show();

        getMultiImageData(product_id_int);

    }

    private void getMultiImageData(Integer product_id_int) {

        Call<List<MultipleImageModel>> multipleProductImage = ApiUtils.getAPIService().MultipleProductImage(product_id_int);
        multipleProductImage.enqueue(new Callback<List<MultipleImageModel>>() {
            @Override
            public void onResponse(Call<List<MultipleImageModel>> call, Response<List<MultipleImageModel>> response) {

                List<MultipleImageModel> posts = response.body();
                adapter.setData(posts);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<MultipleImageModel>> call, Throwable t) {

            }
        });


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View View = inflater.inflate(R.layout.fragment_multiple_image, container, false);

        //imageView = View.findViewById(R.id.imageView3);

        //start recyclerview =======================================================================
        recyclerView = View.findViewById(R.id.multiimage);
        //refreshLayout = findViewById(R.id.swipeId);
        recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(View.getContext(), DividerItemDecoration.HORIZONTAL));
        adapter = new CustomAdapter( multipleImageFragment, modelList, View.getContext());
        layoutManager = new LinearLayoutManager(View.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        //End recyclerview =========================================================================

        return View;
    }



}