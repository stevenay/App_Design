package net.naylinaung.appdesign.data.vos;

import java.util.Date;

/**
 * Created by NayLinAung on 9/16/2016.
 */
public class DiscussionVO {

    private int discussionID;
    private String title;
    private String description;
    private String userName;
    private String postPastTime;
    private Date postedTime;
    private Integer likes;

    public int getDiscussionID() {
        return discussionID;
    }

    public void setDiscussionID(int discussionID) {
        this.discussionID = discussionID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPostPastTime() {
        return postPastTime;
    }

    public void setPostPastTime(String postPastTime) {
        this.postPastTime = postPastTime;
    }

    public Date getPostedTime() {
        return postedTime;
    }

    public void setPostedTime(Date postedTime) {
        this.postedTime = postedTime;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
}
