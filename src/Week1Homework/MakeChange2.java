package Week1Homework;

import java.util.Scanner;

public class MakeChange2 {

		
		public static void main(String[] args) {
			double totalCost, totalGiven;

			Scanner input = new Scanner(System.in);
			
			String choice = "Y";
			
			while (choice.equalsIgnoreCase("Y")) {
				System.out.print("How much did the stuff cost? ");
				totalCost = input.nextDouble();
		
				System.out.print("How much money did the customer tender? ");
				totalGiven = input.nextDouble();
		
				if (totalGiven == totalCost) {
					System.out.println("Don't give change");
				} else if (totalGiven < totalCost) {
					System.out.println("You need to give more money.");
				} else {
					giveChange(totalCost, totalGiven);
				}
				
				System.out.println("Go Again (Y/N)? ");
				choice = input.next();
		
			}

			input.close();
		}

		public static void giveChange(double totalCost, double totalGiven) {
			int totalToGiveBack = (int) ((totalGiven - totalCost) * 100);

			double[] denomination = { 2000, 1000, 500, 100, 25, 10, 5, 1 };
			String[] bills = { "Twenites", "Tens", "Fives", "Ones", "Quarters", "Dimes", "Nickels", "Pennies" };
			String[] bill = { "Twenty", "Ten", "Five", "One", "Quarter", "Dime", "Nickel", "Penny" };

			for (int i = 0; i < denomination.length; i++) {
				int amountToGiveBack = 0;
				amountToGiveBack = (int) (totalToGiveBack / denomination[i]);
				totalToGiveBack = totalToGiveBack - (int) (amountToGiveBack * denomination[i]);
				if (amountToGiveBack > 1) {
					System.out.println(amountToGiveBack + " " + bills[i]);
				} else if (amountToGiveBack == 1) {
					System.out.println(amountToGiveBack + " " + bill[i]);
				}
			}
		}
	}