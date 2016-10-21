package com.recyclerview_list.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ramesh on 10/21/16.
 */

public class Response {

    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("channel")
    @Expose
    private String channel;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("type")
    @Expose
    private String type;
    private List<Response> responseDetailsList;

    public List<Response> getResponseDetailsList() {
        return responseDetailsList;
    }

    public void setResponseDetailsList(List<Response> responseDetailsList) {
        this.responseDetailsList = responseDetailsList;
    }

    /**
     * @return The timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp The timestamp
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return The channel
     */
    public String getChannel() {
        return channel;
    }

    /**
     * @param channel The channel
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * @return The text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }
}
