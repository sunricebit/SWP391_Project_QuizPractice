package com.example.quizv8.model;

public class ExamWithRank {
    private long rank;
    private Exam exam;

    public ExamWithRank() {
    }

    public ExamWithRank(long rank, Exam exam) {
        this.rank = rank;
        this.exam = exam;
    }

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }
}