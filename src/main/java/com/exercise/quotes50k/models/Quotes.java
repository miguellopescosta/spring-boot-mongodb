package com.exercise.quotes50k.models;

import lombok.Data;
import java.util.List;

@Data
public class Quotes {

    private List<Quote> data;
    private Long statusCode;
    private String message;
    private Pagination pagination;
    private Long totalQuotes;

}
