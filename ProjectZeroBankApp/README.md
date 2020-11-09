# Byte Bank -- Project Zero Bank App

### Description
The Bank app is a console-based application that simulates banking operations. A customer can apply for an account, view their balance, and make withdrawals and deposits. An employee can approve or deny accounts and view account balances for their customers.

### Purpose
To see that you can meet deadlines and that you can code. You are expected to complete the following requirements and give a 5 minute presentation of your project.

### Requirements
 - Built as a Maven project in Java 8.
 - All user interaction done through the console using the Scanner class
 - Customers:
    - (a) Apply for an account.
    - (b) View their balance.
    - (c) Make Withdrawals.
    - (d) Make Deposits.
  - Employees:
     - (a) Approve accounts
     - (b) Deny accounts
     - (c) View account balances for their customers.
     - (d) View customer information
   - Admins can view and edit all accounts, this includes:
     - (a) Approving
     - (b) Denying
     - (c) Withdrawing
     - (d) Depositing
     - (e) Transferring from all accounts
     - (f) Canceling accounts
      
- All basic validation should be done, such as trying to input negative amounts, overdrawing from accounts etc.
- All information should be persisted using text files and serialization via Object Input/Output Stream
- 100% test coverage is expected using J-Unit
- You should be using Test Driven Development(TDD): Writing test first, then writing code to pass that test.
- Logging should be accomplished using Log4J, All transactions should be logged
