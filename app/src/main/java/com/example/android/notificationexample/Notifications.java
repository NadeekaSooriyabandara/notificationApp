package com.example.android.notificationexample;

public class Notifications {

    String from, message;

    public Notifications() {

    }

    public Notifications(String from, String message) {
        this.from = from;
        this.message = message;
    }

    public String getFrom() {
        return from;
    }

    public String getMessage() {
        return message;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
