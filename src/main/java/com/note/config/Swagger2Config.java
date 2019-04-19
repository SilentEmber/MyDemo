/**
 * 
 */
package com.note.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Administrator
 * @created 2019年3月7日
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
	@SuppressWarnings("unused")
	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Swagger2Config.class);

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2) //
				.apiInfo(apiInfo()) //
				.select() //
				.apis(RequestHandlerSelectors.basePackage("com.note.controller")) //
				.paths(PathSelectors.any()) //
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder() //
				.title("RESTful APIs from Swagger2") //
				.description("项目swagger description/") //
				// .termsOfServiceUrl("http://blog.didispace.com/") // F
				.version("1.0") //
				.build();
	}
}
