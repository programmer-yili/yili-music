package com.bilitech.yilimusic.core.mapper;

import com.bilitech.yilimusic.core.dto.BaseDto;
import com.bilitech.yilimusic.core.entity.BaseEntity;
import org.mapstruct.MappingTarget;

public interface MapperInterface<Entity extends BaseEntity, Dto extends BaseDto> {
    Dto toDto(Entity entity);

    Entity toEntity(Dto dto);

    Entity updateEntity(@MappingTarget Entity entity, Dto dto);
}
