/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package students;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
    Classes class1 = new Classes("SE20A01", "SE");
    Days day1 = new Days(23,01,2005);
    Students students1 = new Students(1,"Pham Ha Dac Dung",day1,4.0,class1);
        System.out.println(students1.printFacultyNameOfStudent());
    }
}
