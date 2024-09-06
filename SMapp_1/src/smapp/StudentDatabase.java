// Dylan Gorrah ST10398445
package smapp;

import java.util.HashMap;
import java.util.Map;

public class StudentDatabase {
    private final Map<Integer, Student> students;

    public StudentDatabase() {
        this.students = new HashMap<>();
    }

    public void addStudent(Student student) {
        students.put(student.getStudentNumber(), student);
    }

    public Student searchStudent(int studentNumber) {
        return students.get(studentNumber);
    }

    public void printStudentReport(Student student, int studentCount) {
        System.out.println("========================================");
        System.out.println("              Student " + studentCount);
        System.out.println("========================================");
        System.out.println("Name: " + student.getName());
        System.out.println("Surname: " + student.getSurname());
        System.out.println("Age: " + student.getAge());
        System.out.println("E-mail: " + student.getEmail());
        System.out.println("Course: " + student.getCourse());
        System.out.println("Student Number: " + student.getStudentNumber());
        System.out.println("========================================");
        System.out.println(); // empty line for readability
    }

    public void printReport() {
        if (students.isEmpty()) {
            System.out.println("No students in the database.");
        } else {
            int studentCount = 1;
            for (Map.Entry<Integer, Student> entry : students.entrySet()) {
                Student student = entry.getValue();
                printStudentReport(student, studentCount);
                studentCount++;
            }
        }
    }

    public Map<Integer, Student> getStudents() {
        return students;
    }

    public void removeStudent(int studentNumber) {
        students.remove(studentNumber);
    }
}