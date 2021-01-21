package com.ts.dao;

import java.util.List;

import com.ts.db.HibernateTemplate;
import com.ts.dto.Baggage;
import com.ts.dto.Ticket;

public class BaggageDAO {
	public int addbaggage(Baggage baggage){
		return  HibernateTemplate.addObject(baggage);
		
	}
	public  List<Baggage> getBaggageList(){
	     List<Baggage> baggagelist = (List) HibernateTemplate.getObjectListByQuery("From Baggage");
	     return baggagelist;
	}
	public int deleteBaggage(int baggageid){
	 	   return HibernateTemplate.deleteObject(Baggage.class, baggageid);
	    }
	public Baggage getBaggageById(int baggageid){
		return (Baggage)HibernateTemplate.getObjectByBaggageId(baggageid);

	}
}