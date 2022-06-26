package com.movsisyan.mger.program;

import com.movsisyan.mger.comparator.StudentsComparatorCourse;
import com.movsisyan.mger.comparator.StudentsComparatorSurname;
import com.movsisyan.mger.factory.DStudentsFactory;
import com.movsisyan.mger.factory.FStudentsFactory;
import com.movsisyan.mger.factory.StudentFactory;
import com.movsisyan.mger.repository.StudentsRepository;

import java.io.IOException;
import java.util.HashMap;

public class Program {
    public static void main(String[] args) {
        try {
            HashMap<String, StudentFactory> factoryHashMap = new HashMap<>();
            factoryHashMap.put("full", new FStudentsFactory());
            factoryHashMap.put("distance", new DStudentsFactory());
            StudentsRepository repository = new StudentsRepository("students.csv", factoryHashMap);
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
