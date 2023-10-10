package com.WDA.bookstore.utils;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .tags(
                        new Tag("Users", "Management of Users"),
                        new Tag("Rents", "Management of Rentals"),
                        new Tag("Publishers", "Management of Publishers"),
                        new Tag("Books", "Management of Books")
                )
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.WDA.bookstore"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(buildApiInfo());
    }
    
    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title("Bookstore WDA")
                .description("Bookstore made in Java")
                .version("1.0")
                .build();
    }
}