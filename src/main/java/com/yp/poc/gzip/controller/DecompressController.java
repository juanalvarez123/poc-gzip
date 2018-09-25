package com.yp.poc.gzip.controller;

import com.yp.poc.gzip.model.PostImageRequest;
import com.yp.poc.gzip.service.DecompressService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Contains 2 end-points:
 * 1. Receive a compressed image, decompress it and stores it.
 * 2. Returns the decompressed image.
 */
@RestController
public class DecompressController {

    private final DecompressService decompressService;

    @Autowired
    public DecompressController(DecompressService decompressService) {
        this.decompressService = decompressService;
    }

    /** Compressed image */

    @PostMapping(value = "/decompress-1", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Boolean decompressAndStoreImage1(@RequestBody PostImageRequest postImageRequest) throws IOException {
        decompressService.decompressAndStoreImage(postImageRequest.getBase64ImageCompressed());
        return true;
    }

    @GetMapping(value = "/decompress-1", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getDecompressedImage1() {
        return decompressService.getDecompressedImage();
    }

    /** Normal image */

    @PostMapping(value = "/decompress-2", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Boolean storeNormalImage(@RequestBody PostImageRequest postImageRequest) throws IOException {
        decompressService.storeNormalImage(postImageRequest.getBase64ImageCompressed());
        return true;
    }

    @GetMapping(value = "/decompress-2", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getNormalImage() {
        return decompressService.getNormalImage();
    }

}
