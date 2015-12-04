package com.kupferwerk.coppercard.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private String sessionId;
    private String name;
    private String image;
    private String platform;

    protected User(Parcel in) {
        sessionId = in.readString();
        name = in.readString();
        image = in.readString();
        platform = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getSessionId() {
        return sessionId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sessionId);
        dest.writeString(name);
        dest.writeString(image);
        dest.writeString(platform);
    }
}
