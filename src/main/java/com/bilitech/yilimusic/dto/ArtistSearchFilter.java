package com.bilitech.yilimusic.dto;

import lombok.Data;

@Data
public class ArtistSearchFilter extends BaseSearchFilter {
    private String name = "";
}
