package com.boot.api.thumbsup.domains.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.api.thumbsup.domains.service.domain.Board;
import com.boot.api.thumbsup.domains.service.domain.BoardJpaRepo;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardJpaRepo boardJpaRepo;

	/*
	 * @Override public List <BoardEntity> findAll() { return
	 * boardRepository.findAll(); }
	 */
	@Override
	public void save(Board boards) {
		boardJpaRepo.save(boards);
	}
	
/*
	  @Override
	    public Optional <BoardEntity> findById(Long id) {
	        return boardRepository.findById(id);
	    }


	    @Override
	    public void delete(long id) {
	    	boardRepository.deleteById(id);
	    }
	*/
	

	
}
