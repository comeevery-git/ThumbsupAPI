package com.boot.my.thumbsup.domains.Board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.my.thumbsup.domains.Board.domain.BoardEntity;
import com.boot.my.thumbsup.domains.Board.domain.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepository boardRepository;

	/*
	 * @Override public List <BoardEntity> findAll() { return
	 * boardRepository.findAll(); }
	 */
	@Override
	public void save(BoardEntity boards) {
		boardRepository.save(boards);
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
