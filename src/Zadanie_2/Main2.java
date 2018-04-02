package Zadanie_2;

import java.util.Arrays;
import java.util.Scanner;

class Main2 {
	
	public static void main(String[] args) {
		try {
			lottoSim();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	private static void lottoSim() throws Exception {
		Integer[] myNumbers = new Integer[6];
		String myNumber = "0";
	
		Scanner scan = new Scanner(System.in);
	
		System.out.println("Wpisz liczbę!");
		myNumber = scan.nextLine();
		
		
		for(int i = 0;i<myNumbers.length;i++) {
			if (Integer.parseInt(myNumber) < 50 && Integer.parseInt(myNumber) > 0 && !(Arrays.asList(myNumbers).contains(Integer.parseInt(myNumber)))) {
				myNumbers[i] = Integer.parseInt(myNumber);
				System.out.println("Wpisz liczbę!");
				myNumber = scan.nextLine();
			} else {
				System.out.println("Niepoprawna liczba!");
				myNumber = scan.nextLine();
				i--;
			}		
		}
				
		scan.close();			
		System.out.println("Wpisałeś wszystkie liczby!");
		Arrays.sort(myNumbers);
		System.out.println(Arrays.toString(myNumbers));
		
		int[] byComputer = new int[6];
		
		int random = 0;
		for (int i=0;i<byComputer.length;i++) {
			random = (int)(Math.random()*48+1);
			if (!(Arrays.asList(byComputer).contains(random))) {
				byComputer[i]=random;
			} else {
				i--;
			}
			
		}
		System.out.println(Arrays.toString(byComputer));
		int counter = 0;
		for (int i = 0; i<myNumbers.length;i++) {
			for (int j = 0; j<byComputer.length;j++) {
				if(myNumbers[i]==(byComputer[j])) {
					counter++;
				}
			}
		}
		if (counter>=3) {
			System.out.println("Trafiłeś " + counter + "!");
		}else {
			System.out.println("Nie trafiłeś!");
		}
	
	}
}
