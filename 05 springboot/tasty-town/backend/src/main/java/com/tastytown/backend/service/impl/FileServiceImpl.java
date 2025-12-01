package com.tastytown.backend.service.impl;

import com.tastytown.backend.service.IFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Slf4j
@Service
public class FileServiceImpl implements IFileService {
    @Value("${upload.image.path}")
    private String IMAGES_FOLDER_PATH;

    @Override
    public void createImagesFolder() throws IOException {
        File file = new File(IMAGES_FOLDER_PATH);
        if(!file.exists()) {
            file.mkdir();
            log.info("folder created to store images");
        }

        log.info("folder already exists to store images");
    }
}
