package io.github.zhangwei1989.zwconfig.demo;

import io.github.zhangwei1989.zwconfig.client.annotation.EnableZWConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties({ZWDemoConfig.class})
@EnableZWConfig
public class ZwconfigDemoApplication {

    @Value("${zw.a}")
    private String a;

    @Autowired
    private ZWDemoConfig zwDemoConfig;

    public static void main(String[] args) {
        SpringApplication.run(ZwconfigDemoApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            System.out.println(a);
            System.out.println(zwDemoConfig.getA());
        };
    }

}
