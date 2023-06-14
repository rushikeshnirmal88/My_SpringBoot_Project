package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class CountType {

	private long count;
	private String type;
	
	public CountType() {
		super();
	}

	public CountType(long count, String type) {
		super();
		this.count = count;
		this.type = type;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "CountType [count=" + count + ", type=" + type + "]";
	}
	
	
	
}
