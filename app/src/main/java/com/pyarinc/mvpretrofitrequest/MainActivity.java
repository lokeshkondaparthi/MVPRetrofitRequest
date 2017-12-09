package com.pyarinc.mvpretrofitrequest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.pyarinc.mvpretrofitrequest.interfaces.ResponseObjectListener;
import com.pyarinc.mvpretrofitrequest.models.ProfileModel;
import com.pyarinc.mvpretrofitrequest.services.Services;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private EditText mETName;
    private Services mService;
    private TextView mTVResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mETName = (EditText) findViewById(R.id.main_name_et);
        mTVResult = (TextView) findViewById(R.id.main_reslut_tv);
            mService = new Services(this);


    }

    public void mGetUserDetails(View view) {
        if (mETName.length() >0) {
            String mEnteredName  = mETName.getText().toString();
            Map<String,String> mProfileParams  = new HashMap<>();
            mProfileParams.put("q",mEnteredName);
            mService.mGetPResponse("profile_details","search/users",mProfileParams,
                   ProfileModel.class, new ResponseObjectListener() {
                        @Override
                        public void onSuccessResp(Object mObjectModel) {
                            if(mObjectModel !=null) {
                                ProfileModel mProfielModel = (ProfileModel) mObjectModel;
                                mTVResult.setText(mProfielModel.getItems().get(0).getLogin()
                                        +"  "+mProfielModel.getItems().get(0).getScore());
                            }
                            else
                                mTVResult.setText("Not found");

                        }

                    });
        }
    }

}
