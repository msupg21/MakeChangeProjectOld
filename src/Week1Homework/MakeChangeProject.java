package Week1Homework;

import java.util.Scanner;
import java.text.DecimalFormat;

public class MakeChangeProject {

	public static Scanner kb = new Scanner(System.in);
	public static DecimalFormat money = new DecimalFormat();
	public static double changeDue;

	public static void main(String[] args) {
		double changeDue = validPurchase();
		if (changeDue > 0) {
			System.out.print("Let me get you your change...");
		} else {
			System.out.println();
		}
		int twentyD = 0, tenD = 0, fiveD = 0, oneD = 0, quarters = 0, 
			dimes = 0, nickels = 0, pennies = 0;
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
				System.out.println("What you have cost money, so cough up!");
			} else if (balance > 0.0) {
				System.out.println("Ok I owe you some change.");
			}
		} while (!(balance == 0.0) && !(balance > 0.0));
		return balance;
	}
}
