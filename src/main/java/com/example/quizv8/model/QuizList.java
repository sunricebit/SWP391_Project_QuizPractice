package com.example.quizv8.model;

import javax.persistence.*;

@Entity
@Table(name = "Quiz_List")
public class QuizList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "_name", nullable = false)
    private String name;
    @Column(name = "_active", nullable = false)
    private boolean active;
    @Column(name = "_state", nullable = false)
    private boolean state;

    public QuizList() {
    }

    public QuizList(long id, String name, boolean active, boolean state) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
    //_name nvarchar(255) not null,
    //    _active bit not null,
    //    _state bit not null
}
