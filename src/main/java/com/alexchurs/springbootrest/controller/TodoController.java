package com.alexchurs.springbootrest.controller;

import com.alexchurs.springbootrest.entity.TodoEntity;
import com.alexchurs.springbootrest.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *  Этот Controller отвечает за запросы связанные с задачами
 */

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    /**
     * Метод для создания задачи
     * @param todo передаем TodoEntity в теле запроса
     * @param userId id пользователя будем передавать query параметром
     */
    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todo,
                                     @RequestParam Long userId) {

        try {
            return ResponseEntity.ok(todoService.createTodo(todo, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }

    }

    /**
     * Метод для обновления. put запрос
     * @param id передаем параметром id задачи, чтобы её обновить
     * Пользователь будет отправлять запрос, в задаче будет менятся поле completed
     */
    @PutMapping
    public ResponseEntity completeTodo(@RequestParam Long id) {

        try {
            return ResponseEntity.ok(todoService.complete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }

    }

}
