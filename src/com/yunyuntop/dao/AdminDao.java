package com.yunyuntop.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.yunyuntop.domain.Admin;
import com.yunyuntop.util.HibernateUtils;

public class AdminDao {

	public Admin loginadmin(String apwd,String aname){
		
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Criteria criteria=session.createCriteria(Admin.class);
		criteria.add(Restrictions.eq("aname",aname));
		criteria.add(Restrictions.eq("apwd",apwd));
		List<Admin> list=criteria.list();
		if(list.size()>0){
			Admin admin=list.get(0);
			tr.commit();
			session.close();
			return admin;
			
		}else{
			tr.commit();
			session.close();
			return null;
		}
		
	}
	
	public void registeradmin(Admin admin){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		session.save(admin);
		tr.commit();
		session.close();
	}
	
	public List<Admin> findAll(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		List<Admin> list=session.createQuery("from Admin").list();
		tr.commit();
		session.close();
		return list;
	}

	public void deleteAdmin(String aid) {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Admin admin = session.get(Admin.class, aid);
		session.delete(admin);
		tr.commit();
		session.close();
		
	}
}