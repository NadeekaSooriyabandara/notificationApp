package com.example.android.notificationexample;

public class Users extends UserId{

    String fromuserid, message, vehicles, date, reason;

    public Users() {
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {

        return date;
    }

    public Users(String fromuserid, String message, String date) {
        this.fromuserid = fromuserid;
        this.message = message;
        this.date  =date;

    }

    public String getName() {
        return fromuserid;
    }

    public String getImage() {
        return message;
    }

    public void setName(String fromuserid) {
        this.fromuserid = fromuserid;
    }

    public void setImage(String message) {
        this.message = message;
    }
}
