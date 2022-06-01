package com.unittwo.main;

import java.util.Scanner;
public class Test {
    static int max;
    static Scanner scanner;
    public static void main(String[] args){
        scanner = new Scanner(System.in);
        System.out.print("Max value? ");
        max = scanner.nextInt();
        
        
        for (int i=1; i<=max; i++) {
            if (i%15==0) {                                            
                System.out.print("FizzBuzz"+" ");
            }else if (i%5==0) {    
                System.out.print("Buzz"+" ");
            } else if (i%3==0) {    
                System.out.print("Fizz"+" ");    
            }else 
                System.out.print(i+" ");                        
        }
    }

}
