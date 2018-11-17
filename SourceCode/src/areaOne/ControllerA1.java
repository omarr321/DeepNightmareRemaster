package areaOne;

import java.util.Scanner;
import areaOne.TownOne.TownOneControl;

public class ControllerA1 {
	public static void start(int[] playerData, Scanner input, boolean[] isDone, String[] name, String[] health, int[] safeCombo) {
		TownOneControl.start(playerData, input, isDone, name, health, safeCombo);
	}
}
