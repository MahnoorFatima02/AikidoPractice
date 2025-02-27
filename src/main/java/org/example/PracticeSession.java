package org.example;

public class PracticeSession {
    private String date;
    private int duration;

    public PracticeSession(String date, int duration) {
        this.date = date;
        this.duration = duration;
    }

    public String getDate() {
        return date;
    }

    public int getDuration() {
        return duration;
    }
}