package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	/**
	 * @author ishaik
	 * @param key
	 * @return
	 * @throws IOException
	 */

	public String readdatafromproperyfile(String key) throws IOException {

		FileInputStream fis = new FileInputStream(IpathConstant.Filepath);
		Properties pob = new Properties();
		pob.load(fis);
		String value = pob.getProperty(key);
		return value;
	}
	
	public void setdataintoproperyfile(String key, String Value) throws IOException {
		FileInputStream fis = new FileInputStream(IpathConstant.Filepath);
		Properties pob1 = new Properties();
		pob1.load(fis);
		pob1.setProperty(key, Value);
		FileOutputStream fout = new FileOutputStream(IpathConstant.Filepath);
		pob1.store(fout, "data");
	}
}
