package com.yp.poc.gzip.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ImageService {

    private byte[] base64DecompressedImage;

    private byte[] base64NormalImage;
}
