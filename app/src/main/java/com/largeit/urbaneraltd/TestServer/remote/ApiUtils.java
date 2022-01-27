package com.largeit.urbaneraltd.TestServer.remote;

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "https://urbaneraltd.com/";

    public static APIService getAPIServices() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
