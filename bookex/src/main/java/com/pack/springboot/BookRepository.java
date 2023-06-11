package com.pack.springboot;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface BookRepository extends JpaRepository<Book, Long> {

	@Query("select b from Books b")
	public List<Book> getAllBooks();

	@Query("select b.id,b.author from Books b")
	public List<String> getData();

	@Query("select b from Books b where b.title=:title")
	public List<Book> getByTitle(@Param("title") String title);

	@Query("select b from Books b where b.title=?1 and b.author=?2")
	public Book getByTitleAndAuthor(@Param("title") String title, @Param("author") String author);

	@Query("select b from Books b where b.id BETWEEN ?1 AND ?2")
	public List<Book> getBookById(int start, int end);

	@Query("select b.title from Books b order BY b.title ASC")
	public List<String> orderByTitleASC();

	@Query("select b.title from Books b order BY b.title DESC")
	public List<String> orderByTitleDESC();

	@Transactional
	@Modifying
	@Query("update Books b SET b.title =:title WHERE b.id=:id")
	int updateTitle(int id, String title);

	@Transactional
	@Modifying
	@Query("update Books b SET b.author=:author WHERE b.title=:title")
	int updateAuthor(String title, String author);

	
	  @Transactional	  
	  @Modifying	  
	  @Query("delete from Books b where b.title=?1") 
	  int deleteByTitle(String title);
	  

	  @Transactional	  
	  @Modifying	  
	  @Query("delete from Books b where b.title=?1 and b.author=?2") 
	  int deleteByTitleAndAuthor(String title, String author);
	 
}
