package com.example.quizv8.model;

import javax.persistence.*;

@Entity
@Table(name = "Quiz_State")
public class QuizState {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "_stateDetails")
    private String stateDetails;

    public QuizState() {
    }

    public QuizState(long id, String stateDetails) {
        this.id = id;
        this.stateDetails = stateDetails;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStateDetails() {
        return stateDetails;
    }

    public void setStateDetails(String stateDetails) {
        this.stateDetails = stateDetails;
    }
}
