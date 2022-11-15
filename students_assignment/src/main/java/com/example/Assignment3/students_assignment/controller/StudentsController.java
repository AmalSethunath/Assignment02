package com.example.Assignment3.students_assignment.controller;

import com.example.Assignment3.students_assignment.model.Result;
import com.example.Assignment3.students_assignment.model.Count;
import com.example.Assignment3.students_assignment.model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Assignment3.students_assignment.service.StudentsService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

@RequestMapping("/studentlist")
@RestController
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @GetMapping(value = "/students")
    public ArrayList<StudentModel> getStudents() throws IOException {

        return this.studentsService.getStudentsList();
    }
    @GetMapping(value = "/studentid/{id}")
    public Result getStudentDetails(@PathVariable("id") String id) throws IOException {

        return this.studentsService.getStudentById(id);

    }
    @GetMapping(value = "/failingAvg")
    public Count getFailingStudentsCount() throws IOException{
        return  this.studentsService.getCountOfFailingAvg();
    }
    @GetMapping(value = "/90Avg")
    public Count get90StudentsCount() throws IOException{
        return  this.studentsService.getCountOf90Avg();
    }
    @GetMapping(value = "/age")
    public TreeMap<Integer, StudentModel> getAge() throws  IOException{
        return  this.studentsService.getYoungestToEldest();
    }
    @GetMapping(value = "/MeanAge")
    public double getMeanAge() throws  IOException{
        return  this.studentsService.getMeanAge();
    }
    @GetMapping(value = "/MedianAge")
    public int getMedianAge() throws  IOException{
        return  this.studentsService.getMedianAge();
    }
    @GetMapping(value="/ModeAge")
    public int getModeAge() throws IOException{
        return this.studentsService.getModeAge();
    }
}
