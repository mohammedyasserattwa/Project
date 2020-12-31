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
//SAVE
public class TeamMember extends Employees{

    //-------------Constructors------------//
    public TeamMember(String name, int id, int age, String Username, String Password){
        super(id,name,age,Username,Password);
        super.setPosition("Team Member");
        super.setPayRate(30);
        super.setTaxRate(0.15);
        super.setWorkingHours(45);
    }
    public TeamMember(){
        super.setPosition("Team Member");
        super.setPayRate(30);
        super.setTaxRate(0.15);
        super.setWorkingHours(45);
    }
}
