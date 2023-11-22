package com.example.Library.Management.System.Services;

import com.example.Library.Management.System.Entities.Student;
import com.example.Library.Management.System.Repositories.StudentRepository;
import com.example.Library.Management.System.ResponseObject.BasicDetailsStudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    public String addStudent(Student student)
    {
        studentRepository.save(student);

        return "Student has been saved to the DB";
    }


    public BasicDetailsStudentResponse getBasicDetails(Integer id)
    {
        Student student = studentRepository.findById(id).get();

        BasicDetailsStudentResponse result = new BasicDetailsStudentResponse();

        result.setAge(student.getAge());
        result.setName(student.getName());
        result.setMobNo(student.getMobNo());

        return result;
    }
}
