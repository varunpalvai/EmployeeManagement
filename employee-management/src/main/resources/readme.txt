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
