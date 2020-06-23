package com.yunyuntop.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yunyuntop.domain.Receive;
import com.yunyuntop.util.HibernateUtils;

public class ReceiveDao {

	
	public Receive findByRid(String rid){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Receive receive10=session.get(Receive.class,rid);
		tr.commit();
		session.close();
		return receive10;
	}
	public void writeReceive(Receive receive){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		session.save(receive);
		tr.commit();
		session.close();
	}
	public void delete(String rid){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Receive r=session.get(Receive.class, rid);
		session.delete(r);
		tr.commit();
		session.close();
	}
}
