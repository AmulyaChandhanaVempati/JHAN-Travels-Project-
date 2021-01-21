package com.ts.dao;

import java.util.List;

import com.ts.db.HibernateTemplate;
import com.ts.dto.Bus;
import com.ts.dto.Passenger;

public class BusDAO {
	public int addbus(Bus bus){
		return  HibernateTemplate.addObject(bus);
		
	}
    
	public  List<Bus> getBuses(){
	     List<Bus> buslist = (List) HibernateTemplate.getObjectListByQuery("From Bus");
	     return buslist;
	}
	
	public int updateBus(Bus bus){
		return HibernateTemplate.updateObject(bus);
	}
	
	public Bus getBusById(int BusNo){
		return (Bus)HibernateTemplate.getObjectById(BusNo);
	}
	
	public List<Bus> getBusListBySD(String columnname,String value){
		List<Bus> buslist= (List) HibernateTemplate.getObjectListByName(Bus.class, columnname,  value);
		return buslist;
	}
	

}
