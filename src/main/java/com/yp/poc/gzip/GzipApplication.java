package com.yp.poc.gzip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

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
