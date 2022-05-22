package com.bilitech.yilimusic.service;

import com.bilitech.yilimusic.core.dto.FileDto;
import com.bilitech.yilimusic.core.dto.FileUploadDto;
import com.bilitech.yilimusic.core.dto.FileUploadRequest;
import com.bilitech.yilimusic.core.service.FileService;
import com.bilitech.yilimusic.music.dto.ArtistCreateRequest;
import com.bilitech.yilimusic.music.dto.ArtistDto;
import com.bilitech.yilimusic.music.mapper.ArtistMapper;
import com.bilitech.yilimusic.music.service.ArtistService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

import java.io.IOException;

@SpringBootTest
@Slf4j
class ArtistServiceTest extends BaseTest {

    @Autowired
    ArtistService artistService;

    @Autowired
    FileService fileService;

    @Autowired
    ArtistMapper artistMapper;

    private String photoId;


    @Test
    @WithMockUser(username = "yili")
    void create() {
        ArtistCreateRequest artistCreateRequest = new ArtistCreateRequest();
        artistCreateRequest.setName("周杰伦");
        artistCreateRequest.setRemark("Jay Chou");
        ArtistDto artistDto = artistService.create(artistMapper.toDto(artistCreateRequest));
        Assertions.assertEquals(artistCreateRequest.getName(), artistDto.getName());
        log.info(artistDto.toString());
    }

    @BeforeEach
    public void setDefaultPhoto() throws IOException {
        FileUploadRequest fileUploadRequest = new FileUploadRequest();
        fileUploadRequest.setName("测试文件名");
        fileUploadRequest.setExt("mp3");
        fileUploadRequest.setKey("835741aba850778a5b06bfd57f55c98c");
        fileUploadRequest.setSize(30000L);
        FileUploadDto fileUploadDto = fileService.initUpload(fileUploadRequest);

        FileDto finishedFile = fileService.finishUpload(fileUploadDto.getFileId());
        photoId = finishedFile.getId();
    }
}