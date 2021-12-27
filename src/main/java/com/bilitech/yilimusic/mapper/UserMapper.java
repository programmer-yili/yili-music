package com.bilitech.yilimusic.mapper;

import com.bilitech.yilimusic.dto.UserCreateDto;
import com.bilitech.yilimusic.dto.UserDto;
import com.bilitech.yilimusic.entity.User;
import com.bilitech.yilimusic.vo.UserVo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
  UserDto toDto(User user);

  UserVo toVo(UserDto userDto);

  User createEntity(UserCreateDto userCreateDto);
}
