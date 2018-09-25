package com.yp.poc.gzip.configuration;

import io.undertow.UndertowOptions;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmbeddedServerConfiguration {

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        UndertowEmbeddedServletContainerFactory factory = new UndertowEmbeddedServletContainerFactory();
        factory.addBuilderCustomizers(builder -> {
            builder.setServerOption(UndertowOptions.MAX_ENTITY_SIZE, 62914560L);
            builder.setServerOption(UndertowOptions.MULTIPART_MAX_ENTITY_SIZE, 62914560L);
            builder.setServerOption(UndertowOptions.MAX_AJP_PACKET_SIZE, 62914560);
        });

        return factory;
    }

    /*@Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(62914560);
        return multipartResolver;
    }*/

    /** Tests with GZip filter */
	/*@Bean
	public FilterRegistrationBean gzipFilter() {
		FilterRegistrationBean filterBean = new FilterRegistrationBean();
		filterBean.setFilter(new GZIPFilter());
		return filterBean;
	}*/
}
