package wiki.acgcsbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Krian
 * @version 1.0
 * @description: 导航模块启动类
 * @date 2023/4/2 0002 16:24
 */
// 开启服务发现注册：
@EnableDiscoveryClient
@SpringBootApplication
public class WebSiteApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebSiteApplication.class, args);
    }
}
