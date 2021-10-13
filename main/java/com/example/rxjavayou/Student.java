package com.example.rxjavayou;

public class Student {
    private String studentClass;
    private int studentId;
    private String studentName;

    public Student(String studentClass, int studentId, String studentName) {
        this.studentClass = studentClass;
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }
}
