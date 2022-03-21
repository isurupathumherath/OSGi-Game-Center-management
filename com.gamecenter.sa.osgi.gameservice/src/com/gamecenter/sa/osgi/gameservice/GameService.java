package com.gamecenter.sa.osgi.gameservice;

import java.util.HashMap;
import java.util.List;

import com.gamecenter.sa.osgi.model.Game;

public interface GameService {
	public List<Game> displayGame();
	public String addToCart(String gameName, int quantity);
	public int GenerateGameBill(int id, int quantity);
	public double displayBillTotal();
	public String[][] displayBill();
	public HashMap<Integer, Integer> displayCart();

}
