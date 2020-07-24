package com.boot.api.thumbsup.domains.service.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor // 인자없는 생성자를 자동으로 생성합니다.
@AllArgsConstructor
@Table(name = "tb_board")
public class Board implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int board_idx;
	
	@Column(length = 100)
	private String board_title;
	
	@Column(length = 400)
	private String board_contents;
	
	@Column(length = 100)
	private String board_admin;

	public int getBoard_idx() {
		return board_idx;
	}

	public void setBoard_idx(int board_idx) {
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
