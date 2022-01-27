package com.largeit.urbaneraltd.AccountActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.largeit.urbaneraltd.MainActivity;
import com.largeit.urbaneraltd.R;
import com.largeit.urbaneraltd.TestServer.model.auth.CustomarInfo;
import com.largeit.urbaneraltd.TestServer.remote.APIService;
import com.largeit.urbaneraltd.TestServer.remote.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountActivity extends AppCompatActivity {

    private APIService mAPIService;
    TextView C_Name,C_Phone, C_Email, C_Gender, C_Address;
    TextView logout_id;

    public static final String PREFS_NAME = "Login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        mAPIService = ApiUtils.getAPIServices();

        ImageView imageView = findViewById(R.id.imageView_profile);



        C_Name = findViewById(R.id.customar_name_id);
        C_Phone = findViewById(R.id.customar_phone_number_id);
        C_Email = findViewById(R.id.customar_email_id);
        C_Gender = findViewById(R.id.customar_gender_id);
        C_Address = findViewById(R.id.customar_address_id);
        logout_id = findViewById(R.id.logout_id);

        logout_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //SharedPreferences sp1=AccountActivity.this.getSharedPreferences(LoginActivity.PREFS_NAME, MODE_PRIVATE);
                //boolean hasLoggedIn = sp1.getBoolean("hasLoggedIn", true);
                SharedPreferences sp=getSharedPreferences(LoginActivity.PREFS_NAME, MODE_PRIVATE);
                SharedPreferences.Editor Ed=sp.edit();
                Ed.clear();
                Ed.apply();
                finish();

                Intent intent = new Intent(AccountActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


        SharedPreferences sp1=AccountActivity.this.getSharedPreferences(LoginActivity.PREFS_NAME, MODE_PRIVATE);

        //boolean hasLoggedIn = sp1.getBoolean("hasLoggedIn", false);

        String name=sp1.getString("Name", null);
        String phone = sp1.getString("Phone", null);
        String email = sp1.getString("Email", null);
        String address = sp1.getString("Address", null);
        String image = sp1.getString("image", null);
        Integer gender = sp1.getInt("Gender",0);


        C_Name.setText(name);
        C_Phone.setText(phone);
        C_Email.setText(email);
        C_Address.setText(address);
        Glide.with(this).load(image).into(imageView);

        if(gender == 1){
            C_Gender.setText("Male");
        }else {
            C_Gender.setText("Female");
        }

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AccountActivity.this, MainActivity.class);
        startActivity(intent);
    }
}