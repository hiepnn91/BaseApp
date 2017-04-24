
package com.baseapp.hiepnn.mybaseproject.api.response.getnewlistbyplace;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsByGuild {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("sub_title")
    @Expose
    private String subTitle;
    @SerializedName("status_id")
    @Expose
    private String statusId;
    @SerializedName("audio_path")
    @Expose
    private String audioPath;
    @SerializedName("audio_text")
    @Expose
    private String audioText;
    @SerializedName("place_id")
    @Expose
    private String placeId;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("approved_by")
    @Expose
    private Object approvedBy;
    @SerializedName("publish_time")
    @Expose
    private String publishTime;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    /**
     * No args constructor for use in serialization
     * 
     */
    public NewsByGuild() {
    }

    /**
     * 
     * @param updatedAt
     * @param statusId
     * @param id
     * @param subTitle
     * @param title
     * @param publishTime
     * @param placeId
     * @param createdAt
     * @param userId
     * @param audioText
     * @param approvedBy
     * @param audioPath
     */
    public NewsByGuild(Integer id, String title, String subTitle, String statusId, String audioPath, String audioText, String placeId, String userId, Object approvedBy, String publishTime, String createdAt, String updatedAt) {
        super();
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.statusId = statusId;
        this.audioPath = audioPath;
        this.audioText = audioText;
        this.placeId = placeId;
        this.userId = userId;
        this.approvedBy = approvedBy;
        this.publishTime = publishTime;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getAudioPath() {
        return audioPath;
    }

    public void setAudioPath(String audioPath) {
        this.audioPath = audioPath;
    }

    public String getAudioText() {
        return audioText;
    }

    public void setAudioText(String audioText) {
        this.audioText = audioText;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Object getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Object approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
