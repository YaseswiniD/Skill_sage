package com.example.service;

import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.EmployeeSkill;
import com.example.entity.Skills;
//import com.example.entity.User;
import com.example.logrepo.logRepository;
import com.example.repository.Empskillrepo;
import com.example.repository.Skillrepo;
//import com.example.repository.Userrepo;

//import jakarta.transaction.Transactional;

import com.example.entity.EmpID;

@Service
public class EmpSkillService {
	
	@Autowired
	private Empskillrepo repos;
	
//	 @Autowired
//	 private logRepository lrepo; // Inject User repository
//
//	    @Autowired
//	    private Skillrepo sRepo;
	    
	    public void saveEmpSkill(EmployeeSkill Eskill) {
			 repos.save(Eskill);
		}
	public EmployeeSkill saveEmpSkill1(EmployeeSkill Eskill) {
		return repos.save(Eskill);
	}
	
	public List<EmployeeSkill> saveEmpSkills(List<EmployeeSkill> Eskill) {
		return repos.saveAll(Eskill);
	}
	public List<EmployeeSkill> getEmpSkills(){
		return repos.findAll();
	}
	
//	@Transactional
//	 public String deleteEmpSkillByCompositeKey(int id, int skillid) {
//	        Optional<EmployeeSkill> empSkillOptional = repos.findById(new EmpID(id, skillid));
//	        
//	        if (empSkillOptional.isPresent()) {
//	            repos.deleteById(new EmpID(id, skillid));
//	            return "Record deleted successfully";
//	        } else {
//	            return "Record not found";
//	        }
//	    }
//	
	
//	@Transactional(readOnly = true)
//	 public List<EmployeeSkill> getEmpSkillsBySkillOrEmployeeName(String searchName) {
//	        // Assuming searchName can be either skill name or employee name
//
//	        // Fetch users with similar names
//	        List<Login_det> users = uRepo.findByUsernameContaining(searchName);
//
//	        // Fetch skills with similar names
//	        List<Skills> skills = sRepo.findBySkillnameContaining(searchName);
//			return null;
//
//	        // Fetch employee skills based on users and skills
////	        return repository.findByUserInAndSkillsIn(users, skills);
//	    }
}
