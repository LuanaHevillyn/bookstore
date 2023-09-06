package com.WDA.bookstore.utils;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
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
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.WDA.bookstore"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(buildApiInfo());
    }


    private ApiInfo buildApiInfo(){
        return new ApiInfoBuilder()
                .title("Bookstore WDA")
                .description("Bookstore made in Java")
                .version("1.0")
                .contact(new Contact("Luana Hevillyn", "https://github.com/LuanaHevillyn/projeto-vue", "luanahevillynn@gmail.com"))
                .build();
    }
}
