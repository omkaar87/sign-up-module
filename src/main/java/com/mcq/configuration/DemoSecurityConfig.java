package com.mcq.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter{


	@Autowired
	private DataSource myDataSource;

     @Autowired
    CustomSuccessHandler customSuccessHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {


		//jdbc authentication

		auth.jdbcAuthentication().dataSource(myDataSource);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				.antMatchers("/").hasAnyRole("STUDENT")
				.antMatchers("/admin/**").hasAnyRole("ADMIN")
				.antMatchers("/result/**").hasAnyRole("TEACHER")
			.and()
                .csrf()
                    .ignoringAntMatchers("/h2/**")
            .and()
			.formLogin()
				.loginPage("/loginPage")
                .loginProcessingUrl("/authenticateTheUser")
				.successHandler(customSuccessHandler)
				.permitAll()
			.and()
				.logout()
				.permitAll()
			.and()
				.exceptionHandling().accessDeniedPage("/access-denied");

	}

	@Bean
	public UserDetailsManager userDetailsManager()
	{

		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();

		jdbcUserDetailsManager.setDataSource(myDataSource);

		return jdbcUserDetailsManager;
	}







}
