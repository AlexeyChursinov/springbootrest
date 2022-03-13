package com.alexchurs.springbootrest.model;

import com.alexchurs.springbootrest.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс содержит то, что будет передаваться на клиент
 */

public class User {
    private Long id;
    private String username;
    private List<Todo> todos; //список задач пользователя

    //создадим static метод, чтобы обращаться к нему без создания экземпляра класса
    //параметром принимаем entity, а возвращаем модель
    public static User toModel(UserEntity entity) {
        User model = new User();
        model.setId(entity.getId()); //устанавливаем id для модели, сам id берем из entity
        model.setUsername(entity.getUsername());
        //Преобразовываем список в stream, у stream вызываем map. Преобразовываем массив entity в массив модели
        model.setTodos(entity.getTodos().stream().map(Todo::toModel).collect(Collectors.toList()));

        return model;
    }

    public User() {
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
