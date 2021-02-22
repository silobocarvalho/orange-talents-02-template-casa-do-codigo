package br.com.zup.orange.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.orange.model.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long>{

	Optional<Author> findByEmail(String email);
}
