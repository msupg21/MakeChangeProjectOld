package Week1Homework;

import java.util.Scanner;
import java.text.DecimalFormat;

public class MakeChangeProject {

	public static Scanner kb = new Scanner(System.in);
	public static DecimalFormat money = new DecimalFormat();

	public static void main(String[] args) {
		double changeDue = validPurchase();
		if (changeDue > 0) {
			System.out.println("Let me get you your change...\n");
		} else {
			System.out.println();
		}

		int changeDue1 = (int) (changeDue * 100);
		int changeDown = changeDue1;

		int twenties = 0, tens = 0, fives = 0, ones = 0, quarters = 0, dimes = 0, nickels = 0, pennies = 0;

		if (changeDue1 >= 2000) {
			twenties = changeDue1 / 2000;
			if (twenties == 1) {
				System.out.println(twenties + " twenty");
			} else if (twenties > 1) {
				System.out.println(twenties + " twenties");
			}
			changeDue1 = changeDown - (twenties * 2000);

		}
		if (changeDue1 >= 1000) {
			tens = changeDue1 / 1000;
			System.out.println(tens + " ten");
			changeDue1 = changeDown - ((twenties * 2000) + (tens * 1000));
		}

		if (changeDue1 >= 500) {
			fives = changeDue1 / 500;
			System.out.println(fives + " five");
			changeDue1 = changeDown - ((twenties * 2000) + (tens * 1000) + (fives * 500));
		}

		if (changeDue1 >= 100) {
			ones = changeDue1 / 100;
			if (ones == 1) {
				System.out.println(ones + " one");
			} else if (ones > 1) {
				System.out.println(ones + " ones");
			}
			changeDue1 = changeDown - ((twenties * 2000) + (tens * 1000) + (fives * 500) + (ones * 100));
		}

		if (changeDue1 >= 25) {
			quarters = changeDue1 / 25;
			if (quarters == 1) {
				System.out.println(quarters + " quarter");
			} else if (quarters > 1) {
				System.out.println(quarters + " quarters");
			}
			changeDue1 = changeDown
					- ((twenties * 2000) + (tens * 1000) + (fives * 500) + (ones * 100) + (quarters * 25));
		}

		if (changeDue1 >= 10) {
			dimes = changeDue1 / 10;
			if (dimes == 1) {
				System.out.println(dimes + " dime");
			} else if (dimes > 1) {
				System.out.println(dimes + " dimes");
			}

			changeDue1 = changeDown - ((twenties * 2000) + (tens * 1000) + (fives * 500) + (ones * 100)
					+ (quarters * 25) + (dimes * 10));
		}

		if (changeDue1 >= 5) {
			nickels = changeDue1 / 5;
			System.out.println(nickels + " nickel");
			changeDue1 = changeDown - ((twenties * 2000) + (tens * 1000) + (fives * 500) + (ones * 100)
					+ (quarters * 25) + (dimes * 10) + (nickels * 5));
		}

		if (changeDue1 >= 1) {
			pennies = changeDue1 / 1;
			if (pennies == 1) {
				System.out.println(pennies + " penny");
			} else if (pennies > 1) {
				System.out.println(pennies + " pennies");
			}

		}
		System.out.println("\nThank you, come again! * In Abu voice *");
	}

	public static double validPurchase() {
		double balance, cashPaid = 0.0;
		DecimalFormat money = new DecimalFormat("$0.00");

		System.out.print("Hi there, how much is that item you have?: ");
		double price = kb.nextDouble();
		System.out.println("Ok, great $" + price);

		do {
			System.out.print("How much do you plan on paying?: ");
			cashPaid = kb.nextDouble();
			balance = (cashPaid - price);
			System.out.println("Change due: ");
			System.out.println(money.format(balance));

			if (balance == 0.0) {
				System.out.println("Great, have a nice day!");
			} else if (balance < 0.0) {
				System.out.println("Sorry but you are short some cash :(");
				System.out.println("What you have cost money, so cough up!\n50");
			} else if (balance > 0.0) {
				System.out.println("Ok I owe you some change.");
			}
		} while (!(balance == 0.0) && !(balance > 0.0));
		return balance;
	}
}