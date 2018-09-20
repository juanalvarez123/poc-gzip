package com.yp.poc.gzip.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.zip.GZIPInputStream;

public class GzipUtils {

    private GzipUtils() {
    }

    public static byte[] decompressImage(String base64ImageCompressed) throws IOException {
        byte[] imageCompressed = Base64.getDecoder().decode(base64ImageCompressed);
        ByteArrayInputStream bis = new ByteArrayInputStream(imageCompressed);
        GZIPInputStream gis = new GZIPInputStream(bis);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        byte[] buffer = new byte[1024];
        int len;
        while ((len = gis.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }

        return bos.toByteArray();
    }
}
