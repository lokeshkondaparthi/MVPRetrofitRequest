package com.pyarinc.mvpretrofitrequest.interfaces;

import com.pyarinc.mvpretrofitrequest.models.ProfileModel;

/**
 * Created by user2 on 12/7/2017.
 */

public interface ResponseListener {
    void onSuccessResp(ProfileModel body);
    void onFailureResp(String mErrorMsg);

}
