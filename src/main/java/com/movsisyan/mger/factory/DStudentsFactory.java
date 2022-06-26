package com.movsisyan.mger.factory;

import com.movsisyan.mger.model.DistanceStudent;
import com.movsisyan.mger.model.Student;

public class DStudentsFactory implements StudentFactory{
    @Override
    public Student newInstance(String type, String name, String surname, int course, String... args) {
        return new DistanceStudent(type, name, surname, course, args[0]);
    }
}
