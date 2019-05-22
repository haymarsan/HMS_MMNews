package com.example.mmnews_hms.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

public class CommentVO {

 /*   @PrimaryKey(autoGenerate = true)
    private long commentIdPk;
*/

    @SerializedName("comment-id")
    private String commentId;


    @SerializedName("comment-date")
    private String commentDate;

    @SerializedName("acted-user")
    private ActedUserVO actedUser;

    @SerializedName("comment")
    private String comment;



    public String getCommentId() {
        return commentId;
    }

    public String getComment() {
        return comment;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public ActedUserVO getActedUser() {
        return actedUser;
    }



    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public void setActedUser(ActedUserVO actedUser) {
        this.actedUser = actedUser;
    }


}
