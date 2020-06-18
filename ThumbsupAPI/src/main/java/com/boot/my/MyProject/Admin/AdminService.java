package com.boot.my.MyProject.Admin;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdminService{
	private AdminRepository adminRepository;
	/*
	public AdminEntity getAdmin(Long admin_idx) {
		return adminRepo.findById(admin_idx).orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "Not found board"));
		
	}
	*/

}
