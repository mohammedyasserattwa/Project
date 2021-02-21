
package Payroll;

public class Employees extends User{
    //--------------Data Members-------------//
    private char Grade;
    private String position;
    private double taxRate;
    private double payRate;
    private double salary;
    private double workingHours;
    private String Username;
    private String Password;
    //-------------Constructors------------//
    public Employees(){
        super();
        Grade = ' ';
    }
    public Employees(int id, String name, int age, String Username,String Password){
        super(id,name,age);
        this.Username=Username;
        this.Password=Password;
    }
    //-------------------Getter/Setter-------------------//
    public char getGrade(TeamLeader tl) {
        if(payRate >= 0.75 && taxRate >= 0.5)
            return Grade = 'B';
        else
            return Grade = 'A';

    }
    public char getGrade(TeamMember tl) {
        if(payRate >= 0.5 && taxRate >= 0.25)
            return Grade = 'D';
        else
            return Grade = 'C';
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position){
        this.position = position;
    }
    public double getTaxRate() {
        return taxRate;
    }
    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }
    public double getPayRate() {
        return payRate;
    }
    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }
    public double getWorkingHours() {
        return workingHours;
    }
    void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }
    public double getSalary() {
        setSalary();
        return salary;
    }
    public void setSalary() {
        salary = payRate * workingHours * (1-taxRate);
    }
    public String getUsername() {
        return Username;
    }
    public String getPassword() {
        return Password;
    }
}
