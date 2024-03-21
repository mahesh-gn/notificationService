package com.insp.NotificationService.Service;

import com.insp.NotificationService.Dto.Student;
import com.insp.NotificationService.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private NotificationServiceClass notificationService;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student createStudent(Student student) {
        Student savedStudent = studentRepository.save(student);
        notificationService.sendNotification("A new student has been added: " + savedStudent.getName());
        return savedStudent;
    }

    public Student updateStudent(int id, Student studentDetails) {
        Student student = getStudentById(id);
        if (student != null) {
            student.setName(studentDetails.getName());
            student.setEmail(studentDetails.getEmail());
            Student updatedStudent = studentRepository.save(student);
            notificationService.sendNotification("Student details have been updated: " + updatedStudent.getName());
            return updatedStudent;
        }
        return null;
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}
