package com.largeit.urbaneraltd.AccountActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.largeit.urbaneraltd.FinalCheckOutActivity.FinalCheckOutActivity;
import com.largeit.urbaneraltd.MainActivity;
import com.largeit.urbaneraltd.R;
import com.largeit.urbaneraltd.TestServer.model.auth.CustomarInfo;
import com.largeit.urbaneraltd.TestServer.model.auth.Token;
import com.largeit.urbaneraltd.TestServer.remote.APIService;
import com.largeit.urbaneraltd.TestServer.remote.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    GoogleSignInClient mGoogleSignInClient;
    private static int RC_SIGN_IN = 100;
    CallbackManager callbackManager;




    Button btnCreateAccount, btn_Login;
    EditText Email, Password;
    private APIService mAPIService;
    public static  String TokenShar;

    public static final String TOKEN = "Token";
    public static final String PREFS_NAME = "Login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnCreateAccount = findViewById(R.id.btn_new_register);

        Email = findViewById(R.id.useremail);
        Password = findViewById(R.id.password);
        btn_Login = findViewById(R.id.btn_new_login);
        mAPIService = ApiUtils.getAPIServices();


        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });



        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = Email.getText().toString();
                String password = Password.getText().toString();

                if(email.isEmpty() && password.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Fill Up All Field" , Toast.LENGTH_SHORT).show();
                }
                else {

                    getTokenWithEmailPassword(email, password);

                    Password.setText("");
                    Email.setText("");

                }


            }
        });



        //Step 1 - Google sign in=========================================================================================================


        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();


        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // Check for existing Google Sign In account, if the user is already signed in
        // the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);

        // Set the dimensions of the sign-in button.
        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);


        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

        //Step 1 - end Google sign in=========================================================================================================


        //Step 1 - Facebook sign in=========================================================================================================
        callbackManager = CallbackManager.Factory.create();
        LoginButton loginButton = findViewById(R.id.login_button);


        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                AccessToken accessToken = loginResult.getAccessToken();
                Profile profile = Profile.getCurrentProfile();
                if (profile != null){


                    String personName = profile.getName();
                    String personGivenName = profile.getMiddleName();
                    String personFamilyName = profile.getLastName();
                    //String personEmail = profile.get;
                    //String personId = acct.getId();
                    Uri personPhoto = profile.getProfilePictureUri(50, 50);






                    SharedPreferences sp=getSharedPreferences(LoginActivity.PREFS_NAME, MODE_PRIVATE);
                    SharedPreferences.Editor Ed=sp.edit();

                    Ed.putString("Name",personName);
                    //Ed.putString("Phone",personId);
                    //Ed.putString("Email",personEmail);
                    Ed.putString("Address",personGivenName);
                    //Ed.putInt("Gender",personFamilyName );
                    Ed.putString("image", String.valueOf(personPhoto));
                    Ed.putBoolean("hasLoggedIn", true);

                    Ed.commit();


                    SharedPreferences sp1=LoginActivity.this.getSharedPreferences(LoginActivity.PREFS_NAME, MODE_PRIVATE);

                    boolean hasLoggedIn = sp1.getBoolean("hasLoggedIn", false);

                    String name=sp1.getString("Name", null);
                    String phone = sp1.getString("Phone", null);
                    String email = sp1.getString("Email", null);
                    String address = sp1.getString("Address", null);
                    String image = sp1.getString("image", null);
                    Integer gender = sp1.getInt("Gender",0);

                    Intent intent = new Intent(LoginActivity.this, AccountActivity.class);
                    startActivity(intent);
                }
                String personName = loginResult.getAccessToken().getUserId();
                String personGivenName = loginResult.getAccessToken().getUserId();
//                String personFamilyName = acct.getFamilyName();
//                String personEmail = acct.getEmail();
//                String personId = acct.getId();
//                Uri personPhoto = acct.getPhotoUrl();






                SharedPreferences sp=getSharedPreferences(LoginActivity.PREFS_NAME, MODE_PRIVATE);
                SharedPreferences.Editor Ed=sp.edit();

                Ed.putString("Name",personName);
//                Ed.putString("Phone",personId);
//                Ed.putString("Email",personEmail);
                Ed.putString("Address",personGivenName);
                //Ed.putInt("Gender",personFamilyName );
                Ed.putBoolean("hasLoggedIn", true);
                Ed.commit();


                SharedPreferences sp1=LoginActivity.this.getSharedPreferences(LoginActivity.PREFS_NAME, MODE_PRIVATE);

                boolean hasLoggedIn = sp1.getBoolean("hasLoggedIn", false);

                String name=sp1.getString("Name", null);
                String phone = sp1.getString("Phone", null);
                String email = sp1.getString("Email", null);
                String address = sp1.getString("Address", null);
                Integer gender = sp1.getInt("Gender",0);

                Intent intent = new Intent(LoginActivity.this, AccountActivity.class);
                startActivity(intent);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });




    }

    //Step 2 - Google sign in method =========================================================================================================
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        //for fb login
        callbackManager.onActivityResult(requestCode, resultCode, data);//for fb

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
            if (acct != null) {
                String personName = acct.getDisplayName();
                String personGivenName = acct.getGivenName();
                String personFamilyName = acct.getFamilyName();
                String personEmail = acct.getEmail();
                String personId = acct.getId();
                Uri personPhoto = acct.getPhotoUrl();






                SharedPreferences sp=getSharedPreferences(LoginActivity.PREFS_NAME, MODE_PRIVATE);
                SharedPreferences.Editor Ed=sp.edit();

                Ed.putString("Name",personName);
                Ed.putString("Phone",personId);
                Ed.putString("Email",personEmail);
                Ed.putString("Address",personGivenName);
                //Ed.putInt("Gender",personFamilyName );
                Ed.putString("image", String.valueOf(personPhoto));
                Ed.putBoolean("hasLoggedIn", true);
                Ed.commit();


                SharedPreferences sp1=LoginActivity.this.getSharedPreferences(LoginActivity.PREFS_NAME, MODE_PRIVATE);

                boolean hasLoggedIn = sp1.getBoolean("hasLoggedIn", false);

                String name=sp1.getString("Name", null);
                String phone = sp1.getString("Phone", null);
                String email = sp1.getString("Email", null);
                String address = sp1.getString("Address", null);
                String image = sp1.getString("image", null);
                Integer gender = sp1.getInt("Gender",0);

                Intent intent = new Intent(LoginActivity.this, AccountActivity.class);
                startActivity(intent);

            }

            // Signed in successfully, show authenticated UI.

        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            //Log.d("signInResult:failed code="+e.toString());

        }
    }

    //Step 2 - End Google sign in method =========================================================================================================
    //===================================================================================================================================



    private void getTokenWithEmailPassword(String email, String password) {

        mAPIService.LoginCall(email, password).enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {

                String token = response.body().getAccessToken();


                if( token.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Please Register Again", Toast.LENGTH_LONG).show();
                }else {

//                  Intent intent = new Intent(LoginActivity.this, AccountActivity.class);
//                  TokenShar = response.body().getAccessToken();


                    //for store token sharprefarance
                    SharedPreferences sp=getSharedPreferences(TOKEN, MODE_PRIVATE);
                    SharedPreferences.Editor Ed=sp.edit();
                    Ed.putString("token", response.body().getAccessToken());
                    Ed.commit();

                    getdataforStoreSharePrefarence(response.body().getAccessToken() );



//                    //put data in intent
//                    intent.putExtra("token", response.body().getAccessToken());
//                    startActivity(intent);
                }
            }


            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Email or Password invalid", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void getdataforStoreSharePrefarence(String accessToken) {
        mAPIService.CallWithToken(accessToken).enqueue(new Callback<CustomarInfo>() {
            @Override
            public void onResponse(Call<CustomarInfo> call, Response<CustomarInfo> response) {


                SharedPreferences sp=getSharedPreferences(LoginActivity.PREFS_NAME, MODE_PRIVATE);
                SharedPreferences.Editor Ed=sp.edit();

                Ed.putString("Name",response.body().getName());
                Ed.putString("Phone",response.body().getPhone());
                Ed.putString("Email",response.body().getEmail());
                Ed.putString("Address",response.body().getAddress());
                Ed.putInt("Gender",response.body().getGender());
                Ed.putBoolean("hasLoggedIn", true);
                Ed.commit();


                SharedPreferences sp1=LoginActivity.this.getSharedPreferences(LoginActivity.PREFS_NAME, MODE_PRIVATE);

                boolean hasLoggedIn = sp1.getBoolean("hasLoggedIn", false);

                String name=sp1.getString("Name", null);
                String phone = sp1.getString("Phone", null);
                String email = sp1.getString("Email", null);
                String address = sp1.getString("Address", null);
                Integer gender = sp1.getInt("Gender",0);

                Intent intent = new Intent(LoginActivity.this, AccountActivity.class);
                startActivity(intent);


            }

            @Override
            public void onFailure(Call<CustomarInfo> call, Throwable t) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }
}