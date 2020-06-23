package com.yunyuntop.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.yunyuntop.domain.Message;
import com.yunyuntop.util.HibernateUtils;

import javassist.runtime.Desc;

public class MessageDao {

	public void addMessage(Message me) {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		session.save(me);
		tr.commit();
		session.close();
		
	}
	
	public List<Message> findAll(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		List<Message> list=session.createQuery("from Message order by mtime desc").list();
		tr.commit();
		session.close();
		return list;
		
	}
	
	public Integer findCount(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		List<Number> list = session.createQuery("select count(message) from Message").list();
		Integer count =  list.get(0).intValue();
		tr.commit();
		session.close();
		return count;
	}

	public List<Message> findByPage(Integer size, Integer currPage) {
		
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Criteria criteria = session.createCriteria(Message.class);
		criteria.addOrder(Order.desc("mtime"));
		criteria.setFirstResult((currPage-1)*size);
		criteria.setMaxResults(size);
		List<Message> list1 = criteria.list();
		tr.commit();

		session.close();
		return list1;
	}

	
	public void delMessage(String mid){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Message obj=session.get(Message.class, mid);
		session.delete(obj);
		
		tr.commit();

		session.close();
	}
}
