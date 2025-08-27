/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validation;

import static java.time.Clock.system;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Validation {
    private static final Scanner sc = new Scanner(System.in);
    
    public static int getInt(String msg, int min, int max){
        while(true){
            try{
                System.out.print(msg);
                int result = Integer.parseInt(sc.nextLine());
                if(result >= min && result <= max){
                    return result;
                }
                else{
                    throw new NumberFormatException();
                }
            }catch (NumberFormatException e){
                System.out.println("Please input number in range: " +min + "->" + max);  
                System.out.println("Enter again: ");
            }
        }
    }
    
    public static String checkInputBinary(){
        System.out.print("Enter numer binary: ");
        String result = "";
        while(true){
            result = sc.nextLine().trim();
            if(result.matches("[0-1]*")){
                return result;
            }
            System.err.println("Must be enter 0 or 1");
            System.out.print("Re-Enter: ");
        }
    }
    
    public static String checkInlutDecimal(){
        System.out.print("Enter numer decimal: ");
        String result = "";
        while(true){
            result = sc.nextLine().trim();
            if(result.matches("[0-9]*")){
                return result;
            }
            System.err.println("Must be enter 0-9");
            System.out.print("re-Enter: ");
        }
    }
    
    public static String checkInputHexa(){
        System.out.print("Enter number hexa: ");
        String result = "";
        while(true){
            result = sc.nextLine().trim();
            if(result.matches("[0-9A-F]*")){
                return result;
            }
            System.err.println("Must be enter 0-9 A-F");
            System.out.print("Re-Enter");
        }
    }
    
    public static int getchoice(String from, String case1, String case2){
        System.out.println("1. Convert from "+from+" to "+case1);
        System.out.println("2. Convert from "+from+" to "+case2);
        int choice = getInt("Enter your choice: ", 1, 2);
        return choice;
    }
}
