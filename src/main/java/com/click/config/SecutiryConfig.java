package com.click.config;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.click.handler.AppAuthenticationFailureHandler;
import com.click.handler.AppAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecutiryConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;

	@Autowired
	AppAuthenticationSuccessHandler authenticationSuccessHandler;

	@Autowired
	AppAuthenticationFailureHandler authenticationFailureHandler;

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// Spring Security should completely ignore URLs starting with
		// /resources/
		web.ignoring().antMatchers("/resources/**");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/saveUser/**").permitAll()

				// OWNER
				.antMatchers("/user**").hasAnyRole("USER_ROLE")
				// ADMIN
				.antMatchers("/admin**").hasAnyRole("ROLE_ADMIN").and().formLogin().loginPage("/login").permitAll()
				.usernameParameter("userName").passwordParameter("password")
				.successHandler(authenticationSuccessHandler).failureHandler(authenticationFailureHandler).and()
				.logout().invalidateHttpSession(true).logoutSuccessUrl("/login?logout").and().exceptionHandling()
				.accessDeniedPage("/invalid-access.jsp").and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout=true")
				.clearAuthentication(true).invalidateHttpSession(true).deleteCookies("JSESSIONID").and()
				.sessionManagement().maximumSessions(1).expiredUrl("/login?expired=true");
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
		return authenticationProvider;
	}

	@Bean
	public AuthenticationManager authenticationManager() {
		List<AuthenticationProvider> providers = new LinkedList<AuthenticationProvider>();
		providers.add(authenticationProvider());
		ProviderManager pm = new ProviderManager(providers);
		return pm;
	}

	@Bean
	public UsernamePasswordAuthenticationFilter getUsernamePasswordAuthenticationFilter() {
		UsernamePasswordAuthenticationFilter filter = new UsernamePasswordAuthenticationFilter();
		filter.setAuthenticationManager(authenticationManager());
		filter.setUsernameParameter("username");
		filter.setPasswordParameter("password");
		filter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login", "POST"));
		return filter;
	}

}
