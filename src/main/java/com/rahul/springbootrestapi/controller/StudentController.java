package com.rahul.springbootrestapi.controller;

import com.rahul.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping("student")
    public Student getStudent() {
        Student student = new Student(1, "rahul", "sharma");
        System.out.println(student);
        return student;

    }

    @GetMapping("/allStudents")
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "rahul", "sharma"));
        students.add(new Student(2, "poonam", "yadav"));
        students.add(new Student(3, "roshni", "mehto"));
        return students;
    }

    // pathVariable
    // {id} - URI template variable
    // http://localhost:8080/students/1/rahul/sharma
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student
    studentPathVariable(
            @PathVariable("id") int studentId,
            @PathVariable("first-name") String firstName,
            @PathVariable("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);

    }

    // @RequestParam
    // http://localhost:8080/students/query?id=1
    @GetMapping("students/query")
    public Student studentRequestParamVariable(@RequestParam int id) {
        return new Student(id, "rahul", "sharma");
    }

    // http://localhost:8080/students/query?id=1&firstName=rahul&lastName=sharma
    @GetMapping("students/queryy")
    public Student studentRequestParam(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName) {
        return new Student(id, firstName, lastName);

    }

    @PostMapping("/saveStudents")
    @ResponseStatus(HttpStatus.CREATED)
    public Student saveStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());

        System.out.println(student.getLastName());

        return student;

    }
@PutMapping("students/{id}/update")
    // update existing resources
    public Student updateStudent(@RequestBody Student student,@PathVariable("id") int studentId){
    System.out.println(student.getFirstName());

    System.out.println(student.getLastName());

    return student;

}
@DeleteMapping("students/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){
    System.out.println(studentId);

        return "deleted Successfully";
}



}