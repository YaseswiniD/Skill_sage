package com.example.logservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dto.LoginDto;
import com.example.logrepo.logRepository;
import com.example.model.Login_det;

@Service
public class LogServiceImpl implements LogService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private logRepository logRepository;

	@Override
	public Login_det save(LoginDto loginDto) {
		Login_det login_det = new Login_det(loginDto.getEmpid(),loginDto.getEmail(), passwordEncoder.encode(loginDto.getPassword()) , loginDto.getRole(), loginDto.getFullname());
		return logRepository.save(login_det);
	}

	@Override
	public Login_det getEmployeeById(long long1) {
		// TODO Auto-generated method stub
		return null;
	}

}
