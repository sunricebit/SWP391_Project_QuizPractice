package com.example.quizv8.model;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "Quiz_List")
public class QuizList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    @Column(name = "id", nullable = false)
=======
    @Column(name = "id")
>>>>>>> 44983280f7a622ad61a096bf6539c05cb89badc6
    private long id;
    @Column(name = "_name")
    private String name;
    @Column(name = "_active")
    private boolean active;
    @Column(name = "_vote")
    private long vote;
    @OneToMany(mappedBy = "quizList")
    private List<QuestionDetail> questionDetailList;
    @ManyToOne
    @JoinColumn(name="_userId")
    private QuizUser user;
    @ManyToOne
    @JoinColumn(name = "_categoryId")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "_stateId")
    private QuizState state;
    public QuizList() {
    }

    public QuizList(boolean active, long vote, QuizUser user) {
        this.active = active;
        this.vote = vote;
        this.user = user;
    }

    public QuizList(long id, String name, boolean active, long vote, QuizUser user, Category category, QuizState state) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.vote = vote;
        this.user = user;
        this.category = category;
        this.state = state;
    }

    public QuizUser getUser() {
        return user;
    }

    public void setUser(QuizUser user) {
        this.user = user;
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

<<<<<<< HEAD
    public List<QuestionDetail> getQuestionDetailList() {
        return questionDetailList;
    }

    public void setQuestionDetailList(List<QuestionDetail> questionDetailList) {
        this.questionDetailList = questionDetailList;
    }

=======
>>>>>>> 44983280f7a622ad61a096bf6539c05cb89badc6
    public QuizState getState() {
        return state;
    }

    public void setState(QuizState state) {
        this.state = state;
    }
}