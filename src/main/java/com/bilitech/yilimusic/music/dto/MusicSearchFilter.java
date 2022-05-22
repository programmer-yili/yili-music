package com.bilitech.yilimusic.music.dto;

import com.bilitech.yilimusic.core.dto.BaseSearchFilter;
import lombok.Data;

@Data
public class MusicSearchFilter extends BaseSearchFilter {
    private String name = "";
}
