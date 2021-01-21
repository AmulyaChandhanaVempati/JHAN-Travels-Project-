package com.ts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ts.dao.ApproveDAO;
import com.ts.dao.BaggageDAO;
import com.ts.dao.BusDAO;
import com.ts.dao.CancelDao;
import com.ts.dao.DisapproveDAO;
import com.ts.dao.EmailDAO;
import com.ts.dao.PassengerDAO;
import com.ts.dao.RecieverDAO;
import com.ts.dao.SeatDAO;
import com.ts.dao.TicketDAO;
import com.ts.dto.Baggage;
import com.ts.dto.Bus;
import com.ts.dto.BusSearch;
import com.ts.dto.Login;
import com.ts.dto.Passenger;
import com.ts.dto.Seat;
import com.ts.dto.Ticket;


@Path("myresource")
public class MyResource {
	@Path("regPass")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void regPass(Passenger pass) {
    	
    	
		/*Passenger pass = new Passenger();
    	pass.setPassId(100);
    	pass.setPassName("nikhitha");
    	pass.setGender("female");
    	pass.setAge(20);
    	pass.setEmail("dummy@gmail.com");
    	pass.setMobileNo("9121424704");
    	pass.setAddress("Hyderabad");
    	pass.setLoginId("nikki123");
    	pass.setPassword("password"); 
    	PassengerDAO passDao = new PassengerDAO();
    	passDao.register(pass);
    	System.out.println("success"); */
		
    	
    	
   	    System.out.println("Data Recieved in Register:" + pass.getPassId());
    	PassengerDAO passDao = new PassengerDAO();
    	passDao.register(pass);
   	    
    	
   
}
	
	@Path("loginpass")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Passenger daoTest1(Login logIn){
		
		Passenger pass=new Passenger();
		PassengerDAO passDao = new PassengerDAO();
		pass = passDao.login(logIn.getLoginId(),logIn.getPassword());
		
		
			return pass;
	}
	


    @Path("getAllPassengers")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List <Passenger> getAllPassengers(){
		List <Passenger> passlist = new ArrayList<Passenger>();
		PassengerDAO passDao = new PassengerDAO();
		passlist = passDao.getPassengers();
		return passlist;
	} 
	@Path("updatePassenger")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePass(){
	    Passenger passenger = new Passenger();
		
		passenger.setPassId(1);
		passenger.setPassName("V.Nikhitha");
		passenger.setGender("female");
		passenger.setAge(20);
		passenger.setEmail("nikki@gmail.com");
		passenger.setMobileNo("9121424704");
		passenger.setAddress("Hyderabad");
		passenger.setLoginId("nikki1234");
		passenger.setPassword("password");
		
		PassengerDAO passDao = new PassengerDAO();
		passDao.updatePassenger(passenger);
		return "successfully updated";
		
	}
	
	@Path("addBus")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
	public void addBus(Bus bus){
		
		System.out.println("Data Recieved in Register:" + bus.getBusNo());
		BusDAO busDao = new BusDAO();
		busDao.addbus(bus);
		

	}
	
	 @Path("getAllBuses")
     @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 public List <Bus> getAllBuses(){
			List <Bus> buslist = new ArrayList<Bus>();
			BusDAO busDao = new BusDAO();
			buslist = busDao.getBuses();
			return buslist;
		} 

	 @Path("updateBus")
	 @PUT
	 @Consumes(MediaType.APPLICATION_JSON)
	 public String updateBus(Bus bus){
			
			
			BusDAO busDao = new BusDAO();
			busDao. updateBus(bus);
			return "updated successfully";

		}
	 
	   @Path("ReserveTicket")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public String ReserveTicket(Ticket ticket) {
	        System.out.println("datarecieved"+ticket.getTicketNo());
	       
	        TicketDAO ticketDao = new TicketDAO();
	        ticketDao.reserveTicket(ticket);
	        
	        
			return "Success";
		}
	    @Path("CancelTicket/{ticketno}")
		@DELETE
		@Produces(MediaType.TEXT_PLAIN)
		public String CancelTicket(@PathParam("ticketno") int ticketno){
	    	Ticket ticket = new Ticket();
	    	/* SeatDAO seatdao = new SeatDAO();
	    	System.out.println(ticketno);
	    	seatdao.cancelSeat(ticketno);
	    	System.out.println("in seat success"); */

			TicketDAO ticketDao = new TicketDAO();
	    	ticket = ticketDao.getTicket(ticketno);
	    	System.out.println(ticket.getTicketNo());
			CancelDao canceldao = new CancelDao();
			canceldao.sendEmail(ticket);
			
			ticketDao.cancelTicket(ticketno);
			
			
			return "Ticket Cancelled";
		}

	 @Path("getBuses/{sd}")
     @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 public Set <Bus> getBuses(@PathParam("sd") String sd){
		 System.out.println("data recieved:" + sd);
		 List <Bus> buslist = new ArrayList<Bus>();
		 
		 BusDAO busDao = new BusDAO();
		 
		 buslist =  busDao.getBusListBySD("BusCode", sd);
		 Set <Bus> busset = new HashSet<Bus>(buslist);
		 
		 System.out.println(busset);
		 return busset;
		 
	 }
	 
	  @Path("getTickets/{pid}")
	  @GET
	  @Produces(MediaType.APPLICATION_JSON)
		 public List<Ticket> getTickets(@PathParam("pid") int pid){
			 System.out.println("data recieved:" + pid);
			 List <Ticket> tickets;
			 List <Ticket> ticketlist = new ArrayList<Ticket>();
			 TicketDAO ticketDao = new TicketDAO();
			 tickets =  ticketDao.getTickets();
			
			 for(Ticket ticket:tickets){
				 if(ticket.getPassenger().getPassId() == pid){
					 ticketlist.add(ticket);
				 }
			 }
			 System.out.println(ticketlist);
			return ticketlist;
			
		 }
	 
	    @Path("reserveseat")
	    @POST
	    @Consumes(MediaType.APPLICATION_JSON)
	         public String setseats(Seat s){
	    	       System.out.println("data recieved:"+s.getSeatNo());
	    	       SeatDAO seatdao = new SeatDAO();
	    	       seatdao.reserveseat(s);
	    	       EmailDAO emaildao = new EmailDAO();
	    	       emaildao.sendEmail(s);
	    	return "success";
	    }
	      @Path("confirmedseats/{busno}")
		  @GET
		  @Produces(MediaType.APPLICATION_JSON)
			 public List<String> getseats(@PathParam("busno") int busno){
				 System.out.println("data recieved:" + busno);
				 List <Seat> s;
				 List <String> seatlist = new ArrayList<String>();
				 SeatDAO seatdao = new SeatDAO();
				 s =  seatdao.getseats();
				
				 for(Seat seat:s){
					 
					 if(seat.getBus().getBusNo() == busno){
						 System.out.println(seat);
						 
						 seatlist.add(seat.getSeatNo());
					 }
				 }
				 
				return seatlist;
				
			 }
	      @Path("getSeats/{pid}")
		  @GET
		  @Produces(MediaType.APPLICATION_JSON)
			 public List<Seat> getSeats(@PathParam("pid") int pid){
				 System.out.println("data recieved:" + pid);
				 List <Seat> seats;
				 List <Seat> seatlist = new ArrayList<Seat>();
				 SeatDAO seatdao = new SeatDAO();
				 seats =  seatdao.getSeats();
				
				 for(Seat seat:seats){
					 if(seat.getPassenger().getPassId() == pid){
						 seatlist.add(seat);
					 }
				 }
				 System.out.println(seatlist);
				return seatlist;
				
			 }
	      
	      @Path("addBaggage")
	      @POST
	      @Consumes(MediaType.APPLICATION_JSON)
	      public String addbaggage(Baggage baggage){
	    	  System.out.println("recieved: "+ baggage.getDestination());
	    	  BaggageDAO baggagedao = new BaggageDAO();
	    	  baggagedao.addbaggage(baggage);
	    	  return "added successfully";
	      }
	      
	
	      @Path("getBaggageList")
	      @GET
	 	  @Produces(MediaType.APPLICATION_JSON)
	      public List<Baggage> getbaggagelist(){
	    	  List<Baggage> baggagelist = new ArrayList<Baggage>();
	    	  BaggageDAO baggagedao = new BaggageDAO();
	    	  baggagelist =  baggagedao.getBaggageList();
	    	  return baggagelist;
	      }
	      
	      @Path("approvebaggage")
	      @POST
	      @Consumes(MediaType.APPLICATION_JSON)
	      public void approve(Baggage baggage){
	    	  System.out.println("recieved baggageid:"+baggage.getBaggageId());
	    	  ApproveDAO approvedao = new ApproveDAO();
	    	  approvedao.sendEmail(baggage);
	    	  RecieverDAO recieverdao = new RecieverDAO();
	    	  
	    	  recieverdao.sendEmail(baggage);
	    	  
	      }
	      
	      @Path("deletebaggage/{baggageid}")
	      @DELETE
	      @Produces(MediaType.TEXT_PLAIN)
	      public void disapprove(@PathParam("baggageid") int baggageid){
	    	  BaggageDAO baggagedao = new BaggageDAO();
	    	  Baggage baggage = new Baggage();
	    	  baggage = baggagedao.getBaggageById(baggageid);
	    	  DisapproveDAO disapprove = new DisapproveDAO();
	    	  disapprove.sendEmail(baggage);
	    	  baggagedao.deleteBaggage(baggageid);
	    	  
	    	  
	      }
	      
	  
}
