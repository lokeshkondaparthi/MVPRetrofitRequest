package com.pyarinc.mvpretrofitrequest.service_helper;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetroHelper {

    private static Context mContext;

    public static Retrofit getAdapter(Context ctx, String serverUrl) {
        mContext = ctx;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ServerUtilities.BASE_URL+serverUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    }