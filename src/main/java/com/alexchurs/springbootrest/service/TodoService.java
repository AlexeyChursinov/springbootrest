package com.alexchurs.springbootrest.service;

import com.alexchurs.springbootrest.entity.TodoEntity;
import com.alexchurs.springbootrest.entity.UserEntity;
import com.alexchurs.springbootrest.model.Todo;
import com.alexchurs.springbootrest.repository.TodoRepo;
import com.alexchurs.springbootrest.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private UserRepo userRepo;

    /**
     * Метод для создания задачи
     * @param todo entity задачи
     * @param userId id пользователя
     */
    public Todo createTodo(TodoEntity todo, Long userId) {
        //сначала нужно найти пользователя при помощи id, который получаем в параметре
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));
    }

    /**
     * Метод для обновления задачи. Будем обновлять поле completed (выполнено/не выполнено)
     * @param id id задачи
     */
    public Todo complete(Long id) {
        //находим задачу, чтобы потом заменить completed
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted()); //передаем отрицание того значения, которое там находится
        return Todo.toModel(todoRepo.save(todo));
    }

}
