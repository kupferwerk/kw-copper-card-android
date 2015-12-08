package com.kupferwerk.common.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Session implements Parcelable {


    private String sessionId;
    private int presetId;

    public String getName() {
        return name;
    }

    private String name;

    protected Session(Parcel in) {
        sessionId = in.readString();
        presetId = in.readInt();
        name = in.readString();
    }

    public static final Creator<Session> CREATOR = new Creator<Session>() {
        @Override
        public Session createFromParcel(Parcel in) {
            return new Session(in);
        }

        @Override
        public Session[] newArray(int size) {
            return new Session[size];
        }
    };

    public String getSessionId() {
        return sessionId;
    }


    public int getPresetId() {
        return presetId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sessionId);
        dest.writeInt(presetId);
        dest.writeString(name);
    }
}
