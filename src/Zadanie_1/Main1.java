package Zadanie_1;

import java.util.Scanner;

class Main1 {

		public static void main(String[] args) {
			guessNumber();
		}
		private static void guessNumber() {
			
			int byComputer = (int)( Math.random() *100);
			
			System.out.println("Zgadnij liczbę!");
			
			Scanner scan = new Scanner(System.in);
			
			try {
				
				int myNumber = scan.nextInt();
				while (myNumber != byComputer) {
					if (myNumber < byComputer) {
						System.out.println("Za mało!");
					} else  {
						System.out.println("Za dużo!");
					}
					myNumber = scan.nextInt();
				}
				System.out.println("Zgadłeś!");
			} catch (Exception e) {
				System.out.println("To nie jest liczba!");
			}
			scan.close();
		}
}
