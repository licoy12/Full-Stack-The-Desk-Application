import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static ArrayList<Integer> expenses = new ArrayList<Integer>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		expenses.add(1000);
		expenses.add(2300);
		expenses.add(45000);
		expenses.add(32000);
		expenses.add(110);
		System.out.println("\n**************************************\n");
		System.out.println("\tWelcome to TheDesk \n");
		System.out.println("**************************************");
		optionsSelection();
	}

	private static void optionsSelection() {
		String[] arr = { "1. I wish to review my expenditure", "2. I wish to add my expenditure",
				"3. I wish to delete my expenditure", "4. I wish to sort the expenditures",
				"5. I wish to search for a particular expenditure", "6. Close the application" };
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
			// display the all the Strings mentioned in the String array
		}

		System.out.print("\nEnter your choice: ");
		int options = sc.nextInt();
		switch (options) {
		case 1:
			showExpenses();
			optionsSelection();
			break;
		case 2:
			System.out.print("Enter the value to add your Expense: ");
			int newExpense = sc.nextInt();
			addExpense(newExpense);
			optionsSelection();
			break;
		case 3:
			deleteAllExpense(options);
			optionsSelection();
			break;
		case 4:
			sortExpenses(expenses);
			optionsSelection();
			break;
		case 5:
			searchExpenses(expenses);
			optionsSelection();
			break;
		case 6:
			closeApp();
			break;
		default:
			System.out.println("You have made an invalid choice!");
			break;
		}

	}

	private static void showExpenses() {
		if(expenses.size()==0) {
			System.out.println("No expense found");
			return;
		}
		System.out.println("Your saved expenses are listed below:");
		for (int i = 0; i < expenses.size(); i++) {
			System.out.println(i + 1 + ") " + expenses.get(i));
		}
		System.out.println();
	}// end of showExpense

	private static void addExpense(int expenseToBeAdded) {
		expenses.add(expenseToBeAdded);
		System.out.println("Expense " + expenseToBeAdded + " was successfully added");
		System.out.println("Your value is updated!");
		for (int i = 0; i < expenses.size(); i++) {
			System.out.println(i + 1 + ") " + expenses.get(i));
		}
	}

	private static void deleteAllExpense(int options) {
		System.out
				.println("You are about the delete all your expenses! \nConfirm again by selecting the same option...");
		int con_choice = sc.nextInt();
		if (con_choice == options) {
			expenses.clear();
			System.out.println("All your expenses are erased!\n");
		} else {
			System.out.println("Oops... try again!");
		}
	}// end of deleteAllExpense

	private static void closeApp() {
		System.out.println("Closing your application... \nThank you!");
		System.exit(0);
	}// end of closeApp

	private static void searchExpenses(ArrayList<Integer> arrayList) {
		System.out.print("Enter the value: ");
		// Complete the method
		int expenseToSearch = sc.nextInt();
		boolean found = false;
		int index = 0;
		for (int i = 0; i < arrayList.size(); i++) {
			if (expenseToSearch == arrayList.get(i)) {
				found = true;
				index = i+1;
				break;
			}
		}
		if (found) {
			System.out.println("Found expense " + expenseToSearch + " at position: " + index);
			return;
		}
		System.out.println(expenseToSearch + " is not in the in the expense list.");
	}// end of search

	private static void sortExpenses(ArrayList<Integer> arrayList) {
		Collections.sort(arrayList);
		System.out.println("Sorted Expenses:");
		for (int i = 0; i < expenses.size(); i++) {
			System.out.println(i + 1 + ") " + expenses.get(i));
		}
	}// end of sortExpenses
}
