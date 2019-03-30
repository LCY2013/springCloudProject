package com.lcydream.project.springbootcoluddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LuoCY
 */
@SpringBootApplication
public class SpringBootColudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootColudDemoApplication.class, args);
	}


	@Configuration //设置为配置文件
	@Order(Ordered.HIGHEST_PRECEDENCE) //定义最高优先级
	public static class MyPropertySourceLocator implements PropertySourceLocator {

		@Override
		public PropertySource<?> locate(Environment environment) {
			Map<String,Object> source = new HashMap<>(10);
			source.put("server.port",9090);

			MapPropertySource propertySource = new MapPropertySource("my-property-source",source);
			return propertySource;
		}
	}
}
