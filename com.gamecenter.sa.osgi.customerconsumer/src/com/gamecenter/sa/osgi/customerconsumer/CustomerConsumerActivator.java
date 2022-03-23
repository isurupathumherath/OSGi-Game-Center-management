package com.gamecenter.sa.osgi.customerconsumer;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.gamecenter.sa.osgi.datastore.DataStore;
import com.gamecenter.sa.osgi.gameservice.GameService;
import com.gamecenter.sa.osgi.model.Game;

public class CustomerConsumerActivator implements BundleActivator {

	ServiceReference gameCustomerServiceReference;
	Scanner scanner = new Scanner(System.in);
	Scanner optionScanner = new Scanner(System.in);
	boolean exit = false;

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("============Customer consumer started.============");
		gameCustomerServiceReference = bundleContext.getServiceReference(GameService.class.getName());
		GameService gameService = (GameService)bundleContext.getService(gameCustomerServiceReference);
		
		do {
			int option = -1, quantity;
			String gameName;
			
			optionScanner.nextLine();
			
			System.out.println("\n...Options to be Selected...");
			System.out.println("1.Game List");
			System.out.println("2.Add Game to Cart");
			System.out.println("3.Display Cart");
			System.out.println("0.Exit");
			
			System.out.print("\nPlease Select: ");
			option = scanner.nextInt();
			
			if(option == 0)
				exit = true;
			else if(option == 1) {
				List<Game> gameList =gameService.displayGame();
				System.out.println("-----------------------------------Game List--------------------------------------------");
				System.out.println("Game ID|"+"\t" + "Game Name|" + "\t" + "Game Provider|" + "\t" + "Game Year|" + "\t" + "Game Price|" + "\t");
				for(Game game : gameList)  
					  System.out.println(game.getGameId()+"\t\t"+game.getGameName()+"\t\t"+game.getGameProvider()+"\t\t"+game.getGameYear()+"\t\t"+game.getGamePrice()+"\t\t");  
				System.out.println("-----------------------------------------------------------------------------------------");
			}
			else if(option == 2) {
				System.out.print("Game Name: ");
				gameName = optionScanner.nextLine();
				
				System.out.print("Quantity: ");
				quantity = optionScanner.nextInt();
				
				System.out.println(gameService.addToCart(gameName, quantity));
			}
			else if(option == 3) {
				HashMap<Integer, Integer> cartMap = gameService.displayCart();
				List<Game> gameList =gameService.displayGame();
				
				System.out.println("-----------------------------------Game List--------------------------------------------");
				System.out.println("Game ID|"+"\t" + "Game Name|" + "\t" + "Quantity|" + "\t");
				for (Integer i : cartMap.keySet()) {
					for(Game game : gameList) {
						if(game.getGameId() == i) {
							System.out.println(i + "\t\t" + game.getGameName() + "\t\t" + cartMap.get(i) +"\t\t");
							break;
						}
					}
				}
				System.out.println("-----------------------------------------------------------------------------------------");
			}
		}
		while(!exit);
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("============Customer consumer stopped.============");
		bundleContext.ungetService(gameCustomerServiceReference);
	}

}
