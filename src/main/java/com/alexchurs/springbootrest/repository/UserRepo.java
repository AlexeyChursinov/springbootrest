package com.alexchurs.springbootrest.repository;

import com.alexchurs.springbootrest.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

//UserEntity - сущность, с которой будет работать репозиторий
//Long - тип идентификатора репозитория
public interface UserRepo extends CrudRepository<UserEntity, Long> {
    //метод для поиска пользователя по его имени
    UserEntity findByUsername(String username);
}
