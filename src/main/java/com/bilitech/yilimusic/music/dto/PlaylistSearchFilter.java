package com.bilitech.yilimusic.music.dto;

import com.bilitech.yilimusic.core.dto.BaseSearchFilter;
import lombok.Data;

@Data
public class PlaylistSearchFilter extends BaseSearchFilter {
    private String name = "";

    private Boolean recommended;

    private Boolean special;
}
