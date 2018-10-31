package com.wyk.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * SSO 客户端示例
 *
 * @author wyk
 * @Date 2018年10月3日15:34:08
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }
}
