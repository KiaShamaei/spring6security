package spring.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.security.model.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private List<Student> students = new ArrayList<>();

    @GetMapping("/students")
    public List<Student> listStudent(){
         Student s1 = new Student();
         s1.setId(1L);
         s1.setFirstName("kia");
         s1.setLastName("shamaei");

        Student s2 = new Student();
        s2.setId(2L);
        s2.setFirstName("kia2");
        s2.setLastName("shamaei2");

        Student s3 = new Student();
        s3.setId(3L);
        s3.setFirstName("kia3");
        s3.setLastName("shamaei3");

        students.addAll(List.of(s1,s2,s3));
        return students;

    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }
}
