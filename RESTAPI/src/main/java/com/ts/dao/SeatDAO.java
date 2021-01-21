package com.ts.dao;

import java.util.List;

import com.ts.db.HibernateTemplate;

import com.ts.dto.Seat;
import com.ts.dto.Ticket;

public class SeatDAO {
	public int reserveseat(Seat seat) {
		//java.util.Date utilDate = new java.sql.Date(passenger.getJoinDate().getTime()); 
		return HibernateTemplate.addObject(seat);
	}
	public List<Seat> getseats(){
		
		List<Seat> seatlist = (List)HibernateTemplate.getObjectListByQuery("from Seat");	
		
		return seatlist;
			
	   
	}
	public int cancelSeat(int TicketNo){
	 	   return HibernateTemplate.deleteObject(Seat.class, TicketNo);
	    }
	public List<Seat> getSeats(){
		
		List<Seat> seatlist = (List)HibernateTemplate.getObjectListByQuery("from Seat");	
		
		return seatlist;
			
	   
	}
		
}
