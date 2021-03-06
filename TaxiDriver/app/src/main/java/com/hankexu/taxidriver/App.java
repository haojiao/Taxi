package com.hankexu.taxidriver;

import android.app.Application;
import android.content.SharedPreferences;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by hanke on 2016-01-10.
 */
public class App extends Application{

    public static final String PHONE="Phone";
    public static final String NAME="Name";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    public void onCreate() {
        super.onCreate();

        SDKInitializer.initialize(getApplicationContext());

        sharedPreferences = getSharedPreferences("USER_INFO",MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    /*设置和读取手机号和姓名*/
    public String getPhone() {
        return sharedPreferences.getString(PHONE,null);
    }

    public void setPhone(String phone) {
        editor.putString(PHONE,phone);
        editor.commit();
    }

    public String getName() {
        return sharedPreferences.getString(NAME,null);
    }

    public void setName(String name) {
        editor.putString(NAME,name);
        editor.commit();
    }
}
