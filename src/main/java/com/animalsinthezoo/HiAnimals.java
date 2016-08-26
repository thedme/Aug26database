package com.animalsinthezoo;

import java.util.Scanner;



public class HiAnimals {
public static void main(String[] args) {
	//DAO.readFromDB();
	
	
	Scanner sc = new Scanner(System.in);
	
	String menuInput = null;
	
	boolean menuCorrect = false;
	
	System.out.println("welcome to database");
	
	do {
		System.out.println("press 1 to write, or  press 2 to add to database");
		menuInput = sc.nextLine();
		switch (menuInput) {
		case "1":
			DAO.readFromDB();
			break;
		case "2":
			DAO.writeToDB();
			break;

		default:
			System.out.println("you entered invalid option");
			menuCorrect = true;
			break;
		}
	} while (menuCorrect);
}



}

