package cn.deepcoding.dao;

import java.util.List;

import cn.deepcoding.model.User;

public interface UserDao {

	public User get(Integer id);
	
	public int Save(User user);
	public List<User> find(User user);
	public void delete(User user);
	public void saveOrUpdate(User user);
}
