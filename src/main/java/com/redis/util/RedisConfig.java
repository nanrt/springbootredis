package com.redis.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * <dl>
 * <dt>RedisConfig</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2018-12-20 20:21</dd>
 * </dl>
 *
 * @author nanrt
 */
@Configuration
public class RedisConfig {

	public RedisConnectionFactory getRedis(){
		JedisConnectionFactory factory=new JedisConnectionFactory();
		factory.setPort(6381);
		factory.setHostName("10.130.29.7");
		return factory;
	}
}
