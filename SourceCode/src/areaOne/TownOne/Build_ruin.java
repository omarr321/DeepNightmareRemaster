package areaOne.TownOne;

import java.util.Scanner;
import tools.Tools;
import tools.Player;

public class Build_ruin {
	public static void start(Player player, Scanner input) {
		String action;
		while(true) {
			System.out.println();
			
			Tools.slowText("As you look at the ruin, you feel odd but you can't pin it.");
			Tools.slowText("It looks like it was burned in a fire. Ash cover the walls");
			Tools.slowText("and floor. There is only one room still standing but is");
			Tools.slowTextN("still mostly ruin. You see some debris");
			if (player.getIsDone(4) == true) {
				Tools.slowText(" on the ground.");
			} else {
				Tools.slowText(" and something laying");
				Tools.slowText("on the ground.");
			}
			
			System.out.println();
			
			Tools.slowText("What do you want to do?");
			Tools.slowText("1: Look on the ground");
			Tools.slowText("2: Search debris");
			Tools.slowText("3: Leave");
			Tools.slowText("4: Check inventory");
			
			System.out.println();
			Tools.slowTextN(">");
			action = input.nextLine();
			action = action.toLowerCase();
			
			Tools.clearScreen();
			switch(action) {
			case "1":
				if (player.getIsDone(4) == false) {
				Tools.slowText("As you take a closer look, you see some coins.");
				Tools.slowText("You pick up the coins.");
				Tools.slowText("+5 coins added to inventory");
				player.addCoin(5);
				Tools.sleep(1);
				player.setIsDone(true, 4);
				} else {
					Tools.slowText("You see nothing else on the ground.");
				}
				break;
			case "2":
				if (player.getIsDone(5) == false) {
					boolean goodAction = false;
					while (goodAction == false) {

						Tools.slowText("As you searched the debris, you find a sword.");
						System.out.println();
						Tools.slowText("What do you want to do?");
						Tools.slowText("1: Pick up the sword");
						Tools.slowText("2: Leave the sword");
						System.out.println();
						Tools.slowTextN(">");

						action = input.nextLine();
						action = action.toLowerCase();

						System.out.println();
						switch (action) {
						case "1":
							Tools.slowText("You got a broken wooden sword.");
							
							player.setSword("Broken Wooden Sword", 5, 10);
		
							goodAction = true;
							player.setIsDone(true, 5);
							break;
						case "2":
							Tools.slowText("You leave the sword for now.");
							goodAction = true;
							break;
						case "end":
							System.exit(0);
						default:
							Tools.slowText("That is not a valid input!");
						}
					}
				} else {
					Tools.slowText("You find nothing else in the debris.");
				}
				break;
			case "3":
				return;
			case "4":
				player.showInv();
				break;
			case "end":
				System.exit(0);
			default:
				Tools.slowText("That is not a valid input!");
			}
			
		}
	}
}