/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student.manager.hashmap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author ADMIN
 */
public class StudentManager {
    
    private HashMap<String, Student> studentMap = new HashMap<>();
    public void loadFromFile(String filename){
        File f = new File(filename);
        try(
                BufferedReader br = new BufferedReader(new FileReader(f));
            ){
                String line;
                while((line = br.readLine()) != null){
                    String[] parts = line.split(",");
                    if(parts.length == 4){
                        String id = parts[0].trim();
                        String name = parts[1].trim();
                        int age = Integer.parseInt(parts[2].trim());
                        Double gpa = Double.parseDouble(parts[3].trim());
                        studentMap.put(id, new Student(id, name, age, gpa));
                    }
                }
        br.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void findById(String id){
        if(!studentMap.containsKey(id)){
            System.out.println("Student Invalid");
        }
        else{
            System.out.println("The student who you'are looking for: "+studentMap.get(id));
        }
    } 

    public Student findById(HashMap<String, Student> map, String id){
        for(String k : studentMap.keySet()){
            if(k.equalsIgnoreCase(id.trim())){
                return studentMap.get(k);
            }
        }
        return null;
    }

    public HashMap<String, Student> getStudentMap() {
        return studentMap;
    }
    
}
