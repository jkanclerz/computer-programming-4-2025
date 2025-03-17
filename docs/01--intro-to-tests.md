# Test Driven Development

Test-Driven Development (TDD), a technique developed by Kent Beck in the late 1990s, 
prioritizes writing tests before functional code as a fundamental part of the software development process. 
This methodology, characterized by the "Red-Green-Refactor" cycle, not only ensures a robust suite of tests for the software 
but also emphasizes the importance of a well-thought-out interface and the continuous improvement of code quality through refactoring.

https://martinfowler.com/bliki/TestDrivenDevelopment.html

## Arrange Act Assert (AAA)

The Arrange-Act-Assert (AAA) framework is a structured approach to writing unit tests, ensuring they are easy to understand and maintain. This framework divides a unit test into three distinct phases:

* **Arrange**: Set up the test by initializing objects and setting the values of the data to be used in the test. This phase involves creating the necessary environment for the test to run.
* **Act**: Execute the specific functionality being tested. This involves calling the method or function with the arranged parameters.
* **Assert**: Verify the outcome of the action against the expected result. This phase checks if the test's execution yields the expected outcome, ensuring the code behaves as intended.

## Libraries 

* JUnit 5 https://junit.org/junit5/
* AssertJ https://assertj.github.io/doc/

## Examples

* Main method testing 
[src/main/java/pl/jkanclerz/hello/App.java](../src/main/java/pl/jkanclerz/hello/App.java)
* TDD
[src/test/java/pl/jkanclerz/hello/HelloTest.java](../src/test/java/pl/jkanclerz/hello/HelloTest.java)