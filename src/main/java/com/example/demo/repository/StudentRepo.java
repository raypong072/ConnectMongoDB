package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.Students;


public interface StudentRepo extends MongoRepository<Students, String> {

	public Optional<StudentRepo> findByName(String name);
    public List<Students> findByAge(int age);  
    
}
