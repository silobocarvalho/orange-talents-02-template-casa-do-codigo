package br.com.zup.orange.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.zup.orange.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{

	Optional<Category> findByName(String name);
}
