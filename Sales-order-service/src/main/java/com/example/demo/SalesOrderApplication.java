package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@SpringBootApplication
@EntityScan(basePackages = {"entity"})
public class SalesOrderApplication {

    @Autowired
    private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(SalesOrderApplication.class, args);
	}

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).tags(
                new Tag("OrderServices","Order Service")

        )
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Order Service REST API",
                "API ",
                env.getProperty("info.version"),
                null,
                new Contact("Abhishek Das", "https://github.com/babai-abhishek", "babbi.abhishek@gmail.com"),
                null, null, Collections.emptyList());
    }

    @Bean
    public DozerBeanMapper modelMapper() {
        DozerBeanMapper modelMapper=new DozerBeanMapper();

        return modelMapper;
    }

    @Bean
    public ObjectMapper mapper(){
        return new ObjectMapper();
    }

}
