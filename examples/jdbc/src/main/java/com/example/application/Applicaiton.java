package com.example.application;
import java.util.List;
import java.util.NoSuchElementException;

import com.example.models.Champion;
import com.example.services.ChampionService;

public class Applicaiton {
	public static void main(String[] args) {
		ChampionService championService = ChampionService.getService();
		Champion listOfChampions = null;
		
		try {			
			listOfChampions = championService.getChampionByName("Vi").get();

			System.out.println(listOfChampions);
//			for(Champion c:listOfChampions) {
//				System.out.println(c.getChampionName());
//			}
		} catch (NoSuchElementException e) {
			System.out.println("Unable to fetch the champions. Sorry ^_^");
		}
		
	}
}
