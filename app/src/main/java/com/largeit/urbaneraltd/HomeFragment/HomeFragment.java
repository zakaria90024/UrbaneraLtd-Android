package com.largeit.urbaneraltd.HomeFragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.largeit.urbaneraltd.CartActivity.CartListActivity;
import com.largeit.urbaneraltd.HomeFragment.LatestProduct.LatestProductAdapter;
import com.largeit.urbaneraltd.HomeFragment.Slider.SliderAdapter;
import com.largeit.urbaneraltd.HomeFragment.Slider.SliderData;
import com.largeit.urbaneraltd.HomeFragment.TopOneRecycler.TopOneAdapter;
import com.largeit.urbaneraltd.HomeFragment.TopThreeRecycler.TopThreeAdapter;
import com.largeit.urbaneraltd.HomeFragment.TopTwoRecycler.TopTwoAdapter;
import com.largeit.urbaneraltd.MoreProductActivity.MoreProductActivity;
import com.largeit.urbaneraltd.R;
import com.largeit.urbaneraltd.main.data.remote.ApiUtils;
import com.largeit.urbaneraltd.main.model.Category;
import com.largeit.urbaneraltd.main.model.LatestProductModel;
import com.largeit.urbaneraltd.main.model.SliderModel;
import com.largeit.urbaneraltd.main.model.TopOneModel;
import com.largeit.urbaneraltd.main.model.TopOneNameModel;
import com.largeit.urbaneraltd.main.model.TopTwoModel;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {


    ViewFlipper v_Flipper;
    Animation fade_in, fade_out;
    ImageView fliperImageView;
    ImageSlider imageSlider;

    SliderView sliderView;
    List<SliderModel> sliderModelArrayList = new ArrayList<>();


    public TextView cartTextView;
    Button moreBtn, moreBtn2, moreBtn3; ;
    TextView topCategory, Latest_Product;


    public TextView textView, title2, title3;
    public ImageView cartImageView;

    SwipeRefreshLayout swipeLayout;

    //for Latest Product Show
    RecyclerView recyclerView_latest_product;
    RecyclerView.LayoutManager layoutManager_latest_product;
    LatestProductAdapter adapter_latest_product;
    List<LatestProductModel> modelList_latest_product = new ArrayList<>();

    //for women product top one
    RecyclerView recyclerView_top_two;
    RecyclerView.LayoutManager layoutManager_top_two;
    TopTwoAdapter adapterTop_two;
    List<TopTwoModel> modelListTopTwo = new ArrayList<>();


    //for jens product top 2
    RecyclerView recyclerView_top_one;
    RecyclerView.LayoutManager layoutManager_top_one;
    TopOneAdapter adapterTop_one;
    List<TopOneModel> modelListTopOne = new ArrayList<>();

    //for jens product top 3
    RecyclerView recyclerView_top_three;
    RecyclerView.LayoutManager layoutManager_top_three;
    TopThreeAdapter adapterTop_three;
    List<TopOneModel> modelListTopThree = new ArrayList<>();



    //for category show
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    com.largeit.urbaneraltd.HomeFragment.CustomAdapter adapter;
    List<Category> modelList = new ArrayList<>();
    HomeFragment touristFragment;
    Context context;
    ImageView imageView;

    public HomeFragment(){

    }

    @SuppressLint("ResourceAsColor")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View View = inflater.inflate(R.layout.fragment_home, container, false);


        List<SlideModel> imageList = new ArrayList<>();
        imageSlider = View.findViewById(R.id.image_slider);
        sliderView = View.findViewById(R.id.slider);







//        imageList.add(new SlideModel("https://urbaneraltd.com/frontend_assets/upload_assets/images/product/slider/fast.jpg", ""));
//        imageList.add(new SlideModel("https://urbaneraltd.com/frontend_assets/upload_assets/images/product/slider/website.jpg", ""));
//        imageList.add(new SlideModel("https://urbaneraltd.com/frontend_assets/upload_assets/images/product/slider/tab.jpg", ""));
//


        //imageSlider.setImageList(imageList, true);


        //int images[] = {R.drawable.placeholder_image, R.drawable.defaultimage, R.drawable.placeholder};
//        fliperImageView = new ImageView(getActivity());
//        for(int image:images){
//
//            fliperImageView.setBackgroundResource(image);
//        }

        //for slider
        //v_Flipper = View.findViewById(R.id.viewFlipper);



//        v_Flipper.addView(fliperImageView);
//        v_Flipper.setFlipInterval(4000);
//        v_Flipper.setAutoStart(true);
//
//        fade_in = AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_in);
//        fade_out = AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_out);
//
//        v_Flipper.setInAnimation(fade_in);
//        v_Flipper.setOutAnimation(fade_out);




         //cartTextView = View.findViewById(R.id.count);
         textView = View.findViewById(R.id.textView_leather_goods);
         title2 = View.findViewById(R.id.top_two_title_textview_id);
         title3 = View.findViewById(R.id.top_three_title_textview_id);
         cartImageView = View.findViewById(R.id.card_home_image_id);
         moreBtn = View.findViewById(R.id.button_more_id);
         moreBtn2 = View.findViewById(R.id.button_more_id3);
         moreBtn3 = View.findViewById(R.id.button_more_id4);
//         topCategory = View.findViewById(R.id.textView_TopCategory_Id);
//         Latest_Product = View.findViewById(R.id.textView9_Latest_Product);




       // cartTextView.setText(""+cart_count);


//         cartImageView.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(android.view.View v) {
//                 Intent intent = new Intent(getContext(), CartListActivity.class);
//                 startActivity(intent);
//             }
//         });


//        //for swipe refresh
//        swipeLayout = (SwipeRefreshLayout) View.findViewById(R.id.swipe_container);
//        swipeLayout.setOnRefreshListener(this);
//        swipeLayout.setColorSchemeColors(android.R.color.holo_green_dark,
//                android.R.color.holo_red_dark,
//                android.R.color.holo_blue_dark,
//                android.R.color.holo_orange_dark);



        //for category shoe recycler
        recyclerView = View.findViewById(R.id.recycler_home_category);
        recyclerView.setHasFixedSize(true);
        adapter = new CustomAdapter( touristFragment, modelList, View.getContext());
        //recyclerView_top_one.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.setLayoutManager(new LinearLayoutManager(View.getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);

        //loadingDialog = new LoadingDialog(getActivity());//for loading show

        //imageView = View.findViewById(R.id.imageView3);
        //start recyclerview =======================================================================
        //recyclerView = View.findViewById(R.id.recycler_home_category);
        //refreshLayout = findViewById(R.id.swipeId);
        //recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //recyclerView.addItemDecoration(new DividerItemDecoration(View.getContext(), DividerItemDecoration.HORIZONTAL));
        //adapter = new CustomAdapter( touristFragment, modelList, View.getContext());
        //recyclerView.setLayoutManager(new GridLayoutManager(View.getContext(),12));
        //layoutManager = new LinearLayoutManager(View.getContext(), LinearLayoutManager.HORIZONTAL, false);
        //recyclerView.setLayoutManager(layoutManager);
        //End recyclerview =========================================================================





        //RecyclerView myrv = (RecyclerView) v.findViewById(R.id.recyclerview_id);
        //Recyclerview_Adapter myrv_Adapter = new Recyclerview_Adapter(getContext(), lstTovar);
        //myrv.setLayoutManager(new GridLayoutManager(getContext(), 3));
        //myrv.setAdapter(myrv_Adapter);


        //RecyclerView my_recycler_view = (RecyclerView) findViewById(R.id.my_recycler_view);
        //my_recycler_view.setHasFixedSize(true);
        //RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(this, allSampleData);
        //my_recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //my_recycler_view.setAdapter(adapter);


        //RecyclerView my_recycler_view = (RecyclerView) findViewById(R.id.my_recycler_view);
        //my_recycler_view.setHasFixedSize(true);
        //RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(this, allSampleData);
        //my_recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //my_recycler_view.setAdapter(adapter);


        //for women product show
        recyclerView_top_three = View.findViewById(R.id.recycler_top_three_id);
        recyclerView_top_three.setHasFixedSize(true);

        //adapter = new CustomAdapter(HomeActivity.this, modelList);
        adapterTop_three = new TopThreeAdapter( touristFragment, modelListTopThree, View.getContext());

        //RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);


        recyclerView_top_three.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        //recyclerView_top_three.setLayoutManager(new LinearLayoutManager(View.getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView_top_three.setAdapter(adapterTop_three);


        //for women product show
        recyclerView_top_one = View.findViewById(R.id.recylcler_top_2_id);
        recyclerView_top_one.setHasFixedSize(true);
        adapterTop_one = new TopOneAdapter( touristFragment, modelListTopOne, View.getContext());
        recyclerView_top_one.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        //recyclerView_top_one.setLayoutManager(new LinearLayoutManager(View.getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView_top_one.setAdapter(adapterTop_one);


        //recyclerView.setLayoutManager(new GridLayoutManager(View.getContext(),12));
        //layoutManager_top_one = new LinearLayoutManager(View.getContext(), LinearLayoutManager.HORIZONTAL, false);
        //recyclerView_top_one.setLayoutManager(layoutManager_top_one);


        //for jens product show
        recyclerView_top_two = View.findViewById(R.id.recylcler_top_one_id);
        recyclerView_top_two.setHasFixedSize(true);
        adapterTop_two = new TopTwoAdapter( touristFragment, modelListTopTwo, View.getContext());
        //recyclerView_top_one.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView_top_two.setLayoutManager(new LinearLayoutManager(View.getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView_top_two.setAdapter(adapterTop_two);



        //for Latest Product Show
        recyclerView_latest_product = View.findViewById(R.id.recycler_latest_product_view_id);
        recyclerView_latest_product.setHasFixedSize(true);
        adapter_latest_product = new LatestProductAdapter(touristFragment, modelList_latest_product, View.getContext());
        recyclerView_latest_product.setLayoutManager(new LinearLayoutManager(View.getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView_latest_product.setAdapter(adapter_latest_product);




        //view more  btn start
        moreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<TopOneNameModel> listCall = ApiUtils.getAPIService().getTopOneName();
                listCall.enqueue(new Callback<TopOneNameModel>() {
                    @Override
                    public void onResponse(Call<TopOneNameModel> call, Response<TopOneNameModel> response) {
                        TopOneNameModel myResponse = response.body();
                        //textView.setText(myResponse.getCategoryID());

                        Integer idINT = myResponse.getCategoryID();
                        String id = String.valueOf(idINT);
                        Intent intent = new Intent(getActivity(), MoreProductActivity.class);
                        intent.putExtra("category_id", id);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<TopOneNameModel> call, Throwable t) {

                    }
                });



            }
        });

        moreBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<TopOneNameModel> listCall = ApiUtils.getAPIService().getTopTwoName();
                listCall.enqueue(new Callback<TopOneNameModel>() {
                    @Override
                    public void onResponse(Call<TopOneNameModel> call, Response<TopOneNameModel> response) {
                        TopOneNameModel myResponse = response.body();
                        //textView.setText(myResponse.getCategoryID());

                        Integer idINT = myResponse.getCategoryID();
                        String id = String.valueOf(idINT);
                        Intent intent = new Intent(getActivity(), MoreProductActivity.class);
                        intent.putExtra("category_id", id);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<TopOneNameModel> call, Throwable t) {

                    }
                });



            }
        });

        moreBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Call<TopOneNameModel> listCall = ApiUtils.getAPIService().getTopThreeName();
                listCall.enqueue(new Callback<TopOneNameModel>() {
                    @Override
                    public void onResponse(Call<TopOneNameModel> call, Response<TopOneNameModel> response) {
                        TopOneNameModel myResponse = response.body();
                        //textView.setText(myResponse.getCategoryID());
                        Integer idINT = myResponse.getCategoryID();
                        String id = String.valueOf(idINT);
                        Intent intent = new Intent(getActivity(), MoreProductActivity.class);
                        intent.putExtra("category_id", id);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<TopOneNameModel> call, Throwable t) {

                    }
                });


            }
        });

        //end view more btn

        return View;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        //textView.setText("Hello");


        getData();
        getDataTopOne();
        getDataTopTwo();
        getLatestProduct();
        getDataTopThree();

        getSlider();



        //for title get
        Call<TopOneNameModel> listCall = ApiUtils.getAPIService().getTopOneName();
        listCall.enqueue(new Callback<TopOneNameModel>() {
            @Override
            public void onResponse(Call<TopOneNameModel> call, Response<TopOneNameModel> response) {
                TopOneNameModel myResponse = response.body();
                textView.setText(myResponse.getCategoryName());
            }

            @Override
            public void onFailure(Call<TopOneNameModel> call, Throwable t) {

            }
        });


        Call<TopOneNameModel> listCall2 = ApiUtils.getAPIService().getTopTwoName();
        listCall2.enqueue(new Callback<TopOneNameModel>() {
            @Override
            public void onResponse(Call<TopOneNameModel> call, Response<TopOneNameModel> response) {
                TopOneNameModel myResponse = response.body();
                title2.setText(myResponse.getCategoryName());
            }

            @Override
            public void onFailure(Call<TopOneNameModel> call, Throwable t) {

            }
        });


        Call<TopOneNameModel> listCall3 = ApiUtils.getAPIService().getTopThreeName();
        listCall3.enqueue(new Callback<TopOneNameModel>() {
            @Override
            public void onResponse(Call<TopOneNameModel> call, Response<TopOneNameModel> response) {
                TopOneNameModel myResponse = response.body();
                title3.setText(myResponse.getCategoryName());
            }

            @Override
            public void onFailure(Call<TopOneNameModel> call, Throwable t) {

            }
        });

    }

    private void getSlider() {





        Call<List<SliderModel>> sliderModelCall = ApiUtils.getAPIService().getSlider();
        sliderModelCall.enqueue(new Callback<List<SliderModel>>() {
            @Override
            public void onResponse(Call<List<SliderModel>> call, Response<List<SliderModel>> response) {



                List<SliderModel> sliderModels = response.body();
                List<SlideModel> imageList = new ArrayList<>();


                // we are creating array list for storing our image urls.
                ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();

                // initializing the slider view.
                //SliderView sliderView = View.findViewById(R.id.slider);

                //Toast.makeText(getActivity(), ""+sliderModels.get(0).getImageName(), Toast.LENGTH_SHORT).show();

                //imageSlider = View.findViewById(R.id.image_slider);
                for (int i = 0; i < sliderModels.size(); i++){
                    imageList.add(new SlideModel("https://urbaneraltd.com/frontend_assets/upload_assets/images/product/slider/"+sliderModels.get(i).getImageName(), ""));
                }

                for (int i = 0; i < sliderModels.size(); i++){
                    sliderDataArrayList.add(new SliderData("https://urbaneraltd.com/frontend_assets/upload_assets/images/product/slider/"+sliderModels.get(i).getImageName()));
                }
                // passing this array list inside our adapter class.
                SliderAdapter adapter = new SliderAdapter(getActivity(), sliderDataArrayList);
                // initializing the slider view.

                // below method is used to set auto cycle direction in left to
                // right direction you can change according to requirement.
                sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

                // below method is used to
                // setadapter to sliderview.
                sliderView.setSliderAdapter(adapter);

                // below method is use to set
                // scroll time in seconds.
                sliderView.setScrollTimeInSec(3);

                // to set it scrollable automatically
                // we use below method.
                sliderView.setAutoCycle(true);

                // to start autocycle below method is used.
                sliderView.startAutoCycle();





                //sliderModels.get(0).getImageName();

                imageSlider.setImageList(imageList, false);

            }

            @Override
            public void onFailure(Call<List<SliderModel>> call, Throwable t) {

            }
        });

    }

    private void fliperImage(int image) {
        ImageView imageView = new ImageView(getActivity());
        imageView.setBackgroundResource(image);

        v_Flipper.addView(imageView);
        v_Flipper.setFlipInterval(4000);
        v_Flipper.setAutoStart(true);

        fade_in = AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_in);
        fade_out = AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_out);

        v_Flipper.setInAnimation(fade_in);
        v_Flipper.setOutAnimation(fade_out);
    }

    private void getDataTopThree() {
        Call<List<TopOneModel>> toOnleList = ApiUtils.getAPIService().getTopThreeProduct();
        toOnleList.enqueue(new Callback<List<TopOneModel>>() {
            @Override
            public void onResponse(Call<List<TopOneModel>> call, Response<List<TopOneModel>> response) {
                List<TopOneModel> modelListTopOne = response.body();
                adapterTop_three.setDataa(modelListTopOne);
                recyclerView_top_three.setAdapter(adapterTop_three);
            }

            @Override
            public void onFailure(Call<List<TopOneModel>> call, Throwable t) {

            }
        });

        //end get title

    }

//    private void getTopOneName() {
//        Call<TopOneNameModel> listCall = ApiUtils.getAPIService().getTopOneName();
//        listCall.enqueue(new Callback<List<TopOneNameModel>>() {
//            @Override
//            public void onResponse(Call<List<TopOneNameModel>> call, Response<List<TopOneNameModel>> response) {
//               TopOneNameModel jsonString = (TopOneNameModel) response.body();
////                Gson gson = new Gson();
////                TopOneNameModel status = gson.fromJson(jsonString, TopOneNameModel.class);
////
////
////                textView.setText(jsonString);
////                Toast.makeText(getActivity().getBaseContext(), "helloi"+jsonString, Toast.LENGTH_SHORT).show();
//                  System.out.println("Light :"+jsonString.getCategoryName());
//                  String categoryName = jsonString.getCategoryName();
//
//
//
//
//            }
//
//            @Override
//            public void onFailure(Call<List<TopOneNameModel>> call, Throwable t) {
//
//            }
//        });
//    }

    private void getLatestProduct() {


//        final ProgressDialog dialog= DialogUtils.showProgressDialog(getActivity(),"Loading...");
//        dialog.setCancelable(true);

        Call<List<LatestProductModel>> listCall = ApiUtils.getAPIService().getLetestProduct();
        listCall.enqueue(new Callback<List<LatestProductModel>>() {
            @Override
            public void onResponse(Call<List<LatestProductModel>> call, Response<List<LatestProductModel>> response) {
                List<LatestProductModel> latestProductModels = response.body();
                adapter_latest_product.setDataa(latestProductModels);
                recyclerView_latest_product.setAdapter(adapter_latest_product);
                //loadingDialog.dismissDialog();

                //dialog.dismiss();

            }

            @Override
            public void onFailure(Call<List<LatestProductModel>> call, Throwable t) {

            }
        });
    }

    private void getDataTopTwo() {
        Call<List<TopTwoModel>> listCall = ApiUtils.getAPIService().getTopTowProduct();
        listCall.enqueue(new Callback<List<TopTwoModel>>() {
            @Override
            public void onResponse(Call<List<TopTwoModel>> call, Response<List<TopTwoModel>> response) {
                List<TopTwoModel> modelListTopOne = response.body();
                adapterTop_two.setDataa(modelListTopOne);
                recyclerView_top_two.setAdapter(adapterTop_two);
            }

            @Override
            public void onFailure(Call<List<TopTwoModel>> call, Throwable t) {

            }
        });
    }

    private void getDataTopOne() {


        Call<List<TopOneModel>> toOnleList = ApiUtils.getAPIService().getTopOneProduct();
        toOnleList.enqueue(new Callback<List<TopOneModel>>() {
            @Override
            public void onResponse(Call<List<TopOneModel>> call, Response<List<TopOneModel>> response) {
                List<TopOneModel> modelListTopOne = response.body();
                adapterTop_one.setDataa(modelListTopOne);
                recyclerView_top_one.setAdapter(adapterTop_one);
            }

            @Override
            public void onFailure(Call<List<TopOneModel>> call, Throwable t) {

            }
        });
    }

    private void getData() {

        Call<List<Category>> categoryList = ApiUtils.getAPIService().getCategory();

        categoryList.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                List<Category> posts = response.body();
                adapter.setData(posts);
                recyclerView.setAdapter(adapter);
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


//    @Override
//    public void onRefresh() {
//        //new getData().execute();
//    }
}