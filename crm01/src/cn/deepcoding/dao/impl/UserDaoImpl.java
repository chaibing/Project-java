package cn.deepcoding.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.deepcoding.dao.UserDao;
import cn.deepcoding.model.User;

@Repository
@Transactional
public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public User get(Integer id) {
		// TODO Auto-generated method stub
		return (User) getSession().get(User.class,id);
	}

	@Override
	public int Save(User user) {
		// TODO Auto-generated method stub
		return (int) getSession().save(user);
	}

	@Override
	public List<User> find(User user) {
		// TODO Auto-generated method stub
		/*
		 * private String name;
	private String phone;
	private String address;
	private String email;
		 */
		
		Criteria criteria =getSession().createCriteria(User.class);
		if(user!=null){
			if(user.getName()!=null&&!user.getName().isEmpty()){
				criteria.add(Restrictions.like("name", user.getName(),MatchMode.ANYWHERE));
			}
			if(user.getPhone()!=null&&!user.getPhone().isEmpty()){
				criteria.add(Restrictions.like("phone", user.getPhone(),MatchMode.ANYWHERE));
			}
			if(user.getAddress()!=null&&!user.getAddress().isEmpty()){
				criteria.add(Restrictions.like("address", user.getAddress(),MatchMode.ANYWHERE));
			}
			if(user.getEmail()!=null&&!user.getEmail().isEmpty()){
				criteria.add(Restrictions.like("email", user.getEmail(),MatchMode.ANYWHERE));
			}
		}
		
		
		return (List<User>)criteria.list();
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		getSession().delete(user);
	}

	@Override
	public void saveOrUpdate(User user) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(user);
	}

	
	
}
