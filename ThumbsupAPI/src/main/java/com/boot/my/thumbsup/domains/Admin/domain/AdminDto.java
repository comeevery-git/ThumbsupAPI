package com.boot.my.thumbsup.domains.Admin.domain;

public class AdminDto {

	private Long admin_idx;
    private String adminType;
    private String adminDepart;
    private String adminRank;
    // 아이디 
    private String adminId;
    // 비밀번호 
    private String adminPwd;
    // 이름 
    private String adminNm;
    // 전화번호 
    private String adminTel;
    // 생년월일 
    private String adminRrno;
    // 성별 
    private String adminGender;
    // 대표 이미지 
    private Integer adminImg;
    // 사용유무 
    private String adminUseyn;
    // 탈퇴유무 
    private String adminDelyn;
    // 등록일 
    private String adminRegdate;
    // 수정일 
    private String adminUpddate;
    // 권한 
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

	public Admin toEntity() {
		return new Admin(
				admin_idx,
				adminType,
				adminDepart,
				adminRank,
				adminId,
				adminPwd,
				adminNm,
				adminTel,
				adminRrno,
				adminGender,
				adminImg,
				adminUseyn,
				adminDelyn,
				adminRegdate,
				adminUpddate,
				adminGrant,
				adminAccessdate,
				adminToken
				);
	}

    
    
}
