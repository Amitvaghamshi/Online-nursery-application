package com.masai.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Regx {

	   public static void main(String[] args) {
		   
		   Pattern p=Pattern.compile("");
		   
		   Matcher m=p.matcher("Amit@123");
		   
		   System.out.println(m.matches());
		   
		   
		   Address add=new Address();
	}
}
