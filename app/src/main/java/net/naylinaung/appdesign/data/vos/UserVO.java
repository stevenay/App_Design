package net.naylinaung.appdesign.data.vos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import com.google.gson.annotations.SerializedName;

import net.naylinaung.appdesign.AppDesignApp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by NayLinAung on 7/15/16.
 */
public class UserVO {

    private static final SimpleDateFormat sdfRegisteredDate = new SimpleDateFormat("yyyy-MM-dd");

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("date_of_birth")
    private String dateOfBirthText;

    @SerializedName("country_of_origin")
    private String countryOfOrigin;

    @SerializedName("registered_date")
    private String registeredDateText; //YYYY-MM-dd

    private String lastUsedDate;

    private String profilePicture;

    private String coverPicture;

    private String facebookId;

    private String googleId;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getDateOfBirthText() {
        return dateOfBirthText;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public Date getRegisteredDate() {
        try {
            return sdfRegisteredDate.parse(registeredDateText);
        } catch (ParseException e) {
            Log.d(AppDesignApp.TAG, e.getMessage());
        }

        return null;
    }

    public void setRegisteredDate(Date date) {
        registeredDateText = sdfRegisteredDate.format(date);
    }

    public void setRegisteredDate(String date) {
        registeredDateText = date;
    }

    public String getLastUsedDate() {
        return lastUsedDate;
    }

    public void setLastUsedDate(String lastUsedDate) {
        this.lastUsedDate = lastUsedDate;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setDateOfBirthText(String dateOfBirthText) {
        this.dateOfBirthText = dateOfBirthText;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getCoverPicture() {
        return coverPicture;
    }

    public void setCoverPicture(String coverPicture) {
        this.coverPicture = coverPicture;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }
}
