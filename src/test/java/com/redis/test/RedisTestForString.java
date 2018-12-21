package com.redis.test;

import com.redis.SpringbootredisApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <dl>
 * <dt>RedisTestForString</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2018-12-21 15:00</dd>
 * </dl>
 *
 * @author nanrt
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootredisApplication.class)
public class RedisTestForString {

	/**
	 * 注入stringRedisTemplate模板
	 */
	@Autowired
	private StringRedisTemplate redisStringTemplate;


	@Test
	public void testStringRedisTemplateForString() {
		/**添加一个key*/
		redisStringTemplate.opsForValue().set("java", "java");

		/**添加一个数字*/
		redisStringTemplate.opsForValue().set("1", "4");

		/**自增*/
		redisStringTemplate.opsForValue().increment("1");

		/**自增指定长度*/
		redisStringTemplate.opsForValue().increment("1", 5);

		/**获取值*/
		String count = redisStringTemplate.opsForValue().get("1");

		/**重新赋值*/
		redisStringTemplate.opsForValue().getAndSet("java", "c++");
		/**获取key对应的值*/
		String key = redisStringTemplate.opsForValue().get("java");

		System.out.println("key:" + key);
		System.out.println("自增：" + count);
	}


}
