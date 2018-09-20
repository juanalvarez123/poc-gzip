package com.yp.poc.gzip.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.servlet.FilterChain;
import javax.servlet.ReadListener;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Order(1)
public class GzipFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
        FilterChain filterChain) throws ServletException, IOException {

        HttpServletRequest httpServletRequest = request;

        /*String contentEncoding = httpServletRequest.getHeader("Content-Encoding");
        if (contentEncoding != null && contentEncoding.indexOf("gzip") > -1)
        {
            try
            {
                final InputStream decompressStream = StreamHelper.decompressStream(httpServletRequest.getInputStream());

                httpServletRequest = new HttpServletRequestWrapper(httpServletRequest)
                {

                    @Override
                    public ServletInputStream getInputStream() throws IOException
                    {
                        return new DecompressServletInputStream(decompressStream);
                    }

                    @Override
                    public BufferedReader getReader() throws IOException
                    {
                        return new BufferedReader(new InputStreamReader(decompressStream));
                    }
                };
            }
            catch (Exception e)
            {
                String hola = "";
                String hola2 = hola + "123";
            }
        }*/

        filterChain.doFilter(request, response);
    }

    private static class DecompressServletInputStream extends ServletInputStream
    {
        private InputStream inputStream;

        public DecompressServletInputStream(InputStream input)
        {
            inputStream = input;
        }

        @Override
        public int read() throws IOException
        {
            return inputStream.read();
        }

        @Override
        public boolean isFinished() {
            try {
                return inputStream.available() == 0;
            } catch (Exception ex) {
                return true;
            }
        }

        @Override
        public boolean isReady() {
            return true;
        }

        @Override
        public void setReadListener(ReadListener readListener) {
            throw new RuntimeException("Not implemented");
        }

    }

}