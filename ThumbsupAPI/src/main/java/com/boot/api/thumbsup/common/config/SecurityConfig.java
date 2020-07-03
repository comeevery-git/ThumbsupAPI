package com.boot.api.thumbsup.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
	
	/* js, css 경로설정 */
	@Configuration
	public class WebConfig implements WebMvcConfigurer {
	    @Override
	    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/**/*.js").addResourceLocations("/ui/static/");
	        registry.addResourceHandler("/**/*.css").addResourceLocations("/ui/static/");
	    }
	}
	
	/**
    * Spring Security 권한설정
    * JWT Authentication version
    * */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        //http.addFilterBefore(filter,CsrfFilter.class);
        
        http
        // remove csrf and state in session because in jwt we do not need them
        .csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        // add jwt filters (1. authentication, 2. authorization)
//        .addFilter(new JwtAuthenticationFilter(authenticationManager()))
//        .addFilter(new JwtAuthorizationFilter(authenticationManager(),  this.userRepository))
        .authorizeRequests()
        //login 은 모두 접근할 수 있습니다.
        //.antMatchers(HttpMethod.POST, "/login").permitAll()
        .antMatchers("/**").permitAll()
        //admin 경로는 관리자 권한입니다.
        //.antMatchers("/admin/*").hasRole("ADMIN")
        .anyRequest().authenticated();
        /*
		http
			.authorizeRequests()
				.antMatchers("/**").permitAll()
				.and()
				.logout()
				.logoutSuccessUrl("/index");
		
			.formLogin()
				.defaultSuccessUrl("/index")
				.permitAll()
				.and()
			.logout();
		*/
	}
	

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/templates/**");
        web.ignoring().antMatchers("/resources/**").anyRequest();
    }
    
}
