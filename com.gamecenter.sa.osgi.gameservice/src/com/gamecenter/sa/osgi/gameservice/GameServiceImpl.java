package com.gamecenter.sa.osgi.gameservice;

import java.util.HashMap;
import java.util.List;

import com.gamecenter.sa.osgi.datastore.DataStore;
import com.gamecenter.sa.osgi.model.Game;

public class GameServiceImpl implements GameService{
	
	private List<Game> itemList = DataStore.gameList;
	private HashMap<Integer, Integer> cart = new HashMap<Integer, Integer>();

	@Override
	public List<Game> displayGame() {
		return DataStore.gameList;
	}
	
	@Override
	public String addToCart(String gameName, int quantity) {
		int count = -1;
		boolean value = false;
		for(Game game : DataStore.gameList) {
			count ++;
			if(game.getGameName().equals(gameName)) {
				cart.put(game.getGameId(), quantity);
				break;
			}
		}
		
		if(value)
			return "Item cannot be found. Please try again!";
		else
			return "Item is added to cart successfully";
	}
	
	@Override
	public HashMap<Integer, Integer> displayCart() {
		return cart;
	}

	@Override
	public int GenerateGameBill(int id, int quantity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double displayBillTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String[][] displayBill() {
		// TODO Auto-generated method stub
		return null;
	}
}
