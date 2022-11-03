package com.example.quizv8.model;

public class PartName {
    String part;
    long cateId;

    public PartName() {
    }

    public PartName(String part, long cateId) {
        this.part = part;
        this.cateId = cateId;
    }

    public long getCateId() {
        return cateId;
    }

    public void setCateId(long cateId) {
        this.cateId = cateId;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }
}
