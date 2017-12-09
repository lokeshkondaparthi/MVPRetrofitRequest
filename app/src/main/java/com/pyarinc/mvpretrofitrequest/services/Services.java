package com.pyarinc.mvpretrofitrequest.services;


import android.content.Context;

import com.google.gson.Gson;
import com.pyarinc.mvpretrofitrequest.http_client.HttpClient;
import com.pyarinc.mvpretrofitrequest.interfaces.ResponseObjectListener;
import com.pyarinc.mvpretrofitrequest.interfaces.ResponseStringListener;
import com.pyarinc.mvpretrofitrequest.service_helper.ServerUtilities;

import java.util.Map;


/**
 * Created by Lokesh on 12/7/2017.
 */

public class Services {
    private Context mContext;
    private ServerUtilities mServerUtilities;
    private HttpClient mHttpClient;
    public ResponseObjectListener mResponseObjectListener;

    public Services(Context context) {
        mContext = context;
        mServerUtilities = new ServerUtilities();
        mHttpClient = new HttpClient(mContext);
    }

    public void mGetPResponse(String mRequestName, String mPath, Map<String, String> mParams,
                              final Class<?> mClassType, final ResponseObjectListener mResponseObjectListener) {
        this.mResponseObjectListener =  mResponseObjectListener;
        switch (mRequestName) {
            case "profile_details":
                mHttpClient.mGetRequest(mPath, mParams, new ResponseStringListener() {
                    @Override
                    public void onSuccessResp(String body) {
                               Object mModelObject  =  new Gson().fromJson(body,mClassType);
                        Services.this.mResponseObjectListener.onSuccessResp(mModelObject);
                    }
                });
                break;
        }
    }



}
