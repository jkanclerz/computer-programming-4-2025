package pl.jkanclerz.hello;

import java.util.Collections;

public class App {
    public static void main(String[] args) {
        var name = "Jakub";
        System.out.println(String.format("Hello %s", name));

        System.out.println("It Works");

        int a = 2;
        int b = 5;
        int result = a + b;
        System.out.println(result);

        var myList = Collections.emptyList();

        System.out.println(myList);
    }
}
