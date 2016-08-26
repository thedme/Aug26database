package com.animalsinthezoo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

//import com.hithursday.Student;

public class DAO {
	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root&autoReconnect=true&useSSL=false";
	static final String User = "root";
	static final String PASSWORD = "root";

	static Connection CONN = null;;
	static Statement STMT = null;
	static PreparedStatement PREP_STMT = null;
	static ResultSet RES_SET = null;

	static Scanner sc = new Scanner(System.in);

	public static void connToDB() {
		try {
			System.out.println("Trying to connect to the DB...");
			CONN = DriverManager.getConnection(DB_URL, User, PASSWORD);
			System.out.println("Connected to DB. ");
		} catch (SQLException e) {
			System.out.println("Connection failed");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void readFromDB() {
		connToDB();

		ArrayList<Animal> ourAnimals = new ArrayList<>();

		try {
			STMT = CONN.createStatement();
			RES_SET = STMT.executeQuery("SELECT * FROM students.animals_at_zoo;");

			while (RES_SET.next()) {
				Animal animalInDB = new Animal();

				animalInDB.setAnimals_id(RES_SET.getString("animals_id"));
				animalInDB.setSpecies(RES_SET.getString("species"));
				animalInDB.setType_of_cage(RES_SET.getString("Type_of_cage"));
				animalInDB.setFood(RES_SET.getString("food"));
				animalInDB.setName(RES_SET.getString("name"));
				animalInDB.setWeight(RES_SET.getDouble("weight"));

				ourAnimals.add(animalInDB);
			}

			for (Animal animal : ourAnimals) {
				System.out.println(animal.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void writeToDB() {
		Animal animalToAdd = new Animal();
		animalToAdd = aboutTheAnimal();

		connToDB();
		try {
			PREP_STMT = CONN.prepareStatement(insertToDB);

			PREP_STMT.setString(1, animalToAdd.getSpecies());
			PREP_STMT.setString(2, animalToAdd.getType_of_cage());
			PREP_STMT.setString(3, animalToAdd.getFood());
			PREP_STMT.setString(4, animalToAdd.getName());
			PREP_STMT.setDouble(5, animalToAdd.getWeight());

			PREP_STMT.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static String insertToDB = "INSERT INTO `students`.`animals_at_zoo`"
			+ "(species, type_of_cage, food, name, weight)" + " VALUES " + "(?, ?, ?, ?, ?)";

	public static Animal aboutTheAnimal() {
		Animal animalToAdd = new Animal();
		System.out.println("Species?");
		animalToAdd.setSpecies(sc.nextLine());

		System.out.println("Cage?");
		animalToAdd.setType_of_cage(sc.nextLine());

		System.out.println("Food?");
		animalToAdd.setFood(sc.nextLine());

		System.out.println("name?");
		animalToAdd.setName(sc.nextLine());

		System.out.println("weight?");
		animalToAdd.setWeight(Double.parseDouble(sc.nextLine()));

		return animalToAdd;
		/*
		 * } public static void deleteFromDB() {
		 * 
		 * Animal animalToAdd = new Animal(); animalToAdd = aboutTheAnimal();
		 * 
		 * System.out.println("Which animal would you like to delete?");
		 * 
		 * animalToAdd.setAnimals_id(sc.nextLine());
		 * 
		 * 
		 * connToDB(); try { PREP_STMT = CONN.prepareStatement(deleteToDB);
		 * 
		 * PREP_STMT.setString(1, animalToAdd.getAnimals_id());
		 * 
		 * 
		 * PREP_STMT.executeUpdate();
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * } private static String deleteToDB =
		 * "DELETE FROM `students`.`animals_at_zoo`" + "WHERE animals_id =";
		 */

	}
}
