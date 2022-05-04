package com.bilitech.yilimusic.dto;

import lombok.Data;

@Data
public class AlbumSearchFilter extends BaseSearchFilter {
    private String name = "";

    private Boolean recommended;
}
