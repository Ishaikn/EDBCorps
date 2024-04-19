package com.tyss.edbank.home;

public class dummy {
public static void main(String[] args) {
	String text="OTP with Ref no.9251 sent to 903XXXX896 please verify to complete your transaction\r\n"
			+ "\r\n"
			+ "*OTP :663424";
	
	String[] Lines=text.split("\\r?\\\n");
	
	String Otp="";
	for(String line:Lines) {
		if(line.startsWith("*OTP :")){
			String[] parts=line.split(":");
			Otp=parts[1].trim();
			break;
		}
	}System.out.println(Otp);
}
}




