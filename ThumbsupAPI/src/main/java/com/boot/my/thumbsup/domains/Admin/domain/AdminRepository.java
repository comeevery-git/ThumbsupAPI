package com.boot.my.thumbsup.domains.Admin.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	void save(AdminDto admin);
	
	Optional<Admin> findByAdminId(String adminId);
	
	
}
