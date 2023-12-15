package com.yash.LibraryManagementSystem.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchBook {
    private String key;
    private String value;
}
