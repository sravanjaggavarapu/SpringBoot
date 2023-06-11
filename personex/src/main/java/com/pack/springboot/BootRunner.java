package com.pack.springboot;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootRunner implements CommandLineRunner {
	@Autowired
	PersonRepository personRepository;

	/**
	 *
	 */
	@Override
	public void run(String... args) throws Exception {

		Person p1 = new Person();
		p1.setFirstName("sravan");
		p1.setLastName("kumar");
		p1.setEmail("sravan@gmail.com");
		p1.setAge(18);

		Person p2 = new Person();
		p2.setFirstName("sai");
		p2.setLastName("teja");
		p2.setEmail("sai@gmail.com");
		p2.setAge(28);

		Person p3 = new Person();
		p3.setFirstName("sudhakar");
		p3.setLastName("rao");
		p3.setEmail("sudhakar@gmail.com");
		p3.setAge(29);

		Person p4 = new Person();
		p4.setFirstName("vasu");
		p4.setLastName("nadh");
		p4.setEmail("vasun@gmail.com");
		p4.setAge(35);

		personRepository.saveAll(List.of(p1, p2, p3, p4));
		System.out.println();
		Person p = personRepository.findByEmail("sudhakar@gmail.com");
		System.out.println(p);
		System.out.println();
		System.out.println("----------------------------------------------");
		personRepository.findByAgeGreaterThan(25).forEach(System.out::println);
		System.out.println();
		personRepository.findByAgeLessThan(20).forEach(System.out::println);
		System.out.println("----------------------------------------------");

		personRepository.findByFirstName("vasu").forEach(System.out::println);
		System.out.println();
		personRepository.findByLastName("rao").forEach(System.out::println);
		System.out.println("----------------------------------------------");

		personRepository.findByFirstNameStartingWith("s").forEach(System.out::println);

		personRepository.findByLastNameEndingWith("h").forEach(System.out::println);
		System.out.println("----------------------------------------------");

		personRepository.findByFirstNameAndLastName("sravan", "kumar").forEach(System.out::println);
		personRepository.findByFirstNameOrLastName("sudhakar", "nadh").forEach(System.out::println);
		System.out.println("----------------------------------------------");

		personRepository.deleteByEmail("sravan@gmail.com");
		personRepository.deleteByLastName("nadh");
		personRepository.deleteByFirstNameAndLastName("sai", "teja");

	}

}
