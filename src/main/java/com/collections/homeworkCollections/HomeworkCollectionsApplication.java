package com.collections.homeworkCollections;

import com.collections.homeworkCollections.domain.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class HomeworkCollectionsApplication {
	public static Map<String, Employee> listOfEmployees = new HashMap<>();
	public static void main(String[] args) {
		listOfEmployees.put("IvanPetrov", new Employee("Ivan", "Petrov", 1, 50));
		listOfEmployees.put("ChendlerBing", new Employee("Chendler","Bing",  1, 55));
		listOfEmployees.put("MonicaBing", new Employee("Monica","Bing",  1, 78));
		listOfEmployees.put("RossGeller", new Employee("Ross","Geller",  2, 89));
		listOfEmployees.put("GanterJohns", new Employee("Ganter","Johns",  2, 60));
		listOfEmployees.put("RachelGrin", new Employee("Rachel","Grin",  2, 65));
		listOfEmployees.put("JoeTribiani", new Employee("Joe","Tribiani",  3, 32));
		listOfEmployees.put("FuibyBuffey", new Employee("Fuiby","Buffey",  3, 54));
		listOfEmployees.put("JudyGeller", new Employee("Judy", "Geller", 3, 46));
		listOfEmployees.put("MikeHanigan", new Employee("Mike", "Hanigan", 4, 110));
		listOfEmployees.put("CarrolWilik", new Employee("Carrol", "Wilik", 4, 67));
		listOfEmployees.put("RichardBerk", new Employee("Richard", "Berk", 4, 97));
		listOfEmployees.put("FrankBuffey-j", new Employee("Frank", "Buffey-j", 4, 35));
		listOfEmployees.put("FrankBuffey", new Employee("Frank", "Buffey", 5, 45));
		listOfEmployees.put("PitBecker", new Employee("Pit", "Becker", 5, 150));
		listOfEmployees.put("EstelLeonard", new Employee("Estel", "Leonard", 5, 48));
		listOfEmployees.put("PaulStevens", new Employee("Paul", "Stevens", 6, 80));
		listOfEmployees.put("JillGrin", new Employee("Jill", "Grin", 6, 24));

		SpringApplication.run(HomeworkCollectionsApplication.class, args);
	}

}
