package com.pack.lombok;

import java.util.HashSet;

public class Test {
	public static void main(String[] args) {
		HashSet<Person> persons = new HashSet<Person>();
		persons.add(new Person(1001,"mr.ratan","hero","ratan@gmail.com"));
		persons.add(new Person(1001,"mr.ratan","hero","ratan@gmail.com"));
        persons.forEach(System.out::println);
	}

}
