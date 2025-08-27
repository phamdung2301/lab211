/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

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
    
    public String convertBinaryToDecimal(){
        char binaryChars[] = this.binary.toCharArray();
        int log = binaryChars.length - 1;
        int re = 0;
        for(int i=0 ;i< binaryChars.length;i++){
            re += (binaryChars[i] - '0')*Math.pow(2,log);
            log--;
        }
        return Integer.toString(re);
    }
    
    public String convertBinaryToHexa(){
        String decimal = this.convertBinaryToDecimal();
        Decimal dc = new Decimal();
        return dc.convertDecimalToHexa(decimal);
    }
}
