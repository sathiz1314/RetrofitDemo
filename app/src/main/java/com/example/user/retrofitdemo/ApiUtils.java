package com.example.user.retrofitdemo;

/**
 * Created by User on 13-Feb-17.
 */

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "http://dazecorp.com/demos/bajugali_api/index.php/api/bajugali_api/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
