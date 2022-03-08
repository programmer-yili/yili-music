package com.bilitech.yilimusic.service;

import com.bilitech.yilimusic.dto.BaseDto;
import com.bilitech.yilimusic.entity.BaseEntity;
import com.bilitech.yilimusic.exception.ExceptionType;
import com.bilitech.yilimusic.mapper.MapperInterface;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneralService<Entity extends BaseEntity, Dto extends BaseDto> {
    JpaRepository<Entity, String> getRepository();

    MapperInterface<Entity, Dto> getMapper();

    ExceptionType getNotFoundExceptionType();

    Dto create(Dto dto);

    Dto get(String id);

    Dto update(String id, Dto dto);

    void delete(String id);
}
