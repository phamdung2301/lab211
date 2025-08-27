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
public class Binary {
    private String binary;
    public Binary(){
    }
    
    public Binary(String binary){
        this.binary = binary;
    }
    
    public String getBinary(){
        return binary;
    }
    
    public void setBinary(String binary){
        this.binary = binary;
    }
    
    private String convertBinaryToDecimal(){
        char binaryChars[] = binary.toCharArray();
        int log = binaryChars.length - 1;
        int re = 0;
        for(int i=0 ;i< binaryChars.length;i++){
            re += (binaryChars[i] - '0')*Math.pow(2,log);
            log--;
        }
        return Integer.toString(re);
    }
    
    public String convertBinaryToDecimal(String binary){
        char binaryChars[] = binary.toCharArray();
        int log = binaryChars.length - 1;
        int re = 0;
        for(int i=0 ;i< binaryChars.length;i++){
            re += (binaryChars[i] - '0')*Math.pow(2,log);
            log--;
        }
        return Integer.toString(re);
    }    
    
    public String convertBinaryToHexa(String binary){
        String decimal = this.convertBinaryToDecimal(binary);
        Decimal dc = new Decimal();
        return dc.convertDecimalToHexa(decimal);
    }
    
    public void inputBinary(){
        binary = Validation.checkInputBinary();
    }
    
    public void convertFromBinary(String binary){
        int choice = Validation.getchoice("Binary", "Decimal", "HexaDecimal");
        switch(choice){
            case 1:
                System.out.println("Decimal: "+ convertBinaryToDecimal(binary));
                break;
            case 2:
                System.out.println("HexaDecimal: "+ convertBinaryToHexa(binary));
                break;
        }
    }

}
