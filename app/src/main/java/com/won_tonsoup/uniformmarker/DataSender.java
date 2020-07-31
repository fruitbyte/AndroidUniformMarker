package com.won_tonsoup.uniformmarker;

public class DataSender {
    private String fixMessage;
    private String first;
    private String last;
    private int flight;
    private int score;
    private String timestamp;

    public DataSender(){}

    public DataSender(String first, String last, String fixMessage, int score, int flight, String timestamp) {
        this.first = first;
        this.last = last;
        this.fixMessage = fixMessage;
        this.score = score;
        this.flight = flight;
        this.timestamp = timestamp;
    }

    public void setFixMessage(String fixMessage) {
        this.fixMessage = fixMessage;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setFlight(int flight) {
        this.flight = flight;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getFixMessage(){
        return fixMessage;
    }

    public String getFirst(){
        return first;
    }

    public String getLast(){
        return last;
    }

    public int getScore(){
        return score;
    }

    public int getFlight() {
        return flight;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
