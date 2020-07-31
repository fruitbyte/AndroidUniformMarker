package com.won_tonsoup.uniformmarker;

public class Cadet {
    private String last;
    private String first;
    private int flight;
    private String firstlast;

    public Cadet(){}

    public Cadet(String first, String last, int flight, String firstlast) {
        this.last = last;
        this.first = first;
        this.flight = flight;
        this.firstlast = firstlast;
    }

    public String getLast() {
        return last;
    }

    public String getFirst() {
        return first;
    }

    public int getFlight() {
        return flight;
    }

    public String getFirstlast() {
        return firstlast;
    }

}
