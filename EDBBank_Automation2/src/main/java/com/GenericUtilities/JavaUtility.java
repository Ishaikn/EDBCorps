package com.GenericUtilities;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * this method is used to get the Random Numbers in the form of Integer
	 * 
	 * @return
	 */
	public int getRandomNo() {
		Random ran = new Random();
		int random = ran.nextInt();
		return random;
	}

	/**
	 * This method will return the system date in the form of String
	 * 
	 * @return
	 */

	public String getSystemdate() {
		Date dt = new Date();
		String date = dt.toString();
		return date;
	}

	/**
	 * This method will return the system date in customized format
	 * 
	 * @return
	 */

	public String getSystemdateInFormat() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Date dt = new Date();
		String sysdateInformat = dateFormat.format(dt);
		return sysdateInformat;
	}

	/**
	 * This method is used to get the System date and time
	 * 
	 * @return
	 */

	public String getSystemdateandTime() {

		String Timestamp = LocalDateTime.now().toString().replace(':', '-');
		return Timestamp;
	}

}
