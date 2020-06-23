package com.yunyuntop.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.yunyuntop.domain.Kinds;
import com.yunyuntop.util.HibernateUtils;

public class KindsDao {

	public List<Kinds> findAllTag(){
		
		Session session=HibernateUtils.getSession();
		Transaction tr=session.beginTransaction();
		List<Kinds> list=session.createQuery("from Kinds").list();
		tr.commit();
		session.close();
		return list;		
	}
	
	public  Kinds findKindsById(String kid){
		
		Session session=HibernateUtils.getSession();
		Transaction tr=session.beginTransaction();
		Kinds kinds=session.get(Kinds.class, kid);
		tr.commit();
		session.close();
		return kinds;
				
	}

	public void updateKind(Kinds kind) {
		Session session=HibernateUtils.getSession();
		Transaction tr=session.beginTransaction();
		session.update(kind);
		tr.commit();
		session.close();
		
	}

	public void delete(String kid) {
		Session session=HibernateUtils.getSession();
		Transaction tr=session.beginTransaction();
		Kinds kinds=session.get(Kinds.class, kid);
		session.delete(kinds);
		tr.commit();
		session.close();
		
	}
	
	public Kinds addKinds(Kinds kinds) {
		Session session=HibernateUtils.getSession();
		Transaction tr=session.beginTransaction();
		session.save(kinds);
		tr.commit();
		session.close(); return kinds;
	}

	public List<Kinds> findKindsText(String ktext) {
		Session session=HibernateUtils.getSession();
		Transaction tr=session.beginTransaction();
		Criteria criteria= session.createCriteria(Kinds.class);List<Kinds> list;
		if(ktext!=null&&ktext.trim().length()>0){
		criteria.add(Restrictions.like("ktext", ktext+"%").ignoreCase());
		 list= criteria.list();
		}else{
		 list=new ArrayList<Kinds>();
		}
		tr.commit();
		session.close();return list;
	}
	public Kinds findKindsByText(String ktext) {
		Session session=HibernateUtils.getSession();
		Transaction tr=session.beginTransaction();
		Criteria criteria= session.createCriteria(Kinds.class);
		List<Kinds> list;		
		criteria.add(Restrictions.eq("ktext", ktext));
		 list= criteria.list();
		tr.commit();
		session.close();
		if(list!=null&&list.size()>=1){
			return list.get(0);
		}else{
			return null;
		}
		
	}
}
