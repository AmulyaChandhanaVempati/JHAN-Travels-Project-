package com.ts.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.*;

import com.ts.dto.Seat;
public class EmailDAO {
	public List<String> getseatbyticketno(int ticketno){
		 List <Seat> s;
		 List <String> seatlist = new ArrayList<String>();
		 SeatDAO seatdao = new SeatDAO();
		 s =  seatdao.getseats();
		
		 for(Seat seat:s){
			 
			 if(seat.getTicket().getTicketNo() == ticketno){
				 
				 
				 seatlist.add(seat.getSeatNo());
				 
			 }
		 }
		 
		return seatlist;
		
		
	}
	public void sendEmail(Seat seat){

		System.out.println("In mail sending");
	           String sendMessage = "<b style='font-size:20'>JHAN TRAVELS</b>&nbsp;&nbsp;&nbsp;&nbsp;<h1>eTicket</h1><br>"+"Dear"+seat.getPassenger().getPassName()+"<br><br>Your tickets are attached to this mail.<br><hr>"+
		"<br>You Are Travelling<br><br>From: "+seat.getBus().getBoardingPt()+"<br>To: "+seat.getBus().getDestination()+"<br>On: "+seat.getTicket().getDateOfJourney()
		+"<br><br>Ticket Details:<br> "+"TicketNo: "+seat.getTicket().getTicketNo()+"<br>BusNo: "+seat.getBus().getBusNo()+"<br>SeatNo: "+seat.getSeatNo()+"<br><br><br><hr><br><br>For Any Queries Contact Us Through Our<br>PhoneNo : 5789199087<br>Email : jhan798a@gmail.com";
		       MimeBodyPart mime = new MimeBodyPart();
		       MimeMultipart mime1 = new MimeMultipart();
		       
				try {
					mime.setContent(sendMessage,"text/html");
					mime1.addBodyPart(mime);

				} catch (MessagingException e1) {
					
					e1.printStackTrace();
				}
				
			
		       final String username = "jhan798a@gmail.com";
		       final String password = "@jhan123";
		      
		       Properties prop = new Properties();
		       prop.put("mail.smtp.host", "smtp.gmail.com");
		       prop.put("mail.smtp.port", "587");
		       prop.put("mail.smtp.auth", "true");
		       prop.put("mail.smtp.starttls.enable", "true"); 
		       Session session = Session.getInstance(prop,
		               new javax.mail.Authenticator() {
		                   protected PasswordAuthentication getPasswordAuthentication() {
		                       return new PasswordAuthentication(username, password);
		                   }
		               });

		       try {
     
		    	   MimeMessage message = new MimeMessage(session);
		           message.setContent(mime1);
		           message.setFrom(new InternetAddress("jhan798a@gmail.com"));
		           message.setRecipients(
		                   Message.RecipientType.TO,
		                   InternetAddress.parse(seat.getPassenger().getEmail())
		           );
		           message.setSubject("Ticket Confirmation mail ");
		           message.setText(sendMessage,"UTF-8","html");

		           Transport.send(message);

		           System.out.println("Done");

		       } catch (MessagingException e) {
		           e.printStackTrace();
		       }
		       
		       
		       
		       

		     
		   }

}