package com.tcs.angular.creditcard.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Tomcat.Resource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.tcs.angular.creditcard.entity.CreditCardImage;
import com.tcs.angular.creditcard.entity.Response;
import com.tcs.angular.creditcard.repository.CreditCardImageRepo;

@RestController
@RequestMapping("/image")
class ImageController {

    @Autowired
    CreditCardImageRepo imageDbRepository;

    @PostMapping("/upload")
    public Response uploadImage(@RequestParam MultipartFile multipartImage) throws Exception {
    	CreditCardImage dbImage = new CreditCardImage();
       dbImage.setCardType(multipartImage.getName());
        dbImage.setCreditCardImage(multipartImage.getBytes());

        return new  Response("ok","Card Image Uploaded!");
    }
    /*
    @GetMapping(value = "/{cardType}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ByteArrayResource downloadImage(@PathVariable String cardType) {
        byte[] image = imageDbRepository.findById(cardType)
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
          .getCreditCardImage();

        return new ByteArrayResource(image);
    }
    */
}