package com.boot.my.thumbsup.domains.Admin.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tb_admin")
public class Admin {
 
	public Admin() {}
	
	public Admin(Long admin_idx, String adminType, String adminDepart, String adminRank, String adminId,
			String adminPwd, String adminNm, String adminTel, String adminRrno, String adminGender, Integer adminImg,
			String adminUseyn, String adminDelyn, String adminRegdate, String adminUpddate, String adminGrant,
			String adminAccessdate, String adminToken) {
		super();
		this.admin_idx = admin_idx;
		this.adminType = adminType;
		this.adminDepart = adminDepart;
		this.adminRank = adminRank;
		this.adminId = adminId;
		this.adminPwd = adminPwd;
		this.adminNm = adminNm;
		this.adminTel = adminTel;
		this.adminRrno = adminRrno;
		this.adminGender = adminGender;
		this.adminImg = adminImg;
		this.adminUseyn = adminUseyn;
		this.adminDelyn = adminDelyn;
		this.adminRegdate = adminRegdate;
		this.adminUpddate = adminUpddate;
		this.adminGrant = adminGrant;
		this.adminAccessdate = adminAccessdate;
		this.adminToken = adminToken;
		
	}


	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long admin_idx;

    // 관리자유형 
	@Column(length = 100)
    private String adminType;

    // 부서 
	@Column(length = 100)
    private String adminDepart;

    // 직급 
	@Column(length = 100)
    private String adminRank;

    // 아이디 
	@Column(length = 100)
    private String adminId;

    // 비밀번호 
	@Column(length = 255)
    private String adminPwd;

    // 이름 
	@Column(length = 100)
    private String adminNm;

    // 전화번호 
	@Column(length = 100)
    private String adminTel;

    // 생년월일 
    @Column(length = 100)
    private String adminRrno;

    // 성별 
    @Column(length = 100)
    private String adminGender;

    // 대표 이미지 
    @Column(length = 100)
    private Integer adminImg;

    // 사용유무 
    @Column(length = 100)
    private String adminUseyn;

    // 탈퇴유무 
    @Column(length = 100)
    private String adminDelyn;

    // 등록일 
    private String adminRegdate;

    // 수정일 
    private String adminUpddate;

    // 권한 
    @Column(length = 100)
    private String adminGrant;
    
    // 마지막 접속일 
    private String adminAccessdate;

    // token
    private String adminToken;
    
	public Long getAdmin_idx() {
		return admin_idx;
	}

	public void setAdmin_idx(Long admin_idx) {
		this.admin_idx = admin_idx;
	}

	public String getAdminType() {
		return adminType;
	}

	public void setAdminType(String adminType) {
		this.adminType = adminType;
	}

	public String getAdminDepart() {
		return adminDepart;
	}

	public void setAdminDepart(String adminDepart) {
		this.adminDepart = adminDepart;
	}

	public String getAdminRank() {
		return adminRank;
	}

	public void setAdminRank(String adminRank) {
		this.adminRank = adminRank;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	public String getAdminNm() {
		return adminNm;
	}

	public void setAdminNm(String adminNm) {
		this.adminNm = adminNm;
	}

	public String getAdminTel() {
		return adminTel;
	}

	public void setAdminTel(String adminTel) {
		this.adminTel = adminTel;
	}

	public String getAdminRrno() {
		return adminRrno;
	}

	public void setAdminRrno(String adminRrno) {
		this.adminRrno = adminRrno;
	}

	public String getAdminGender() {
		return adminGender;
	}

	public void setAdminGender(String adminGender) {
		this.adminGender = adminGender;
	}

	public Integer getAdminImg() {
		return adminImg;
	}

	public void setAdminImg(Integer adminImg) {
		this.adminImg = adminImg;
	}

	public String getAdminUseyn() {
		return adminUseyn;
	}

	public void setAdminUseyn(String adminUseyn) {
		this.adminUseyn = adminUseyn;
	}

	public String getAdminDelyn() {
		return adminDelyn;
	}

	public void setAdminDelyn(String adminDelyn) {
		this.adminDelyn = adminDelyn;
	}

	public String getAdminRegdate() {
		return adminRegdate;
	}

	public void setAdminRegdate(String adminRegdate) {
		this.adminRegdate = adminRegdate;
	}

	public String getAdminUpddate() {
		return adminUpddate;
	}

	public void setAdminUpddate(String adminUpddate) {
		this.adminUpddate = adminUpddate;
	}

	public String getAdminGrant() {
		return adminGrant;
	}

	public void setAdminGrant(String adminGrant) {
		this.adminGrant = adminGrant;
	}
	
	public String getAdminAccessdate() {
		return adminAccessdate;
	}

	public void setAdminAccessdate(String adminAccessdate) {
		this.adminAccessdate = adminAccessdate;
	}

	public String getAdminToken() {
		return adminToken;
	}

	public void setAdminToken(String adminToken) {
		this.adminToken = adminToken;
	}

	@Override
	public String toString() {
		return "AdminEntity [admin_idx=" + admin_idx + ", adminType=" + adminType + ", adminDepart=" + adminDepart
				+ ", adminRank=" + adminRank + ", adminId=" + adminId + ", adminPwd=" + adminPwd + ", adminNm="
				+ adminNm + ", adminTel=" + adminTel + ", adminRrno=" + adminRrno + ", adminGender=" + adminGender
				+ ", adminImg=" + adminImg + ", adminUseyn=" + adminUseyn + ", adminDelyn=" + adminDelyn
				+ ", adminRegdate=" + adminRegdate + ", adminUpddate=" + adminUpddate + ", adminGrant=" + adminGrant
				+ ", adminAccessdate=" + adminAccessdate
				+ ", adminToken=" + adminToken
				+ "]";
	}

    
    
    
    
}
