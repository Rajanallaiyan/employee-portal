# EmployeePortal
Application stack: 
1)Spring Boot, Spring Rest, Log4j2 (For Async logging - Application logs can be found in employee-portal.log file)
2)Swagger 2(Documentation), Actuator (For Monitoring), Hal Browser (For viewing actuator data)
3)Hibernate (For ORM), H2 (For in-memory database)
4)Junit + Mockito (For Unit Testing)
5)Angular8 (For UI)

# Back end Spring Boot main class to be executed to start the application

EmployeePortalApplication

# Rest API Endpoints 

get - http://localhost:8888/employeeportal/employees to view stored Employees in a json format.

get - http://localhost:8888/employeeportal/employee/{id} to view an employee details.

post - http://localhost:8888/employeeportal/employee to save an employee details.

#Sample request body for the above post request

{"employeeId":0,"firstName":"R","lastName":"N","gender":"M","dateOfBirth":"1900-01-16","department":"D1"}

# Navigate Swagger

http://localhost:8888/swagger-ui.html

# Navigate Hal Browser to view Actuator reports

http://localhost:8888/browser/index.html#/

Enter /actuator on the Explorer text box and click Go! button

# UI Development server

Run `ng serve` for a dev server. 

#Navigate UI 
`http://localhost:4200/` to view the Employee Portal UI to Add Employee and to View List of Employees that are stored.


