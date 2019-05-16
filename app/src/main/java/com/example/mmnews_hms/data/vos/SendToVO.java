package com.example.mmnews_hms.data.vos;

import com.google.gson.annotations.SerializedName;

public class SendToVO {

    private String sentToId;
    private String sentToDate;
    private ActedUserVO actedUser;
    private ActedUserVO receivedUser;

    public String getSentToId() {
        return sentToId;
    }

    public String getSentToDate() {
        return sentToDate;
    }

    public ActedUserVO getActedUser() {
        return actedUser;
    }

    public ActedUserVO getReceivedUser() {
        return receivedUser;
    }
}
