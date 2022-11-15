package com.example.Assignment3.students_assignment.service;

import com.example.Assignment3.students_assignment.model.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;


@Service
public class StudentsService
{
    public static ObjectMapper objectMapper = new ObjectMapper();

    public static ArrayList<StudentModel> getStudentsList() throws IOException {
        InputStream inputStream = new FileInputStream(new File("src/main/resources/students.json"));
        TypeReference<List<StudentModel>> typeReference = new TypeReference<List<StudentModel>>() {
        };
        ArrayList<StudentModel> students = objectMapper.readValue(inputStream, new TypeReference<ArrayList<StudentModel>>() {
        });
        return students;
    }


    public Result getStudentById(String studentId) throws IOException {

        ArrayList<StudentModel> list = getStudentsList();
        int studentIndex = 0;
        double average = 0;
        for (int i = 0; i < list.size(); i++) {
            if (studentId.equals(list.get(i).getId())) {
                studentIndex = i;
                for (int j = 0; j < list.get(i).getCourses().length; j++) {
                    average += list.get(i).getCourses()[j].getGrade();
                }
                average = average / list.get(i).getCourses().length;
                break;
            }

        }
        return new Result(list.get(studentIndex), average);


    }

    public Count getCountOfFailingAvg() throws IOException {
        ArrayList<StudentModel> list = getStudentsList();
        ArrayList<StudentModel> failList = new ArrayList<>();
        double average = 0;
        int k = 0;
        for (int i = 0; i < list.size(); i++) {
            average = 0;

            for (int j = 0; j < list.get(i).getCourses().length; j++) {
                average += list.get(i).getCourses()[j].getGrade();
            }

            average = average / list.get(i).getCourses().length;

            if (average < 55.0) {

                failList.add(list.get(i));
                ++k;
            }
        }

        return new Count(failList, k);
    }

    public Count getCountOf90Avg() throws IOException {
        ArrayList<StudentModel> list = getStudentsList();
        ArrayList<StudentModel> passList = new ArrayList<>();
        double average = 0;
        int k = 0;
        for (int i = 0; i < list.size(); i++) {
            average = 0;

            for (int j = 0; j < list.get(i).getCourses().length; j++) {
                average += list.get(i).getCourses()[j].getGrade();
            }

            average = average / list.get(i).getCourses().length;

            if (average > 90.0) {

                passList.add(list.get(i));
                ++k;
            }
        }

        return new Count(passList, k);
    }

    public TreeMap<Integer, StudentModel> getYoungestToEldest() throws IOException {
        ArrayList<StudentModel> list = getStudentsList();

        TreeMap<Integer, StudentModel> treeMap = new TreeMap<>();

        LocalDate curDate = LocalDate.now();

        for (int i = 0; i < list.size(); i++) {
            LocalDate DOB = LocalDate.parse(list.get(i).getDob());
            int currentAge = Period.between(DOB, curDate).getYears();
            treeMap.put(currentAge, list.get(i));

        }
        return (treeMap);

    }

    public double getMeanAge() throws IOException
    {
        ArrayList<StudentModel> list = getStudentsList();
        double average = 0;
        LocalDate curDate = LocalDate.now();
        for (int i = 0; i < list.size(); i++) {
            LocalDate DOB = LocalDate.parse(list.get(i).getDob());
            int currentAge = Period.between(DOB, curDate).getYears();
            average += currentAge;
        }
        average = average / list.size();

        return (average);
    }
    public int getMedianAge() throws IOException
    {
        ArrayList<StudentModel> list = getStudentsList();
        LocalDate curDate = LocalDate.now();
        int median;
        int[] age = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
            LocalDate DOB = LocalDate.parse(list.get(i).getDob());
            int currentAge = Period.between(DOB, curDate).getYears();
            age[i]=currentAge;
        }
        Arrays.sort(age);
        int count = age.length;
        if(count%2==1)
        {
            median = age[(count+1)/2-1];
        }
        else
        {
            median = (age[count/2-1]+age[count/2])/2;

        }

        return  median;
    }
    public int getModeAge() throws IOException{
        ArrayList<StudentModel> list = getStudentsList();
        LocalDate curDate = LocalDate.now();
        int count=0,maxCount=0,maxValue=0;
        int[] age = new int[list.size()];

        for (int i = 0; i < list.size(); i++)
        {
            LocalDate DOB = LocalDate.parse(list.get(i).getDob());
            int currentAge = Period.between(DOB, curDate).getYears();
            age[i]=currentAge;
        }
        for(int i=0; i<age.length;i++)

        {
            count=0;
            for(int j=0;j<age.length;j++){
                if(age[i]==age[j]){
                    ++count;
                }
            }
            if(count>maxCount){
                maxCount=count;
                maxValue=age[i];
            }
        }
        return (maxValue);
    }

}
