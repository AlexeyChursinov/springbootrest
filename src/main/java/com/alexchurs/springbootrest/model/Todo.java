package com.alexchurs.springbootrest.model;

import com.alexchurs.springbootrest.entity.TodoEntity;

/**
 * Класс содержит то, что будет передаваться на клиент
 */

public class Todo {
    private Long id;
    private String title;
    private Boolean completed;

    //создадим static метод, чтобы обращаться к нему без создания экземпляра класса
    //параметром принимаем entity, а возвращаем модель
    public static Todo toModel(TodoEntity entity) {
        Todo model = new Todo();
        model.setId(entity.getId());
        model.setTitle(entity.getTitle());
        model.setCompleted(entity.getCompleted());

        return model;
    }

    public Todo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
