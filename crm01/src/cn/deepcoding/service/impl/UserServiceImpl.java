package cn.deepcoding.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.deepcoding.dao.UserDao;
import cn.deepcoding.model.User;
import cn.deepcoding.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	@Override
	public int save(User user) {
		// TODO Auto-generated method stub
		return userDao.Save(user);
	}

	@Override
	public User get(Integer id) {
		// TODO Auto-generated method stub
		return userDao.get(id);
	}

	@Override
	public List<User> find(User user) {
		// TODO Auto-generated method stub
		return userDao.find(user);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		User user = userDao.get(id);
		userDao.delete(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		User oUser = userDao.get(user.getId());
		
		oUser.setAddress(user.getAddress());
		oUser.setEmail(user.getEmail());
		oUser.setName(user.getName());
		oUser.setPhone(user.getPhone());
		userDao.saveOrUpdate(oUser);
		
	}
	
}
