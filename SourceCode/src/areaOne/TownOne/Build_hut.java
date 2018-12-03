package areaOne.TownOne;

import java.util.Scanner;
import tools.Tools;
import tools.Player;

public class Build_hut {
	public static void start(Player player, Scanner input) {
		String action;
		while (true) {
			System.out.println();
			
			Tools.slowText("You stand in the hut. As you look around you notice a few details. The hut");
			Tools.slowText("seems to be builded out of old scrap and debris. There is a door which looks");
			Tools.slowText("like it leads to back room and a door to the right that seems to lead to a");
			Tools.slowText("bedroom. There is a desk in the corner and a sitting area.");
			System.out.println();
			Tools.slowText("What do you want to do?");
			Tools.slowText("1: Look at the desk");
			Tools.slowText("2: Look at the sitting area");
			Tools.slowText("3: Enter backroom");
			Tools.slowText("4: Enter bedroom");
			Tools.slowText("5: Leave");
			Tools.slowText("6: Check inventory");
			System.out.println();
			Tools.slowTextN(">");
			action = input.nextLine();
			action = action.toLowerCase();
			Tools.clearScreen();
			switch(action) {
			case "1":
				boolean isBack = false;
				while(isBack == false) {
					System.out.println();
					if(player.getIsDone(6) == true) {
						Tools.slowText("The desk is very simple. It has a desk with two draws. There is a");
						Tools.slowText("letter on the desk.");
					} else {
						Tools.slowText("The desk is very simple. It has a desk with two draws, one looks to");
						Tools.slowText("be locked with a key. There is a letter on the desk.");
					}
					
					System.out.println();
					Tools.slowText("What do you want to do?");
					Tools.slowText("1: Read letter");
					Tools.slowText("2: Look in top draw");
					if (player.getIsDone(6) == false) {
						Tools.slowText("3: Look in bottom draw");
					} else {
						if (player.getIsDone(6) == false) { 
							Tools.slowText("3: Unlock safe");
						} else {
							Tools.slowText("3: Check safe");
						}
					}
					Tools.slowText("4: Go back");
					Tools.slowText("5: Check inventory");
					System.out.println();
					Tools.slowTextN(">");
					action = input.nextLine();
					action = action.toLowerCase();
					Tools.clearScreen();
					
					switch (action) {
					case "1":
						Tools.slowText("The letter reads as following:");
						System.out.println();
						Tools.slowText("Hello " + player.getName() + ",");
						System.out.println();
						Tools.slowText("   I was wrong. They are much too powerful for any one man. We tried to fight");
						Tools.slowText("but  we were unable. We are going to flea this town and hope that you can do");
						Tools.slowText("the same. I will talk with you in due time, just head towards Ironclan when you");
						Tools.slowText("leave. The rock arch outside is a portal. That where they came from. We were");
						Tools.slowText("to hold off them then but our numbers are wearing thin. We found this odd book");
						Tools.slowText("that seem to be filled in some alien language. I put it in a safe in the bottem");
						Tools.slowText("draw. You can find a key in the night stand. The safe has a 3 digit combo which");
						Tools.slowText("I have written down but I lost the paper in the hosptal when I was ambushed.");
						System.out.println();
						Tools.slowText("-Love you");
						Tools.slowText("Omar");
						System.out.println();
						Tools.slowText("P.S. Sorry for bad grammer. I must go now.");
						break;
					case "2":
						if (player.getIsDone(7) == false) {
							Tools.slowText("You open the draw and find 10 coins!");
							Tools.slowText("+10 coins add to inventory!");
							player.addCoin(10);
							player.setIsDone(true, 7);
						} else {
							Tools.slowText("There is nothing else in the draw.");
						}
						break;
					case "3":
						if (player.getIsDone(6) == false) {
							if (player.getKey() > 0) {
								Tools.slowText("You unlock the draw and find a safe and put it on the desk.");
								Tools.slowText("-1 key from inventory");
								player.subKey(1);
								player.setIsDone(true, 6);
							} else {
								Tools.slowText("The draw is locked.");
								isBack = false;
							}
						} else {
							boolean tryAgain = true;
							if (player.getIsDone(2) == false) {
								int[] combo = new int[3];
								
								Tools.slowText("You look at the safe. It is three digits input.");
								Tools.slowText("(Each digit is between 0 and 9)");
								while (tryAgain == true) {
									System.out.println();
									Tools.slowText("What is the combo?");
									System.out.println();
									Tools.slowTextN("1st digit: ");
									combo[0] = input.nextInt();

									Tools.slowTextN("2nd digit: ");
									combo[1] = input.nextInt();

									Tools.slowTextN("3rd digit: ");
									combo[2] = input.nextInt();
									@SuppressWarnings("unused")
									String temp = input.nextLine();
									System.out.println();
									
									if (player.checkCombo(0, combo[0], combo[1], combo[2]) == true) {
										Tools.slowText("You open the safe and find the magic spell book.");
										player.setIsDone(true, 2);
										break;
									} else {
										Tools.slowText("That is not correct.");
									}
									
									Tools.clearScreen();
									boolean good = false;
									while (good == false) {
										Tools.slowText("What do you want to do?");
										Tools.slowText("1: Try again");
										Tools.slowText("2: Go back");
										System.out.println();
										Tools.slowTextN(">");
										action = input.nextLine();
										action = action.toLowerCase();
										Tools.clearScreen();
										
										switch (action) {
										case "1":
											tryAgain = true;
											good = true;
											break;
										case "2":
											tryAgain = false;
											good = true;
											break;
										case "end":
											System.exit(0);
										default:
											Tools.slowText("That is not a vaild input!");
										}
									}
								}
							} else {
								Tools.slowText("You look in the safe again but find nothing.");
								tryAgain = false;
							}
						}
						break;
					case "4":
						isBack = true;
						break;
					case "5":
						player.showInv();
						break;
					case "end":
						System.exit(0);
					default:
						Tools.slowText("Thats not a vaild input!");
					}
					
				}
				break;
			case "2":
				Tools.slowText("You search the sitting area but you find nothing of intrest.");
				break;
			case "3":
				backroom(player, input);
				break;
			case "4":
				bedroom(player, input);
				break;
			case "5":
				TownOneControl.start(player, input);
			case "6":
				player.showInv();
				break;
			case "end":
				System.exit(0);
			default:
				Tools.slowText("Thats not a vaild input!");
			}
		}
	}
	
	public static void backroom(Player player, Scanner input) {
		while(true) {
			
		}
		
	}
	
	public static void bedroom(Player player, Scanner input) {
		
	}
}