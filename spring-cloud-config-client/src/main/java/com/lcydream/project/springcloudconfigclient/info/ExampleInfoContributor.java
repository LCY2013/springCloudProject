package com.lcydream.project.springcloudconfigclient.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * ExampleInfoContributor
 *
 * @author Luo Chun Yun
 * @email 1475653689@qq.com
 * @date 2018/12/2 22:08
 */
@Component
public class ExampleInfoContributor implements InfoContributor {

	@Override
	public void contribute(Info.Builder builder) {
		builder.withDetail("example",
				Collections.singletonMap("key", "value"));
	}
}
