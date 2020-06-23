package com.yunyuntop.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.yunyuntop.domain.Context;
import com.yunyuntop.util.HibernateUtils;

public class ContextDao {

	
	
	public void delete(String cid){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Context context = session.get(Context.class, cid);
		session.delete(context);
		tr.commit();
		session.close();
	}
	public  Context findBlogContext(String bid){
		Session session = HibernateUtils.getSession();
		Transaction tr=session.beginTransaction();
		//session.createQuery("select * from Context where bid="+bid).list();
		 Criteria criteria = session.createCriteria(Context.class);	        
	        // 设置查询条件
	      criteria.add(Restrictions.eq("bid", bid));
	      List<Context> list = criteria.list();	      
	      tr.commit();
	      session.close();
	      Context context=null;
	      if(list.size()>0)
	      context=list.get(0) ;
	      return context;
	     

	}
	
	
	
	public String add(Context context){
		Session session = HibernateUtils.getSession();
		Transaction tr  = session.beginTransaction();
		

		session.save(context);
		String cid=context.getCid();
		tr.commit();
		session.close();
		return cid;
	}
	
	public void update(Context context){
		Session session = HibernateUtils.getSession();
		Transaction tr =session.beginTransaction();
		session.saveOrUpdate(context);
		
		tr.commit();
		session.close();
	}
	
	
	
	
}
