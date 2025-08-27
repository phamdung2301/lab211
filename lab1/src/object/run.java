/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

/**
 *
 * @author ADMIN
 */
public class run {
    public static void main(String[] args){
        HexaDecimal h = new HexaDecimal();
        System.out.println(h.convertHexaToDecimal("d8"));
        Decimal d = new Decimal("216");
        System.out.println(d.convertDecimalToHexa(d.getDecimal()));
    }
}
