package com.example.demo.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Students;
import com.example.demo.repository.StudentRepo;


@RestController
@RequestMapping(value="/api/Students")
public class StudentController {

	@Autowired
    private StudentRepo studentRepo;
	
	/**
     * 查詢全部
     */
    @GetMapping(value="/all")
    public List<Students> getAllStudents() {
        return studentRepo.findAll();
    }
    
    @GetMapping(value="/test")
    public String test() {
        return "test";
    }
    
    /**
     * 依id查詢
     */
    @GetMapping(value="/id/{id}")
    public Students getStudentsById(@PathVariable String id) {
        return studentRepo.findById(id).orElse(null);
    }

    /**
     * 依名稱name查詢
     */
//    @GetMapping(value="/name/{name}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public Students getStudentsByName(@PathVariable String name) {
//        return studentRepo.findByName(name).orElse(null);
//    }

    /**
     * 依年紀age查詢
     */
    @GetMapping(value="/age/{age}")
    public List<Students> getStudentsByAge (@PathVariable int age) {
        return studentRepo.findByAge(age);
    }

    /**
     * 新增一筆資料
     */
    @PostMapping(value="/add")
    public Students createStudents(@RequestBody Students Students) {
        Students.setId(ObjectId.get().toHexString());
        studentRepo.save(Students);
        return Students;
    }
	
}
