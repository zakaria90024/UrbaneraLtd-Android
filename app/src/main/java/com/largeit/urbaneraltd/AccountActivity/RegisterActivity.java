package com.largeit.urbaneraltd.AccountActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

import com.largeit.urbaneraltd.R;
import com.largeit.urbaneraltd.TestServer.model.Post;
import com.largeit.urbaneraltd.TestServer.remote.APIService;
import com.largeit.urbaneraltd.TestServer.remote.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText name, email, phone, address, password;
    RadioButton MaleRadio, FemailRadio;
    Integer MaleOrFemale = null;
    Button btn_Register;
    ProgressBar pd;
    private APIService mAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        MaleRadio = findViewById(R.id.radioMale);
        FemailRadio = findViewById(R.id.radioFemale);

        name = findViewById(R.id.editTextTextPersonName);
        email = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        phone = findViewById(R.id.editTextPhone);
        address = findViewById(R.id.full_address_id);
        btn_Register = findViewById(R.id.button3);

        mAPIService = ApiUtils.getAPIServices();
        pd = new ProgressBar(this);
        pd.setVisibility(View.VISIBLE);

        MaleRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MaleOrFemale = 1;

            }
        });

        FemailRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaleOrFemale = 2;
            }
        });



        btn_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitRegesterID(
                        name.getText().toString(),
                        email.getText().toString(),
                        MaleOrFemale,
                        phone.getText().toString(),
                        address.getText().toString(),
                        password.getText().toString());

                        name.setText("");
                        email.setText("");
                        phone.setText("");
                        address.setText("");
                        password.setText("");
            }
        });


    }

    private void submitRegesterID(String name, String email, Integer maleOrFemale,  String phone, String address, String password) {
        Toast.makeText(RegisterActivity.this, "Please Wait...", Toast.LENGTH_LONG).show();

        mAPIService.RegisterCall(name, email, maleOrFemale,  phone, address, password).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                pd.setVisibility(View.GONE);
                Toast.makeText(RegisterActivity.this, "Register Success", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Please Try Again", Toast.LENGTH_LONG).show();
            }
        });

    }
}