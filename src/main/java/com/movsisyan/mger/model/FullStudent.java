package com.movsisyan.mger.model;

import java.util.ArrayList;
import java.util.Arrays;

public class FullStudent extends Student {
    private String full;
    private ArrayList<Integer> grades = new ArrayList<>();

    public FullStudent(String full, String name, String surname, int course, ArrayList<Integer> grades) {
        super(name, surname, course);
        this.full = full;
        this.grades = grades;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }

    public void addGrade(Integer... n) {
        this.grades.addAll(Arrays.asList(n));
    }

    @Override
    public String toString() {
        return super.toString().replace(";", ", ") + " " +
                "type ='" + full + '\'' +
                ", grades=" + grades +
                '}';
    }
}
