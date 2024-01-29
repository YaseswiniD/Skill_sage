package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.EmpID;
import com.example.entity.EmployeeSkill;
import com.example.entity.Skills;
//import com.example.entity.User;
import com.example.model.Login_det;




@Repository
public interface Empskillrepo extends JpaRepository<EmployeeSkill, EmpID> {

    List<EmployeeSkill> findById_Empid(String empid);
}












//public interface Empskillrepo extends JpaRepository<EmployeeSkill, Integer>{
//	
////	void deleteById(EmpID id);
////	Optional<EmployeeSkill> findById(EmpID empId);
//	
//	  List<EmployeeSkill> findById_IdIn(List<Long> ids);
//
////	    List<EmployeeSkill> findByUserIn(List<Login_det> users);
//
//	    List<EmployeeSkill> findBySkillsIn(List<Skills> skills);
//	    
////	    List<EmployeeSkill> findByUserInAndSkillsIn(List<Login_det> users, List<Skills> skills);
//
////	          List<EmployeeSkill> findById_UserIn(List<User> users);
////
////
////	    List<EmployeeSkill> findById_UserInAndSkillsIn(List<User> users, List<Skills> skills);
//
//	   
//		
//
////	    List<EmployeeSkill> findById_IdIn(List<Integer> userIds);
//	
//	
//	    
//}
