package isp.lab6.exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Exercise1 {
    public static void addStudent(List<Student> students, Student student) {
        students.add(student);
    }

    public static void removeStudent(List<Student> students, Student student) {
        students.remove(student);
    }

    public static void displayStudents(List<Student> students) {
        for (Student student : students) {
            System.out.print(student.toString());
        }
    }

    public static void updateInfo(List<Student> students, Student student) {
        boolean exista = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introdu materia: ");
        String materie = scanner.next();
        System.out.println("Introdu nota la " + materie + ": ");
        int nota = scanner.nextInt();
        for (Student stud : students) {
            if (stud.getStudentId().equals(student.getStudentId())) {
                exista = true;
                if (nota > 10) {
                    nota = 10;
                } else if (nota < 1) {
                    nota = 1;
                }
                stud.addGrade(materie, nota);
            }
        }
        if (!exista) {
            System.out.println("Studentul nu exista in lista!");
        }
    }

    public static void updateInfo(List<Student> students, Student student, String materie, int nota) {
        boolean exista = false;
        for (Student stud : students) {
            if (stud.getStudentId().equals(student.getStudentId())) {
                exista = true;
                if (nota > 10) {
                    nota = 10;
                } else if (nota < 1) {
                    nota = 1;
                }
                stud.addGrade(materie, nota);
            }
        }
        if (!exista) {
            System.out.println("Studentul nu exista in lista!");
        }
    }

    public static double avgMedie(List<Student> students, Student student) {
        boolean exista = false;
        double medie = 0;
        for (Student stud : students) {
            if (stud.getStudentId().equals(student.getStudentId())) {
                exista = true;
                for (int nota : stud.getGrades().values()) {
                    medie += nota;
                }
                medie /= stud.getGrades().size();
                return medie;
            }
        }
        if (!exista) {
            System.out.println("Studentul nu exista in lista!");
        }
        return 0;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student[] student = new Student[4];
        student[0] = new Student("Andrei", "1");
        student[1] = new Student("Matei", "3");
        student[2] = new Student("Mihai", "7");
        student[3] = new Student("Andreea", "10");
        for (Student stud : student) {
            addStudent(students, stud);
        }
        Student studentt = new Student("Vlad", "11");
        removeStudent(students, student[2]);
        updateInfo(students, student[0]);
        updateInfo(students, studentt);
        System.out.println("Media " + avgMedie(students, student[0]));
        displayStudents(students);

    }

}
