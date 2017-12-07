package com.pyarinc.mvpretrofitrequest.services;


import android.content.Context;

import com.pyarinc.mvpretrofitrequest.models.ProfileModel;
import com.pyarinc.mvpretrofitrequest.interfaces.ResponseListener;
import com.pyarinc.mvpretrofitrequest.service_helper.ServerUtilities;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by user2 on 12/7/2017.
 */

public class PServices {
    private Context mContext;
    private ServerUtilities mServerUtilities;
    public ResponseListener mResponseListener;

    public PServices(Context context) {
        mContext = context;
        mServerUtilities = new ServerUtilities();
    }

    public void mGetPResponse(String mRequestName, String mPath,Map<String, String> mParams, ResponseListener mResponseListener) {
        this.mResponseListener =  mResponseListener;
        switch (mRequestName) {
            case "profile_details":
                mGetRequest(mPath,mParams);
                break;
        }
    }

    private void mGetRequest( String mPath,Map<String, String> mParams) {
        // Show progressbar
        Call<ProfileModel> mGetReqResponse =  mServerUtilities.mGetService(mContext,"").mGetReqResponse(mPath,mParams);
        mGetReqResponse.enqueue(new Callback<ProfileModel>() {
            @Override
            public void onResponse(Call<ProfileModel> call, Response<ProfileModel> response) {
                // dismiss progress bar
                mResponseListener.onSuccessResp(response.body());
            }

            @Override
            public void onFailure(Call<ProfileModel> call, Throwable t) {
                // dismiss progress bar
                mResponseListener.onFailureResp(t.getMessage());
            }
        });
    }

}
