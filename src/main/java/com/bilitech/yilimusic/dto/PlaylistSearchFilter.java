package com.bilitech.yilimusic.dto;

import lombok.Data;

@Data
public class PlaylistSearchFilter extends BaseSearchFilter {
    private String name = "";

    private Boolean recommended;
}
