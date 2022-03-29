package com.bilitech.yilimusic.service.impl;

import com.bilitech.yilimusic.dto.ArtistDto;
import com.bilitech.yilimusic.dto.ArtistSearchFilter;
import com.bilitech.yilimusic.entity.Artist;
import com.bilitech.yilimusic.exception.ExceptionType;
import com.bilitech.yilimusic.mapper.ArtistMapper;
import com.bilitech.yilimusic.mapper.MapperInterface;
import com.bilitech.yilimusic.repository.ArtistRepository;
import com.bilitech.yilimusic.repository.specs.ArtistSpecification;
import com.bilitech.yilimusic.repository.specs.SearchCriteria;
import com.bilitech.yilimusic.repository.specs.SearchOperation;
import com.bilitech.yilimusic.service.ArtistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArtistServiceImpl extends TraceableGeneralServiceImpl<Artist, ArtistDto> implements ArtistService {

    private ArtistMapper mapper;

    private ArtistRepository repository;

    @Override
    public List<ArtistDto> list() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Page<ArtistDto> search(ArtistSearchFilter artistSearchFilter) {
        ArtistSpecification specs = new ArtistSpecification();
        specs.add(new SearchCriteria("name", artistSearchFilter.getName(), SearchOperation.MATCH));
        if (artistSearchFilter.getRecommended() != null) {
            specs.add(new SearchCriteria("recommended", artistSearchFilter.getRecommended(), SearchOperation.EQUAL));
        }
        return repository.findAll(specs, artistSearchFilter.toPageable()).map(mapper::toDto);
    }

    @Override
    public ArtistDto recommend(String id, Integer recommendFactor) {
        Artist artist = getEntity(id);
        artist.setRecommended(true);
        artist.setRecommendFactor(recommendFactor);
        return mapper.toDto(repository.save(artist));
    }

    @Override
    public ArtistDto cancelRecommendation(String id) {
        Artist artist = getEntity(id);
        artist.setRecommended(false);
        artist.setRecommendFactor(0);
        return mapper.toDto(repository.save(artist));
    }

    @Autowired
    public void setRepository(ArtistRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(ArtistMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public JpaRepository<Artist, String> getRepository() {
        return repository;
    }

    @Override
    public MapperInterface<Artist, ArtistDto> getMapper() {
        return mapper;
    }

    @Override
    public ExceptionType getNotFoundExceptionType() {
        return ExceptionType.ARTIST_NOT_FOUND;
    }
}
