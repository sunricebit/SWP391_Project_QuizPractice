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
    @Column(name = "_vote", nullable = false)
    private long vote;
//    @Column(name = "_categoryId", nullable = false)
//    private long categoryId;

    @Column(name = "_stateId", nullable = false)
    private long stateId;

    @Column(name = "_userId")
    private long userId;

    @ManyToOne
    @JoinColumn(name = "_categoryId")
    private Category category;

    public QuizList() {
    }

    public QuizList(long id, String name, boolean active, long vote, long stateId, long userId, Category category) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.vote = vote;
        this.stateId = stateId;
        this.userId = userId;
        this.category = category;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public long getVote() {
        return vote;
    }

    public void setVote(long vote) {
        this.vote = vote;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public long getStateId() {
        return stateId;
    }

    public void setStateId(long stateId) {
        this.stateId = stateId;
    }
}