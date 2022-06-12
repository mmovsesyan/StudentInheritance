package com.movsisyan.mger.comparator;

import com.movsisyan.mger.model.Student;

import java.util.Comparator;

public class StudentsComparatorSurname implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getSurname().compareTo(o2.getSurname()) == 0) {
            return o1.getName().compareTo(o2.getName());
        }
        return o1.getSurname().compareTo(o2.getSurname());
    }
}
