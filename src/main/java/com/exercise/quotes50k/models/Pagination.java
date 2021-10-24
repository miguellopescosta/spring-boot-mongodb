package com.exercise.quotes50k.models;

import lombok.Data;

@Data
public class Pagination {

    private Long currentPage;
    private Long nextPage;
    private Long totalPages;

}
