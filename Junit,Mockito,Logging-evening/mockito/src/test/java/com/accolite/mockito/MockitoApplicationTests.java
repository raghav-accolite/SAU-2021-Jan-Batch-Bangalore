package com.accolite.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MockitoApplicationTests {

    Demo1 demo1 = new Demo1();
    Demo2 demo2 = new Demo2();

    @Test
    public void testToUpperCase() {
        System.out.println("Testing toUpperCase Method");
        Demo1 demo1 = mock(Demo1.class);
        when(demo1.getName()).thenReturn("Accolite");
        String str = demo2.upperCaseConversion(demo1);
        assertEquals("ACCOLITE", str);
    }

    @Test
    public void testAverage() {
        System.out.println("Testing Average Method");
        Demo1 demo1 = mock(Demo1.class);
        int arr[] = {2, 2, 2, 2, 2, 2};
        when(demo1.getMarks()).thenReturn(arr);
        int average = demo2.average(demo1);
        assertEquals(2, average);
    }

    @Test
    public void testgetMax(){
        System.out.println("Testing Max Method");
        Demo2 obj = mock(Demo2.class);
        int arr[] = {1,2,3,4,5};
        when(obj.getNumbers()).thenReturn(arr);
        int res = demo1.getMax(obj);
        assertEquals(5,res);
    }

    @Test
    public void testSubstring(){
        System.out.println("Testing SubString Method");
        Demo2 obj = mock(Demo2.class);
        String str = "Software Developer Intern";
        when(obj.getDepartment()).thenReturn(str);
        String res = demo1.subStringCalc(obj);
        assertEquals("Software",res);
    }
}
