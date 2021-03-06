package com.boot.api.thumbsup.domains.member.domain;

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

/*
 * SpringSecurity의 보안을 적용하기 위해 User entity에 UserDetails Class를 상속받아 추가 정보를 재정의 합니다.
 * roles는 회원이 가지고 있는 권한 정보이고, 가입했을 때는 기본 “ROLE_USER”가 세팅됩니다.
 * 권한은 회원당 여러 개가 세팅될 수 있으므로 Collection으로 선언합니다.
getUsername은 security에서 사용하는 회원 구분 id입니다. 여기선 uid로 변경합니다.
다음 값들은 Security에서 사용하는 회원 상태 값입니다. 여기선 모두 사용 안 하므로 true로 설정합니다.
Json결과로 출력 안 할 데이터는 @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) 어노테이션을 선언해줍니다.

isAccountNonExpired – 계정이 만료가 안되었는지
isAccountNonLocked – 계정이 잠기지 않았는지
isCredentialsNonExpired – 계정 패스워드가 만료 안됬는지
isEnabled – 계정이 사용 가능한지
 */


@Builder // builder를 사용할수 있게 합니다.
@Entity // jpa entity임을 알립니다.
@Getter // user 필드값의 getter를 자동으로 생성합니다.
@NoArgsConstructor // 인자없는 생성자를 자동으로 생성합니다.
@AllArgsConstructor // 인자를 모두 갖춘 생성자를 자동으로 생성합니다.
@Table(name = "tb_member") // 'user' 테이블과 매핑됨을 명시
public class Member implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mbIdx;
    
    // 아이디
    @Column(nullable = false, unique = true, length = 30)
    private String mbId;
    
    // 비밀번호 
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false, length = 100)
    private String mbPwd;
    
    // 이름 
    @Column(nullable = false, length = 100)
    private String mbNm;
    
    // 전화번호 
    @Column(nullable = true, length = 100)
    private String mbTel;
    
    // 생년월일 
    @Column(nullable = false, length = 100)
    private String mbRrno;
    
    // 성별 
    @Column(nullable = true, length = 100)
    private String mbGender;
    
    // 대표 이미지 
    @Column(nullable = true, length = 100)
    private Integer mbImg;
    
    // 탈퇴유무 
    @Column(nullable = false, length = 100)
    private String mbDelyn;
    
    // 등록일 
    @Column(nullable = false, length = 100)
    private String mbRegdate;
    
    // 수정일 
    @Column(nullable = false, length = 100)
    private String mbUpddate;
    
    // 마지막접속일 
    @Column(nullable = true, length = 100)
    private String mbAccessdate;
    
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
        return this.mbId;
    }
    
    @Override
    public String getPassword () {
        return this.mbPwd;
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