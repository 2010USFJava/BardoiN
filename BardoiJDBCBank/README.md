# BardoiJDBCBank

BardoiJDBCBank is a console based simple banking app that takes user input. Listed below is the admin username and password which is in the database.properties file. 

        adminuser: admin
        adminpass: adpass

# Instructions
- Clone this repository to your machine.
- Set up your database in Amazon RDS through the AWS website.
- Save the endpoint connection(url), the username, and the password used to set up your database.
- Add these values into the database.properties file.
- Set up a connection in DBeaver using the url to establish a connection.
- Run the JDBCBank.sql file to create a new schema and create new tables.
- Run the application in Spring Tool Suite and the console application is ready for you to use.

### Required Technologies
  - Maven
  - PostgreSQL
  - AWS RDS
  - JUnit
  - Log4J

### Required in database.properties file

        url: the endpoint connection used to connect to the RDS database.
        username: the user name to connect to the database with (use database username)
        password: the password to use for the login (use database password)
        adminuser: username created for the admin (above)
        adminpass: password created for the admin (above)

### Agile Requirements
 - Develop using the agile methodologies taught in class
 - You should be using TDD (see JUnit4 requirements)
 - All transactions should be logged (see Log4J requirements)

### Java Requirements
 - Build the application using Java 8
 - All interaction with the user should be done through the console using the Scanner class

### Business Requirements
- A registered user can login with their username and password
- An unregistered user can register by creating a username and password
- An Admin can view, create, update, and delete all users.
- A user can view their own existing accounts and balances.
- A user can create an account.
- A user can delete an account if it is empty.
- A user can add to or withdraw from an account.
- A user can execute multiple deposits or withdrawals in a session.
- A user can logout.

### Required Components
- A registered user can login with their username and password
- An unregistered user can register by creating a username and password
- An Admin can view, create, update, and delete all users.
- A user can view their own existing accounts and balances.
- A user can create an account.
- A user can delete an account if it is empty.
- A user can add to or withdraw from an account.
- A user can execute multiple deposits or withdrawals in a session.
- A user can logout.