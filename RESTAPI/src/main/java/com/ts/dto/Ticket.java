package com.ts.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
@XmlRootElement
@Entity
public class Ticket {
	@Id@GeneratedValue
	private int TicketNo;
	private String DateOfJourney;
	private double TotalFare;
	private int NoOfSeats;
	
	
	@OneToMany(mappedBy="ticket",fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@Fetch(value = FetchMode.JOIN)
	private Set<Seat> seats;
	
	@OneToOne
	@JoinColumn(name="PassId")
	 private Passenger passenger;
	
		@ManyToOne
		@JoinColumn(name="BusNo")
		private Bus bus;

		public Ticket() {
			super();
			
		}
		
		
		public int getTicketNo() {
			return TicketNo;
		}
		public void setTicketNo(int ticketNo) {
			TicketNo = ticketNo;
		}
		public String getDateOfJourney() {
			return DateOfJourney;
		}
		public void setDateOfJourney(String dateOfJourney) {
			DateOfJourney = dateOfJourney;
		}
		public double getTotalFare() {
			return TotalFare;
		}
		public void setTotalFare(double totalFare) {
			TotalFare = totalFare;
		}
		
		public int getNoOfSeats() {
			return NoOfSeats;
		}
		public void setNoOfSeats(int noOfSeats) {
			NoOfSeats = noOfSeats;
		}
		public Passenger getPassenger() {
			return passenger;
		}
		public void setPassenger(Passenger passenger) {
			this.passenger = passenger;
		}
		public Bus getBus() {
			return bus;
		}
		public void setBus(Bus bus) {
			this.bus = bus;
		}


		


		
	    
	}