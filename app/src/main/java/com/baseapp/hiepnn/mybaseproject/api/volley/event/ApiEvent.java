package com.baseapp.hiepnn.mybaseproject.api.volley.event;

/**
 * Created by Envy 15T on 9/24/2015.
 */
public class ApiEvent {

    public ApiEventType apiEventType;
    public String message;
    public Exception exception;

    public ApiEvent(ApiEventType apiEventType) {
        this.apiEventType = apiEventType;
    }

    public ApiEvent(ApiEventType apiEventType, String message) {
        this.apiEventType = apiEventType;
        this.message = message;
    }

    public ApiEventType getApiEventType() {
        return apiEventType;
    }

    public void setApiEventType(ApiEventType apiEventType) {
        this.apiEventType = apiEventType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
