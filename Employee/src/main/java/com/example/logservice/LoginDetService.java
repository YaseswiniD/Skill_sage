package com.example.logservice;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.LoginDto;
import com.example.logrepo.logRepository;
import com.example.model.Login_det;


@Service
public class LoginDetService {
    @Autowired
    private logRepository repository;

    public Login_det saveLoginDet(Login_det loginDet) {
        return repository.save(loginDet);
    }

    public List<Login_det> saveLoginDets(List<Login_det> loginDets) {
        return repository.saveAll(loginDets);
    }

    public List<Login_det> getLoginDets() {
        return repository.findAll();
    }

    public Login_det getLoginDetByEmpId(String empid) {
        return repository.findByEmpid(empid).orElse(null);
    }

    public Login_det getLoginDetByEmail(String email) {
        return repository.findByEmail(email).orElse(null);
    }

    public String deleteLoginDet(String empId) {
        repository.deleteById(empId);
        return "Login Details removed!! " + empId;
    }

    public Login_det updateLoginDet(Login_det loginDet) {
        Login_det existingLoginDet = repository.findByEmpid(loginDet.getEmpid()).orElse(null);
        existingLoginDet.setEmail(loginDet.getEmail());
        existingLoginDet.setPassword(loginDet.getPassword());
        existingLoginDet.setRole(loginDet.getRole());
        existingLoginDet.setFullname(loginDet.getFullname());
        return repository.save(existingLoginDet);
    }

    public List<LoginDto> getAllEmployeeDetails() {
        // TODO: Implement logic for fetching employee details
        return null;
    }

    public List<LoginDto> searchEmployees(String empId, String skillname, String domain, String subdomain,
            String proficiency) {
        // TODO: Implement logic for searching employees
        return null;
    }
}

