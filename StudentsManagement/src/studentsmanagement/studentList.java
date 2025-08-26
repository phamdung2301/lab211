/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentsmanagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class studentList extends ArrayList<students>{
    public boolean loadFromFile(String filename){
        File f = new File(filename);
        try(
                BufferedReader br = new BufferedReader(new FileReader(f));
        ){
            String line;
            while((line = br.readLine()) != null){
                String[] temp = line.split(" ");
                if(temp.length == 6){
                    String studentID = temp[0];
                    String name = temp[1];
                    int age = Integer.parseInt(temp[2]);
                    String gender = temp[3];
                    String major = temp[4];
                    double gpa = Double.parseDouble(temp[5]);
                    this.add(new students(studentID,name,age,gender,major,gpa));
                }
            }
            br.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return true;
    }
    
    public boolean saveToFile(String filename){
        File f = new File(filename);
        try(
                BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        ){
            for(students s : this){
                bw.write(s.toString());
                bw.newLine();
            }
        bw.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return true;
    }
}
