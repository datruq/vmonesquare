# VM Onesquare

Case study for vendor machine API for Onesquare

## Prerequisites

* Java 8
* Maven 4+
* Git
* Lombok on your IDE

## Installing

First we need to clone the project

````git clone https://github.com/datruq/vmonesquare.git````

When it finished clonning and have it in your local machine, just open it with IntelliJ IDE and import all the dependencies with Maven

**Note:** We need to enable annotation processing: Setting/Build, Execution, Deployment/Compiler/Annotation Processors check "Enable annotation processing"

![alt text](https://github.com/datruq/vmonesquare/blob/master/img/lombok_enable_annotation.png)

## Add the CSV file to the next path

* [CSV File](https://github.com/datruq/vmonesquare/blob/master/files/productList.csv)
**C:/test/productList.csv**


## Building and running this application

1. Open a command line window or terminal.
2. Navigate to the root directory of the project, where the pom.xml resides.
3. Compile the project: ```maven clean build ```.
4. Change into the target directory: cd build/libs
5. You should see the file name: vmonesquareapp-1.0.jar.
6. Execute the JAR: ``` java -jar vmonesquareapp-1.0.jar```.
7. The application should be available at http://localhost:8080/vm/postVendorMachine.

## Running the tests

1. Open a command line window or terminal.
2. Navigate to the root directory of the project, where the pom.xml resides.
3. Compile the project: ```maven test --info ```.
4. Change into the target directory: cd build/reports/tests/test.
5. You should see the file name: index.html.
6. Open it with you favorite browser

## Built With

* [Spring](https://spring.io/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Lombok](https://projectlombok.org/) - Java library to simplify the development
* [Junit](http://junit.org/junit4/) Java unit testing framework
* [Mockito](https://site.mockito.org/) Java Mocking framework

## REST API overviiew

With this VendorMachineApp we can get:
* If the user hasn’t added enough money, the app will provide a message indicating they need to add x more cents.
* If the user has added exact money, the app will provide a message indicating they can keep buying.
* If the user has added more than enough money, the app will provide a message indicating they can keep buying, and the extra balance.
* All of a new set of products can be added CSV upload.

**Get postVendorMachine to start or keep buying**

````curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d "{\"cents\": 0.0, \"bills\": 0.0, \"totalAmount\": 0.0, \"vmItem\": {\"code\": \"value1\" }}" http://localhost:8080/vm/postVendorMachine````
![alt text](https://github.com/datruq/vmonesquare/blob/master/img/console-curl-example.jpg)

### Targeting the REST API with Postman
Alternatively to curl, you can use Postman to target the REST API.


**Postman with postVendorMachine Request**
![alt text](https://github.com/datruq/vmonesquare/blob/master/img/postman_postVendorMachine.jpg)

**Postman with postVendorMachine exact amount**
![alt text](https://github.com/datruq/vmonesquare/blob/master/img/postman-exact.jpg)

**Postman with postVendorMachine not enough money**
![alt text](https://github.com/datruq/vmonesquare/blob/master/img/postman-not-enough.jpg)

**Postman with postVendorMachine extra balance**
![alt text](https://github.com/datruq/vmonesquare/blob/master/img/postman-extra-balance.jpg)

## Authors

* **David Trujillo** - *Initial work* - [datruq](https://github.com/datruq)

