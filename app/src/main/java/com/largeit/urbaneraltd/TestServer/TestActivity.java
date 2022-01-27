package com.largeit.urbaneraltd.TestServer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.largeit.urbaneraltd.R;
import com.largeit.urbaneraltd.TestServer.model.Post;
import com.largeit.urbaneraltd.TestServer.remote.APIService;
import com.largeit.urbaneraltd.TestServer.remote.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestActivity extends AppCompatActivity {

    private APIService mAPIService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mAPIService = ApiUtils.getAPIServices();
    }

//    public void insertedClickec(View view) {
//        createPost("8", "bangla", "1");
//
//    }

//    private void createPost(String s, String bangla, String s1) {
//        mAPIService.putPost(s, bangla, s1).enqueue(new Callback<Post>() {
//            @Override
//            public void onResponse(Call<Post> call, Response<Post> response) {
//                Toast.makeText(TestActivity.this, "Inserted ", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<Post> call, Throwable t) {
//                Toast.makeText(TestActivity.this, " not Inserted "+t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}