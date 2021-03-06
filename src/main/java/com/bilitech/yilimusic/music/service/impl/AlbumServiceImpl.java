package com.bilitech.yilimusic.music.service.impl;

import com.bilitech.yilimusic.core.exception.ExceptionType;
import com.bilitech.yilimusic.core.mapper.MapperInterface;
import com.bilitech.yilimusic.core.repository.specs.SearchCriteria;
import com.bilitech.yilimusic.core.repository.specs.SearchOperation;
import com.bilitech.yilimusic.core.service.impl.TraceableGeneralServiceImpl;
import com.bilitech.yilimusic.music.dto.AlbumDto;
import com.bilitech.yilimusic.music.dto.AlbumSearchFilter;
import com.bilitech.yilimusic.music.entity.Album;
import com.bilitech.yilimusic.music.mapper.AlbumMapper;
import com.bilitech.yilimusic.music.repository.AlbumRepository;
import com.bilitech.yilimusic.music.repository.specs.AlbumSpecification;
import com.bilitech.yilimusic.music.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl extends TraceableGeneralServiceImpl<Album, AlbumDto> implements AlbumService {

    private AlbumRepository repository;

    private AlbumMapper mapper;

    @Override
    public Page<AlbumDto> search(AlbumSearchFilter albumSearchFilter) {
        AlbumSpecification specs = new AlbumSpecification();
        specs.add(new SearchCriteria("name", albumSearchFilter.getName(), SearchOperation.MATCH));
        if (albumSearchFilter.getRecommended() != null) {
            specs.add(new SearchCriteria("recommended", albumSearchFilter.getRecommended(), SearchOperation.EQUAL));
        }
        return repository.findAll(specs, albumSearchFilter.toPageable()).map(mapper::toDto);
    }

    @Override
    public AlbumDto recommend(String id, Integer recommendFactor) {
        Album album = getEntity(id);
        album.setRecommended(true);
        album.setRecommendFactor(recommendFactor);
        return mapper.toDto(repository.save(album));
    }

    @Override
    public AlbumDto cancelRecommendation(String id) {
        return null;
    }

    @Autowired
    public void setRepository(AlbumRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(AlbumMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public JpaRepository<Album, String> getRepository() {
        return repository;
    }

    @Override
    public MapperInterface<Album, AlbumDto> getMapper() {
        return mapper;
    }

    @Override
    public ExceptionType getNotFoundExceptionType() {
        return ExceptionType.ALBUM_NOT_FOUND;
    }
}
