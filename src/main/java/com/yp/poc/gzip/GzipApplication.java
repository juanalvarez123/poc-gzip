package com.yp.poc.gzip;

import io.undertow.server.handlers.encoding.RequestEncodingHandler;
import io.undertow.servlet.UndertowServletLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.undertow.Undertow.Builder;

@SpringBootApplication
@Configuration
public class GzipApplication {

	public static void main(String[] args) {
		SpringApplication.run(GzipApplication.class, args);
	}

	/*@Bean
	public UndertowEmbeddedServletContainerFactory servletWebServerFactory() {
		UndertowEmbeddedServletContainerFactory factory = new UndertowEmbeddedServletContainerFactory();
		factory.addBuilderCustomizers(builder -> {
			builder.setHandler()
		});
		return factory;
	}*/

	/*@Bean
	public FilterRegistrationBean gzipFilter() {
		FilterRegistrationBean filterBean = new FilterRegistrationBean();
		filterBean.setFilter(new GZIPFilter());
		return filterBean;
	}*/
}
