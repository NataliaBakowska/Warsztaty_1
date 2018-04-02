package Zadanie_3;

import java.util.Random;
import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		guessNumber2();
	}
	
	private static void guessNumber2() {
		Scanner scan = new Scanner(System.in);
		Random generator = new Random();
		int computerGuess;
		String userAnswer;
		int max = 100;
		int min = 0;
		
		System.out.println("Pomyśl liczbę od 0 do 1000, a ja ją zgadnę w max. 10 próbach.");
		System.out.println("Max: " + max);
		System.out.println("Min: " + min);
		//computerGuess = (int) (Math.random() * ((max-min)/2 + min));
		computerGuess = generator.nextInt((max - min )/2) + min +1;
		System.out.println("Czy twoja liczba to " + computerGuess + "?");
		
		userAnswer = scan.nextLine();
		
		while (!userAnswer.equals("zgadłeś")){
			
		
			if (userAnswer.equals("za dużo")) {
				try {	
					max = computerGuess;
					//computerGuess = (int) (Math.random() * ((max-min)/2 + min));
					computerGuess = generator.nextInt((max - min)/2) + min +1;
	
					System.out.println("Max: " + max);
					System.out.println("Min: " + min);
					System.out.println("Czy twoja liczba to " + computerGuess + "?");
					userAnswer = scan.nextLine();
				} catch (Exception e) {
					System.out.println("Nie oszukuj!");
					break;
				}
			
			} else if (userAnswer.equals("za mało")) {
				try {
					min = computerGuess;
					//computerGuess = (int) (Math.random() * ((max-min)/2 + min));
					computerGuess = generator.nextInt((max - min )/2) + min +1;
					if (min < computerGuess) {	
					System.out.println("Max: " + max);
					System.out.println("Min: " + min);
					System.out.println("Czy twoja liczba to " + computerGuess + "?");
					userAnswer = scan.nextLine();
					} 
				} catch (Exception e) {
					System.out.println("Nie oszukuj!");
					break;
				}
			}
		
		}
		System.out.println("Wygrałem!");
		scan.close();
	}
}
