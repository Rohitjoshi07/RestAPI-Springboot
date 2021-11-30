package com.tcs.angular.creditcard.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.tcs.angular.creditcard.entity.ImageFile;
import com.tcs.angular.creditcard.repository.CreditCardImageRepo;



@Service
public class ImageFileService {

    private final CreditCardImageRepo fileRepository;

    @Autowired
    public ImageFileService(CreditCardImageRepo fileRepository) {
        this.fileRepository = fileRepository;
    }

    public void save(MultipartFile file, String name) throws IOException {
        ImageFile fileEntity = new ImageFile();
        //fileEntity.setName(StringUtils.cleanPath(file.getOriginalFilename()));
        fileEntity.setName(name);
        fileEntity.setContentType(file.getContentType());
        fileEntity.setData(file.getBytes());
        fileEntity.setSize(file.getSize());

        fileRepository.save(fileEntity);
    }

    public Optional<ImageFile> getFile(String id) {
        return fileRepository.findById(id);
    }

    public List<ImageFile> getAllFiles() {
        return fileRepository.findAll();
    }
    

}