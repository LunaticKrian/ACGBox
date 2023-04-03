package wiki.acgcsbox.config;

import cn.hutool.core.collection.CollUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.List;

/**
 * @author Krian
 * @version 1.0
 * @description: Knife 在线API文档配置类
 * @date 2023/4/3 0003 15:51
 */
@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfig {

    /**
     * 向容器中注入Docket文档对象
     *
     * @return Docket 文档对象
     */
    @Bean
    public Docket adminApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                // API 分组管理：
                .groupName("网站导航模块-接口文档")
                .apiInfo(adminInfoBuilder())
                // 设置全局Token：
                .securitySchemes(securitySchemes())
                .select()
                .apis(RequestHandlerSelectors.basePackage("wiki.acgcsbox"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 生成接口文档信息配置对象
     *
     * @return ApiInfo 接口文档信息
     */
    private ApiInfo adminInfoBuilder() {
        return new ApiInfoBuilder()
                .title("WebSite 网站导航模块")
                .description("网站集合管理模块，定制化分类管理网站！")
                .version("1.0")
                .contact(new Contact("爱吃糖的范同学", "https://website.csbox.wiki", "2793260947@qq.com"))
                .build();
    }

    /**
     * 生成Token列表
     *
     * @return List<ApiKey>
     */
    private List<ApiKey> securitySchemes() {
        ApiKey apiKey = new ApiKey("Authorization",
                "Authorization", "header");
        return CollUtil.newArrayList(apiKey);
    }
}
