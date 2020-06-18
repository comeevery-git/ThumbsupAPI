package com.boot.my.MyProject.Board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
