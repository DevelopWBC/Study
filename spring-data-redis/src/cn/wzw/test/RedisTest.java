package cn.wzw.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.wzw.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class RedisTest {
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	/**
	 * 添加
	 */
	@Test
	public void add() {
		redisTemplate.opsForValue().set("op", "po");
	}
	
	/**
	 * 获取
	 */
	@Test
	public void find() {
		String res = (String)redisTemplate.opsForValue().get("op");
		System.out.println(res);
	}
	
	/**
	 * 存储对象
	 */
	@Test
	public void addObject() {
		User user = new User();
		user.setId(1);
		user.setAge(18);
		user.setAddress("家庭住址");
		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		redisTemplate.opsForValue().set("user", user);
	}
	
	/**
	 * 查询对象
	 */
	@Test
	public void findObject() {
		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		User user = (User)redisTemplate.opsForValue().get("user");
	}
	
	/**
	 * 存储json对象
	 */
	@Test
	public void addJSON() {
		User  user = new User();
		user.setId(2);
		user.setAge(20);
		user.setAddress("地址地址");
		redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<User>(User.class));
		redisTemplate.opsForValue().set("userJSON", user);
	}
	
	/**
	 * 获取json对象
	 */
	@Test
	public void findJSON() {
		redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<User>(User.class));
		redisTemplate.opsForValue().get("userJSON");
	}
}
