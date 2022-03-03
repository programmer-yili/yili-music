package com.bilitech.yilimusic.service;

import com.bilitech.yilimusic.dto.FileDto;
import com.bilitech.yilimusic.dto.FileUploadDto;
import com.bilitech.yilimusic.dto.FileUploadRequest;
import com.bilitech.yilimusic.enums.FileStatus;
import com.bilitech.yilimusic.enums.Storage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

import java.io.IOException;

@SpringBootTest
@Slf4j
class FileServiceTest extends BaseTest {

    private FileService fileService;


    @Test
    void initUpload() throws IOException {
        FileUploadRequest fileUploadRequest = new FileUploadRequest();
        fileUploadRequest.setName("测试文件名");
        fileUploadRequest.setExt("mp3");
        fileUploadRequest.setKey("835741aba850778a5b06bfd57f55c98c");
        fileUploadRequest.setSize(30000L);
        FileUploadDto fileUploadDto = fileService.initUpload(fileUploadRequest);
        Assertions.assertNotNull(fileUploadDto.getSecretKey());
        Assertions.assertNotNull(fileUploadDto.getSecretId());
        Assertions.assertNotNull(fileUploadDto.getSessionToken());
        Assertions.assertNotNull(fileUploadDto.getFileId());
        Assertions.assertEquals(fileUploadDto.getKey(), fileUploadRequest.getKey());
    }


    @Test
    void initUploadMaxSize() throws IOException {
        FileUploadRequest fileUploadRequest = new FileUploadRequest();
        fileUploadRequest.setName("测试文件名");
        fileUploadRequest.setExt("mp3");
        fileUploadRequest.setKey("835741aba850778a5b06bfd57f55c98c");
        fileUploadRequest.setSize(6082813636L);
        FileUploadDto fileUploadDto = fileService.initUpload(fileUploadRequest);
        Assertions.assertNotNull(fileUploadDto.getSecretKey());
        Assertions.assertNotNull(fileUploadDto.getSecretId());
        Assertions.assertNotNull(fileUploadDto.getSessionToken());
        Assertions.assertNotNull(fileUploadDto.getFileId());
        Assertions.assertEquals(fileUploadDto.getKey(), fileUploadRequest.getKey());
    }

    @Test
    @WithMockUser(username = "yili")
    void finishUpload() throws IOException {
        FileUploadRequest fileUploadRequest = new FileUploadRequest();
        fileUploadRequest.setName("测试文件名");
        fileUploadRequest.setExt("mp3");
        fileUploadRequest.setKey("835741aba850778a5b06bfd57f55c98c");
        fileUploadRequest.setSize(30000L);
        FileUploadDto fileUploadDto = fileService.initUpload(fileUploadRequest);

        FileDto finishedFile = fileService.finishUpload(fileUploadDto.getFileId());
        Assertions.assertEquals(fileUploadDto.getFileId(), finishedFile.getId());
        Assertions.assertEquals(FileStatus.UPLOADED, finishedFile.getStatus());
    }


    @Test
    void getDefaultStorage() {
        Storage storage = fileService.getDefaultStorage();
        Assertions.assertEquals(Storage.COS, storage);
    }

    @Autowired
    private void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

}