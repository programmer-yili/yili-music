package com.bilitech.yilimusic.mapper;

import com.bilitech.yilimusic.dto.SiteSettingDto;
import com.bilitech.yilimusic.vo.SiteSettingVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SiteSettingMapper {
    SiteSettingVo toVo(SiteSettingDto siteSettingDto);
}
