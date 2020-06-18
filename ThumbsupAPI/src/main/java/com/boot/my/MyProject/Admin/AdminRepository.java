package com.boot.my.MyProject.Admin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	void save(AdminDto admin);

	
}
