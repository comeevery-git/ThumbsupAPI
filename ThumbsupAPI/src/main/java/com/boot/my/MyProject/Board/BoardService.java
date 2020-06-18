package com.boot.my.MyProject.Board;

import java.util.List;

public interface BoardService {
	/*
	public BoardEntity getBoard(Long board_idx) {
		return boardRepo.findById(board_idx).orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "Not found board"));
		
	}
	 */

//	public List<BoardEntity> findBySalBetween(int a, int b);
	
	 //List <BoardEntity> findAll();

	 void save(BoardEntity boards);

	    //Optional < BoardEntity > findById(Long id);

	    //void delete(long id);
		
	
}
