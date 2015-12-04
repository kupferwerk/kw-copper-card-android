package com.kupferwerk.coppercard.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

   private String sessionId;
   private String name;
   private String image;
   private String platform;
   private String userId;
   private String color;

   public String getUserId() {
      return userId;
   }

   public String getColor() {
      return color;
   }

   public User(String sessionId, String name, String image, String platform) {
      this.sessionId = sessionId;
      this.name = name;
      this.image = image;
      this.platform = platform;
   }

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
   }
}
