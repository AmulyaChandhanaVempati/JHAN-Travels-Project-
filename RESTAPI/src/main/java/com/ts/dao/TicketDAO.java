package com.ts.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.ts.db.HibernateTemplate;
import com.ts.dto.Ticket;

public class TicketDAO {
	public int reserveTicket(Ticket ticket){
 	   return HibernateTemplate.addObject(ticket);
 	   
    }
	public int cancelTicket(int TicketNo){
 	   return HibernateTemplate.deleteObject(Ticket.class, TicketNo);
    }
	
public List<Ticket> getTickets(){
		
	List<Ticket> ticketlist = (List)HibernateTemplate.getObjectListByQuery("from Ticket");	
	
	return ticketlist;
		
   
}

public Ticket getTicket(int ticketno){
	return (Ticket)HibernateTemplate.getObjectByNo(ticketno);

}
}
