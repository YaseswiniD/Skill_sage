package com.example.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.EmployeeSkill;

import com.example.service.EmpSkillService;

import jakarta.validation.Valid;


@Controller
public class EmpSkillController {
	
	@Autowired
	private EmpSkillService service;

	 @GetMapping("/addEmpSkill")
	    public String showAddEmpSkillForm(Model model) {
	        // Return the name of the HTML file (addSkillForm.html) without the extension
		 model.addAttribute("employeeSkill", new EmployeeSkill());
	        return "addEmpSkill";
	    }
	 
	 @PostMapping("/addEmpSkill")
	    public String addSkill(@ModelAttribute("employeeSkill") @Valid EmployeeSkill employeeSkill, BindingResult bindingResult) {
	        if (bindingResult.hasErrors()) {
	            return "addSkillForm"; // If validation fails, return to the form with error messages
	        }

	        service.saveEmpSkill(employeeSkill);

	        return "success"; // Redirect to the skill details page or any other appropriate page
	    }
	 
	 @GetMapping("/skillDetails")
	 public String showSkillDetails(Model model) {
		 
		 
	     List<EmployeeSkill> employeeSkills = service.getEmpSkills();
	     model.addAttribute("employeeSkills", employeeSkills);
	  // get your list of employee skills from the database or service
	     return "skillDetails";
	 }



	@PostMapping("/addEmpSkill1")
	public String addEmpskill(@ModelAttribute EmployeeSkill Eskill) {
		
	 service.saveEmpSkill(Eskill);
	 return "success";
	}
	
	@PostMapping("/addEmpSkills")
	public List<EmployeeSkill> addEmpskills(@RequestBody List<EmployeeSkill> Eskills) {
		return service.saveEmpSkills(Eskills);
		
	}
    @GetMapping("/EmpSkills")
	public List<EmployeeSkill> findAllEmpskills() {
		return service.getEmpSkills();
		
	}
	
    @GetMapping("/searchEmployeeSkills")
    public String showEmployeeSkills(Model model) {
        List<EmployeeSkill> employeeSkills = service.getEmpSkills();
        model.addAttribute("employeeSkills", employeeSkills);
        return "Empskillsearch";
    }

//    @DeleteMapping("/deleteEmpSkill/{id}/{skillid}")
//    public String deleteEmpSkill(@PathVariable int id, @PathVariable int skillid) {
//        return service.deleteEmpSkillByCompositeKey(id, skillid);
//    }
//    
//    @GetMapping("/getEmpSkillsBySkillOrEmployeeName/{searchName}")
//    public List<EmployeeSkill> getEmpSkillsBySkillOrEmployeeName(@PathVariable String searchName) {
//        return service.getEmpSkillsBySkillOrEmployeeName(searchName);
//    }
}
