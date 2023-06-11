package com.pack.springboot;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	List<Person> findByAgeGreaterThan(int age);

	List<Person> findByAgeLessThan(int age);

	public Person findByEmail(String email);

	List<Person> findByFirstName(String firstName);

	List<Person> findByLastName(String lastName);

	List<Person> findByFirstNameStartingWith(String prefix);

	List<Person> findByLastNameEndingWith(String suffix);

	List<Person> findByFirstNameAndLastName(String firstName, String lastName);

	List<Person> findByFirstNameOrLastName(String firstName, String lastName);

	@Transactional
	void deleteByLastName(String lastName);

	@Transactional
	void deleteByEmail(String email);

	@Transactional
	void deleteByFirstNameAndLastName(String firstName, String lastName);

}
