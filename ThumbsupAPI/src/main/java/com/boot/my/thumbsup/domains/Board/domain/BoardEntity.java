package com.boot.my.thumbsup.domains.Board.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_board")
public class BoardEntity implements Serializable {
	
	//기본 생성자 필수
	private BoardEntity(){}
 
	public BoardEntity(String board_title, String board_contents, String board_admin) {
		this.board_title = board_title;
		this.board_contents = board_contents;
		this.board_admin = board_admin;
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long board_idx;
	
	@Column(length = 100)
	private String board_title;
	
	@Column(length = 400)
	private String board_contents;
	
	@Column(length = 100)
	private String board_admin;

	public Long getBoard_idx() {
		return board_idx;
	}

	public void setBoard_idx(Long board_idx) {
		this.board_idx = board_idx;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_contents() {
		return board_contents;
	}

	public void setBoard_contents(String board_contents) {
		this.board_contents = board_contents;
	}

	public String getBoard_admin() {
		return board_admin;
	}

	public void setBoard_admin(String board_admin) {
		this.board_admin = board_admin;
	}

	@Override
	public String toString() {
		return "["+board_title+"] board_contents="+board_contents+", board_admin ="+board_admin;
	}
	
}
