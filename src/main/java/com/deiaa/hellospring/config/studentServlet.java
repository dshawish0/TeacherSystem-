package com.deiaa.hellospring.config;


import com.deiaa.hellospring.controller.ExceptionController;
import com.deiaa.hellospring.dao.StudentDAO;
import com.deiaa.hellospring.dao.StudentDAOImpl;
import com.deiaa.hellospring.dao.TeacherDAO;
import com.deiaa.hellospring.dao.TeacherDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;

@EnableWebMvc
@Configuration
@ComponentScan (value = "com.deiaa")
@PropertySource(("classpath:/application.properties"))
public class studentServlet implements WebMvcConfigurer  {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    private Environment environment;

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver ivr = new InternalResourceViewResolver();
        ivr.setPrefix("/WEB-INF/views/");
        ivr.setSuffix(".jsp");
        ivr.setOrder(0);

        return ivr;
    }
   @Bean
    HandlerExceptionResolver customExceptionResolver () {
        ExceptionController resolver = new ExceptionController();
        Properties mappings = new Properties();
        // Mapping Spring internal error NoHandlerFoundException to a view name
        mappings.setProperty(NoHandlerFoundException.class.getName(), "/error");
        mappings.setProperty(NullPointerException.class.getName(), "/error");
        mappings.setProperty(ClassNotFoundException.class.getName(), "/error");
        mappings.setProperty(Exception.class.getName(), "/error");
        resolver.setExceptionMappings(mappings);
        // Set specific HTTP codes
        resolver.addStatusCode("404", HttpStatus.NOT_FOUND.value());
        resolver.addStatusCode("500", HttpStatus.INTERNAL_SERVER_ERROR.value());
        resolver.setDefaultErrorView("/error");
        resolver.setDefaultStatusCode(200);
        resolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
        resolver.setExceptionAttribute("exception");
        return resolver;
    }

    @Override
    public void addViewControllers( ViewControllerRegistry registry ) {
        registry.addViewController( "/" ).setViewName( "forward:/home" );
        registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
        WebMvcConfigurer.super.addViewControllers( registry );
    }

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Objects.requireNonNull(environment.getProperty("spring.datasource.driver-class-name")));
        dataSource.setUrl(environment.getProperty("spring.datasource.url"));
        dataSource.setUsername(environment.getProperty("spring.datasource.name"));
        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
        return dataSource;
    }


    @Bean
	public StudentDAO getStudentDao() {

        return new StudentDAOImpl(getDataSource());
	}

    @Bean
    public TeacherDAO getTeacherDao() {

        return new TeacherDAOImpl(getDataSource());
    }


}
