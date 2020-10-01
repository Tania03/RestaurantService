package com.practice;

/**
 * @author tania.gupta
 * @date 08/08/20
 */
public class Rounding {

    public static void main(String[] args) {

        int i = 3594; //554 , 1108

        System.out.println("Ceil : " + Math.ceil(i / 10.0));
        System.out.println("Round : " + Math.round(i / 10.0));

        //rounding up all digits to zero
        System.out.println( (int)(Math.ceil(i / 10.0) * 10));

        //rounding up all digits to nine
        System.out.println( (int)(Math.ceil(i / 10.0) * 10) - 1);

        int lastDigit = i % 10;
        //rounding off all digits to zero
        if(lastDigit == 5)
            System.out.println((int)(Math.round( i / 10.0) * 10) - 10);
        else
            System.out.println((int)(Math.round( i / 10.0) * 10));

        //rounding off all digits to zero
        if(lastDigit == 5)
            System.out.println((int)(Math.round( i / 10.0) * 10) - 11);
        else
            System.out.println((int)(Math.round( i / 10.0) * 10) - 1);

        //rounding up specific digits to zero
        System.out.println( (int)(Math.round( i / 10.0) * 10));

        //rounding up specific digits to nine
        System.out.println( (int)(Math.round( i / 10.0) * 10) - 1);







    }
}
