package com.bilitech.yilimusic.dto;

import com.bilitech.yilimusic.enums.Storage;
import lombok.Data;

@Data
public class SiteSettingDto {
    private String bucket;

    private String region;

    private Storage storage;
}
