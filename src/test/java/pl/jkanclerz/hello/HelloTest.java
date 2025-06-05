package pl.jkanclerz.hello;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloTest {

    @Test
    void helloTest() {
        //A / Arrange  / Given
        var a = 2;
        var b = 4;
        //A / Act      / When
        var result = a + b;
        //A / Assert   / Then / Expected
        assert 6 == result;
    }

    @Test
    void itFail() {
        //A / Arrange  / Given
        var a = 2;
        var b = 4;
        //A / Act      / When
        var result = a + b;
        //A / Assert   / Then / Expected
        assert 10 == result;
    }

    @Test
    void itGreetUsername() {
        //Arrange
        String name = "Jakub";
        //Act
        String message = String.format("Hello %s", name);
        //Assert
        assertEquals("Hello Jakub", message);
    }

    @Test
    void listExpectedToBeEmpty() {
        var list = new ArrayList<>();

        list.add("Jakub");
        list.remove(0);

        assert list.isEmpty();
    }
}
