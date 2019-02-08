package com.example.doa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.models.User;
import com.example.util.ConnectionUtil;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

public class UserOracle implements UserDoa {
	private static UserOracle instance;
	//private static final Logger log = LogManager.getLogger(UserOracle.class);
	
	private UserOracle() {
		// TODO Auto-generated constructor stub
	}
	
	public static UserDoa getDao() {
		if(instance == null) {
			instance = new UserOracle();
		}
		
		return instance;
	}
	
	@Override
	public Optional<User> login(String username, String password) throws Exception {
		Connection con = ConnectionUtil.getConnection();
		
		if (con == null) {
			return Optional.empty();
		}
		
		try {
			String sql = "call attempt_login(?,?,?,?,?)";
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, username);
			cs.setString(2, password);
			cs.registerOutParameter(3, Types.INTEGER);
			cs.registerOutParameter(4, Types.INTEGER);
			cs.registerOutParameter(5, Types.INTEGER);
			cs.execute();
			
			Integer success = cs.getInt(3);
			Integer id = cs.getInt(4);
			Integer admin = cs.getInt(5);
			
			if (success == 0) {
				throw new Exception("Invalid username / password combination");
			}
			
			User user = new User(id, username, "", (admin > 0) ? true : false);
			return Optional.of(user);
		} catch (SQLException e) {
			System.out.println("database problem");
			//log.error("problem with database {}", e);
			return Optional.empty();
		}
	}

	@Override
	public Optional<User> addUser(String username, String password, Boolean isAdmin) {
		Connection con = ConnectionUtil.getConnection();
		
		if (con == null) {
			return Optional.empty();
		}
		
		try {
			String sql = "call addEndUser(?,?,?, ?)";
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, username);
			cs.setString(2, password);
			cs.setInt(3, (isAdmin) ? 1 : 0);
			cs.registerOutParameter(4, Types.INTEGER);
			cs.execute();
			
			Integer id = cs.getInt(4);
			
			User user = new User(id, username, "", isAdmin);
			
			return Optional.of(user);
		} catch (SQLException e) {
			return Optional.empty();
		}
	}

}
