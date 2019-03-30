package com.lcydream.project.springcloudconfigclientdemo;

import com.lcydream.project.springcloudconfigclientdemo.health.MyHealthIndicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Set;

/**
 * @author LuoCY
 */
@SpringBootApplication
public class SpringCloudConfigClientDemoApplication {

	private final ContextRefresher contextRefresher;
	private final Environment environment;

	@Autowired
	public SpringCloudConfigClientDemoApplication(ContextRefresher contextRefresher, Environment environment) {
		this.contextRefresher = contextRefresher;
		this.environment = environment;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigClientDemoApplication.class, args);
	}

	@Bean
	public MyHealthIndicator myHealthIndicator(){
		return new MyHealthIndicator();
	}

	@Scheduled(fixedRate = 60*1000,initialDelay = 5000)
	public void autoRefresh() {
		Set<String> refreshPropertyBuName = contextRefresher.refresh();
        refreshPropertyBuName.forEach(propertyName ->
		        System.out.printf("[Thread:%s]当前配置已经更新, key：%s : value：%s\n",
				        Thread.currentThread().getName(),
				        propertyName,
				        environment.getProperty(propertyName)
				        ));
		if (!refreshPropertyBuName.isEmpty()) {
			System.out.printf("[Thread:%s]当前配置已经更新，具体项：%s \n",
					Thread.currentThread().getName(),
					refreshPropertyBuName);
		}
	}
}
