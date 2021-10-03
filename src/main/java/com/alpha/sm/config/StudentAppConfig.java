package com.alpha.sm.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration // To set this class as Configuration file
@EnableWebMvc // To Enable all MVC Features
@ComponentScan(basePackages = { "com.alpha.sm" }) // To scan all the @Component/@Controller classes to maintain in bean
													// containers by Spring
@PropertySource("classpath:db.connection.properties")
public class StudentAppConfig implements WebMvcConfigurer {

	@Bean
	public InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver("/WEB-INF/view/", ".jsp");

		return viewResolver;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
//		String url="jdbc:mysql://localhost:3306/alphatraining?useSSL=false";
//		String username="root";
//		String password="Skyl@lph@1";
//		String driver="com.mysql.cj.jdbc.Driver";
//		
//		
//		DriverManagerDataSource dataSource=new DriverManagerDataSource(url, username, password);
//		dataSource.setDriverClassName(driver);
//		
//		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}

	public DataSource dataSource() {
		String url = "jdbc:mysql://localhost:3306/alphatraining?useSSL=false";
		String username = "root";
		String password = "Skyl@lph@1";
		String driver = "com.mysql.cj.jdbc.Driver";

		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);
		dataSource.setDriverClassName(driver);

		return dataSource;

	}
	
	//Resources path handler for CSS file to load
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		System.out.println("Create Resources Path URL fo CSS file load");
		//till Resource Folder
		registry
			.addResourceHandler("/URLtoReachResourcesFolder/**")
			.addResourceLocations("/resources/");
	
		//till CSS Folder
		registry
		.addResourceHandler("/URLtoReachCSSFolder/**")
		.addResourceLocations("/resources/css/");
		//till Images folder
		registry
		.addResourceHandler("/URLtoReachImagesFolder/**")
		.addResourceLocations("/resources/images/");
		
	}

}
