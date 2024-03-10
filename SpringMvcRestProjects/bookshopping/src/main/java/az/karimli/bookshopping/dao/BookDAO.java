package az.karimli.bookshopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import az.karimli.bookshopping.model.Book;

public interface BookDAO extends JpaRepository<Book, Integer>{
	
}
