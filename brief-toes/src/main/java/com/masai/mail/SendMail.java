package com.masai.mail;
import java.io.File;
import java.util.Properties;

import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class SendMail {

	
	 public static boolean sendEmail(String to, String from, String subject, String text,File file) {
	        boolean flag = false;

	        //logic
	        
	        
	        //smtp properties
	        Properties properties = new Properties();
	        properties.put("mail.smtp.auth", true);
	        properties.put("mail.smtp.starttls.enable", true);
	        properties.put("mail.smtp.port", "587");
	        properties.put("mail.smtp.host", "smtp.gmail.com");

	        final  String username = "tinygrowindia@gmail.com";
	        final String  password = "qyhqowfdqrxyvvsw";


	        //session
	        
	        Session session=Session.getInstance(properties, new jakarta.mail.Authenticator() {
	        	
	        	@Override
	        	protected PasswordAuthentication getPasswordAuthentication() {
	        		return new PasswordAuthentication(username, password);
	        	}
			});
	        
	       
	        //  code for sending File
	        MimeMultipart mimemulti=new MimeMultipart();
           try {
        	   
   	          MimeBodyPart textmime=new MimeBodyPart();
   	          MimeBodyPart filemime=new MimeBodyPart();
   	        
   	             ///  File file=new File("amit.txt");
   	          
   	            filemime.attachFile(file);
       	        textmime.setText(text);
       	
            	mimemulti.addBodyPart(filemime);
            	mimemulti.addBodyPart(textmime);
				
			} catch (Exception e) {
			     e.printStackTrace();
			}
           
           //  sending file code ended and 

	        try {
	        	
	            Message message = new MimeMessage(session);
	            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
	            message.setFrom(new InternetAddress(from));
	            message.setSubject(subject);
	            message.setText(text);
	            message.setContent(mimemulti);   // push mime obj  
	            
	            Transport.send(message);
	            
	            
	            flag = true;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return flag;
	    }

	}
	


