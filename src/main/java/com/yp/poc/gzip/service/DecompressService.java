package com.yp.poc.gzip.service;

import com.yp.poc.gzip.util.GzipUtils;
import java.io.IOException;
import java.util.Base64;
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
        byte[] compressedByteArray = Base64.getDecoder().decode(base64ImageCompressed);
        byte[] decompressedByteArray = GzipUtils.decompress(compressedByteArray);
        imageService.setBase64DecompressedImage(decompressedByteArray);
    }

    public byte[] getDecompressedImage() {
        return imageService.getBase64DecompressedImage();
    }
}
