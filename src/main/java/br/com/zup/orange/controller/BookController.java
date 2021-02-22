package br.com.zup.orange.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.zup.orange.dto.BookFormInDto;
import br.com.zup.orange.dto.BookListDetailsDto;
import br.com.zup.orange.dto.BookListDto;
import br.com.zup.orange.model.Book;

@RestController
@Validated
@RequestMapping("/books")
public class BookController {

	@PersistenceContext // Create a unique EntityManager for each Thread. @Autowired is not thread-safe.
	private EntityManager entityManager;

	

	
	@GetMapping
	@Transactional
	public List<BookListDto> getBooks() {
		return entityManager.createQuery("SELECT b FROM Book b", Book.class)
				.getResultStream()
				.map(BookListDto::new)
				.collect(Collectors.toList());
	}
	
	@PostMapping
	@Transactional
	public void addBook(@Valid @RequestBody BookFormInDto bookFormInDto) {

		Book book = bookFormInDto.convertToModel(entityManager);

		entityManager.persist(book);

	}
	
	
	@GetMapping("/{id}")
	public BookListDetailsDto getBookDetails(@Valid @NotNull @PathVariable("id") long bookId) {
		
		System.out.println(bookId);
		Book bookFromDb = entityManager.find(Book.class, bookId);
		
		if(bookFromDb == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		BookListDetailsDto bookDetails = new BookListDetailsDto(bookFromDb);
		
		return bookDetails;
		
	}




}
