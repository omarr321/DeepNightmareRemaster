package areaOne.TownOne;

import java.util.Scanner;
import tools.Tools;

public class TownOneControl {
	public static void start(int[] playerData, Scanner input, boolean[] isDone, String[] name, int[] safeCombo) {
		String action;
		if (isDone[0] == false) {
			Intro.start(playerData, input, isDone, name, safeCombo);
			Tools.clearScreen();
			Tools.slowText("As you walk thought the door, you are blinded by sunlight. As you");
			Tools.slowText("get use to the sunlight, you turn around and notice the house you");
			Tools.slowText("were in is no more. You look around some more and notice some type");
			Tools.slowText("of force field was surrounding the town.");
			System.out.println();
			Tools.slowText("(When you see no options for what you can do you can type or press any button to)");
			Tools.slowText("(continue or type end to end the program. This is so you can read the whole thing)");
			Tools.slowText("(before moving on.");
			Tools.slowText("[Paused]");
			Tools.slowTextN(">");
			action = input.nextLine();
			action = action.toLowerCase();
			if (action.equals("end")) {
				System.exit(0);
			}
			Tools.clearScreen();
		}
		while (true) {
			Tools.slowText("As you look around the town, you notice most of the building are");
			Tools.slowText("destroyed and only a few still stand. You see one in ruin but it");
			Tools.slowText("is still standing. There is also small make-shift hut. You see");
			Tools.slowText("a more intact building with a red-cross on it. You also see some");
			Tools.slowText("type of stone ark woth odd lights moving around it.");
			System.out.println();
			Tools.slowText("What do you want to do?");
			Tools.slowText("1: Go to hosptal");
			Tools.slowText("2: Go to hut");
			Tools.slowText("3: Go to ruins");
			if (isDone[2] == true || isDone[1] == true) {
				Tools.slowText("4: Go to portal");
			} else {
				Tools.slowText("4: Go to rock arch");
			}
			Tools.slowText("5: Leave town");
			Tools.slowText("6: Check inventory");
			System.out.println();
			Tools.slowTextN(">");
			action = input.nextLine();
			action = action.toLowerCase();
			Tools.clearScreen();
			switch (action) {
			case "1":
				Build_hospital.start(playerData, input, isDone, name, safeCombo);
				break;
			case "2":
				Build_hut.start(playerData, input, isDone, name, safeCombo);
				break;
			case "3":
				Build_ruin.start(playerData, input, isDone, name);
				break;
			case "4":
				Portal.start(playerData, input, isDone, name);
				break;
			case "5":
				if (isDone[1] == true) {
					Tools.slowText("You leave the town, hoping to destory the evil once and for all.");
					return;
				} else {
					Tools.slowText("You can't leave becasue the force field is impenetrable. Find a way");
					Tools.slowText("to disable/remove the force field.");
				}
				break;
			case "6":
				Tools.showInv(playerData, name);
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