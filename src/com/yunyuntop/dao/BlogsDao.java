package com.yunyuntop.dao;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.yunyuntop.domain.Blogs;
import com.yunyuntop.util.HibernateUtils;

public class BlogsDao {

	public List<Blogs> findNewBlogs() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Criteria criteria = session.createCriteria(Blogs.class);
		criteria.addOrder(Order.desc("btime"));
		criteria.setFirstResult(0);
		criteria.setMaxResults(6);
		List<Blogs> list = criteria.list();
		list.get(1).setBimg("/img/4.jpg");

		tr.commit();
		session.close();
		return list;
	}

	public List<Blogs> findPageBlogs(Integer currPage, Integer size) {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Criteria criteria = session.createCriteria(Blogs.class);
		criteria.addOrder(Order.desc("btime"));
		criteria.setFirstResult((currPage - 1) * size);
		criteria.setMaxResults(size);
		List<Blogs> list = criteria.list();

		tr.commit();
		session.close();
		return list;
	}

	public List<Blogs> findByKtext(String ktext) {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		List<String> list1 = session
				.createSQLQuery(
						"SELECT bk.bid FROM kinds k,blogs_kinds bk WHERE k.kid=bk.kid AND k.ktext='" + ktext + "' ")
				.list();
		String str = "";
		for (int i = 0; i < list1.size(); i++) {
			str = str + "'" + list1.get(i) + "'" + ((i != list1.size() - 1) ? "," : "");
		}
		List<Blogs> list = session.createQuery("from Blogs where bid in(" + str + ")").list();
		tr.commit();
		session.close();
		return list;
	}

	public List<Blogs> findAll() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		List<Blogs> list = session.createQuery("from Blogs ").list();
		tr.commit();
		session.close();
		return list;
	}

	public List<Blogs> findLikeContext(String context1) {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		List<Blogs> list = null;
		if (context1 != null && context1.trim().length() > 0) {
			String context = context1.trim();

			Criteria dc = session.createCriteria(Blogs.class);
			dc.addOrder(Order.desc("btime"));
			dc.add(Restrictions.or(Restrictions.like("btitle", "%"+context+"%").ignoreCase(),
					Restrictions.like("bheader", "%"+context+"%").ignoreCase()));

			list = dc.list();
		}
		tr.commit();
		session.close();
		return list;
	}

	public Blogs findByBid(String bid) {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Blogs blog = session.get(Blogs.class, bid);
		tr.commit();
		session.close();
		return blog;
	}

	public  String writeBlog(Blogs blog) {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		session.save(blog);
		String bid=blog.getBid();
		tr.commit();
		session.close();
		return bid;

	}

	public void deleteBlog(String bid) {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Blogs blog = session.get(Blogs.class, bid);
		session.delete(blog);
		tr.commit();
		session.close();

	}

	public void EditBlog(Blogs blog) {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		session.update(blog);
		tr.commit();
		session.close();
	}

	public List<Blogs> findFeatureBlogs() {
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		List<Blogs> blogs=null;
		Criteria criteria = session.createCriteria(Blogs.class);
		criteria.addOrder(Order.desc("greatecount"));
		blogs=criteria.list();
		tr.commit();
		session.close();
		return blogs;	
		}
	
	public void updateTotallook(String bid){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Blogs blog = session.get(Blogs.class, bid);
		blog.setTotallook(blog.getTotallook()+1);
		session.update(blog);
	    tr.commit();
	    session.close();
	}
}
