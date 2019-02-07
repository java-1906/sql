package com.example.services;

import java.util.List;
import java.util.Optional;

import com.example.models.Champion;
import com.revature.dao.ChampionDao;
import com.revature.dao.ChampionOracle;

public class ChampionService {
	
	private static ChampionService championService;
	final static ChampionDao championDao = ChampionOracle.getDao();
	
	private ChampionService() {
		
	}

	public static ChampionService getService() {
		if (championService == null) {
			championService = new ChampionService();
		}
		
		return championService;
	}
	
	
	public Optional<List<Champion>> getChampions() {
		return championDao.getAllChampions();
	}
	
	public Optional<Champion> getChampionByName(String name) {
		return championDao.getChampionByName(name);
	}
}
