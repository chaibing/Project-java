package cn.deepcoding.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.deepcoding.model.User;
import cn.deepcoding.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"classpath:applicationContext.xml"}) 
public class UserTest {

	@Autowired
	private UserService userService;
	
	@Test
	@Rollback (value=false)
	public void save(){
		User  user = new User();
		user.setName("abc");
		userService.save(user);
	}
	
}
