package isp.lab6.exercise1;

import java.util.HashMap;

public class Student {
    private String name;
    private String studentId;
    private HashMap<String, Integer> grades;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.grades = new HashMap<String, Integer>();
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void addGrade(String subject, int grade) {
        grades.put(subject, grade);
    }

    public void removeGrade(String subject) {
        grades.remove(subject);
    }
    public HashMap<String, Integer> getGrades() {
        return grades;
    }

    public int getGrade(String subject) {
        return grades.get(subject);
    }

    public String toString() {
        String afis="Nume student: " + name + "\n";
        afis=afis +(" ID: " + studentId + "\n" + "Note: " );
        for (String subject : grades.keySet()) {
            afis=afis + subject + ": " + grades.get(subject) + "\n";
        }
        return afis;
    }
}
