package com.yunyuntop.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.yunyuntop.domain.Discuss;
import com.yunyuntop.util.HibernateUtils;

public class DiscussDao {

	public void addDiscuss(Discuss discuss) {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		session.save(discuss);

		tr.commit();
		session.close();
	}

	public List<Discuss> findAllByBid(String bid) {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		List<Discuss> list = session.createQuery("from Discuss where bid='" + bid + "' order by dtime desc").list();
		tr.commit();
		session.close();
		return list;
	}
	public List<Discuss> findByDtime(int currPage, int size) {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Criteria criteria = session.createCriteria(Discuss.class);
		criteria.setFirstResult((currPage-1)*size);
		criteria.setMaxResults(size);
		criteria.addOrder(Order.desc("dtime"));
		List<Discuss> list=criteria.list();
		tr.commit();
		session.close();
		return list;
	}
	
	
	public int findSize(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		List<Number> l=session.createQuery("select count(did) from Discuss").list();
		tr.commit();
		session.close();
		if(l.size()>0){
			return l.get(0).intValue();
		}else{
			return 0;
		}
			
	}

	public void delete(String did) {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Discuss d=session.get(Discuss.class, did);
		session.delete(d);
		tr.commit();
		session.close();
		
	}

	public Discuss findByDid(String did) {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Discuss discuss = session.get(Discuss.class, did);
		tr.commit();
		session.close();
		return discuss;
	}
}
