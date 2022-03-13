package com.alexchurs.springbootrest.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //каждый id будет инкрементироваться
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    //создаем список задач. Один пользователь может иметь несколько задач (список).
    //используем отношение один ко многим
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user") //CascadeType.ALL - если удаляем пользователя, то удаляются и все задачи связанные с пользователем
    private List<TodoEntity> todos;

    public UserEntity() {
    }

    public List<TodoEntity> getTodos() {
        return todos;
    }

    public void setTodos(List<TodoEntity> todos) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
