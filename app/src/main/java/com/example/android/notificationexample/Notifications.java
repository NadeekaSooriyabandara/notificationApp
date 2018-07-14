package com.example.android.notificationexample;

public class Notifications extends UserId{

    String fromuserid, message, vehicles, date, reason, status;

    public Notifications() {

    }

    public Notifications(String fromuserid, String message, String status) {
        this.fromuserid = fromuserid;
        this.message = message;
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {

        return status;
    }

    public String getFrom() {
        return fromuserid;
    }

    public String getMessage() {
        return message;
    }

    public void setFrom(String fromuserid) {
        this.fromuserid = fromuserid;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
