package com.shanjupay.merchant.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
//2. 开启swagger支持
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2) // 选择swagger的版本
                // 配置文档信息：swagger文档的标题、版本、描述
                .apiInfo(this.apiInfo())
                .select()
                // 配置要生成swagger文档的扫描的目录包
                .apis(RequestHandlerSelectors.basePackage("com.shanjupay.merchant.service"))
                // 对指定路径下的任意类生成文档
                .paths(PathSelectors.any())
                // 创建对象
                .build();
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                // 指定文档标题 （在swagger页面会显示）
                .title("交易服务")
                // 指定文档的版本
                .version("1.0")
                // 文档描述
                .description("API描述").build();
    }

}
