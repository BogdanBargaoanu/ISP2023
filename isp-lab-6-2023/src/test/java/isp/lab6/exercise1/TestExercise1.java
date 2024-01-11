package isp.lab6.exercise1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestExercise1 extends Exercise1 {
    @Test
    public void testEx1() {
        List<Student> students = new ArrayList<>();
        Student student = new Student("Matei", "m100");
        addStudent(students, student);
        updateInfo(students, student, "Mate", 10);
        updateInfo(students, student, "Info", 8);
        assertEquals(9.0, avgMedie(students, student), 0.01);
        removeStudent(students, student);
        assertEquals(0.0, avgMedie(students, student), 0.01);
    }

}
