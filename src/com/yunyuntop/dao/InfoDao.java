package com.yunyuntop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yunyuntop.domain.Info;
import com.yunyuntop.util.HibernateUtils;

public class InfoDao {

	public void updateInfo(Info info) {
		Session session = HibernateUtils.getSession();
		Transaction tr =session.beginTransaction();
		session.saveOrUpdate(info);
		tr.commit();
		session.close();
		
	}

	public void insertInfo(Info info) {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		session.save(info);
		tr.commit();
		session.close();
		
	}

	public Info findInfo(String iid) {
		Session session = HibernateUtils.getSession();
		Transaction tr =  session.beginTransaction();
		Info info=session.get(Info.class, iid);
		tr.commit();
		session.close();
		return info;
		
	}
	
	public List<Info> find() {
		Session session = HibernateUtils.getSession();
		Transaction tr =  session.beginTransaction();
		List<Info> list=session.createQuery("from Info").list();
		tr.commit();
		session.close();
		return list;
		
	}

	public void deleteInfo(String iid) {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Info info=session.get(Info.class, iid);
		session.delete(info);
		tr.commit();
		session.close();
		
		
	}

}
