package org.sandcastle.apps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@EnableConfigurationProperties
@EnableSwagger2
@ComponentScan("org.sandcastle.apps")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Docket personApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("person")
                .apiInfo(personApiInfo())
                .select()
                .paths(regex("/person.*"))
                .build();
    }

    @Bean
    public Docket memoryApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("memory")
                .apiInfo(memoryApiInfo())
                .select()
                .paths(regex("/memory.*"))
                .build();
    }

    private ApiInfo personApiInfo(){
        return new ApiInfoBuilder()
                .title("Person Api")
                .description("Spring based RESTful Api for genealogy ")
                .termsOfServiceUrl("")
                .contact(new Contact("Saumil Patel", null, null))
                .license("Apache License version 2.0")
                .version("2.0")
                .build();
    }

    private ApiInfo memoryApiInfo(){
        return new ApiInfoBuilder()
                .title("Memory Api")
                .description("Spring based RESTful Api for genealogy ")
                .termsOfServiceUrl("")
                .contact(new Contact("Saumil Patel", null, null))
                .license("Apache License version 2.0")
                .version("2.0")
                .build();
    }
}
