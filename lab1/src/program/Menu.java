/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program;

import Validation.Validation;
import object.Binary;
import object.Decimal;
import object.HexaDecimal;

/**
 *
 * @author ADMIN
 */
public class Menu {
    public void displayProgram(){
        Binary binary = new Binary();
        Decimal decimal = new Decimal();
        HexaDecimal hexa = new HexaDecimal();
        
        int choice;
        do{
            System.out.println("==Change base system program==");
            System.out.println("1. Change Binary");
            System.out.println("2. Change Decimal");
            System.out.println("3. Change HexaDecimal");
            System.out.println("4. Exit");
            choice = Validation.getInt("Enter your choice: ", 1, 4);
            switch(choice) {
                case 1:
                    binary.inputBinary();
                    binary.convertFromBinary(binary.getBinary());
                    break;
                case 2:
                    decimal.inputDecimal();
                    decimal.convertFromDecimal(decimal.getDecimal());
                    break;
                case 3: 
                    hexa.inputHexa();
                    hexa.convertFromHexa(hexa.getHexa());
                    break;
                case 4:
                    break;
            }
        }while(true);
    }
}
