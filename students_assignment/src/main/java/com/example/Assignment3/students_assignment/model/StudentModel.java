package com.example.Assignment3.students_assignment.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.util.Comparator;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentModel {

    @JsonProperty("id")
    private String id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("dob")
    private String dob;
    @JsonProperty("courses")
    private Course courses[];



    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class Course{
        @JsonProperty("name")
        private String name;
        @JsonProperty("grade")
        private int grade;
        @JsonProperty("weight")
        private double weight;
    }
}


