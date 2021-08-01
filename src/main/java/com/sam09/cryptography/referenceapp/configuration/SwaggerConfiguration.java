/**
 * @author Sam
 *
 */
package com.sam09.cryptography.referenceapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    private static final String BASE_PACKAGE = "com.sam09.cryptography.referenceapp.controller";
    private static final String PATH_SELECTOR = "/v1/*";
    @Bean
    public Docket apiDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(PathSelectors.ant(PATH_SELECTOR))
                .build()
                .useDefaultResponseMessages(true)
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Reference Cryptography Application",
                "/encrypt & /decrypt has been exposed to facilitate cryptography",
                " A sample ref-app levering a custom cryptography starter",
                "Terms of Service",
                new Contact("Soumyabrata09",null ,"sen.soumyabrata09@yahoo.com"),
                null,
                null,
                Collections.emptyList()
        );
    }
}
