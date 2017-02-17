
package com.example.user.retrofitdemo.modelDatas;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("userdetails")
    @Expose
    private List<Userdetail> userdetails = null;

    public List<Userdetail> getUserdetails() {
        return userdetails;
    }

    public void setUserdetails(List<Userdetail> userdetails) {
        this.userdetails = userdetails;
    }

    @SerializedName("noticeboard")
    @Expose
    private List<Noticeboard> noticeboard = null;

    public List<Noticeboard> getNoticeboard() {
        return noticeboard;
    }

    public void setNoticeboard(List<Noticeboard> noticeboard) {
        this.noticeboard = noticeboard;
    }

}
