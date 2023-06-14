package com.example.entity;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Task")
//@AllArgsConstructor
//@NoArgsConstructor
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;
	@Column
	private String title;
	@Column
	private String type;
	@Column
	private Date dueDate;
	@Column
	private String discription;
	
	public Task(long id, String title, String type, Date dueDate, String discription) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.dueDate = dueDate;
		this.discription = discription;
	}

	public Task() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", type=" + type + ", dueDate=" + dueDate + ", discription="
				+ discription + "]";
	}
	
	
}
