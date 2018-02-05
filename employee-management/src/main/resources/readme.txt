1.To get the access_token run the below url from postman and use this token for subsequent requests

	URL : http://localhost:8090/employeeMgmnt/oauth/token
	TYPE : POST
	username : Shiva
	password : password
	grant_type : password
	
	Response :
	{
    	"access_token": "d00b01e1-667a-4cd9-af3d-153acd7ea9ab",
   		"token_type": "bearer",
    	"refresh_token": "78c7adbe-7569-49c7-91d4-b2ea1dee6e7f",
    	"expires_in": 3599,
    	"scope": "read write trust"
	}
3. To add an employee use the below 
URL : http://localhost:8090/employee/employee?access_token=ad7af328-9da6-49ae-a23e-89444123ff59
TYPE : POST
REQUEST BODY PRAMAMS :

{
    "name": "kiran",
    "designation": "TeamLead"
}

4. To get all employees 
URL : http://localhost:8090/employee/employees?access_token=ad7af328-9da6-49ae-a23e-89444123ff59
TYPE : GET


5.


## INSERT INTO Employee(designation,employee_name)  VALUES('SSE','varun');
## INSERT INTO Employee(designation,employee_name)  VALUES('SE','shiva v');
## INSERT INTO Employee(designation,employee_name)  VALUES('SSE','balaram');
## INSERT INTO Employee(designation,employee_name)  VALUES('SE','shiva chander');
## INSERT INTO Employee(designation,employee_name)  VALUES('TL','Ranadheer');
## INSERT INTO Employee(designation,employee_name)  VALUES('SE','Sai');


## INSERT INTO SKILL(LEVEL,SKILL_NAME) VALUES (6,'JAVA');
## INSERT INTO SKILL(LEVEL,SKILL_NAME) VALUES (7,'HADOOP');
## INSERT INTO SKILL(LEVEL,SKILL_NAME) VALUES (8,'INFORMATICA');
## INSERT INTO SKILL(LEVEL,SKILL_NAME) VALUES (9,'BIG_DATA');

## INSERT INTO Employee_SKILL (EMPLOYEE_ID,SKILL_ID) VALUES (1,1);
## INSERT INTO Employee_SKILL (EMPLOYEE_ID,SKILL_ID) VALUES (1,2);
## INSERT INTO Employee_SKILL (EMPLOYEE_ID,SKILL_ID) VALUES (1,3);
## INSERT INTO Employee_SKILL (EMPLOYEE_ID,SKILL_ID) VALUES (1,4);


## INSERT INTO Employee_SKILL (EMPLOYEE_ID,SKILL_ID) VALUES (2,1);
## INSERT INTO Employee_SKILL (EMPLOYEE_ID,SKILL_ID) VALUES (2,2);
## INSERT INTO Employee_SKILL (EMPLOYEE_ID,SKILL_ID) VALUES (2,3);
## INSERT INTO Employee_SKILL (EMPLOYEE_ID,SKILL_ID) VALUES (2,4);

## INSERT INTO Employee_SKILL (EMPLOYEE_ID,SKILL_ID) VALUES (3,1);
## INSERT INTO Employee_SKILL (EMPLOYEE_ID,SKILL_ID) VALUES (3,2);
## INSERT INTO Employee_SKILL (EMPLOYEE_ID,SKILL_ID) VALUES (3,3);
## INSERT INTO Employee_SKILL (EMPLOYEE_ID,SKILL_ID) VALUES (3,4);

## INSERT INTO Employee_SKILL (EMPLOYEE_ID,SKILL_ID) VALUES (4,1);
## INSERT INTO Employee_SKILL (EMPLOYEE_ID,SKILL_ID) VALUES (4,2);
## INSERT INTO Employee_SKILL (EMPLOYEE_ID,SKILL_ID) VALUES (4,3);
## INSERT INTO Employee_SKILL (EMPLOYEE_ID,SKILL_ID) VALUES (4,4);

## INSERT INTO Employee_SKILL (EMPLOYEE_ID,SKILL_ID) VALUES (5,1);
## INSERT INTO Employee_SKILL (EMPLOYEE_ID,SKILL_ID) VALUES (5,2);
## INSERT INTO Employee_SKILL (EMPLOYEE_ID,SKILL_ID) VALUES (5,3);
## INSERT INTO Employee_SKILL (EMPLOYEE_ID,SKILL_ID) VALUES (5,4);

## INSERT INTO Employee_SKILL (EMPLOYEE_ID,SKILL_ID) VALUES (6,1);
## INSERT INTO Employee_SKILL (EMPLOYEE_ID,SKILL_ID) VALUES (6,2);
## INSERT INTO Employee_SKILL (EMPLOYEE_ID,SKILL_ID) VALUES (6,3);
## INSERT INTO Employee_SKILL (EMPLOYEE_ID,SKILL_ID) VALUES (6,4);
