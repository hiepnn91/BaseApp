
package com.baseapp.hiepnn.mybaseproject.api.response.loginresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("api_token")
    @Expose
    private String apiToken;
    @SerializedName("current_user")
    @Expose
    private CurrentUser currentUser;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LoginResponse() {
    }

    /**
     * 
     * @param message
     * @param statusCode
     * @param apiToken
     * @param currentUser
     */
    public LoginResponse(Integer statusCode, String message, String apiToken, CurrentUser currentUser) {
        super();
        this.statusCode = statusCode;
        this.message = message;
        this.apiToken = apiToken;
        this.currentUser = currentUser;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public CurrentUser getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

}
