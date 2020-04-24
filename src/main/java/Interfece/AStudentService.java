package Interfece;

import Entity.Student;

import java.util.List;

public interface AStudentService {
    //学生系统业务层接口
    List<Student> findAllStudents();
    Student FindStudentById(Integer id);
    void saveStudent(Student s);
    void updateStudent(Student s);
    void deleteStudent(Integer id);
    Student findStudentByName(String Name);
}
