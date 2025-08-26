/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student.manager.hashmap;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args){
        StudentManager sm = new StudentManager();
        Scanner sc = new Scanner(System.in);
        sm.loadFromFile("data.txt");
        
        System.out.println("enter id need to find: ");
        String id = sc.nextLine();
        sm.findById(id);
        System.out.println(sm.findById(sm.getStudentMap(), id));
    }
}
