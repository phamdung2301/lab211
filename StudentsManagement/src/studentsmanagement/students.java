/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentsmanagement;

/**
 *
 * @author ADMIN
 */
public class students {
    private String studentID;
    private String name;
    private int age;
    private String gender;
    private String major;
    private double gpa;

    public students(String studentID, String name, int age, String gender, String major, double gpa) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.major = major;
        this.gpa = gpa;
    }
    
    

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return studentID +" "+ name +" "+ age +" "+ gender +" "+ major +" "+ gpa;
    }
    
}
