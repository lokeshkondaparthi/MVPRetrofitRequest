package com.pyarinc.mvpretrofitrequest.http_client;

import android.content.Context;

import com.pyarinc.mvpretrofitrequest.interfaces.ResponseStringListener;
import com.pyarinc.mvpretrofitrequest.service_helper.ServerUtilities;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Lokesh on 12/9/2017.
 */

public class HttpClient {
    private Context mContext;

    private ServerUtilities mServerUtilities;

    public HttpClient(Context context) {
        mContext = context;
        mServerUtilities = new ServerUtilities();
    }



    public void mGetRequest(String mPath, Map<String, String> mParams, final ResponseStringListener mResponseListener) {
        // Show progressbar
        Call<String> mGetReqResponse =
                mServerUtilities.mGetService(mContext,"").mGetReqResponse(mPath,mParams);
        mGetReqResponse.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                // dismiss progress bar
                mResponseListener.onSuccessResp(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                // dismiss progress bar
            }
        });
    }
}
