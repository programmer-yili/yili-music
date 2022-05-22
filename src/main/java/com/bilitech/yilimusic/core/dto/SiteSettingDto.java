package com.bilitech.yilimusic.core.dto;

import com.bilitech.yilimusic.core.enums.Storage;
import lombok.Data;

@Data
public class SiteSettingDto {
    private String bucket;

    private String region;

    private Storage storage;
}
