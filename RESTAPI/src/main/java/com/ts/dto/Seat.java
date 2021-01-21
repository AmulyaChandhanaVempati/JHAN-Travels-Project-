package com.ts.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.ws.rs.DELETE;


@XmlRootElement
@Entity
public class Seat {
    @Id@GeneratedValue
    private int Sno;
   
    private String SeatNo;
       
    public Seat() {
		
	}

	
	public Seat(int sno, String seatNo, Bus bus, Passenger passenger, Ticket ticket) {
		super();
		Sno = sno;
		SeatNo = seatNo;
		this.bus = bus;
		this.passenger = passenger;
		this.ticket = ticket;
	}







	@ManyToOne
   	@JoinColumn(name="BusNo")
   	private Bus bus;
    
    @ManyToOne
	@JoinColumn(name="PassId")
	private Passenger passenger;
    
    @ManyToOne
   	@JoinColumn(name="TicketNo",referencedColumnName="TicketNo",insertable=true, updatable=false)
   	private Ticket ticket;

	public String getSeatNo() {
		return SeatNo;
	}

	public void setSeatNo(String seatNo) {
		SeatNo = seatNo;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}


	public int getSno() {
		return Sno;
	}


	public void setSno(int sno) {
		Sno = sno;
	}
    
    
       
}
