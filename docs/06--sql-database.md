# Allows Java speaks SQL

In order to store, load, sort, and manage data effectively, lets introduce database to our solution

### ToDoes
- Install Java Data Base Connectivity library
- Install required database driver
- Configure database access
- Introduce integration test for the database queries 

### Dependencies

* springboot-starter-jdbc
* h2-database

### SQL Hello world

`localhost:9999/h2-console`

### Integration test

Ensures our code speaks SQL 

`pl.jkanclerz.ecommerce.playground.SqlTest` 

### Integration tests VS Unit tests

* Complexity: `Integration > Unit`
* Time: `Integration > Unit`
* Resources `Integration > Unit`

#### Example

- Database needs to be prepared upfront
- Database needs to be cleaned / reverted to the clear stage before next test run

### CRUD

0. Create table
1. Insert / CREATE
2. Select / READ
3. Update / UPDATE
4. Delete / DELETE

## Files
* [pom.xml](../pom.xml)
* [src/main/resources/application.yaml](../src/main/resources/application.yaml)
* [src/test/java/pl/jkanclerz/ecommerce/playground/SqlTest.java](../src/test/java/pl/jkanclerz/ecommerce/playground/SqlTest.java)

