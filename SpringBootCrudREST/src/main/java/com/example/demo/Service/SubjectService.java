package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.SubjectRepository;
import com.example.demo.springBootCrud.Subject;

@Service
public class SubjectService {

	@Autowired
	public SubjectRepository subRepo;
	
	public List<Subject> getAllSubjects()
	{
		List<Subject> subject= new ArrayList<>();
		subRepo.findAll().forEach(subject::add);
		return subject;
	}

	public void addSubject(Subject subject) {
		subRepo.save(subject);
	}

	public void updateSubject(String id, Subject subject) {
		// TODO Auto-generated method stub
		subRepo.save(subject);
	}

	public void deleteSubject(String id) {
		subRepo.deleteById(id);
	}
}
