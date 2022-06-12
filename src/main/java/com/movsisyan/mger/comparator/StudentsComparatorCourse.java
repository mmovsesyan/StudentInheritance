package com.movsisyan.mger.comparator;

import com.movsisyan.mger.model.Student;

import java.util.Comparator;

public class StudentsComparatorCourse implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getCourse(), o2.getCourse());
    }
}
