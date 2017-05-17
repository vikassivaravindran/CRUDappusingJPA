##CUSTOMER CRUD OPERATION

The Customer CRUD Operation with JPA allows the user to interact with the application and perform his/her basic CRUD requests.
The Operations that can be performed are listed below,

1) GetAll Customers
2) Insert a Customer
3) Retrieve a Customer by his CustomerID
4) Update a Customer
5) Delete a Customer

## GET ALL CUSTOMERS

To get the list of customers present,

Try Tools like PostMan or Advanced Rest Client to test the API's

 http://localhost:9085/getAll   Method = GET

presents you the list of customers present in the table named "CUSTOMER" under the database named "microservices"

#INSERT A CUSTOMER

Try the link -> http://localhost:9085/customer/save  Method=POST

	{
    "customerId": 999,
    "customerName": "Mark Twain"
  	}
  	
  with the above mentione JSON and check the result.	
  
  
#RETRIEVE A CUSTOMER 
 
Try the link -> http://localhost:9085/customer/get/{customerId}  Method = GET
  
	 {
    "customerId": 999,
    "customerName": "Mark Twain"
    }
  	
#UPDATE A CUSTOMER  

Try the link -> http://localhost:9085/update   Method = PUT

Supply the customer entity you have already inserted by changing the name say,

	 {
    "customerId": 999,
    "customerName": "Richard Johnson"
    }
  
#DELETE A CUSTOMER

Try the link -> http://localhost:9085/delete/(customerId} METHOD = DELETE

Say for example http://localhost:9085/delete/999

  
  