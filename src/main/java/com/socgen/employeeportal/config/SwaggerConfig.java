package com.socgen.employeeportal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * Created by rajnalla on 7/19/2019.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private  static  final ApiInfo apiInfo = new ApiInfo("Employee Portal Documentation", "Employee Portal Api Documentation", "1.0", "",
            new Contact("Raja", "", "leoraja8@gmail.com"), "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo);
    }
}
