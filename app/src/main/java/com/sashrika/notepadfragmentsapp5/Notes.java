package com.sashrika.notepadfragmentsapp5;

import java.util.Date;

public class Notes {
    private String message;
//    Boolean isDone = false;
    private String time;

    public Notes(String message) {

        this.message = message;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//    public Boolean getDone() {
//        return isDone;
//    }
//
//    public void setDone(Boolean done) {
//        isDone = done;
//    }



}
