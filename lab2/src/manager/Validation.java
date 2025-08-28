/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Validation {
    private static Scanner sc = new Scanner(System.in);
    
    public static int getInt(String msg, int min, int max){
        System.out.print(msg);
        while(true){
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if(result >= min && result <= max){
                    return result;
                }
                else{
                    System.out.print("Please input number in range ["+min+"->"+max+"] : ");
                }
            } catch(NumberFormatException e){
                System.out.print("Number must be integer. Enter again: ");
            }
        }
    }
    
    public static double getDouble(String msg, double min, double max) {
        System.out.print(msg);
        while(true){
            try {
                double result = Double.parseDouble(sc.nextLine().trim());
                if(result % 0.5 != 0){
                    System.out.print("Please input ,5 or integer number: ");
                    continue;
                }
                if(result >= min && result <= max){
                    return result;
                }else {
                    System.out.print("Please input number in range ["+min+"->"+max+": ]");
                }
            }catch(NumberFormatException e){
                System.out.print("Number must be double. Enter again: ");
            }
        }
    }
    
    public static String getDate(String msg){
        System.out.print(msg);
        while(true){
            try {
                String result = sc.nextLine().trim();
                SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
                Date date = sf.parse(result);
                if(result.equalsIgnoreCase(sf.format(date))){
                    Date today = new Date();
                    if(date.before(today)){
                        System.out.println("Date cannot be in the past. Please enter again: ");
                    }
                    else{
                        return result;
                    }
                }else{
                    System.out.print("Date not valid. Please enter again: ");
                }
            }catch(ParseException e){
                System.out.println("Please input follow format dd-MM-yyyy. ENter again: ");
            }
        }
    }
    
    public static boolean checkInputYN(){
        while(true){
            String result = sc.nextLine().trim();
            if(result.equalsIgnoreCase("y")){
                return true;
            }
            if(result.equalsIgnoreCase("n")){
                return false;
            }
            System.out.print("Please enter Y/y or N/n");
            System.out.print("Enter again: ");
        }
    }
    
    public static String getString(String msg, String regex){
        System.out.print(msg);
        while(true){
            String result = sc.nextLine().trim();
            if(!result.matches(regex)){
                System.out.println("Please input matches regex: "+regex);
                continue;
            }
            if(result.isEmpty()){
                System.out.println("Please input a non_empty string: ");
                continue;
            }
            return result;
        }
    }
}
