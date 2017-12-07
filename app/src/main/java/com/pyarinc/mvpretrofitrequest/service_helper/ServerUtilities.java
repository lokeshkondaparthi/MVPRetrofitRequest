package com.pyarinc.mvpretrofitrequest.service_helper;

import android.content.Context;



/**
 * Created by user2 on 12/7/2017.
 */

public class ServerUtilities {
    public static final String BASE_URL = "https://api.github.com";
    public MyAppServices mGetService(Context ctx, String url) {
        return RetroHelper.getAdapter(ctx, url).create(MyAppServices.class);
    }
}
