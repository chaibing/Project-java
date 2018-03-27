package cn.deepcoding.action;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import cn.deepcoding.model.User;
import cn.deepcoding.service.UserService;

public class UserAction extends ActionSupport {

	@Autowired
	private UserService userService;
	
	private User user;
	private Integer id;
	private List<User> users;
	
	public String save(){
		userService.save(user);
		return "list";
	}
	public String add(){
		return "success";
	}

	public String find(){
		users = userService.find(user);
		return "success";
	}
	//id
	public String delete(){
		userService.delete(id);
		return "list";
	}
	public String edit(){
		user = userService.get(id);
		return "success";
	}
	public String update(){
		userService.update(user);
		return "list";
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
