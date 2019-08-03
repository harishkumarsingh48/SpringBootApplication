package com.myApplication.config;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2

public class SwaggerConfig {
	
	private static final Contact DEFAULT_CONTACT = new Contact("Harish Kumar Singh","Harish", "harish.singh@gmail.com");
	private static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Api Documentation", "Api Documentation", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	private static final HashSet<String> DEFAULT_PRODUCE_CONSUME = new HashSet<String>
	                  (Arrays.asList("application/json","application/xml"));
	@Bean
	public Docket api() {
		// http://localhost:8081/swagger-ui.html
		// http://localhost:8081/v2/api-docs
		// http://localhost:8081/browser/index.html#/
		// http://localhost:8081/actuator
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO)
				.consumes(DEFAULT_PRODUCE_CONSUME).produces(DEFAULT_PRODUCE_CONSUME);
	}

}
