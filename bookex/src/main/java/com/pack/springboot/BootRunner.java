package com.pack.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootRunner implements CommandLineRunner {
	@Autowired
	BookRepository bookRepository;

	@Override
	public void run(String... args) throws Exception {
		Book b1 = new Book();
		b1.setId(111L);
		b1.setTitle("java");
		b1.setAuthor("jamesgosling");

		Book b2 = new Book();
		b2.setId(222L);
		b2.setTitle("reactjs");
		b2.setAuthor("bredan eich");

		Book b3 = new Book();
		b3.setId(333L);
		b3.setTitle("springframework");
		b3.setAuthor("rod jhonson");

		Book b4 = new Book();
		b4.setId(444L);
		b4.setTitle("perl");
		b4.setAuthor("larry wall");

		bookRepository.saveAll(List.of(b1, b2, b3, b4));

		bookRepository.getAllBooks().forEach(System.out::println);
		System.out.println();

		bookRepository.getData().forEach(System.out::println);
		System.out.println();

		List<Book> books1 = bookRepository.getByTitle("springframework");
		System.out.println(books1);
		System.out.println();

		Book books2 = bookRepository.getByTitleAndAuthor("java", "jamesgosling");
		System.out.println(books2);
		System.out.println();

		List<Book> books3 = bookRepository.getBookById(1, 3);
		System.out.println(books3);
		System.out.println();

		List<String> books4 = bookRepository.orderByTitleASC();
		System.out.println(books4);
		System.out.println();

		List<String> books5 = bookRepository.orderByTitleDESC();
		System.out.println(books5);
		System.out.println();
		  
		int s=bookRepository.updateTitle(1, "winner winner");
        System.out.println("Update Successful : "+s);
        System.out.println();
        
		
		  int s1= bookRepository.updateAuthor("reactjs", "ratan");
		  System.out.println("Update Successful : "+s1); 
		  System.out.println();
		 
		
		  int s2 = bookRepository.deleteByTitle("reactjs");
		  System.out.println("Deleted Record :"+s2);
		  System.out.println();
		  
		  int s3 = bookRepository.deleteByTitleAndAuthor("perl", "larry wall");
		  System.out.println("Deleted Records :"+s3);
		 
	}

}
