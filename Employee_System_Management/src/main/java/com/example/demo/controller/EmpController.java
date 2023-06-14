package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmpService;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

//import com.example.demo.entity.Employee;
@RestController
@RequestMapping("/employee")
public class EmpController {

	@Autowired
	private EmpService service;
	
	@GetMapping("/")
	public String home(Model m) {
		
		List<Employee> emp =service.getAllEmp();
		m.addAttribute("emp",emp);
		return "index";
	}
	
	@GetMapping("/addemp")
	public String addEmp() {
		return "add_emp";
	}
	
	@GetMapping("/home")
	public String homePage()
	{
		return "home";	
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e,HttpSession session)
	{
		System.out.print(e);
		service.addEmp(e);
		session.setAttribute("msg", "Employee Added Successfully.......!!");
		
		return "redirect:/";
	}
	
	@GetMapping("/edite/{id}")
	public String edit(@PathVariable int id,Model m)
	{
		Employee e =service.getEmpById(id);
		m.addAttribute("emp",e);
		return "edite";
		
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e,HttpSession session)
	{
		service.addEmp(e);
		session.setAttribute("msg","Employee Data updated successfully");
		return"redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id,HttpSession session) 
	{
		session.setAttribute("msg","Employee Deleted Successfully");
		service.deleteEmplopee(id);
		return "redirect:/";
	}
}


