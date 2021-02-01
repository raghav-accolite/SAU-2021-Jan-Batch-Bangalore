package com.accolite.mockito;

public class Demo1 {

    public Demo2 demo2;

    public int[] getMarks() {
        int arr[] = {1, 2, 3, 4, 5};
        return arr;
    }

    public String getName() {
        return "Aagam";
    }

    public int getMax(Demo2 demo2) {
        int nums[] = demo2.getNumbers();
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        return max;
    }

    public String subStringCalc(Demo2 demo2){
        String str = demo2.getDepartment();
        return str.substring(0,8);
    }


}
