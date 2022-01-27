package com.largeit.urbaneraltd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;
import com.google.android.material.navigation.NavigationView;
import com.largeit.urbaneraltd.AccountActivity.AccountActivity;
import com.largeit.urbaneraltd.AccountActivity.LoginActivity;
import com.largeit.urbaneraltd.AccountActivity.RegisterActivity;
import com.largeit.urbaneraltd.CartActivity.CartListActivity;
import com.largeit.urbaneraltd.CartFragment.CartFragment;
import com.largeit.urbaneraltd.CategoryFragment.CategoryFragment;
import com.largeit.urbaneraltd.HomeFragment.HomeFragment;
import com.largeit.urbaneraltd.LoadingDialog.LoadingDialog;
import com.largeit.urbaneraltd.SearchFragment.AccountFragment;
import com.largeit.urbaneraltd.WebViewActivity.WebViewActivity;
import com.largeit.urbaneraltd.main.model.Word;
import com.largeit.urbaneraltd.CategoryFragment.CategoryActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static int cart_count = 0;
    LoadingDialog loadingDialog;
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    ActionBarDrawerToggle mToogle;
    SwipeRefreshLayout refreshLayout;
    ImageView ImageCart;
    Button btnOpenDrawer;
    public static  TextView textViewCart;

    TextView topCategory, Latest_Product;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNav  = findViewById(R.id.bottomNavigationView);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        ImageCart = findViewById(R.id.card_home_image_id);
        textViewCart = findViewById(R.id.count);
        btnOpenDrawer = findViewById(R.id.button2);


        //loadingDialog = new LoadingDialog(MainActivity.this);//for loading show
        //loadingDialog.startLoadingActivity();
        //default fragment
        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,
                    new HomeFragment()).commit();

        }
        mDrawerLayout = findViewById(R.id.drawerlayout);
        mNavigationView = findViewById(R.id.nav_view);
        //loadingDialog.dismissDialog();
        refreshLayout = findViewById(R.id.swipe_container);
        setupNavigationView();
        sweeprefresh();

        ImageCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(MainActivity.this, CartListActivity.class);
                startActivity(intent);
            }
        });

        btnOpenDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

    }



    private OnNavigationItemSelectedListener navListener =
            new OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            //loadingDialog.dismissDialog();
                            break;
                        case R.id.nav_cart:
                            //selectedFragment = new CartFragment() ;

                            Intent intent = new Intent(MainActivity.this,CartListActivity.class);
                            startActivity(intent);
                            return true;
                            //break;
                        case R.id.nav_category:
//                            selectedFragment = new CategoryFragment();
//                            break;

                            Intent intent1 = new Intent(MainActivity.this,CategoryActivity.class);
                            startActivity(intent1);
                            return true;


                            case R.id.nav_account:




                                SharedPreferences sp1=MainActivity.this.getSharedPreferences(AccountActivity.PREFS_NAME, MODE_PRIVATE);
                                boolean hasLoggedIn = sp1.getBoolean("hasLoggedIn", false);
//                                String unm=sp1.getString("Name", null);
//                                String pass = sp1.getString("Phone", null);

                                if(hasLoggedIn){


                                    Intent intent2 = new Intent(MainActivity.this, AccountActivity.class);

                                    SharedPreferences sp2=MainActivity.this.getSharedPreferences(LoginActivity.TOKEN, MODE_PRIVATE);
                                    String token =sp2.getString("token", null);
                                    //put data in intent
                                    intent2.putExtra("token", token);

                                    startActivity(intent2);
                                }
                                else {
                                    Intent intent2 = new Intent(MainActivity.this, LoginActivity.class);

                                    SharedPreferences sp2=MainActivity.this.getSharedPreferences(LoginActivity.TOKEN, MODE_PRIVATE);
                                    String token =sp2.getString("token", null);


                                    //put data in intent
                                    intent2.putExtra("token", token);
                                    startActivity(intent2);
                                }

                            return true;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,
                            selectedFragment).commit();

                    return true;
                }
            };


    //navigation drawer setup =======================================================================
    private void setupNavigationView() {

        mNavigationView.bringToFront();

        mToogle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(mToogle);
        mToogle.syncState();
        mNavigationView.setNavigationItemSelectedListener(this);
    }


    //Navigation item selected
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.menu_rateus)
        {
            Intent rateIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getBaseContext().getPackageName()));
            startActivity(rateIntent);

        }

        else if(item.getItemId()==R.id.menu_corporate){
            //Way one

            String url = "https://urbaneraltd.com/page/corporate-information";

            //Intent to start activity
            Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
            //put data in intent
            intent.putExtra("address", url);

            startActivity(intent);
        }


        else if(item.getItemId()==R.id.menu_affilate){

            String url = "https://urbaneraltd.com/page/urbaneraltd-affiliate";;

            //Intent to start activity
            Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
            //put data in intent
            intent.putExtra("address", url);

            startActivity(intent);


        }


        else if(item.getItemId()==R.id.menu_product_request){
            String url = "https://urbaneraltd.com/requested_product";

            //Intent to start activity
            Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
            //put data in intent
            intent.putExtra("address", url);

            startActivity(intent);


        }
        else if(item.getItemId()==R.id.menu_privacy_policy){

            String url ="https://urbaneraltd.com/page/privacy-policy";

            //Intent to start activity
            Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
            //put data in intent
            intent.putExtra("address", url);

            startActivity(intent);


        }
        else if(item.getItemId()==R.id.menu_contact_us){

            String url ="https://urbaneraltd.com/page/contact-us";

            //Intent to start activity
            Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
            //put data in intent
            intent.putExtra("address", url);

            startActivity(intent);



        }


        else if(item.getItemId()==R.id.menu_share)
        {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "https://play.google.com/store/apps/details?id=com.largeit.urbaneraltd";
            String shareSub = "UrbaneraLtd - Large Online Market";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share using"));
        }

//        else if(item.getItemId()==R.id.menu_gallery) {
//            Intent intent = new Intent(HomeActivity.this, GalleryActivity.class);
//            startActivity(intent);
//            finish();
//        }


        mDrawerLayout.closeDrawers();
        return true;
    }
    //navigation drawer setup =======================================================================




    private void sweeprefresh()
    {
        refreshLayout.setColorSchemeResources(R.color.primarycolor,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //getData();
                setupNavigationView();
                Intent intent = getIntent();
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_out_left , R.anim.slide_in_right);
                refreshLayout.setRefreshing(false);
            }
        });
    }


    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing Activity")
                .setMessage("Are you sure you want to close this activity?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Word word = new Word();
        ArrayList<Word> list = word.getMyCard();

        //list.clear();
        textViewCart.setText(""+list.size());
    }
}