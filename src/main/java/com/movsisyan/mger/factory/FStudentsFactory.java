package com.movsisyan.mger.factory;

import com.movsisyan.mger.model.FullStudent;
import com.movsisyan.mger.model.Student;

import java.util.ArrayList;
import java.util.Arrays;

public class FStudentsFactory implements StudentFactory{
    @Override
    public Student newInstance(String type, String name, String surname, int course, String... args) {
        ArrayList<Integer> grades = new ArrayList<>(Arrays.stream(args).map(Integer::parseInt).toList());
        return new FullStudent(type, name, surname, course, grades);
    }
}
