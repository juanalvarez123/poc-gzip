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

    @PostMapping(value = "/decompress", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void decompressAndStoreImage(@RequestBody PostImageRequest postImageRequest) throws IOException {
        decompressService.decompressAndStoreImage(postImageRequest.getBase64ImageCompressed());
    }

    @GetMapping(value = "/decompress", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] getDecompressedImage() {
        return decompressService.getDecompressedImage();
    }

}
