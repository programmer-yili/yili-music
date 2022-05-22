package com.bilitech.yilimusic.core.vo;

import com.bilitech.yilimusic.core.enums.Storage;
import lombok.Data;

@Data
public class SiteSettingVo {
    private String bucket;

    private String region;

    private Storage storage;
}
