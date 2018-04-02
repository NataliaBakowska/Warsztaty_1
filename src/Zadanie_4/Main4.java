package Zadanie_4;

import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
		diceRoll();
	}
	
	private static void diceRoll() {
		Scanner scan = new Scanner(System.in);
		String myCode= "Kod: ";
		
		try {
			System.out.println("How many times?");
			int rolls = scan.nextInt();

			if(rolls != 1) {
				myCode = myCode + rolls;
			}
		
			System.out.println("Dice type:");
			int type = scan.nextInt(); 
			while (type != 3 &&
					type != 6 &&
					type != 8 &&
					type != 10 &&
					type != 12 &&
					type != 20 &&
					type != 100) {
				System.out.println("Incorrect type!");
				System.out.println("Dice type:");
				type = scan.nextInt(); 
			}
			myCode += "D" + type;
		
			System.out.println("Add: ");
			int add = scan.nextInt();		
		
			if(add != 0) {
				myCode += "+" + add;
			}
			System.out.println(myCode);
		
			int result = 0;
			int totalResult = 0;
			for (int i = 1; i<=rolls; i++) {
				result = (int) (Math.random() * type + 1);
				System.out.println("Score in " + i + " roll: " + result);
				totalResult= totalResult + result;
			}
			scan.close();
			totalResult += add;
			System.out.println("Total score: " + totalResult);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
