package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.dto.CountType;
import com.example.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

	@Query(value = "Select * from Task order by due_Date desc",nativeQuery = true)
	public List<Task> getAllTaskDueDateDesc();
	
	@Query(value = "Select new com.example.dto.CountType(COUNT(*)/(select COUNT(*) from Task)*100,type) from Task GROUP BY type")
	public List<CountType> getPercentageGroupByType();
}
