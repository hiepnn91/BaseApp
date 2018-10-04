
package com.baseapp.hiepnn.api.response.getnewlistbyplace;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewListByPlace {

    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("newsByCity")
    @Expose
    private List<NewsByCity> newsByCity = null;
    @SerializedName("newsByCounty")
    @Expose
    private List<NewsByCounty> newsByCounty = null;
    @SerializedName("newsByGuild")
    @Expose
    private List<NewsByGuild> newsByGuild = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public NewListByPlace() {
    }

    /**
     * 
     * @param message
     * @param statusCode
     * @param newsByCounty
     * @param newsByCity
     * @param newsByGuild
     */
    public NewListByPlace(Integer statusCode, String message, List<NewsByCity> newsByCity, List<NewsByCounty> newsByCounty, List<NewsByGuild> newsByGuild) {
        super();
        this.statusCode = statusCode;
        this.message = message;
        this.newsByCity = newsByCity;
        this.newsByCounty = newsByCounty;
        this.newsByGuild = newsByGuild;
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

    public List<NewsByCity> getNewsByCity() {
        return newsByCity;
    }

    public void setNewsByCity(List<NewsByCity> newsByCity) {
        this.newsByCity = newsByCity;
    }

    public List<NewsByCounty> getNewsByCounty() {
        return newsByCounty;
    }

    public void setNewsByCounty(List<NewsByCounty> newsByCounty) {
        this.newsByCounty = newsByCounty;
    }

    public List<NewsByGuild> getNewsByGuild() {
        return newsByGuild;
    }

    public void setNewsByGuild(List<NewsByGuild> newsByGuild) {
        this.newsByGuild = newsByGuild;
    }

}
