package com.example.quizv8.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Report_Details")
public class ReportDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    //references quiz_list ID
    @Column(name = "_quizId")
    private long quizId;
    @Column(name = "_date")
    private Date date;
    @Column(name = "_reason")
    private String reason;
    //pending and approve
    @Column(name = "_status")
    private boolean status;

    public ReportDetails() {
    }

    public ReportDetails(long id, long quizId, Date date, String reason, boolean status) {
        this.id = id;
        this.quizId = quizId;
        this.date = date;
        this.reason = reason;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getQuizId() {
        return quizId;
    }

    public void setQuizId(long quizId) {
        this.quizId = quizId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
