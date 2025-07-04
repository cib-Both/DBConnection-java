# DBConnectionTest

This Java project demonstrates how to connect to a MySQL database, execute a query, and process the results using JDBC.

## Prerequisites

- Java Development Kit (JDK) installed
- MySQL server running and accessible
- MySQL Connector/J JAR file (e.g., `mysql-connector-j-9.0.0.jar`)
- A database named `Your_DB_name` with a table named `User`

## Setup

1. Place the MySQL Connector/J JAR file in your project or reference its path in `.vscode/settings.json`.
2. Update the `USER` and `PASSWORD` fields in [`DBConnectionTest.java`](DBConnectionTest.java) with your MySQL credentials.
3. Ensure the `User` table exists in your `DB_name` database with columns: `id`, `User_name`, `Role`, and `password`.

## Running the Program

Compile and run the Java file:

```sh
javac DBConnectionTest.java
java -cp .;c:\mysql-connector-j-9.0.0.jar DBConnectionTest
```

## Notes

- The program prints all rows from the `User` table.
- If the table is empty, it prints "No data found in the User table."
- Make sure your MySQL server is running and accessible at `127.0.0.1:3306`.