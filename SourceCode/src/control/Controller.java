package control;

import java.util.Scanner;
import areaOne.ControllerA1;
import tools.Tools;

public class Controller {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] name = {"", "Elite Armor", "Elite Sword"};
		String[] health = new String[33];
		for (int i = 0; i < health.length; i++) {
			health[i] = "=";
		}
		
		int[] playerData = {100, 10, 10, 10, 50000, 100000, 40000, 0, 80000, 0};
		boolean[] isDone = new boolean[11];
		
		int[] safeCombo = {Tools.random(0, 9), Tools.random(0, 9), Tools.random(0, 9), Tools.random(0, 9), Tools.random(0, 9), Tools.random(0, 9), Tools.random(0, 9), Tools.random(0, 9), Tools.random(0, 9)};
		
		SplashScreen.start(input);
		ControllerA1.start(playerData, input, isDone, name, health, safeCombo);
		input.close();
	}
}