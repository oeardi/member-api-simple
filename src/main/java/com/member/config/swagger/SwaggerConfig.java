package com.member.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger-ui 配置类
 *
 * @author 冷枫红舞
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket memberInfoApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(memberInfoDocument())
                .pathMapping("/")
                .select()
                .paths(PathSelectors.regex("/.*"))
                .build();
    }

    private ApiInfo memberInfoDocument() {
        return new ApiInfoBuilder().title("会员服务测试项目")
                .contact(new Contact("冷枫红舞", "", ""))
                .description("接口信息描述.").version("1.0.0")
                .build();
    }
}
