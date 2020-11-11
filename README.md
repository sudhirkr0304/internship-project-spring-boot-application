# internship-project-spring-boot-application

 ## steps to setup the project 

1 . Clone the project into the local system.

    https://github.com/sudhirkr0304/internship-project-spring-boot-application.git
  
2 . Create mysql database

    create database users_database;
   
3 . open src/main/resources/application.properties

    change username and password
    
4 . run tha app in development mode

      mvn sping-boot:run
      
5 . application will start running on http://localhost:8080

6 . explore the api

       GET - http://localhost:8080/suppliers - get all the suppliers .
       
       GET - http://localhost:8080/suppliers/{id} - get supplier by supplier id .
       
       POST - http://localhost:8080/suppliers - post the data to the supplier.
       
       GET - http://localhost:8080/catalogs - get all the catalogs.
       
       GET - http://localhost:8080/catalogs/{id} - get the catalog by catalog id.
       
       POST - http://localhost:8080/catalogs - add the data into the catalogs.
       
       GET - http://localhost:8080/catalogs/suppliers/{id} - seach the catalog by supplier id .
       
       GET - http://localhost:8080/catalogs/catalogs/{skuName} - seach the catalog SKU Name( FULL or PARTIAL) 
       
      
      
      

     
