package com.socgen.employeeportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by rajnalla on 7/19/2019.
 */
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class EmployeePortalApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(EmployeePortalApplication.class);
    }


}
