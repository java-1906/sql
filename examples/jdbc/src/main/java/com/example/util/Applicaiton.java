package com.example.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Applicaiton {
	public static void main(String[] args) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		
		String sql = "SELECT * FROM Champions";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getString("CHAMPION_NAME"));
		}
		
	}
}
