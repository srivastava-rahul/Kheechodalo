package com.click.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecutiryConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		// auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/saveUser/**").permitAll()
				
		//OWNER
		.antMatchers("/user**").hasAnyRole("USER_ROLE")
				// ADMIN
				.antMatchers("/admin**").hasAnyRole("ADMIN")
				.and()
				.formLogin().loginPage("/login")
				.usernameParameter("userName")
				.passwordParameter("password")
				.defaultSuccessUrl("/user/dashboard")
				.failureUrl("/login?error=true")
				.and()
				.logout()
				.invalidateHttpSession(true)
				.logoutSuccessUrl("/login?logout")
				.and()
				//.csrf()
				//.and()
				.exceptionHandling().accessDeniedPage("/invalid-access.jsp")
		        .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout=true").clearAuthentication(true).invalidateHttpSession(true).deleteCookies("JSESSIONID").and().sessionManagement().maximumSessions(1).expiredUrl("/login?expired=true");
	} 

}
