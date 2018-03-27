package cn.deepcoding.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao {

	 @Autowired  
	 private SessionFactory sessionfactory;
	 
	 public Session getSession(){
		 return sessionfactory.getCurrentSession();
	 }
}
