package com.hms.ProfileMS.services;

import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Value;
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
    private final Path storageLocation;

    public FileStorageService(@Value("${file.upload-dir}") String uploadDir){
        this.storageLocation = Paths.get(uploadDir).toAbsolutePath().normalize();
        try{
            Files.createDirectories(this.storageLocation);
        } catch(IOException e) {
            throw new RuntimeException("can`t create Folder", e);
        }
    }
    public String saveFile(MultipartFile file) {
        if(file.isEmpty()) {
            throw new IllegalArgumentException("Is Empty");
        }
        String contentType = file.getContentType();
        if(contentType == null || !contentType.startsWith("image/")) {
            throw new IllegalArgumentException("No, Just Image");
        }
        try{
            String originalFileName = file.getOriginalFilename();
            String extension = "";
            if(originalFileName!= null && originalFileName.contains(".")) {
                extension = originalFileName.substring(originalFileName.lastIndexOf("."));
            }
            String uniqueFileName = UUID.randomUUID().toString() + extension;

            Path targetLocation = this.storageLocation.resolve(uniqueFileName);
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

        return "/uploads/images/" + uniqueFileName;

        } catch (IOException e){
            throw new RuntimeException("there is error");
        }
    }
}
