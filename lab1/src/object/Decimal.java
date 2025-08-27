/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import Validation.Validation;

/**
 *
 * @author ADMIN
 */
public class Decimal {
    private String decimal;
    
    public Decimal(){
        
    }
    
    public Decimal(String decimal){
        this.decimal = decimal;
    }
    
    public String getDecimal(){
        return decimal;
    }
    
    public void setDecimal(String decimal){
        this.decimal = decimal;
    }
    
    public String convertDecimalToBinary(String decimal){
        int n = Integer.parseInt(decimal);
        String re = "";
        while(n != 0){
            re += Integer.toString(n % 2);
            n = n/2;
        }
        String reversed = new StringBuilder(re).reverse().toString();
        return reversed;
    }
    
    public String convertDecimalToBinary(){
        int n = Integer.parseInt(decimal);
        String re = "";
        while(n != 0){
            re += Integer.toString(n % 2);
            n = n/2;
        }
        String reversed = new StringBuilder(re).reverse().toString();
        return reversed;
    }
    
    public String convertDecimalToHexa(String decimal){
        int n = Integer.parseInt(decimal);
        String re = "";
        while(n != 0){
            int temp = n % 16;
            switch(temp){
                case 10:
                    re += "A";
                    break;
                case 11:
                    re += "B";
                    break;
                case 12:
                    re += "C";
                    break;
                case 13:
                    re += "D";
                    break;
                case 14:
                    re += "E";
                    break;
                case 15:
                    re += "F";
                    break;
                default:
                    re += Integer.toString(temp);
            }
            n = n/16;
        }
        String reversed = new StringBuilder(re).reverse().toString();
        return reversed;        
    }
    
    public String convertDecimalToHexaUsingArr(){
        int n = Integer.parseInt(decimal);
        StringBuilder sb = new StringBuilder();
        char[] hexChars = "0123456789ABCDEF".toCharArray();
        
        while(n != 0){
            int temp = n % 16;
            sb.insert(0,hexChars[temp]);
            n /= 16;
        }
        return sb.toString();
    }
    
    public void inputDecimal(){
        decimal = Validation.checkInlutDecimal();
    }
    
    public void convertFromDecimal(String decimal){
        int choice = Validation.getchoice("Decimal", "Binary", "HexaDecimal");
        switch(choice){
            case 1:
                System.out.println("Binary: "+ convertDecimalToBinary(decimal));
                break;
            case 2:
                System.out.println("Hexadecimal: "+ convertDecimalToHexa(decimal));
                break;
        }
    }
}
