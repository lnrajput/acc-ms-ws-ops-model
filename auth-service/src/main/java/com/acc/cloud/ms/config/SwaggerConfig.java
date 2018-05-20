package com.acc.cloud.ms.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.acc.cloud.ms.resource"))
			.paths(PathSelectors.any())
			.build()
			.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo(
			"Auth API",
			"This Auth API is being used to retrieve JWT access token",
			"Auth API",
			"This is Accenture Workshop API",
			new Contact("Accenture", "www.accenture.com", "customersupport@accentrue.com"),
			"License of API", "Accenture", Collections.emptyList());
			
	}

}
