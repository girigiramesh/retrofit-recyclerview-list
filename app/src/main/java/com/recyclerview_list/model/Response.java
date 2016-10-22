package com.recyclerview_list.model;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Ramesh on 10/21/16.
 */

public class Response {
    private static final String TAG = "Response";

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


    public JSONObject toJson() {
        String jsonRepresentation = new Gson().toJson(this, Response.class);
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonRepresentation);
        } catch (JSONException e) {
            Log.e(TAG, "Error converting to JSON in toJson(): " + e.getMessage());
        }
        return jsonObject;
    }

    public static Response fromJson(String jsonString) {
        return new Gson().fromJson(jsonString, Response.class);
    }
}
