package com.yunyuntop.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.yunyuntop.domain.Blogs;
import com.yunyuntop.domain.Greate;
import com.yunyuntop.domain.User;
import com.yunyuntop.util.HibernateUtils;

public class GreateDao {

	public List<Greate> findPage(int currPage,int size){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Criteria criteria = session.createCriteria(Greate.class);
		criteria.addOrder(Order.desc("gtime"));
		criteria.setFirstResult((currPage-1)*size);
		criteria.setMaxResults(size);
		//
		List<Greate> list = criteria.list();
		tr.commit();
		session.close();
		return list;
	}
	public void saveLike(Greate greate) {

		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		session.save(greate);
		tr.commit();
		session.close();

	}

	public Greate findGreate(User user, Blogs blog) {

		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		List<Greate> list = null;
		DetachedCriteria dc = DetachedCriteria.forClass(Greate.class);
		dc.add(Restrictions.eq("user", user));
		dc.add(Restrictions.eq("blog", blog));
		list = dc.getExecutableCriteria(session).list();
		tr.commit();
		session.close();
		if(list.size()>0)
			return list.get(0);
		else
			return null;
	}
	
	public int findSize(Blogs blog){
		
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Criteria dc = session.createCriteria(Greate.class);
		dc.add(Restrictions.eq("blog", blog));
		List<Greate>list = dc.list();
		tr.commit();
		session.close();
		return list.size();
	}
	

	public void delLike(Greate greate) {

		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		//Greate greate = session.get(Greate.class, greate2);
		session.delete(greate);
		tr.commit();
		session.close();
	}
	public Greate findLikeByGid(String gid){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Greate greate = session.get(Greate.class, gid);
		System.out.println(gid);
		tr.commit();
		session.close();
		return greate;
	}

	public int findCount() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		List<Number> l=session.createQuery("select count(gid) from Greate").list();
		tr.commit();
		session.close();
		if(l.size()>0){
			return l.get(0).intValue();
		}else{
			return 0;
		}

	}
	public void delete(String gid) {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Greate great=session.get(Greate.class,gid);
		session.delete(great);
		tr.commit();
		session.close();
	}
}
