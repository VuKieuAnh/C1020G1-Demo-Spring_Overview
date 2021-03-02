package service.student;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService {
    private static List<Student> students;
    static {
        students = new ArrayList<>();
        students.add(new Student(1, "Vinh", "Ha Noi"));
        students.add(new Student(1, "Qui", "Vinh Phuc"));
        students.add(new Student(1, "Thanh", "Ha Noi"));
        students.add(new Student(1, "Nghia", "Dien Bien"));
        students.add(new Student(1, "Quoc Anh", "Vinh"));
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public Student findById(int id) {
        return students.get(id);
    }

    @Override
    public boolean update(Student student) {
//        students.
        return false;
    }

    @Override
    public boolean save(Student student, int id) {
        students.set(id, student);
        return false;
    }
}