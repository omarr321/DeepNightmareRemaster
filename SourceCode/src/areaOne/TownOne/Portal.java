package areaOne.TownOne;

import java.util.Scanner;
import tools.Tools;
import tools.Player;

public class Portal {
	public static void start(Player player, Scanner input) {
		String action;
		String enter = "[Locked]";

		if (player.getIsDone(1) == true) {
			Tools.slowText("The poral is No more. Just a bunch of rockes on the ground.");
		} else {

			while (true) {
				if (player.getIsDone(2) == true) {
					enter = "Read spell";
				} else if (player.getIsDone(3) == true) {
					enter = "Go thoght portal";
				}
				Tools.slowText("You look at the arch of rocks. The stones are engraved with odd marks.");
				Tools.slowText("You notice red light shining from the stone cracks. You feel uneasy.");
				System.out.println();
				Tools.slowText("What do you want to do?");
				Tools.slowText("1: Examine the arch");
				Tools.slowText("2: " + enter);
				Tools.slowText("3: Go back");
				Tools.slowText("4: Check inventory");
				System.out.println();
				Tools.slowTextN(">");
				action = input.nextLine();
				action = action.toLowerCase();
				Tools.clearScreen();
				switch (action) {
				case "1":
					Tools.slowText("You see red lgiht in the engravment of the stone. It looks almost new.");
					Tools.slowText("As you look you feel uneasy so you stop.");
					break;
				case "2":
					if (player.getIsDone(2) == true) {
						Tools.slowText("You: dnammoc ym no nepo lliw uoY !latroP");
						Tools.slowText("As you say the spell, the ground starts to shake and the lights start");
						Tools.slowText("to glow bright and bright. The wind picks up and the red light from");
						Tools.slowText("the stone start to get pulled toward the middle of the arc and form a");
						Tools.slowText("bright red ball and you get fling back as the balls exspoldn in bright");
						Tools.slowText("light. When you recover, you see a red portal has opened up and you");
						Tools.slowText("get a urge that is where you need to go.");
						player.setIsDone(false, 2);
						player.setIsDone(true, 3);
					} else if (player.getIsDone(3) == true) {
						Tools.slowText("Are you sure you want to enter?");
						System.out.println();
						Tools.slowText("1: Yes");
						Tools.slowText("2: No");
						System.out.println();
						Tools.slowTextN(">");
						action = input.nextLine();
						action = action.toLowerCase();
						switch (action) {
						case "1":
							BossFight.start();
						case "2":
							break;
						case "end":
							System.exit(0);
						default:
							Tools.slowText("That is not a valid input!");
						}
					} else {
						Tools.slowText("This option is locked. Try doing another action to unlock this option.");
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
					Tools.slowText("That is not a vaild input!");
				}
				System.out.println();
			}
		}
	}
}
