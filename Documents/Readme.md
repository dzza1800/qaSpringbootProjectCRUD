Coverage: 
# Full stack application - Daniyal Abbas

This project was made with the sole purpose to allow users to interact with crud operations through a website. Using Spring boot for the installation of the back-end in java, with maven being the dependancy management system used and mySQL for data storation and manipulation. The project was allowed to be themed at the developer's discretion and must have the ability to create, read, update and delete assets. At the end a full stack project is then developed and the theme chosen was a crypto coin management system where the database has no relationships and are single to its own data, the tables chosen for this were a miner account table, coin table with a 24% rate and value and finally a final table for blockchain transactions and the number of coins mined/sent and whether it has been processed or not. The function and purpose of this is to keep a record for many things, miner's incentives, how much they mined etc, the number of miners and their details and so on, as mining is already a hard task, keeping a record can help everyone, a miner can use this information to keep in track of their incentives and the rate of crypto, an investor can see a daily statistic of the coins and how much coin exist atm, and finally an admin can use this site to see the number of miners and check whether a coin is worth investing to or not, all in all, this is more of a learning site than an actual management site, but works both ways. This project was also developed with scalability in mind for the ability to improve this project in the future with better features and easier maintenance.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

Maven is required for the use of unit testing and integration testing.
JUnit is used for unit testing, is a unit testing framework, used in a pom file as a dependancy on maven.<br />
Mockito is used for integration testing, is a mocking framework for java for unit testing also. Used in a pom file as a dependancy on maven. <br />
Eclipse for IDE or any other Java compatible IDE. Can be installed from their official sites Eclipse, intelliJ etc. <br />
MySQL is installed for the use of a database, can be installed by mySQL official site. <br />
Spring boot is installed for the use of back-end programming which is then used to link to a front-end for user interaction<br />


### Installing

A step by step series of examples that tell you how to get a development env running

Say what the step will be
<br />
Maven must be installed to be able to use dependencies this being mockito, JDBC and JUnit.
<br />
Using the IDE you prefer, import the project onto it by clicking on file > import > file system (on Eclipse), since it is a maven project, it automatically imports as a maven project.
![Import Image](import.PNG)
<br />
Any dependencies that were used for the skeleton are also imported.
<br />
User can update dependencies with new versions if they choose to do so.
<br />
There are two ways to install springboot, first being to download the springboot ide and can then start of the program, similar to the installation of eclipse. [SpringToolSuite](https://spring.io/tools)
<br />
The second being if you have eclipse, you can go to the marketplace and install spring tools, by going onto help -> eclipse marketplace and then searching for spring tools 4 and then installing the extension, after you can start programming in spring boot!
![Import Image](SpringEclipse.PNG)

<br />

## Running the tests

Explain how to run the automated tests for this system. Break down into which tests and what they do
<br />
There were two tests that were undertaken, Unit testing and integration testing.
<br />
Unit testing is a form of testing to test small pieces of code, mainly being variables and constructors to check if they are fit to use. This happens by checking a small piece of code is delivering the expected outcome the developer is trying procure. 
<br />
Integration testing is integrating the modules into a group and are testing. Similar to unit testing but without testing smaller code, its a combined set hence being fit for code that is integrated into different methods and is used to check if the method is fit for use.

### Unit Testing

### Integration Testing
```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Springboot] (https://spring.io/projects/spring-boot) - Back-end programming tool
* [Jira] https://d-abbas-1800.atlassian.net/jira/software/projects/QAP/boards/2
## Versioning

We use [SemVer](http://semver.org/) for versioning.


## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
