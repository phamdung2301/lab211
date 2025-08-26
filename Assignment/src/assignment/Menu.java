/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;
import java.util.*;
/**
 *
 * @author ADMIN
 */
public class Menu {
    public int int_getChoice(ArrayList options) {
    
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.print("Choose 1.." + options.size() + ": ");
            choice = sc.nextInt();
        } while (choice < 1 || choice > options.size());
        return choice;
    }

    public Object ref_getChoice(ArrayList options) {
        int response = int_getChoice(options);
        return options.get(response - 1);
    }
}
