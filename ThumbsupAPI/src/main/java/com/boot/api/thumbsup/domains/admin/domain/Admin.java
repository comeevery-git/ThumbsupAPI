package com.boot.api.thumbsup.domains.admin.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Getter
@NoArgsConstructor // 인자없는 생성자를 자동으로 생성합니다.
@AllArgsConstructor
@Table(name = "tb_admin")
public class Admin implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }
    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public String getUsername() {
        return this.adminId;
    }
    
    @Override
    public String getPassword () {
        return this.adminPwd;
    }
    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isEnabled() {
        return true;
    }

    
}
