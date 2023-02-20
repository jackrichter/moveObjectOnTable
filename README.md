# moveObjectOnTable
Simulate moving an object on a table (eg matrix), without the object fallig off (eg x or y = -1).

**Technical details**  
The application was developed using the following technologies:  
- Java version 17.0.5  
- IntelliJ IDEA Ultimate version 2022.3.2
- Maven version 3.8.7  
- Spring Boot 3 with Lombok dependency (removes a lot of boillerplate code).  
- JUnit 5

**Application**  
This application is a simple simulation of a point inside a table being  
moved by given commands.  
The goal is to keep the point inside the table after finishing moving it (eg command 0).  
The simulation game is run only once.  

**Running the simulation game**  
Fork, clone or download this repository and place it anywhere in your file system.  
Open a Command Prompt and move to the folder 'moveObjectOnTable'.  
Withinn that folder there is a sub-folder 'target' containing the executable jar file.  
While standing in the 'moveObjectOnTable folder run the following command to bring up the simulation game:  
**java -jar target/moveObjectOnTable-0.0.1-SNAPSHOT.jar**  

**Observe**  
In order to be able to run the above command, your system must have a Java Runtime Environment (JDK) software installed.  
You can download it from: "https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html".  
Furthermore a system environment variable pointing to the jdk/bin folder must be set  
so the appropriate commands (java, -jar) can be found.  
The process is easily done and there are planty of clear explanation on Google. 

**Spring Boot**  
Though unusual to choose Spring Boot for developinng a console application, it brings many advantages  
while developing Java code, non less Dependency Injection, many libradies that can easily be incorporated  
should one wish further development options.

**Maven**  
If you need to change anything in the code and want to re-run with the changes,  
you should first, as with the Java JDK, install Maven (https://maven.apache.org/) and set the system variable.  
Then open a Command Prompt in the object folder and run command:  
**>mvn clean package**  

**Test and Coverrage**  
The unit tests where perfomed on the two classes handlin all logic: 'MenuConsole' and 'CommandServiceImpl',  
which is the Iterface 'CommandService' implementation. I chose this setup to demonstrate the ability to let the application evolve in time.  
Testing the 'MenuConsole' class proved to be a bit cumbersome because of some characteristics of Spring Boot and stdin/stdout.  
That’s way chose to create tests that cover combined functionality instead of testing individual methods. 
Thus, the coverage report for this class became a bit wired.  
Tests and coverage for class ‘CommandServiceImpl’ are normal. Gaps a due to not testing boilerplate methods such as getters and setters.  
  
  
  
