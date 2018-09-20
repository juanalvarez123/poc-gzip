package com.yp.poc.gzip.service;

import com.yp.poc.gzip.util.GzipUtils;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DecompressService {

    private final ImageService imageService;

    @Autowired
    public DecompressService(ImageService imageService) {
        this.imageService = imageService;
    }

    public void decompressAndStoreImage(String base64ImageCompressed) throws IOException {
        byte[] decompressedImage = GzipUtils.decompressImage(base64ImageCompressed);
        imageService.setBase64DecompressedImage(decompressedImage);
    }

    public byte[] getDecompressedImage() {
        return imageService.getBase64DecompressedImage();
    }
}
