package com.alexchurs.springbootrest.entity;

import javax.persistence.*;

@Entity
@Table(name = "todo")
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "completed")
    private Boolean completed;

    @ManyToOne //у нескольких задач может быть один пользователь
    @JoinColumn(name = "user_id") //связываем таблицы, указывается поле user_id (внешний ключ), по которому таблицы будут связаны.
    private UserEntity user; //название user указано в классе UserEntity в mappedBy. Это нужно для связи сущностей

    public TodoEntity() {
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
