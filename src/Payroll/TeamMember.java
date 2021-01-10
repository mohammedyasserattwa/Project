
package Payroll;

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
