package com.example.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.CountType;
import com.example.entity.Task;
import com.example.service.TaskService;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
@AllArgsConstructor
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@GetMapping("/task/vData/percentageCountType")
	public List<CountType> GetPercentageGroupByType()
	{
		return taskService.GetPercentageGroupByType();
	}
	
	@GetMapping("/task")
	public List<Task> getAll()
	{
		return taskService.getAllTask();
	}
	
	@PostMapping("/task")
	public Task saveTask(@RequestBody Task task)
	{
		return taskService.savetasks(task);
	}
	
	@GetMapping("/task/{id}")
	public Task getById(@PathVariable Long id)
	{
		return taskService.getTaskById(id).
				orElseThrow(() ->new EntityNotFoundException("Task Not Found"));
	}
	
	@PutMapping("/task/{id}")
	public ResponseEntity<?> updateTask(@RequestBody Task taskPara,@PathVariable Long id)
	{
		if(taskService.exitsByID(id)) 
		{
			Task task=taskService.getTaskById(id).
					orElseThrow(() ->new EntityNotFoundException("Task Not Found"));
			task.setTitle(taskPara.getTitle());
			task.setDiscription(taskPara.getDiscription());
			task.setDueDate(taskPara.getDueDate());
			task.setType(taskPara.getType());
			taskService.savetasks(task);
			
			return ResponseEntity.ok().body(task);	
		}
		else
		{
			HashMap<String, String> message= new HashMap<>();
			message.put("message", id +"task not found or matched");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}
	}
	
	@DeleteMapping("/task/{id}")
	public ResponseEntity<?> deleteTask(@PathVariable Long id)
	{
		if(taskService.exitsByID(id)) 
		{
	
			taskService.deleteTask(id);
			HashMap<String, String> message= new HashMap<>();
			message.put("message", id +" task deleted successfully");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
			
			//return ResponseEntity.ok().body(task);	
		}
		else
		{
			HashMap<String, String> message= new HashMap<>();
			message.put("message", id +"task not found or matched");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}
	}
	
}
