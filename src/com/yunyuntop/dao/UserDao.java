package com.yunyuntop.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.yunyuntop.domain.Blogs;
import com.yunyuntop.domain.User;
import com.yunyuntop.util.HibernateUtils;

public class UserDao {

	public User login(String username,String password){
		
		Session session=HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		
		List<User> list=null;
		Criteria dc = session.createCriteria(User.class);
    	dc.add(Restrictions.eq("username", username));
    	dc.add(Restrictions.eq("password", password));
        list=dc.list();
		tr.commit();
		session.close();
		if(list.size()>0){
			return list.get(0);
		}else{
		
		return null;
		
		}
	}
	
	public User findByUid(String uid){
	
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		User user = session.get(User.class,uid);
		tr.commit();
		session.close();
		return user;
	}
	
	public void add(User u){
		Session session =HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		session.save(u);
		tr.commit();
		session.close();
	}
	public List<User> findAllByUtime(int size,Integer currPage){
		
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		criteria.addOrder(Order.desc("utime"));
		criteria.setFirstResult((currPage-1)*size);
		criteria.setMaxResults(size);
		List<User> list = criteria.list();
		tr.commit();
		session.close();		
		return list;
	}
	public int findTotalSize(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		List<Number> number = session.createQuery("select count(uid) from User").list();
		int size=number.get(0).intValue();
		tr.commit();
		session.close();		
		return size;
	}
	public void deleteuser(User user){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		
		session.delete(user);
		tr.commit();
		session.close();
	}
	
	public User updateState(String uid){
		Session session = HibernateUtils.getSession();
		Transaction tr =  session.beginTransaction();
		User user=session.get(User.class, uid);
		if(user!=null){
		user.setUstate(1);
		session.update(user);
		}
		tr.commit();
		session.close();
		return user;
	}
	
	public User updatePassword(String password,String uemail){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("uemail",uemail));
		List<User> list=criteria.list();
		//List<User> list=session.createQuery("from User where uemail='"+uemail+"'").list();
		
		if(list.size()>0){
			User user = list.get(0);
			user.setPassword(password);
			session.update(user);
			tr.commit();
			session.close();
			return user;
		}
		tr.commit();
		session.close();
		return null;
		
	}

	public User findByEmail(String uemail) {
		Session session = HibernateUtils.getSession();
		Transaction tr= session.beginTransaction();
		List<User> list=null;
		Criteria dc = session.createCriteria(User.class);
   	    dc.add(Restrictions.eq("uemail", uemail));
        list=dc.list();
        tr.commit();
        session.close();
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
		
	}

	public User findByName(String username) {
		Session session = HibernateUtils.getSession();
		Transaction tr= session.beginTransaction();
		List<User> list=null;
		Criteria dc = session.createCriteria(User.class);
   	    dc.add(Restrictions.eq("username", username));
        list=dc.list();
        tr.commit();
        session.close();
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
	
	public void editUser(User user){
		Session session=HibernateUtils.getSession();
		Transaction tr=session.beginTransaction();
		session.update(user);
		tr.commit();
		session.close();
	}
}
