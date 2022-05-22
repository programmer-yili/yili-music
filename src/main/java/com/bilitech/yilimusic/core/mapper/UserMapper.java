package com.bilitech.yilimusic.core.mapper;

import com.bilitech.yilimusic.core.dto.UserCreateRequest;
import com.bilitech.yilimusic.core.dto.UserDto;
import com.bilitech.yilimusic.core.dto.UserUpdateRequest;
import com.bilitech.yilimusic.core.vo.UserVo;
import com.bilitech.yilimusic.core.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
  UserDto toDto(User user);

  UserVo toVo(UserDto userDto);

  User createEntity(UserCreateRequest userCreateRequest);

  User updateEntity(@MappingTarget User user, UserUpdateRequest userUpdateRequest);
}
