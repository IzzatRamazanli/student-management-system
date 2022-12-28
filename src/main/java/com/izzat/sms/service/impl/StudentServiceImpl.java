package com.izzat.sms.service.impl;

import com.izzat.sms.entity.Student;
import com.izzat.sms.repository.StudentRepository;
import com.izzat.sms.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteStudentById(Long id) {
        repository.deleteById(id);
    }


}
