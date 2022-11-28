package com.rishabh.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rishabh.entity.Employee;
import com.rishabh.service.EmpService;

@Controller
public class EmpController {
	@Autowired
	private EmpService service;
	private Model m;
	@GetMapping("/")
	public String home(Model m) {
		List<Employee> emp=service.getAllEmp();
		m.addAttribute("emp", emp);
		
		return "index";
	}
	@GetMapping("/add_emp")
	public String addEmpForm() {
		return"add_emp";
	}
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e,HttpSession session) {
		System.out.println(e);
		
		
		service.add_Emp(e);
		session.setAttribute("msg", "Employee Added Sucessfully..");
		return "redirect:/";
	}
	
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id) {
		
		Employee  e=service.getEMpById(id);
		m.addAttribute("emp", e);
		
		return "edit";
		
	}
		@PostMapping
		public String upadateEmp(@ModelAttribute Employee e,HttpSession session) {
			
			service.add_Emp(e);
			session.setAttribute("msg", "Emp Data update secessfully..");
			return "redirect:/";
		}
		
		@GetMapping
		public String deleteEMp(@PathVariable int id, HttpSession session)
		{ 
			
			service.deleteEMp(id);
			session.setAttribute("msg", "Emp Data delete secessfully..");
			return " redirect:/ ";
					
		}
}
