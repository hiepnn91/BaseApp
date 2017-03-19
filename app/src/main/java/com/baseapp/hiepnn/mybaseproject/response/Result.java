
package com.baseapp.hiepnn.mybaseproject.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Result {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("publish_date")
    @Expose
    private String publishDate;
    @SerializedName("owner")
    @Expose
    private Owner owner;
    @SerializedName("multimedia")
    @Expose
    private List<Multimedium> multimedia = new ArrayList<Multimedium>();
    @SerializedName("topic")
    @Expose
    private List<Topic> topic = new ArrayList<Topic>();
    @SerializedName("is_my_post")
    @Expose
    private Boolean isMyPost;
    @SerializedName("state")
    @Expose
    private Integer state;
    @SerializedName("is_public_answer")
    @Expose
    private Boolean isPublicAnswer;

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The content
     */
    public String getContent() {
        return content;
    }

    /**
     * 
     * @param content
     *     The content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 
     * @return
     *     The publishDate
     */
    public String getPublishDate() {
        return publishDate;
    }

    /**
     * 
     * @param publishDate
     *     The publish_date
     */
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * 
     * @return
     *     The owner
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     * 
     * @param owner
     *     The owner
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    /**
     * 
     * @return
     *     The multimedia
     */
    public List<Multimedium> getMultimedia() {
        return multimedia;
    }

    /**
     * 
     * @param multimedia
     *     The multimedia
     */
    public void setMultimedia(List<Multimedium> multimedia) {
        this.multimedia = multimedia;
    }

    /**
     * 
     * @return
     *     The topic
     */
    public List<Topic> getTopic() {
        return topic;
    }

    /**
     * 
     * @param topic
     *     The topic
     */
    public void setTopic(List<Topic> topic) {
        this.topic = topic;
    }

    /**
     * 
     * @return
     *     The isMyPost
     */
    public Boolean getIsMyPost() {
        return isMyPost;
    }

    /**
     * 
     * @param isMyPost
     *     The is_my_post
     */
    public void setIsMyPost(Boolean isMyPost) {
        this.isMyPost = isMyPost;
    }

    /**
     * 
     * @return
     *     The state
     */
    public Integer getState() {
        return state;
    }

    /**
     * 
     * @param state
     *     The state
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 
     * @return
     *     The isPublicAnswer
     */
    public Boolean getIsPublicAnswer() {
        return isPublicAnswer;
    }

    /**
     * 
     * @param isPublicAnswer
     *     The is_public_answer
     */
    public void setIsPublicAnswer(Boolean isPublicAnswer) {
        this.isPublicAnswer = isPublicAnswer;
    }

}
