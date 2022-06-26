package com.movsisyan.mger.factory;

import com.movsisyan.mger.model.Student;

public interface StudentFactory {
    Student newInstance(String type, String name, String surname, int course, String... args);
}
