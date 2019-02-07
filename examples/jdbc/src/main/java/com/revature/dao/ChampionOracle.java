package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.models.Champion;
import com.example.util.ConnectionUtil;

public class ChampionOracle implements ChampionDao {
	
	private static ChampionOracle championOracle;
	private static final Logger log = LogManager.getLogger(ChampionOracle.class);
	
	
	private ChampionOracle() {
		
	}
	
	public static ChampionDao getDao() {
		if (championOracle == null) {
			championOracle = new ChampionOracle();
		}
		
		return championOracle;
	}

	public Optional<List<Champion>> getAllChampions() {
		log.traceEntry();
		
		Connection con = ConnectionUtil.getConnection();

		if (con == null) {
			log.traceExit(Optional.empty());
			return Optional.empty();
		}

		try {
			String sql = "select * from champions";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			List<Champion> listOfChampions = new ArrayList<Champion>();

			while (rs.next()) {
				listOfChampions.add(new Champion(rs.getInt("champion_id"), rs.getString("champion_name"),
						rs.getString("a1"), rs.getString("a2"), rs.getString("a3"), rs.getString("a4"),
						rs.getString("passive"), rs.getFloat("health")));
			}
			
			return log.traceExit(Optional.of(listOfChampions));
		} catch (SQLException e) {
			log.catching(e);
			log.error("Sql Exception ovcured", e);
		}

		log.traceExit(Optional.empty());
		return Optional.empty();
	}

	public Optional<Champion> getChampionByName(String name) {
		log.traceEntry("name = {}", name);
		
		Connection con = ConnectionUtil.getConnection();

		if (con == null) {
			log.traceExit(Optional.empty());
			return Optional.empty();
		}

		try {
			String sql = "select * from champions where champion_name = ? and power_level = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			Champion champion = null;

			while (rs.next()) {
				champion = new Champion(rs.getInt("champion_id"), rs.getString("champion_name"),
						rs.getString("a1"), rs.getString("a2"), rs.getString("a3"), rs.getString("a4"),
						rs.getString("passive"), rs.getFloat("health"));
			}
			
			if (champion == null) {
				log.traceExit(Optional.empty());
				return Optional.empty();
			}

			return log.traceExit(Optional.of(champion));
		} catch (SQLException e) {
			log.catching(e);
			log.error("Sql Exception ovcured", e);
		}

		log.traceExit(Optional.empty());
		return Optional.empty();
	}

	public Optional<Champion> getChampionById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
