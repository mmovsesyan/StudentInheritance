package com.movsisyan.mger.repository;

import com.movsisyan.mger.model.DistanceStudent;
import com.movsisyan.mger.model.FullStudent;
import com.movsisyan.mger.model.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class StudentsRepository {
    private ArrayList<Student> studentList = new ArrayList<>();

    private void load(String name) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(name))) {
            while (bufferedReader.ready()) {
                String s = bufferedReader.readLine();
                String[] split = s.split(",");
                if (split[0].contains("full")) {
                    FullStudent student = new FullStudent(split[0], split[1], split[2], Integer.parseInt(split[3]));
                    String[] strings = Arrays.copyOfRange(split, 4, split.length);
                    Integer[] grades = Arrays.stream(strings).map(Integer::parseInt).toArray(Integer[]::new);
                    student.addGrade(grades);
                    studentList.add(student);
                    continue;
                }
                DistanceStudent students = new DistanceStudent(split[0], split[1], split[2],
                        Integer.parseInt(split[3]), split[4]);
                this.studentList.add(students);
            }
        }
    }

    public StudentsRepository(String name) throws IOException {
        load(name);
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
