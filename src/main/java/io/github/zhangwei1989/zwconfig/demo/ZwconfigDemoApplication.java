package io.github.zhangwei1989.zwconfig.demo;

import io.github.zhangwei1989.zwconfig.client.annotation.EnableZWConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableConfigurationProperties({ZWDemoConfig.class})
@EnableZWConfig
@RestController
public class ZwconfigDemoApplication {

	@Value("${zw.a}")
	private String a;

	@Value("${zw.b}")
	private String b;

	@Autowired
	private ZWDemoConfig zwDemoConfig;

	@GetMapping("/demo")
	public String demo() {
		return "Value a: " + a + "\n"
				+ "Value b: " + b + "\n"
				+ "ConfigurationProperties a: " + zwDemoConfig.getA() + "\n"
				+ "ConfigurationProperties b: " + zwDemoConfig.getB();
	}

	public static void main(String[] args) {
		SpringApplication.run(ZwconfigDemoApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner() {
		return args -> {
			System.out.println(a);
			System.out.println(b);
			System.out.println(zwDemoConfig.getA());
			System.out.println(zwDemoConfig.getB());
		};
	}

}
