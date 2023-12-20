package com.fengwenyi.springboot.swagger2.config;

import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-06-26
 */
@Configuration
@EnableWebMvc
public class Swagger2Config implements WebMvcConfigurer {

    @Bean
    public Docket api() {
        /*return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.fengwenyi"))
                .paths(PathSelectors.regex("/.*"))
                .build().apiInfo(apiInfoMetaData());*/

        return new Docket(DocumentationType.SWAGGER_2)
//                .securitySchemes(securitySchemes())
//                .securityContexts(securityContexts())
                //配置是否启用Swagger，如果是false，在浏览器将无法访问，默认是true
                .enable(true)
                //apiInfo： 添加api详情信息，参数为ApiInfo类型的参数，这个参数包含了第二部分的所有信息比如标题、描述、版本之类的，开发中一般都会自定义这些信息
                .apiInfo(apiInfoMetaData())
                .select()
                //apis： 添加过滤条件,
                //加了ApiOperation注解的类，才生成接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //包下的类，才生成接口文档
//                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .apis(Predicates.or(
                        RequestHandlerSelectors.basePackage(""),
                        RequestHandlerSelectors.basePackage("")
                ))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfoMetaData() {

        return new ApiInfoBuilder()
                .title("API Title")
                .description("API Decoration")
                .contact(new Contact("Erwin Feng", "https://fengwenyi.com", "xfsy_2015@163.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }

    private List<ApiKey> securitySchemes() {
        return Lists.newArrayList(
                new ApiKey("Authorization", "Authorization", "header"));
    }

    private List<SecurityContext> securityContexts() {
        return Lists.newArrayList(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
                        .build()
        );
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(
                new SecurityReference("Authorization", authorizationScopes));
    }

}
