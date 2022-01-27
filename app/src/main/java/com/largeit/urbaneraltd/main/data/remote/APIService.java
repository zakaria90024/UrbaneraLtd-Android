package com.largeit.urbaneraltd.main.data.remote;


import com.google.gson.JsonObject;
import com.largeit.urbaneraltd.main.model.CartModel;
import com.largeit.urbaneraltd.main.model.Category;
import com.largeit.urbaneraltd.main.model.LatestProductModel;
import com.largeit.urbaneraltd.main.model.MultipleImageModel;
import com.largeit.urbaneraltd.main.model.Product;
import com.largeit.urbaneraltd.main.model.ProductDiscriptionModel;
import com.largeit.urbaneraltd.main.model.RelateProductModel;
import com.largeit.urbaneraltd.main.model.SliderModel;
import com.largeit.urbaneraltd.main.model.Test;
import com.largeit.urbaneraltd.main.model.TopOneModel;
import com.largeit.urbaneraltd.main.model.TopOneNameModel;
import com.largeit.urbaneraltd.main.model.TopTwoModel;
import com.largeit.urbaneraltd.main.model.Word;

import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface APIService {


    //for category
    @GET("/apps/slider_item")
    Call<List<SliderModel>> getSlider();

    //for category
    @GET("/apps/category")
    Call<List<Category>> getCategory();



    //for get category name
    @GET("/apps/first_frontend_category")
    Call<TopOneNameModel> getTopOneName();

    @GET("/apps/second_frontend_category")
    Call<TopOneNameModel> getTopTwoName();

    @GET("/apps/third_frontend_category")
    Call<TopOneNameModel> getTopThreeName();



    //single product details
    @GET("/apps/single_product_details/{id}")
    Call<ProductDiscriptionModel> getDescription(@Path("id") int id);


    //categorywise related product
    //apps/single_product_related_category_products/127
    @GET("apps/single_product_related_category_products/{id}")
    Call<List<RelateProductModel>> getRelatedProduct(@Path("id") int id);




    //for topthree category get
    @GET("/apps/latest_products")
    Call<List<LatestProductModel>> getLetestProduct();

    @GET("apps/first_frontend_category_products")
    Call<List<TopTwoModel>> getTopTowProduct();

    @GET("/apps/second_frontend_category_products")
    Call<List<TopOneModel>> getTopOneProduct();
    //for get category name
    @GET("/apps/third_frontend_category_products")
    Call<List<TopOneModel>> getTopThreeProduct();




    //single product multiple image
    @GET("/apps/single_product_multiple_image/{id}")
    Call<List<MultipleImageModel>> MultipleProductImage(@Path("id") int id);




    //category wise product
    @GET("/apps/category_wise_product/{id}")
    Call<List<Product>> CategoryWisePost(@Path("id") int id,
                                         @Query("page") int page,
                                         @Query("limit") int limit
                                         );




//    //@Headers("Content-Type: application/json")
//    @POST("/apps/add_to_cart")
//    Call<CartModel> getaddToCart(@Body String  user);


    @POST("/posts")
    Call<CartModel> savePost(@Body ResponseBody post);

//    //post request cart

    //@Headers("Content-Type: application/x-www-form-urlencoded")
//    @FormUrlEncoded
//    @POST("/apps/add_to_cart")
//    Call<CartModel> getaddToCart(@Field("id") Integer ProductID,
//                                 @Field("name") String ProductName,
//                                 @Field("price") Integer SalePrice,
//                                 @Field("quantity") Integer quantity);


//    @Headers( "Content-Type: application/json" )
//    @POST("/apps/add_to_cart")
//    Call<CartModel> ApiName(@Body JsonObject jsonBody);



//    @POST("/apps/add_to_cart")
//    Call<CartModel> createPost(@Body CartModel post);
////    @FormUrlEncoded
////    @POST("/apps/add_to_cart")
////    Call<CartModel> createPost(@Field("ProductID") Integer ProductID, @Field("ProductName") String ProductName,
////                                  @Field("SalePrice") Integer SalePrice, @Field("quantity") Integer quantity);


//    @FormUrlEncoded
//    @POST("/apps/add_to_cart")
//    Call<CartModel> createPost(@FieldMap Map<String, String> fields);

//    @FormUrlEncoded
//    @POST("/apps/buy_now")
//    Call<CartModel> createPost(@Field("id") Integer ProductID, @Field("name") String ProductName,
//                                  @Field("price") Integer SalePrice, @Field("quantity") Integer quantity);





    @FormUrlEncoded
    @POST("/api/cart")
    Call<Test> createPost(@Field("pID") Integer pID, @Field("pName") String pName,
                          @Field("pPrice") Integer pPrice, @Field("pQty") Integer pQty, @Field("pImage") String pImage);



}
