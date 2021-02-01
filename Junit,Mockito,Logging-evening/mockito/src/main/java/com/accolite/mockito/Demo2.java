package com.accolite.mockito;

public class Demo2 {
    public Demo1 demo1;

    public int average(Demo1 demo1) {
        this.demo1 = demo1;
        int arr[] = demo1.getMarks();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum / arr.length;
    }

    public String upperCaseConversion(Demo1 demo1) {
        this.demo1 = demo1;
        String str = demo1.getName();
        return str.toUpperCase();
    }

    public int[] getNumbers() {
        int nums[] = {10, 20, 30, 40, 50};
        return nums;
    }

    public String getDepartment() {
        return "Software Developer Intern";
    }
}
