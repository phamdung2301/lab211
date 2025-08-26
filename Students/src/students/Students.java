/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package students;

/**
 *
 * @author ADMIN
 */
public class Students {
    private int MSSV;
        private String fullname;
        private Days day;
        private double GPA;
        private Classes classes;

    public Students(int MSSV, String fullname, Days day, double GPA, Classes classes) {
        this.MSSV = MSSV;
        this.fullname = fullname;
        this.day = day;
        this.GPA = GPA;
        this.classes = classes;
    }

    public int getMSSV() {
        return MSSV;
    }

    public void setMSSV(int MSSV) {
        this.MSSV = MSSV;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Days getDay() {
        return day;
    }

    public void setDay(Days day) {
        this.day = day;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
    public String printFacultyNameOfStudent(){
        return this.classes.getFacultyName();
    }
    /**
     * @param args the command line arguments
     */
    
}
