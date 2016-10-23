
package com.example.hiepnn.mydemoapplication.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Multimedium {

    @SerializedName("thumb_path")
    @Expose
    private String thumbPath;

    /**
     * 
     * @return
     *     The thumbPath
     */
    public String getThumbPath() {
        return thumbPath;
    }

    /**
     * 
     * @param thumbPath
     *     The thumb_path
     */
    public void setThumbPath(String thumbPath) {
        this.thumbPath = thumbPath;
    }

}
