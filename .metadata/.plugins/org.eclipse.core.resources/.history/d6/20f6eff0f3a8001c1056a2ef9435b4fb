package com.gamecenter.sa.osgi.gameservice;

import java.util.HashMap;
import java.util.List;

import com.gamecenter.sa.osgi.datastore.DataStore;
import com.gamecenter.sa.osgi.model.Game;

public class GameServiceImpl implements GameService{
	
	private List<Game> itemList = DataStore.gameList;

	@Override
	public List<Game> displayGame() {
		if(DataStore.gameList.isEmpty())
			return null;
		else
			return DataStore.gameList;
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
