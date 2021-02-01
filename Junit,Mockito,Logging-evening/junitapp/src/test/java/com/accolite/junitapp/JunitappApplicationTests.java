package com.accolite.junitapp;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JunitappApplicationTests {

    @Test
    public void test1() {
        Leapyear object = new Leapyear();
        boolean res = object.isLeapYear(2012);
        assertEquals(true, res);
    }

    @Test
    public void test2() {
        Leapyear object = new Leapyear();
        boolean res = object.isLeapYear(2021);
        assertEquals(false, res);
    }

    @Test
    public void test3() {
        Leapyear object = new Leapyear();
        boolean res = object.isLeapYear(0004);
        assertEquals(true, res);
    }

    @Test
    public void test4() {
        Leapyear object = new Leapyear();
        boolean res = object.isLeapYear(-2004);
        assertEquals(false, res);
    }

    @Test
    public void test5() {
        Leapyear object = new Leapyear();
        boolean res = object.isLeapYear(2000);
        assertEquals(true, res);
    }

}
