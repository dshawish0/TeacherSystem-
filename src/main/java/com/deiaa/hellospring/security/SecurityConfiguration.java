package com.deiaa.hellospring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;



    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
            throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from users where username=?")
                .authoritiesByUsernameQuery(
                        "select username, role from user_roles where username=?");


//        auth.inMemoryAuthentication().withUser("deiaa@gmail.com").password("{noop}1234")
//                .roles("USER");
//        auth.inMemoryAuthentication().withUser("deiaa@yahoo.com").password("{noop}12345")
//                .roles("USER");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login","/SignUp","/saveTeacher").permitAll()
                .antMatchers("/", "/*Student*/**","/**").access("hasRole('USER')").and()
                .formLogin();
        http.formLogin()
                .loginPage("/login");
        http.formLogin()
                .loginProcessingUrl("/login");

        http.formLogin()
                .defaultSuccessUrl("/home");
    }
}
