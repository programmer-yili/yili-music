package com.bilitech.yilimusic.service;

import com.bilitech.yilimusic.core.dto.SiteSettingDto;
import com.bilitech.yilimusic.core.enums.Storage;
import com.bilitech.yilimusic.core.service.SettingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SettingServiceTest {

    private SettingService service;

    @Test
    void getSiteSetting() {
        SiteSettingDto siteSettingDto = service.getSiteSetting();
        Assertions.assertNotNull(siteSettingDto.getBucket());
        Assertions.assertNotNull(siteSettingDto.getRegion());
        Assertions.assertInstanceOf(Storage.class, siteSettingDto.getStorage());
    }

    @Autowired
    public void setService(SettingService service) {
        this.service = service;
    }
}