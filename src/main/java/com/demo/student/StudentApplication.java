package com.demo.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);

		// User record
		record User(String name, int age, int score) {}


		// Creating a list of User records
		List<User> users = Arrays.asList(
				new User("Nimal", 25, 85),
				new User("Kamal", 30, 90),
				new User("Sunil", 22, 75),
				new User("Perera", 28, 95),
				new User("Saman", 35, 80)
		);


		// 1. Filtering users with score above 80
		List<User> highScorers = users.stream()
				.filter(user -> user.score() > 80)
				.toList();
		System.out.println("Users with score above 80: " + highScorers);

		// 2. Get only user's names
		List<String> userNames = users.stream()
				.map(User::name)
				.toList();
		System.out.println("User names: " + userNames);

		// 3. Sorting users by age
		List<User> sortedByAge = users.stream()
				.sorted((u1, u2) -> Integer.compare(u1.age(), u2.age()))
				.toList();
		System.out.println("Users sorted by age: " + sortedByAge);

		// 4. Counting users
		long userCount = users.stream().count();
		System.out.println("Total number of users: " + userCount);

		// 5. Checking if any user is older than 30
		boolean anyOlderThan30 = users.stream()
				.anyMatch(user -> user.age() > 30);
		System.out.println("Any user older than 30? " + anyOlderThan30);

		// 6. Checking if all users are younger than 40
		boolean allYoungerThan40 = users.stream()
				.allMatch(user -> user.age() < 40);
		System.out.println("All users younger than 40? " + allYoungerThan40);

		// 7. Find any user with score 95
		Optional<User> userWithScore95 = users.stream()
				.filter(user -> user.score() == 95)
				.findAny();
		userWithScore95.ifPresent(user -> System.out.println("User with score 95: " + user));

		// 8. Find first user with age 22
		Optional<User> firstUserWithAge22 = users.stream()
				.filter(user -> user.age() == 22)
				.findFirst();
		firstUserWithAge22.ifPresent(user -> System.out.println("First user with age 22: " + user));

		// 9. Skipping first 2 users
		List<User> skippedUsers = users.stream()
				.skip(2)
				.toList();
		System.out.println("Skipped users: " + skippedUsers);
	}

}


