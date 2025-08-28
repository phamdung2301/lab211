/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import manager.ManagerTask;
import manager.Validation;

/**
 *
 * @author ADMIN
 */
public class Menu {
    public void display(){
        ManagerTask manager = new ManagerTask();
        int choice;
        System.out.println("====Task Program====");
        do{
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Show Task");
            System.out.println("4. Exit");
            choice = Validation.getInt("Enter your choice: ", 1, 4);
            switch(choice){
                case 1:
                    manager.addTask();
                    break;
                case 2:
                    manager.deleteTask();
                    break;
                case 3:
                    manager.displayTask();
                    break;
                case 4:
                    break;
            }
        }while(true);
    }
}
