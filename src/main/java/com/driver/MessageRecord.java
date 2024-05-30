package com.driver;

import java.util.Date;

public class MessageRecord {
    private Date date;
    private String send;
    private String message;

    public MessageRecord() {
    }

    public MessageRecord(Date date, String send, String message) {
        this.date = date;
        this.send = send;
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSend() {
        return send;
    }

    public void setSend(String send) {
        this.send = send;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
