package com.masai;
import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.masai.mail.SendMail;

@SpringBootApplication
public class BriefToesApplication {

	public static void main(String[] args) {
		 SpringApplication.run(BriefToesApplication.class, args);
		
//		File f=new File("amit.txt");
//		
//		SendMail.sendEmail("ua55359@gmail.com","amitvaghamshi123@gmail.com", "Order sucsess","done" ,f);
	}
}
