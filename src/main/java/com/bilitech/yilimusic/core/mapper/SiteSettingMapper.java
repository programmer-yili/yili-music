package com.bilitech.yilimusic.core.mapper;

import com.bilitech.yilimusic.core.dto.SiteSettingDto;
import com.bilitech.yilimusic.core.vo.SiteSettingVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SiteSettingMapper {
    SiteSettingVo toVo(SiteSettingDto siteSettingDto);
}
