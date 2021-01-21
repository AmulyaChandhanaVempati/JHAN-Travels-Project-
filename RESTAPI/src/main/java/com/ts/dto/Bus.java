package com.ts.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@XmlRootElement
@Entity
public class Bus {
	@Id@GeneratedValue
	private int BusNo;
	private String BusType;
	private String Timings;
	private String BoardingPt;
	private String Destination;
	private int SeatsAvail;
	private String BusCode;
	private double Price;
	
	@OneToMany(mappedBy="bus",fetch = FetchType.LAZY)
	@Fetch(value = FetchMode.JOIN)
	
	
	
	private List<Ticket> ticketlist = new ArrayList<Ticket>();

	public int getBusNo() {
		return BusNo;
	}
	public void setBusNo(int busNo) {
		BusNo = busNo;
	}
	public String getBusType() {
		return BusType;
	}
	public void setBusType(String busType) {
		BusType = busType;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public String getTimings() {
		return Timings;
	}
	public void setTimings(String timings) {
		Timings = timings;
	}
	public String getBoardingPt() {
		return BoardingPt;
	}
	public void setBoardingPt(String boardingPt) {
		BoardingPt = boardingPt;
	}
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String destination) {
		Destination = destination;
	}
	public int getSeatsAvail() {
		return SeatsAvail;
	}
	public void setSeatsAvail(int seatsAvail) {
		SeatsAvail = seatsAvail;
	}

	public String getBusCode() {
		return BusCode;
	}
	public void setBusCode(String busCode) {
		BusCode = busCode;
	}

}