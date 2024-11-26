package com.ankursinha.backend.helper;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileStorageService {

private static final String BASE_UPLOAD_DIR = "src/main/resources/static/";

    public String storeFile(MultipartFile file, String subDirectory) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("Cannot store an empty file.");
        }

        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

        String uploadDir = BASE_UPLOAD_DIR + subDirectory + "/";
        Path filePath = Paths.get(uploadDir).resolve(fileName).normalize();

        Files.createDirectories(filePath.getParent());

        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return subDirectory + '/' + fileName;
    }

}
