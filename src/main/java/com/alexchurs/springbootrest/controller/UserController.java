package com.alexchurs.springbootrest.controller;

import com.alexchurs.springbootrest.entity.UserEntity;
import com.alexchurs.springbootrest.exception.UserAlreadyExistException;
import com.alexchurs.springbootrest.exception.UserNotFoundException;
import com.alexchurs.springbootrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *  Этот Controller отвечает за запросы связанные с пользователем
 */

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Метод для регистрации пользователей
     * Post запрос. Данные будут передаваться в теле запроса.
     * @RequestBody - тело запроса
     * @param user  - объект пользователя
     */
    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok().body("Пользователь успешно сохранен");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage()); //ошибка, если пользователь уже создан (пользователь должен быть уникальным)
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    /**
     * Метод для получения пользователя по id
     * Будем принимать query параметр в get запросе
     * @param id - id пользователя
     */
    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok().body(userService.getOne(id)); //возвращаем в ответ id пользователя
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage()); //ошибка, если пользователь не был найден
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    /**
     * Метод для удаления пользователя
     * id передаем, как часть пути запроса, для этого используем @PathVariable
     * @param id - id пользователя
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(userService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

}
