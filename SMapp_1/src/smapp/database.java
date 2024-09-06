// Dylan Gorrah ST10398445
package smapp;

import java.util.HashMap;
import java.util.Map;

public class database {
    private final Map<Integer, Student> students;

    public database() {
        this.students = new HashMap<>();
    }

    public void addStudent(Student student) {
        students.put(student.getStudentNumber(), student);
    }

    public Student searchStudent(int studentNumber) {
        return students.get(studentNumber);
    }
}