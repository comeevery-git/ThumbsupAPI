package com.boot.my.thumbsup.domains.Login.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.boot.my.thumbsup.domains.Admin.domain.Admin;
import com.boot.my.thumbsup.domains.Admin.domain.AdminRepository;
import com.boot.my.thumbsup.domains.Login.domain.Role;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByAdminId(id)
                .orElseThrow(() -> new UsernameNotFoundException(id));

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        
        //admin id가 admin이면, admin 권한 부여
        if (id.equals("admin@naver.com")) {
            grantedAuthorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
            System.out.println("예에에에에에에에 admin");
        //그 외 member 권한 부여
        } else {
            grantedAuthorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
            System.out.println("뇨오오오오오 member");
        }
	
        return new User(admin.getAdminId(), admin.getAdminPwd(), grantedAuthorities);
    }

}