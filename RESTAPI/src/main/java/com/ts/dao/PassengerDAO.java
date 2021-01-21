package com.ts.dao;

import java.util.List;

import com.ts.db.HibernateTemplate;
import com.ts.dto.Passenger;

public class PassengerDAO {
	public int register(Passenger passenger) {
		//java.util.Date utilDate = new java.sql.Date(passenger.getJoinDate().getTime()); 
		return HibernateTemplate.addObject(passenger);
	}
	
	public Passenger login(String loginId,String password){
		
		return (Passenger) HibernateTemplate.getObjectByUserPass(loginId,password);
	}
	public List<Passenger> getPassengers() {
		List<Passenger> passengers = (List) HibernateTemplate.getObjectListByQuery("From Passenger");
		return passengers;	
	}
	public int updatePassenger(Passenger passenger){
		return HibernateTemplate.updateObject(passenger);
	}

}
