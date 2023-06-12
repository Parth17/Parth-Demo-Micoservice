package com.example.demo;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select().apis(RequestHandlerSelectors.basePackage("com.example.demo"))
				.build().apiInfo(apiDettails());
	}
	
	private ApiInfo apiDettails() {
		return new ApiInfo(
				"Shop Items Management API",
				"API with swagger docs",
				"1.0",
				"",
				new springfox.documentation.service.Contact("Parth Mehta", "" , "mr.parthmehta@gmail.com"),
				"",
				"",
				Collections.emptyList()
				);
	}

}
