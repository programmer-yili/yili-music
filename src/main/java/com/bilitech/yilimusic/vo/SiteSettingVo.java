package com.bilitech.yilimusic.vo;

import com.bilitech.yilimusic.enums.Storage;
import lombok.Data;

@Data
public class SiteSettingVo {
    private String bucket;

    private String region;

    private Storage storage;
}
