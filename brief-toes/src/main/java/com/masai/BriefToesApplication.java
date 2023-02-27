package com.masai;
import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.masai.mail.SendMail;

@SpringBootApplication
public class BriefToesApplication {

	public static void main(String[] args) {
		 SpringApplication.run(BriefToesApplication.class, args);
		
	}
}
