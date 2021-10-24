package com.exercise.quotes50k.view;

import com.exercise.quotes50k.models.Quote;

import java.io.Serializable;
import java.util.List;

public class DataResponse implements Serializable {

    List<Quote> quotes;

    public DataResponse(List<Quote> quotes) {
        this.quotes = quotes;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }
}
