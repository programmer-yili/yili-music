package com.bilitech.yilimusic.dto;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class BaseSearchFilter {
    @Min(value = 1, message = "page最小值为1")
    private Integer page = 1;

    @Min(value = 0, message = "page最小值为1")
    private Integer size = 10;
}
