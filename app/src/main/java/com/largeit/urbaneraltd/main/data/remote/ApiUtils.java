package com.largeit.urbaneraltd.main.data.remote;

import retrofit2.Retrofit;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "https://urbaneraltd.com/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);

    }

//    public static APIService getApiServiceNew(){
//        return RetrofitClientNew
//    }

}
