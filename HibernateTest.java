package cn.deepcoding;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;


import cn.deepcoding.model.DbUtils;
import cn.deepcoding.model.User;


public class HibernateTest {

/*	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
		//hibernate3���á�hibernate4�з����ķ���
		//SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Properties setting = configuration.getProperties();
		ServiceRegistry  serviceRegistry = new ServiceRegistryBuilder().applySettings(setting).buildServiceRegistry();
		//ʹ��sesseionfactory����session
		//����������
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		                   
		Session session  =  sessionFactory.openSession();
		//��������
		Transaction t = session.beginTransaction();
		
		User user = new User();
		user.setName("xiaoming");
		user.setAge(11);
		//����session�ķ���ʵ�����
		session.save(user);
		
		t.commit();
		session.close();
		
		sessionFactory.close();
	}
	*/
	@Test
	public void test1(){
		Session session=DbUtils.getSession();
		Transaction t=session.beginTransaction();
		User user=new User("mayun", 50);
		
		session.save(user);
		t.commit();
		session.close();
		
	}
	

	@Test
	public void test2(){
		Session session=DbUtils.getSession();
		Transaction t=session.beginTransaction();
		
		User user=(User)session.get(User.class,1);
		
		System.out.println(user);
		t.commit();
		session.close();
		
	}
	
	
	@Test
	public void test3(){
		
		Session  session=DbUtils.getSession();
		Transaction t=session.beginTransaction();
		 
		User user=new User("xiaoming", 11);
		session.save(user);
		t.commit();
		session.close();
		
	}
	@Test
	public void test4(){
		Session session =DbUtils.getSession();	
		Transaction  t=session.beginTransaction();
		String hql="from User ";	
		Query query=session.createQuery(hql);	
		List<User> users=query.list();	
		for(User user:users){
			System.out.println(user);			
		}
		t.commit();
		session.close();		
	}
	
	@Test
	public  void test5(){
		Session session=DbUtils.getSession();
		Transaction t=session.beginTransaction();
		String hql="from User where age=?";
		Query query =session.createQuery(hql);
		query.setInteger(0, 11);
	    List<User> users=query.list();
	    
	    
	    for(User user:users){
	    	  System.out.println(user);
	    }
	  
	    t.commit();
	    session.close();
	   
	}
	
	@Test
	public void test6(){
		Session session=DbUtils.getSession();
		Transaction t=session.beginTransaction();
		
		String hql="from User where age=:age";
		Query query=session.createQuery(hql);
		query.setInteger("age", 11);
		List<User> user=query.list();
		
		for( User userw:user){
			System.out.println(userw);
			
		}
		t.commit();
		session.close();		
	}
	//---------------------------------------------------------------------------------
	@Test
	public  void test7(){
		
		Session session=DbUtils.getSession();
		Transaction t=session.beginTransaction();
		 
		String sql="select name from aaaaa";
		
		Query  query=session.createSQLQuery(sql);
		
		
		List<Object> user=query.list();
		for(Object users:user){
			System.out.println(users);
			
		}
		t.commit();
		session.close();
	}
	
	
	@Test
	public  void test8(){
		Session session=DbUtils.getSession();
		Transaction t=session.beginTransaction();
		
		Criteria c=session.createCriteria(User.class);
		
		List<User> users=c.list()
				;
		for(User user:users){
			System.out.println(user);
			
		}
		t.commit();
		session.close();
		
		
	}
	
	@Test
	public void test9(){
		Session session=DbUtils.getSession();
		Transaction t=session.beginTransaction();
		
		Criteria c=session.createCriteria(User.class);
		c.add(Restrictions.eq("age", 1));
		c.add(Restrictions.like("name", "2" ,MatchMode.ANYWHERE));
		
		List<User> user=c.list();
		for(User us:user){
			System.out.println(us);
			
		}
		t.commit();
		session.close();
		
		
	}
	@Test
	public void test10(){
		Session session=DbUtils.getSession();
		Transaction   t=session.beginTransaction();
		Criteria criteria=session.createCriteria(User.class);
//	    criteria.add(Restrictions.eq("id", 2));
	   // criteria.add(Restrictions.between("id", , 3));
	    criteria.add(Restrictions.like("name","zhang%"));
	    
	    
	   //User user=(User)criteria.uniqueResult();
	    List<User> user=criteria.list();
	    for( User users:user){
	    	System.out.println(users);
	    	
	    }
	  
//	    System.out.println(user);
	    
	    t.commit();
	    session.close();
		
	}
	
	@Test
	public void test11(){
		Session session =DbUtils.getSession();
		Transaction  t=session.beginTransaction();
		//Criteria����������˼
		Criteria c=session.createCriteria(User.class);
		//Restrictions��������������˼
		c.add(Restrictions.eq("id", 5));
		
		User user=(User)c.uniqueResult();
		System.out.println(user);
		t.commit();
		session.close();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	
	 
	@Test
	public void test5(){
		Session session=DbUtils.getSession();
		Transaction t=session.beginTransaction();
		String hql="from User where age=?";
		Query query= session.createQuery(hql);
		query.setInteger(0,11);		
		List<User> users=query.list();
		
		
		for(User user:users){
			System.out.println(user);
			
		}
		t.commit();
		session.close();
		
	}*/
	
	
}