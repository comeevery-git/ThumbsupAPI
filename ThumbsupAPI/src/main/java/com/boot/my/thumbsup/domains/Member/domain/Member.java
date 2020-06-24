package com.boot.my.thumbsup.domains.Member.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_member")
public class Member {
 
	public Member() {}

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer mbIdx;

    // 사용자유형 
	@Column(length = 100)
    private String mbType;

    // 아이디 
	@Column(length = 100)
    private String mbId;

    // 비밀번호 
	@Column(length = 100)
    private String mbPwd;

    // 이름 
	@Column(length = 100)
    private String mbNm;

    // 전화번호 
	@Column(length = 100)
    private String mbTel;

    // 생년월일 
	@Column(length = 100)
    private String mbRrno;

    // 성별 
	@Column(length = 100)
    private String mbGender;

    // 대표 이미지 
	@Column(length = 100)
    private Integer mbImg;

    // 탈퇴유무 
	@Column(length = 100)
    private String mbDelyn;

    // 등록일 
	@Column(length = 100)
    private String mbRegdate;

    // 수정일 
	@Column(length = 100)
    private String mbUpddate;
   
    // 마지막 접속일 
	@Column(length = 100)
    private String mbAccessdate;

	
	public Integer getMbIdx() {
		return mbIdx;
	}

	public void setMbIdx(Integer mbIdx) {
		this.mbIdx = mbIdx;
	}

	public String getMbType() {
		return mbType;
	}

	public void setMbType(String mbType) {
		this.mbType = mbType;
	}

	public String getMbId() {
		return mbId;
	}

	public void setMbId(String mbId) {
		this.mbId = mbId;
	}

	public String getMbPwd() {
		return mbPwd;
	}

	public void setMbPwd(String mbPwd) {
		this.mbPwd = mbPwd;
	}

	public String getMbNm() {
		return mbNm;
	}

	public void setMbNm(String mbNm) {
		this.mbNm = mbNm;
	}

	public String getMbTel() {
		return mbTel;
	}

	public void setMbTel(String mbTel) {
		this.mbTel = mbTel;
	}

	public String getMbRrno() {
		return mbRrno;
	}

	public void setMbRrno(String mbRrno) {
		this.mbRrno = mbRrno;
	}

	public String getMbGender() {
		return mbGender;
	}

	public void setMbGender(String mbGender) {
		this.mbGender = mbGender;
	}

	public Integer getMbImg() {
		return mbImg;
	}

	public void setMbImg(Integer mbImg) {
		this.mbImg = mbImg;
	}

	public String getMbDelyn() {
		return mbDelyn;
	}

	public void setMbDelyn(String mbDelyn) {
		this.mbDelyn = mbDelyn;
	}

	public String getMbRegdate() {
		return mbRegdate;
	}

	public void setMbRegdate(String mbRegdate) {
		this.mbRegdate = mbRegdate;
	}

	public String getMbUpddate() {
		return mbUpddate;
	}

	public void setMbUpddate(String mbUpddate) {
		this.mbUpddate = mbUpddate;
	}

	public String getMbAccessdate() {
		return mbAccessdate;
	}

	public void setMbAccessdate(String mbAccessdate) {
		this.mbAccessdate = mbAccessdate;
	}

	public Member(Integer mbIdx, String mbType, String mbId, String mbPwd, String mbNm, String mbTel, String mbRrno,
			String mbGender, Integer mbImg, String mbDelyn, String mbRegdate, String mbUpddate, String mbAccessdate) {
		super();
		this.mbIdx = mbIdx;
		this.mbType = mbType;
		this.mbId = mbId;
		this.mbPwd = mbPwd;
		this.mbNm = mbNm;
		this.mbTel = mbTel;
		this.mbRrno = mbRrno;
		this.mbGender = mbGender;
		this.mbImg = mbImg;
		this.mbDelyn = mbDelyn;
		this.mbRegdate = mbRegdate;
		this.mbUpddate = mbUpddate;
		this.mbAccessdate = mbAccessdate;
	}

	@Override
	public String toString() {
		return "Member [mbIdx=" + mbIdx + ", mbType=" + mbType + ", mbId=" + mbId + ", mbPwd=" + mbPwd + ", mbNm="
				+ mbNm + ", mbTel=" + mbTel + ", mbRrno=" + mbRrno + ", mbGender=" + mbGender + ", mbImg=" + mbImg
				+ ", mbDelyn=" + mbDelyn + ", mbRegdate=" + mbRegdate + ", mbUpddate=" + mbUpddate + ", mbAccessdate="
				+ mbAccessdate + "]";
	}


    
}
