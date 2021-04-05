package com.xlh.swagger.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * 用途描述
 *
 * @author 胡晓磊
 * @company xxx
 * @date 2021年04月05日 18:06 胡晓磊 Exp $
 */
@Configuration
public class Swagger2Config {

    /**
     * 是否开启swagger，生产环境不开启
     */
    @Value("${swagger.enabled}")
    private Boolean enabled;

    /**
     * swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
     **/
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enabled)
                .apiInfo(apiInfo())
                .select()
                // 为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.xlh.swagger.demo.controller"))
                .paths(PathSelectors.any())
                .build();
    }


    /**
     * 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 页面标题
                .title("测试swagger api demo")
                // 创建人信息
                .contact(new Contact("xlhu", "https://huxiaolei.xyz", "123@qq.com"))
                // 版本号
                .version("1.0")
                // 描述
                .description("测试api描述")
                .build();
    }
}
