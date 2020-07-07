package com.boot.api.thumbsup.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.RequiredArgsConstructor;

/*
 * 서버에 보안 설정을 적용합니다.
 * com.rest.api.config.security 하위에 다음 Class를 작성합니다.
 * 아무나 접근 가능한 리소스는 permitAll()로 세팅하고 나머지 리소스는 다음과 같이 ‘ROLE_USER’ 권한이 필요함으로 명시합니다.
 * anyRequest().hasRole(“USER”) 또는 anyRequest().authenticated()는 동일한 동작을 합니다.
위에서 설명했듯이 해당 filter는 UsernamePasswordAuthenticationFilter 앞에 설정해야 합니다.
SpringSecurity 적용 후에는 모든 리소스에 대한 접근이 제한되므로.
Swagger 페이지에 대해서는 예외를 적용해야 페이지에 접근할 수 있습니다.
리소스 접근 제한 표현식은 여러 가지가 있으며 다음과 같습니다.

hasIpAddress(ip) – 접근자의 IP주소가 매칭 하는지 확인합니다.        
hasRole(role) – 역할이 부여된 권한(Granted Authority)과 일치하는지 확인합니다.        
hasAnyRole(role) – 부여된 역할 중 일치하는 항목이 있는지 확인합니다.
ex) access = “hasAnyRole(‘ROLE_USER’,’ROLE_ADMIN’)”        
permitAll – 모든 접근자를 항상 승인합니다.        
denyAll – 모든 사용자의 접근을 거부합니다.        
anonymous – 사용자가 익명 사용자인지 확인합니다.        
authenticated – 인증된 사용자인지 확인합니다.        
rememberMe – 사용자가 remember me를 사용해 인증했는지 확인합니다.        
fullyAuthenticated – 사용자가 모든 크리덴셜을 갖춘 상태에서 인증했는지 확인합니다.
 */


/*@EnableWebSecurity*/
@RequiredArgsConstructor
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final JwtTokenProvider jwtTokenProvider;
    
	@Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
	/**
	    * Spring Security 권한설정
	    * JWT Authentication version
	**/
   @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .httpBasic().disable() // rest api 이므로 기본설정 사용안함. 기본설정은 비인증시 로그인폼 화면으로 리다이렉트 된다.
            .csrf().disable() // rest api이므로 csrf 보안이 필요없으므로 disable처리.
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // jwt token으로 인증하므로 세션은 필요없으므로 생성안함.
            .and()
                .authorizeRequests() // 다음 리퀘스트에 대한 사용권한 체크
                	.antMatchers("/**").permitAll()
                 //   .antMatchers("/*/signin", "/*/signup").permitAll() // 가입 및 인증 주소는 누구나 접근가능
                    .antMatchers(HttpMethod.GET, "index/**").permitAll() // hellowworld로 시작하는 GET요청 리소스는 누구나 접근가능
                    .anyRequest().hasRole("USER") // 그외 나머지 요청은 모두 인증된 회원만 접근 가능
            .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class); // jwt token 필터를 id/password 인증 필터 전에 넣는다
	}
   @Override // ignore check swagger resource
   public void configure(WebSecurity web) {
       web.ignoring().antMatchers(
    		   "/v2/api-docs",
    		   "/swagger-resources/**",
               "/swagger-ui.html",
               "/webjars/**",
               "/swagger/**"
           );
       
       web.ignoring().antMatchers("/templates/**");
       web.ignoring().antMatchers("/resources/**").anyRequest();

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
    * 
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
	}
	*/
	
/*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/templates/**");
        web.ignoring().antMatchers("/resources/**").anyRequest();
    }
*/
	
}
