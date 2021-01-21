package com.ts.dto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Baggage {
	@Id@GeneratedValue
	private int BaggageId;
	private String Source;
	private String Destination;
	private String TypeOfGoods;
	private String RecieverMailId;
	private String SenderMailId;
	private String RecieverMobileNo;
	private String Date;
	private int Quantity;
	
	
	@ManyToOne
   	@JoinColumn(name="PassId")
	private Passenger passenger = new Passenger();
	
	public Baggage() {
		
	}
	


	public Baggage(int baggageId, String source, String destination, String typeOfGoods, String recieverMailId,
			String senderMailId, String recieverMobileNo, String date, int quantity, Passenger passenger) {
		super();
		BaggageId = baggageId;
		Source = source;
		Destination = destination;
		TypeOfGoods = typeOfGoods;
		RecieverMailId = recieverMailId;
		SenderMailId = senderMailId;
		RecieverMobileNo = recieverMobileNo;
		Date = date;
		Quantity = quantity;
		this.passenger = passenger;
	}



	public int getBaggageId() {
		return BaggageId;
	}



	public void setBaggageId(int baggageId) {
		BaggageId = baggageId;
	}



	public String getSource() {
		return Source;
	}



	public void setSource(String source) {
		Source = source;
	}



	public String getDestination() {
		return Destination;
	}



	public void setDestination(String destination) {
		Destination = destination;
	}



	public String getTypeOfGoods() {
		return TypeOfGoods;
	}



	public void setTypeOfGoods(String typeOfGoods) {
		TypeOfGoods = typeOfGoods;
	}



	public String getRecieverMailId() {
		return RecieverMailId;
	}



	public void setRecieverMailId(String recieverMailId) {
		RecieverMailId = recieverMailId;
	}



	public String getSenderMailId() {
		return SenderMailId;
	}



	public void setSenderMailId(String senderMailId) {
		SenderMailId = senderMailId;
	}



	public String getRecieverMobileNo() {
		return RecieverMobileNo;
	}



	public void setRecieverMobileNo(String recieverMobileNo) {
		RecieverMobileNo = recieverMobileNo;
	}



	public String getDate() {
		return Date;
	}



	public void setDate(String date) {
		Date = date;
	}



	public int getQuantity() {
		return Quantity;
	}



	public void setQuantity(int quantity) {
		Quantity = quantity;
	}



	public Passenger getPassenger() {
		return passenger;
	}



	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}



	
	
}