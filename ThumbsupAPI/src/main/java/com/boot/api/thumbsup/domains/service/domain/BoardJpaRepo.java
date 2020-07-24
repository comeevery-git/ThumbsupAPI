package com.boot.api.thumbsup.domains.service.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardJpaRepo extends JpaRepository<Board, Long> {
	
}
