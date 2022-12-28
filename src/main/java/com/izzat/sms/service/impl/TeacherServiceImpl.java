package com.izzat.sms.service.impl;

import com.izzat.sms.entity.Teacher;
import com.izzat.sms.repository.TeacherRepository;
import com.izzat.sms.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
}
