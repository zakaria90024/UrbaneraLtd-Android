package com.largeit.urbaneraltd.CartFragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.largeit.urbaneraltd.CartFragment.CustomAdapter;
import com.largeit.urbaneraltd.HomeFragment.LatestProduct.LatestProductAdapter;
import com.largeit.urbaneraltd.R;
import com.largeit.urbaneraltd.main.model.LatestProductModel;
import com.largeit.urbaneraltd.main.model.TopOneModel;
import com.largeit.urbaneraltd.main.model.Word;

import java.util.ArrayList;
import java.util.List;


public class CartFragment extends Fragment {

    //for notification
    public static int cart_count;
    public TextView cartTextView;
    Button moreBtn;
    CartFragment cartFragment;
    //List<Word> post = new ArrayList<>();
    com.largeit.urbaneraltd.CartFragment.CustomAdapter adapter;



    public TextView textView, title2, title3;
    public ImageView cartImageView;

    SwipeRefreshLayout swipeLayout;

    //for Latest Product Show
    RecyclerView recyclerView_Cart_in_fragment;
    RecyclerView.LayoutManager layoutManager_latest_product;
    LatestProductAdapter adapter_latest_product;
    ArrayList<Word> modelList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View View = inflater.inflate(R.layout.fragment_cart, container, false);


//        int ii = 0;
//        int  i = modelList.get(ii).getTotalCash();
//
//        Toast.makeText(getActivity(), ""+i, Toast.LENGTH_SHORT).show();

        //for category shoe recycler
        recyclerView_Cart_in_fragment = View.findViewById(R.id.cart_fragment_recycler_id);
        recyclerView_Cart_in_fragment.setHasFixedSize(true);
        adapter = new CustomAdapter(cartFragment, modelList, View.getContext());

        //recyclerView_Cart_in_fragment.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView_Cart_in_fragment.setLayoutManager(new LinearLayoutManager(View.getContext(), LinearLayoutManager.VERTICAL, false));

//        Word word = new Word();
//        ArrayList<Word> list = word.getMyCard();

        ArrayList<Word> modelList = new ArrayList<>();
        adapter.setData(modelList);

        recyclerView_Cart_in_fragment.setAdapter(adapter);

        return View;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }
}