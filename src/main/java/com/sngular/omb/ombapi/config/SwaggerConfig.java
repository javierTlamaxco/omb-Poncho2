package com.sngular.omb.ombapi.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Documentation;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * Swagger Class.
 * */
@Configuration
@EnableSwagger2
@ConditionalOnWebApplication
public class SwaggerConfig  implements WebMvcConfigurer {

    /***
     * Product API
     *
     * @return Interfaz Constructor Swagger
     * */
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sngular.omb.ombapi.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo())
                .enableUrlTemplating(false);
    }

    /**
     *  AddView Controllers
     * */
   // @Override
    public void addResourceHandler(ResourceHandlerRegistry registry){
        registry
                .addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath: /META-INF/resources/webjars/springfox-swagger-ui")
                .resourceChain(false);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/swagger-ui/")
                .setViewName("forward : /swagger-ui/index.html");
    }


    /**
     * Api Info
     *
     * @return Return APIInfo
     * */
    private static ApiInfo getApiInfo(){
        return new ApiInfoBuilder().title("OMB")
                .description("Services for API OMB")
                .version("1.1.1").build();
    }
}
