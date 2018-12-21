package com.redis.test;

import com.redis.SpringbootredisApplication;
import com.redis.util.RedisConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <dl>
 * <dt>RedisTest</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2018-12-20 20:27</dd>
 * </dl>
 *
 * @author nanrt
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootredisApplication.class)
public class RedisTest {
	@Autowired
	private RedisConfig redisConfig;
	/**
	 * 使用的String序列化
	 */
	@Autowired
	private StringRedisTemplate redisStringTemplate;

	/**
	 * 使用jdk默认的序列化
	 */
	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void testRedis() {
		RedisConnection redisConnection = redisConfig.getRedis().getConnection();
		redisConnection.set("hello".getBytes(), "word".getBytes());
		System.out.println(new String(redisConnection.get("hello".getBytes())));
	}

	@Test
	public void testStringRedisTemplate() {
		redisStringTemplate.opsForValue().set("stringRedisTemplate", "ok");
		System.out.println(redisStringTemplate.opsForValue().get("stringRedisTemplate"));
	}


	@Test
	public void testRedisTemplate() {
		redisTemplate.opsForValue().set("redisTemplate", "ok");
		System.out.println(redisTemplate.opsForValue().get("redisTemplate"));
	}


}
