package com.zxk175.ssm.swagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by zxk175 on 2017/2/23.
 */

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket.apiInfo(apiInfo());

        ApiSelectorBuilder apiSelectorBuilder = docket.select();
        apiSelectorBuilder.apis(RequestHandlerSelectors.basePackage("com.zxk175.ssm.controller"));
        apiSelectorBuilder.paths(PathSelectors.any());

        return apiSelectorBuilder.build();
    }

    /**
     * 构建Api基本信息
     *
     * @return
     */
    private ApiInfo apiInfo() {
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("使用Swagger2构建RESTful APIs");
        apiInfoBuilder.description("更多文章请点击：http://zxk175.com");
        apiInfoBuilder.termsOfServiceUrl("http://zxk175.com");
        apiInfoBuilder.contact(new Contact("张小康", "http://zxk175.com", "zxk175@qq.com"));
        apiInfoBuilder.version("1.0");
        return apiInfoBuilder.build();
    }
}
