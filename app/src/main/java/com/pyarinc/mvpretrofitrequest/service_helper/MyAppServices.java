package com.pyarinc.mvpretrofitrequest.service_helper;

import com.pyarinc.mvpretrofitrequest.models.ProfileModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by user2 on 12/7/2017.
 */

public  interface MyAppServices {
    @GET("{api}")
    Call<ProfileModel> mGetReqResponse(@Path(value = "api" , encoded = true) String mPath,@QueryMap Map<String, String> mParams);
}
