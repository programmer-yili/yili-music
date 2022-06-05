package com.bilitech.yilimusic.core.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bilitech.yilimusic.core.config.SecurityConfig;
import com.bilitech.yilimusic.core.dto.*;
import com.bilitech.yilimusic.core.entity.User;
import com.bilitech.yilimusic.core.exception.BizException;
import com.bilitech.yilimusic.core.exception.ExceptionType;
import com.bilitech.yilimusic.core.mapper.UserMapper;
import com.bilitech.yilimusic.core.repository.UserRepository;
import com.bilitech.yilimusic.core.repository.specs.SearchCriteria;
import com.bilitech.yilimusic.core.repository.specs.SearchOperation;
import com.bilitech.yilimusic.core.repository.specs.UserSpecification;
import com.bilitech.yilimusic.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl extends BaseService implements UserService {

    UserRepository repository;

    UserMapper mapper;

    PasswordEncoder passwordEncoder;


    @Override
    public UserDto create(UserCreateRequest userCreateRequest) {
        checkUserName(userCreateRequest.getUsername());
        User user = mapper.createEntity(userCreateRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return mapper.toDto(repository.save(user));
    }

    @Override
    public UserDto get(String id) {
        return mapper.toDto(getById(id));
    }

    @Override
    public UserDto update(String id, UserUpdateRequest userUpdateRequest) {
        return mapper.toDto(repository.save(mapper.updateEntity(getById(id), userUpdateRequest)));
    }

    private User getById(String id) {
        Optional<User> user = repository.findById(id);
        if (!user.isPresent()) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
        return user.get();
    }

    @Override
    public void delete(String id) {
        repository.delete(getById(id));
    }

    @Override
    public Page<UserDto> search(UserSearchFilter userSearchFilter) {
        UserSpecification specs = new UserSpecification();
        // ToDo: 需要重构
        if (!Objects.equals(userSearchFilter.getNickname(), "")) {
            specs.add(new SearchCriteria("nickname", userSearchFilter.getNickname(), SearchOperation.MATCH));
        }
        return repository.findAll(specs, userSearchFilter.toPageable()).map(mapper::toDto);
    }

    @Override
    public User loadUserByUsername(String username) {
        return super.loadUserByUsername(username);
    }

    @Override
    public String createToken(TokenCreateRequest tokenCreateRequest) {
        User user = loadUserByUsername(tokenCreateRequest.getUsername());
        if (!passwordEncoder.matches(tokenCreateRequest.getPassword(), user.getPassword())) {
            throw new BizException(ExceptionType.USER_PASSWORD_NOT_MATCH);
        }
        if (!user.isEnabled()) {
            throw new BizException(ExceptionType.USER_NOT_ENABLED);
        }

        if (!user.isAccountNonLocked()) {
            throw new BizException(ExceptionType.USER_LOCKED);
        }

        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SecurityConfig.SECRET.getBytes()));
    }

    @Override
    public UserDto getCurrentUser() {
        return mapper.toDto(super.getCurrentUserEntity());
    }


    private void checkUserName(String username) {
        Optional<User> user = repository.findByUsername(username);
        if (user.isPresent()) {
            throw new BizException(ExceptionType.USER_NAME_DUPLICATE);
        }
    }


    @Autowired
    private void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    private void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    private void setRepository(UserRepository repository) {
        this.repository = repository;
    }
}
