package com.android.ken.firetest;

import android.widget.TextView;

public class Auth {

    private String userName;
    private String expiredAt;


    //空コンストラクタ
    public Auth() {

    }

    public Auth(String userName, String expiredAt) {
        this.userName = userName;
        this.expiredAt = expiredAt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(String expiredAt) {
        this.expiredAt = expiredAt;
    }

}
