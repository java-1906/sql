package com.example.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionUtil {
	private static Connection con;
	//private static Logger log = LogManager.getLogger(ConnectionUtil.class);
	private ConnectionUtil() {
		
	}
	
	public static Connection getConnection() {
		if (con != null) {
			return con;
		}
		InputStream in = null;

		try {
			// load information from properties file
			Properties props = new Properties();
			in = new FileInputStream(
					"C:\\Users\\qiunn\\Documents\\Reveture\\Batches\\1901-big-data\\sql\\examples\\vehicle\\src\\main\\resources\\connection.properties");
			props.load(in);

			// get the connection object
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String endpoint = props.getProperty("jdbc.url");
			String username = props.getProperty("jdbc.username");
			String password = props.getProperty("jdbc.password");

			con = DriverManager.getConnection(endpoint, username, password);
			return con;
		} catch (Exception e) {
			//log.error("Unable to get connection to database");
		} finally {
			try {
				in.close();
			} catch (IOException e) {

			}
		}

		return null;
	}
}
