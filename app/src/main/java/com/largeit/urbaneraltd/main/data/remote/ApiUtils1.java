package com.largeit.urbaneraltd.main.data.remote;

public class ApiUtils1 {

    private ApiUtils1() {}

    public static final String BASE_URL = "http://exam.androwep.com/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);


    }

//    public static APIService getApiServiceNew(){
//        return RetrofitClientNew
//    }

}
