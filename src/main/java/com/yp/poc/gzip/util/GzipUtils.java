package com.yp.poc.gzip.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class GzipUtils {

    private GzipUtils() {
    }

    public static byte[] decompress(byte[] toDecompress) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(toDecompress);
        GZIPInputStream gis = new GZIPInputStream(bis);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        byte[] buffer = new byte[1024];
        int len;
        while ((len = gis.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }

        bos.close();
        gis.close();
        bis.close();

        return bos.toByteArray();
    }
}
