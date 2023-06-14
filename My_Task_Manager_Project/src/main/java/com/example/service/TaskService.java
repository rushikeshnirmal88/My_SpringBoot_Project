package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.CountType;
import com.example.entity.Task;
import com.example.repository.TaskRepository;


import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Transactional(readOnly = true)
	public List<Task> getAllTask()
	{
		return taskRepository.getAllTaskDueDateDesc();
		
	}
	@Transactional
	public Task savetasks(Task task) {
		return taskRepository.saveAndFlush(task);
	}
	
	public boolean exitsByID(long id)
	{
		return taskRepository.existsById(id);
		
	}

	public Optional<Task> getTaskById(long id) {
		// TODO Auto-generated method stub
		return taskRepository.findById(id);
	}
	public void deleteTask(long id)
	{
		taskRepository.deleteById(id);
	}
	
	public List<CountType> GetPercentageGroupByType()
	{
		return taskRepository.getPercentageGroupByType();
	}
	
}
