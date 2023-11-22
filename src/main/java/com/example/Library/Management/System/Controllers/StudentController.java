package com.example.Library.Management.System.Controllers;

import com.example.Library.Management.System.Entities.Author;
import com.example.Library.Management.System.Entities.Book;
import com.example.Library.Management.System.Entities.Student;
import com.example.Library.Management.System.ResponseObject.BasicDetailsStudentResponse;
import com.example.Library.Management.System.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student)
    {
          return studentService.addStudent(student);

    }


    @GetMapping("/getBasicDetails")
    public BasicDetailsStudentResponse getBasicDetails(@RequestParam("id") Integer id)
    {
        BasicDetailsStudentResponse resultObj = studentService.getBasicDetails(id);
        return resultObj;

    }





}
