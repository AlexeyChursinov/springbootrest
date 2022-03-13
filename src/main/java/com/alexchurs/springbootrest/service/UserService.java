package com.alexchurs.springbootrest.service;

import com.alexchurs.springbootrest.entity.UserEntity;
import com.alexchurs.springbootrest.exception.UserAlreadyExistException;
import com.alexchurs.springbootrest.exception.UserNotFoundException;
import com.alexchurs.springbootrest.model.User;
import com.alexchurs.springbootrest.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    //метод для создания нового пользователя
    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        //делаем проверку на уникальность user перед тем, как сохранять в базу
        //Username приходит в теле запроса, указываем его параметром в findByUsername
        //если репозиторий вернул что-то отличное от null, то будем отправлять клиенту ошибку
        if(userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует!");
        }
        return userRepo.save(user);
    }

    //метод для получения пользователя по id
    //в параметре id пользователя
    public User getOne(Long id) throws UserNotFoundException {
        //ищем пользователя, если не находим бросаем ошибку
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("Пользователь не найден!");
        }
        return User.toModel(user); //возвращаем модель. Вызываем метод toModel, который доступен, потому что он static
    }

    //метод для удаления пользователя
    //в параметре id пользователя
    public Long delete(Long id) {
        userRepo.deleteById(id);
        return id; //возвращать будем просто id
    }

}
