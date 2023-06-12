# Shop items management microservice
Spring-boot application with a REST controller, which expose a Swagger API catalog

## Built With
The following technologies:

- Java
- Spring boot 
- Swagger 
- REST API/JSON
- Docker 

The application expose the following APIs:

-List of the inventory items list (item no, name, amount, inventory code)      

-Read item details (by item no)       

-Withdrawal quantity of a specific item from stock             

-Deposit quantity of a specific item to stock			                                 

-Add item to stock						                                                     

-Delete an item from stock


Data persisted on H2 DB using JPA. The application pack and run from docker.

You can go to swagger-ui and see the API. on local box api docs - http://localhost:8080/v2/api-docs
Herr in Api are used create/read/update and delete the items in the shop,  meanwhile you can use Postman to see the resposes.

Using below command i ceated docker image in my local system and run and tested them:

To create image at root -> docker build --tag=demo:latest . 

DemoApplicationRunDocker.PNG

To run container from image -> docker run -p8887:8888 demo:latest

DockerImageCreation.PNG





