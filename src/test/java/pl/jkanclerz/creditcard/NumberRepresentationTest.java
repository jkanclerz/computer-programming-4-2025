package pl.jkanclerz.creditcard;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NumberRepresentationTest {

    @Test
    void doubleTest() {
        double a = 0.02;
        double b = 0.03;
        System.out.println("Double");
        System.out.println(b - a);
    }

    @Test
    void floatTest() {
        float a = 0.002f;
        float b = 0.003f;
        System.out.println("Float");
        System.out.println(a - b);
    }

    @Test
    void bigDecimalTest() {
        BigDecimal a = new BigDecimal("0.002");
        BigDecimal b= new BigDecimal("0.003");

        System.out.println("Big Decimal");
        System.out.println(a.subtract(b));
    }
}
