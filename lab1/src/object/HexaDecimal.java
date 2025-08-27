/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

/**
 *
 * @author ADMIN
 */
public class HexaDecimal {
    private String hexa;
    
    public HexaDecimal(){
        
    }
    
    public HexaDecimal(String hexa){
        this.hexa = hexa;
    }
    
    public String getHexa(){
        return hexa;
    }
    
    public void setHexa(String hexa){
        this.hexa = hexa;
    }
    
    public String convertHexaToBinary(){
        String decimal = this.convertHexaToDecimal(this.hexa);
        Decimal d = new Decimal();
        return d.convertDecimalToBinary(decimal);
    }
    
    public String convertHexaToDecimal(String hexa){
        hexa = hexa.toUpperCase();
        int re = 0;
        char hexaCharsModel[] = "0123456789ABCDEF".toCharArray();
        char hexaChars[] = hexa.toCharArray();
        int log = hexaChars.length - 1;
        for(int i=0; i<hexaChars.length;i++){
            for(int j=0;j<hexaCharsModel.length;j++){
                if(hexaChars[i] == hexaCharsModel[j]){
                    re += j * (int)Math.pow(16, log);
                    break;
                }
            }
            log--;
        }
        return Integer.toString(re);
    }
}
