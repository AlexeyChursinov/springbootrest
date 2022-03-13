package com.alexchurs.springbootrest.repository;

import com.alexchurs.springbootrest.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

//TodoEntity - сущность, с которой будет работать репозиторий
//Long - тип идентификатора репозитория
public interface TodoRepo extends CrudRepository<TodoEntity, Long> {
}
