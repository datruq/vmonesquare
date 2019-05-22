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

## Building and running this application

1. Open a command line window or terminal.
2. Navigate to the root directory of the project, where the pom.xml resides.
3. Compile the project: ```maven clean build ```.
4. Change into the target directory: cd build/libs
5. You should see the file name: vmonesquareapp-1.0.jar.
6. Execute the JAR: ``` java -jar vmonesquareapp-1.0.jar```.
7. The application should be available at http://localhost:8080/vm/getItem.

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


## Authors

* **David Trujillo** - *Initial work* - [datruq](https://github.com/datruq)

