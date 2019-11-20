package com.finanzas.letter.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T> {

	T insertOrUpdate(T entity);

	Optional<T> getOne(Long id);

	List<T> getAll();

	T delete(Long id);

}
