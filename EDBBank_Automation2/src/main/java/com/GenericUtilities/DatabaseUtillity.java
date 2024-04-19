package com.GenericUtilities;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtillity {

	/**
	 * This method is used to register the driver
	 */
	Connection connect = null;

//Register Driver
	public void registerDriver() throws SQLException {

		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
	}
	public void connectoDB() throws SQLException {
		// Create connection
		connect = DriverManager.getConnection(IpathConstant.DBurl, IpathConstant.Dusername, IpathConstant.Dpassword);
	}

	/**
	 * This Method is used to Execute the Query
	 * 
	 * @param Query
	 * @param colIndex
	 * @param expdata
	 * @throws SQLException
	 */

	public void executeAndGetdata(String Query, int colIndex, String expdata) throws SQLException {

		Statement state = connect.createStatement();
		ResultSet result = state.executeQuery(Query);

		boolean flag = false;
		while (result.next()) {
			String actual = result.getString(colIndex);
			if (actual.contains(expdata)) {

				flag = true;
				break;
			}
		}
		if (flag == true) {
			System.out.println("Data is present");
		} else {
			System.out.println("Data is not Present in the Table");
		}

	}

	/**
	 * This Method is used to close the connection with Database
	 * 
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException {
		connect.close();
	}

}
