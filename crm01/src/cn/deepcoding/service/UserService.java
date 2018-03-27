package cn.deepcoding.service;

import java.util.List;

import cn.deepcoding.model.User;

public interface UserService {

	public int save(User user);
	public User get(Integer id);
	public List<User> find(User user);
	public void delete(Integer id);
	public void update(User user);
}
