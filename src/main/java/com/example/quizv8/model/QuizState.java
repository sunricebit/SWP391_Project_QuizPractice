package com.example.quizv8.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Quiz_State")
public class QuizState {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "_stateDetail")
    private String stateDetails;
    @OneToMany(mappedBy = "state")
    private List<QuizList> quiz;
    public QuizState() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public QuizState(long id, String stateDetails) {
        this.id = id;
        this.stateDetails = stateDetails;
    }

    public String getStateDetails() {
        return stateDetails;
    }

    public void setStateDetails(String stateDetails) {
        this.stateDetails = stateDetails;
    }
}
