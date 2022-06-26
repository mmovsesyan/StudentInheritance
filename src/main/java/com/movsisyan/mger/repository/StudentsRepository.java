package com.movsisyan.mger.repository;

import com.movsisyan.mger.factory.StudentFactory;
import com.movsisyan.mger.model.DistanceStudent;
import com.movsisyan.mger.model.FullStudent;
import com.movsisyan.mger.model.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class StudentsRepository {
    private ArrayList<Student> studentList = new ArrayList<>();

    private void load(String name, Map<String, StudentFactory> factoryMap) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(name))) {
            while (bufferedReader.ready()) {
                String s = bufferedReader.readLine();
                String[] split = s.split(",");
                String type = split[0];
                StudentFactory studentFactory = factoryMap.getOrDefault(type, null);
                Student student = studentFactory.newInstance(type, split[1], split[2],
                        Integer.parseInt(split[3]), Arrays.copyOfRange(split, 4, split.length));
                studentList.add(student);
            }
        }
    }

    public StudentsRepository(String name,Map<String, StudentFactory> factory) throws IOException {
        load(name, factory);
    }

    /**
     * 3.Вернуть студентов, которые являются отличниками
     */
    public ArrayList<Student> coolestStudents() {
        ArrayList<Student> students = new ArrayList<>();
        for (Student student : studentList) {
            boolean isBest = true;
            if (student instanceof FullStudent fullStudent) {
                for (Integer grade : fullStudent.getGrades()) {
                    if (grade != 5) {
                        isBest = false;
                        break;
                    }
                }
                if (isBest) {
                    students.add(student);
                }
            }
        }
        return students;
    }


    /**
     * 4.Отсортировать коллекцию студентов-заочников в лексикографическом порядке по фамилии и имени
     */
    /**
     * 5.Отсортировать коллекцию студентов-очников по количеству людей из каждого курса
     */
    public void sort(Comparator<Student> comparator) {
        studentList.sort(comparator);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "studentsList=" + studentList +
                '}';
    }
}
