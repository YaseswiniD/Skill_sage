package com.example.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Skills;
import com.example.repository.Skillrepo;

@Service
public class SkillService {
	@Autowired
	private Skillrepo repository;
	
	public Skills saveSkill(Skills skill) {
		return repository.save(skill);
	}
	public List<Skills> saveSkills(List<Skills> skill) {
		return repository.saveAll(skill);
	}
	public List<Skills> getSkills(){
		return repository.findAll();
	}
	
	public Skills getSkillById(int skillid){
		return repository.findById(skillid).orElse(null);
	}
	public Skills getSkillByName(String skillname){
		return repository.findBySkillname(skillname).orElse(null);
	}

	public String deleteSkill(int skillid)
	{
		repository.deleteById(skillid);
		return "Skill removed!! "+ skillid;
	}
	public Skills updateSkill(Skills skill)
	{
		Skills existingUser=repository.findById(skill.getSkillid()).orElse(null);
		existingUser.setSkillname(skill.getSkillname());
		existingUser.setSubdomain(skill.getSubdomain());
		existingUser.setDomain(skill.getDomain());
		return repository.save(existingUser);
		
		
	}
	

//    public List<String> getAllDomains() {
//        return repository.getAllDomains();
//    }

	   public List<String> getAllDomains() {
	        List<Skills> allSkills = repository.findAll();
	        return allSkills.stream().map(Skills::getDomain).distinct().collect(Collectors.toList());
	    }

	    public List<String> getAllSubdomains() {
	        List<Skills> allSkills = repository.findAll();
	        return allSkills.stream().map(Skills::getSubdomain).distinct().collect(Collectors.toList());
	    }
//    public Map<String, List<String>> getAllSubdomainsByDomain() {
//        return repository.getAllSubdomainsByDomain();
//    }
//	

	    public List<String> getDistinctDomains() {
	        return repository.findDistinctDomains();
	    }

	
	    public List<String> getDistinctSubdomainsByDomain(String domain) {
	        return repository.findDistinctSubdomainsByDomain(domain);
	    }

	 
	    public void addSkill(Skills skill) {
	        repository.save(skill);
	    }
//	public List<Skills> searchSkills(Integer skillid, String skillname, String domain, String subdomain) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	 public List<Skills> searchSkills(Integer skillid, String skillname, String domain, String subdomain) {
	        // Implement your search logic using the repository
	        return repository.findBySkillidAndSkillnameAndDomainAndSubdomain(skillid, skillname, domain, subdomain);
	    }
	    public Map<String, List<String>> getAllSubdomainsByDomain() {
	        List<Skills> allSkills = repository.findAll();
	        
	        return allSkills.stream()
	            .collect(Collectors.groupingBy(Skills::getDomain, 
	                    Collectors.mapping(Skills::getSubdomain, Collectors.toList())));
	    }
}
