package com.example.Assignment3.students_assignment.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Count {
    public ArrayList<StudentModel> student;
    public int count;
}
