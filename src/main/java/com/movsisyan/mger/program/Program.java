package com.movsisyan.mger.program;

import com.movsisyan.mger.comparator.StudentsComparatorCourse;
import com.movsisyan.mger.comparator.StudentsComparatorSurname;
import com.movsisyan.mger.repository.StudentsRepository;

import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        try {
            StudentsRepository repository = new StudentsRepository("students.csv");
            System.out.println(repository);
            System.out.println(repository.coolestStudents());
            repository.sort(new StudentsComparatorCourse());
            System.out.println(repository);
            repository.sort(new StudentsComparatorSurname());
            System.out.println(repository);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
