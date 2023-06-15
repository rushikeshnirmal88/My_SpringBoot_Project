package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.springBootCrud.Subject;

@Repository
@Component
public interface SubjectRepository extends CrudRepository<Subject, String>{

}
