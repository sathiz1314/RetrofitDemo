
package com.example.user.retrofitdemo.modelDatas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignInResponceModel {

    @SerializedName("responseCode")
    @Expose
    private Integer responseCode;
    @SerializedName("responseStatus")
    @Expose
    private String responseStatus;
    @SerializedName("responseMessage")
    @Expose
    private String responseMessage;
    @SerializedName("response")
    @Expose
    private Response response;

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "SignInResponceModel{" +
                "responseCode=" + responseCode +
                ", responseStatus='" + responseStatus + '\'' +
                ", responseMessage='" + responseMessage + '\'' +
                ", response=" + response +
                '}';
    }
}
