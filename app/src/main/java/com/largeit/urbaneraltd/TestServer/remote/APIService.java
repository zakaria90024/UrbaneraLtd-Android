package com.largeit.urbaneraltd.TestServer.remote;



import com.largeit.urbaneraltd.TestServer.model.CartList;
import com.largeit.urbaneraltd.TestServer.model.ListOrder;
import com.largeit.urbaneraltd.TestServer.model.Order;
import com.largeit.urbaneraltd.TestServer.model.Post;
import com.largeit.urbaneraltd.TestServer.model.auth.CustomarInfo;
import com.largeit.urbaneraltd.TestServer.model.auth.Token;
import com.largeit.urbaneraltd.main.model.Category;
import com.largeit.urbaneraltd.main.model.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {

//    @GET("/api/order")
//    Call<List<Post>> getpost();
//
//    @GET("/api/order")
//    Call<List<Post>> getUsers(@Query("name") String keyword);

//    @FormUrlEncoded
//    @POST("/apps/add_to_cart")
//    Call<Post> savePost(@Body Post post);

    @POST("/apps/add_to_cart")
    Call<Post> createPost(@Body Post post);

    @FormUrlEncoded
    @POST("/apps/add_to_cart")
    Call<ResponseBody> createPost(@Field("ProductID") Integer ProductID, @Field("ProductName") String ProductName,
                                    @Field("SalePrice") Integer SalePrice, @Field("quantity") Integer quantity);

    @FormUrlEncoded
    @POST("/apps/add_to_cart")
    Call<Post> createPost(@FieldMap Map<String, String> fields);


//    @FormUrlEncoded
//    @POST("/apps/Subject")
//    Call<Post> putPost(
//            //@Path("id") int id,
//            @Field("class_id") String class_id,
//            @Field("subject_name") String subject_name,
//            @Field("subject_code") String subject_code);

//
////    @PATCH("/api/order")
////    Call<Post> patchPost(@Path("id") int id, @Field("name") String name, @Field("email") String email, @Field("number") String number, @Field("cash") String cash,
////                         @Field("address") String address, @Field("state") String state, @Field("zip") String zip, @Field("role") String role);
//
//    @DELETE("/api/order/{id}")
//    Call<Void> deletePost(@Path("id") int id);

//    @FormUrlEncoded
//    @POST("/api/cart")
//    Call<Post> putPost(@Field("pID") Integer pID, @Field("pName") String pName,
//                          @Field("pPrice") Integer pPrice, @Field("pQty") Integer pQty, @Field("pImage") String pImage);


    @FormUrlEncoded
    @POST("/apps/Subject")
    Call<Post> putPostProductMaping(
            //@Path("id") int id,
            @Field("OrderID") Integer OrderID,
            @Field("ProductID") Integer ProductID,
            @Field("Qty") Integer Qty,
            @Field("Price") Integer Price);

    @FormUrlEncoded
    @POST("/apps/order")
    Call<Order> putPostProductOrder(
            //@Path("id") int id,
            @Field("OrderID") Integer OrderID,
            @Field("TotalPrice") Integer TotalPrice,
            @Field("TotalQty") Integer TotalQty,
            @Field("Phone") String Phone,
            @Field("CustomerName") String CustomerName,
            @Field("ShippingAddress") String ShippingAddress,
            @Field("delivery_charge") Integer delivery_charge,
            @Field("Comments") String Comments);


    @FormUrlEncoded
    @POST("/apps/order_by_apps_latest")
    Call<Order> PostFinalOrder(
            //@Path("id") int id,
            @Field("name") String name,
            @Field("number") String number,
            @Field("email") String email,
            @Field("address") String address,
            @Field("grandtotal") Integer grandtotal,
            @Field("deliverycost") Integer deliverycost,
            @Field("total_quantity") Integer total_quantity,

            //@FieldMap Map<String, String> cartlist
            @Field("cartlist") ArrayList<Word> cartlist

    );

    @FormUrlEncoded
    @POST("/apps/register_customer")
    Call<Post> RegisterCall(
            @Field("name") String name,
            @Field("email") String email,
            @Field("gender") Integer gender,
            @Field("phone") String phone,
            @Field("address") String address,
            @Field("password") String password

    );

    @FormUrlEncoded
    @POST("/apps/auth/login")
    Call<Token> LoginCall(

            @Field("email") String email,
            @Field("password") String password

    );

    @FormUrlEncoded
    @POST("/apps/auth/me")
    Call<CustomarInfo> CallWithToken(
            @Field("token") String token
    );



    @POST("/apps/order_by_apps")
    Call<Post> postWithObject(@Body CartList cartlist);


    @GET("/apps/Subject")
    Call<List<Post>> getLastOrderId();



}
