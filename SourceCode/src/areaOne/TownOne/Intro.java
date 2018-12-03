package areaOne.TownOne;

import java.util.Scanner;
import tools.Tools;
import tools.Player;

public class Intro {
	public static void start(Player player, Scanner input) {
		
		Tools.clearScreen();
		Tools.slowText("You wake up, freezing and dazed. You look around the room you are in. The room");
		Tools.slowText("is small with simple wooden walls and floor. You are lying on a old mattress");
		Tools.slowText("in the corner. You see a cabinet, a rug, and a door.");
		Tools.sleep(1);
		System.out.println();
		String rug = "[Locked]";
		int checkDoor = 0;
		boolean broken = false;
		while (true) {
			
			Tools.slowText("What do you want to do?");
			Tools.slowText("(To select an option, type in the number next to the option and press enter.)");
			Tools.slowText("1: Search the cabinet");
			Tools.slowText("2: " + rug);
			Tools.slowText("3: Leave");
			Tools.slowText("4: Check inventory");
			System.out.println();
			Tools.slowTextN(">");
			String action = input.nextLine();
			action = action.toLowerCase();
			Tools.clearScreen();
			switch (action) {
			case "1":
				if (player.getIsDone(0) == false) {
					Tools.slowText("You search the cabinet and find a letter!");
					System.out.println();
					boolean vaildIn = false;
					while (vaildIn == false) {
						Tools.slowText("What do you want to do?");
						Tools.slowText("1: Read the letter");
						Tools.slowText("2: Leave the letter");
						System.out.println();
						Tools.slowTextN(">");
						action = input.nextLine();
						action = action.toLowerCase();
						Tools.clearScreen();
						switch (action) {
						case "1":
							Tools.slowText("The letter reads as followed:");
							Tools.slowText("Hello " + player.getName() + ",");
							System.out.println();
							Tools.slowText("   You might be wondering why you are here and where I am. I will answer both in");
							Tools.slowText("due time but first something really important. You are in grave danger. The town");
							Tools.slowText("you are in has been attacked by them. I locked you in here becasue I knew you");
							Tools.slowText("would be safe. You are here becasue you are our only hope. You have shown great");
							Tools.slowText("power in the past unlike any of us. I need you safe, we need you safe. You were");
							Tools.slowText("knocked out. I don't know for how long but you must find a way to kill them.");
							System.out.println();
							Tools.slowText("   Now for where I am. I went off to fight off this evil and hopefully rid this");
							Tools.slowText("town of them. I am writing this letter just incase I don't come back. If I don't,");
							Tools.slowText("just know that I love you. I wish you best of luck.");
							System.out.println();
							Tools.slowText("-Your Brother,");
							Tools.slowText("Omar");
							System.out.println();
							Tools.slowText("P.S. I hidden the key under the rug.");
							vaildIn = true;
							player.setIsDone(true, 0);
							rug = "Lift rug";
							break;
						case "2":
							Tools.slowText("You leave the letter for now.");
							vaildIn = true;
							break;
						case "end":
							System.exit(0);
						default:
							Tools.slowText("That is not a vaild input!");
						}
					}
				} else {
					Tools.slowText("You search the cabinet but find nothing else.");
				}
				break;
			case "2":
				if (player.getIsDone(1) == false) {
					if (player.getIsDone(0) == true) {
						Tools.slowText("You lift the rug up and find a key!");
						Tools.slowText("+1 key added to inventory.");
						Tools.sleep(1);
					player.addKey(1);
					player.setIsDone(true, 1);
				} else {
					Tools.slowText("This option is locked. Try doing another action to unlock it.");
					}
				} else {
					Tools.slowText("You looked again but atlas no second key magically appeared out of thin air.");
				}
				break;
			case "3":
				if (broken == false) {
				if (player.getKey() > 0) {
					Tools.slowText("You unlock the door and leave");
					Tools.slowText("-1 key from your inventory.");
					player.subKey(1);
					
					player.setIsDone(true, 0);
					player.setIsDone(false, 1);
					Tools.sleep(1);
					return;
				} else {
					
					switch (checkDoor) {
					case 0:
						Tools.slowText("You try the door but it is locked.");
						checkDoor++;
						break;
					case 1:
						Tools.slowText("You check the door again but it is still locked.");
						checkDoor++;
						break;
					case 2:
						Tools.slowText("The door did not unlock while you were looking away.");
						checkDoor++;
						break;
					case 3:
						Tools.slowTextN("You try the door and it opens. ");
						Tools.sleep(2);
						Tools.slowText("Just Kidding");
						checkDoor++;
						break;
					case 4:
						Tools.slowText("Just because you can check the door doesn't mean you should.");
						checkDoor++;
						break;
					case 5:
						Tools.slowText("Please just stop checking the door. I can't program many more custom messages.");
						checkDoor++;
						break;
					case 6:
						Tools.slowText("Just stop. The door is still locked.");
						checkDoor++;
						break;
					case 7:
						Tools.slowText("Dude. The door will never unlock becasue you keep checking it");
						checkDoor++;
						break;
					case 8:
						Tools.slowText("Do you know that the defintion of sociopath a person with a personality disorder manifesting");
						Tools.slowText("itself in extreme antisocial attitudes and behavior and a lack of conscience.");
						Tools.sleep(2);
						Tools.slowTextN("Perhaps you need to get checked out. ");
						Tools.sleep(1);
						Tools.slowText("Weirdo");
						Tools.sleep(1);
						checkDoor++;
						break;
					case 9:
						Tools.slowText("This is your 10th time checking the door. What are you trying to do?");
						checkDoor++;
						break;
					case 10:
						Tools.slowText("I feel like you trying to annoy me on purpose now.");
						checkDoor++;
						break;
					case 11:
						Tools.slowText("I hate you. What is your end goal?");
						checkDoor++;
						break;
					case 12:
						Tools.slowText("You not going to magiclly get lock picks and picklock the door. This's not");
						Tools.slowText("even in the game.");
						checkDoor++;
						break;
					case 13:
						Tools.slowText("You try to lock pick the door and it failed.");
						checkDoor++;
						break;
					case 14:
						Tools.slowTextN("You try to lock pick the door again and it works. ");
						Tools.sleep(3);
						Tools.slowText("Just kidding.");
						checkDoor++;
						break;
					case 15:
						Tools.slowText("See how dumb it would be if you can lockpick the door. You are not going to accomplish");
						Tools.slowText("anything by checking to door so much.");
						checkDoor++;
						break;
					case 16:
						Tools.slowTextN("Achievement Unlocked: ");
						Tools.sleep(2);
						Tools.slowText("Being an asshole who won't stop checking the dam door.");
						checkDoor++;
						break;
					case 17:
						Tools.slowText("Why won't you stop.");
						checkDoor++;
						break;
					case 18:
						Tools.slowText("If you keep checking this door, your going to have a bad time.");
						checkDoor++;
						break;
					case 19:
						Tools.slowText("You checked the door 20 times now. Why!? ");
						checkDoor++;
						break;
					case 20:
						Tools.slowText("I will kill you.");
						checkDoor++;
						break;
					case 21:
						Tools.slowText("3. I wonder what i'm counting down to.");
						checkDoor++;
						break;
					case 22:
						Tools.slowText("2. Is it good?");
						checkDoor++;
						break;
					case 23:
						Tools.slowText("1. Is it bad?");
						checkDoor++;
						break;
					case 24:
						Tools.slowText("You tried the door so much that the handle fell off making the door unopenable. Are you happy with yourself?");
						broken = true;
						break;
					default:
						Tools.slowText("You try the door but it is locked.");
						checkDoor++;
					}
				}
				} else {
					Tools.slowText("The door is unopenable, even with the key.");
				}
				break;
			case "4":
				player.showInv();
				break;
			case "end":
				System.exit(0);
			default:
				Tools.slowText("That is not a vaild input!");
			}
			System.out.println();
		}
	}
}