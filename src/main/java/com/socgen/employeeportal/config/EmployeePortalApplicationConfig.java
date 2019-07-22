package com.socgen.employeeportal.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by rajnalla on 7/20/2019.
 */
@Configuration
@ComponentScan("com.socgen.employeeportal")
@Import({RepositoryConfig.class})
public class EmployeePortalApplicationConfig {

}
