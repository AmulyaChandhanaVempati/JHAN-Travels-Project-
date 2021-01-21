package com.ts.db;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ts.dto.Baggage;
import com.ts.dto.Bus;
import com.ts.dto.Passenger;
import com.ts.dto.Ticket;



public class HibernateTemplate {

	private static SessionFactory sessionFactory;
	
	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	public static int addObject(Object obj){
		System.out.println("Inside Template...");
		int result=0;
		
		Transaction tx=null;
		
		try {
			
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.save(obj);
			
			tx.commit();
			
			result=1;
			
		} catch (Exception e) {
		
			tx.rollback();
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static Object getObject(Class c,Serializable serializable)
	{
		Object obj=null;
		
		try {			
			return sessionFactory.openSession().get(c,serializable);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return obj;
	} 
	
	public static Object getObjectByUserPass(String loginId,String password) {
	
	String queryString = "from Passenger where LoginId = :loginId and Password =:password";
	  Query query = sessionFactory.openSession().createQuery(queryString);
	  query.setString("loginId", loginId);
	  query.setString("password", password);
	  Object queryResult = query.uniqueResult();
	  Passenger passenger = (Passenger)queryResult;
	  return passenger; 
	}
	
public static Object getObjectById(int BusNo) {
		
		String queryString = "from Bus where BusNo = :BusNo";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setInteger("BusNo", BusNo);
		  Object queryResult = query.uniqueResult();
		  Bus bus = (Bus)queryResult;
		  return bus; 
		}
public static Object getObjectByNo(int TicketNo) {
	
	String queryString = "from Ticket where TicketNo = :TicketNo";
	  Query query = sessionFactory.openSession().createQuery(queryString);
	  query.setInteger("TicketNo", TicketNo);
	  Object queryResult = query.uniqueResult();
	  Ticket ticket = (Ticket)queryResult;
	  return ticket; 
	}
	
public static Object getObjectByBaggageId(int BaggageId) {
	
	String queryString = "from Baggage where BaggageId = :BaggageId";
	  Query query = sessionFactory.openSession().createQuery(queryString);
	  query.setInteger("BaggageId", BaggageId);
	  Object queryResult = query.uniqueResult();
	  Baggage baggage = (Baggage)queryResult;
	  return baggage; 
	}

	
	public static List<Object> getObjectListByQuery(String query)
	{
		return sessionFactory.openSession().createQuery(query).list();
	}
	
	public static int updateObject(Object obj)
	{
		int result=0;
		
		Transaction tx=null;
		
		try {
			
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.saveOrUpdate(obj);
			
			tx.commit();
			
			result=1;
			
		} catch (Exception e) {
		
			tx.rollback();
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static int deleteObject(Class c,Serializable serializable)
	{
		int result=0;
		
		Session session=sessionFactory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			
			Object obj=session.get(c,serializable);
			
			session.delete(obj);
			
			tx.commit();
			
			result=1;
						
		} catch (Exception e) {
			
			e.printStackTrace();
			
			tx.rollback();
		}
		
		return result;
	}

	public static List<Object> getObjectListByName(Class c, String columName, String value) {
		Session session=sessionFactory.openSession();
		  Criteria criteria = session.createCriteria(c);
			Criterion nameCriterion = Restrictions.eq(columName, value);
			criteria.add(nameCriterion);
			return criteria.list();
	} 
	
	
}
