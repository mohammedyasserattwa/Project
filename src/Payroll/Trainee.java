/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Payroll;

/**
 *
 * @author Mohammed Yasser
 */
public class Trainee extends Company{
    //--------------Data Members-------------//
    private String facultyName;
    private int academicYear;
    private double GPA;
    private final double salary = 1000;
    private String Username;
    private String Password;
    //-------------Constructors------------//
    public Trainee(){
        facultyName = null;
        academicYear = 0;
        GPA = 1.0;
    }
    public Trainee(int id, String name, int age, String facultyName, int academicYear, double GPA,String Username, String Password){
        super(id,name,age);
        this.facultyName = facultyName;
        this.academicYear = academicYear;
        this.GPA = GPA;
        this.Username=Username;
        this.Password=Password;
    }
    //-------------------Getter/Setter-------------------//
    public String getFacultyName() {
        return facultyName;
    }
    public int getAcademicYear() {
        return academicYear;
    }
    public double getGPA() {
        return GPA;
    }
    public double getSalary() {
        return salary;
    }
    public String getUsername() {
        return Username;
    }
    public String getPassword() {
        return Password;
    }
}