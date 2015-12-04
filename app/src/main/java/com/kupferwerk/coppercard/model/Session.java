package com.kupferwerk.coppercard.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Session implements Parcelable {

   private String sessionId;
   private String userId;
   private int presetId;

   public String getName() {
      return name;
   }

   private String name;

   protected Session(Parcel in) {
      sessionId = in.readString();
      userId = in.readString();
      presetId = in.readInt();
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

   public String getUserId() {
      return userId;
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
      dest.writeString(userId);
      dest.writeInt(presetId);
   }
}
