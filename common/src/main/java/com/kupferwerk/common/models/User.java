package com.kupferwerk.common.models;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private String sessionId;
    private String name;
    private String image;
    private String platform;
    private String uuid;
    private String color;

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public String getColor() {
        return color;
    }

    public User() {
        // empty
    }

    public User(String sessionId, String name, String image, String platform, String uuid) {
        this.sessionId = sessionId;
        this.name = name;
        this.image = image;
        this.platform = platform;
        this.uuid = uuid;
    }

    protected User(Parcel in) {
        sessionId = in.readString();
        name = in.readString();
        image = in.readString();
        platform = in.readString();
        uuid = in.readString();
        color = in.readString();
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

    public String getImage() {
        return image;
    }

    public String getPlatform() {
        return platform;
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
        dest.writeString(uuid);
        dest.writeString(color);
    }

    public void setColor(String color) {
        this.color = color;
    }
}
