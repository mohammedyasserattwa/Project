/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Payroll;
import java.util.*;
/**
 *
 * @author Mohammed Yasser
 */
public class TeamLeader extends Employees{
    //--------------Data Members-------------//
    private int TeamCapacity;
    private ArrayList<TeamMember> TeamMembers;
    //-------------Constructors------------//
    public TeamLeader(){
        TeamCapacity = 0;
        TeamMembers = new ArrayList(0);
        super.setPosition("Team Leader");
        super.setPayRate(40);
        super.setTaxRate(0.10);
        super.setWorkingHours(50);
    }
    public TeamLeader(String name, int id, int age, int TeamCapacity, ArrayList<TeamMember> TeamMembers, String Username,String Password){
        super(id, name, age,Username,Password);
        this.TeamCapacity = TeamCapacity;
        this.TeamMembers = TeamMembers;
        super.setPosition("Team Leader");
        super.setPayRate(40);
        super.setTaxRate(0.10);
        super.setWorkingHours(50);
    }
    //-------------------Getter/Setter-------------------//
    public int getTeamCapacity() {
        return TeamCapacity;
    }
    public void setTeamMembers(ArrayList<TeamMember> TeamMembers) {
        this.TeamMembers = TeamMembers;
    }
    public ArrayList<TeamMember> getTeamMembers() {
        return TeamMembers;
    }
    //-------------------Display-------------------------//
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<TeamMembers.size();i++){
            sb.append(TeamMembers.get(i).getId()+" "+TeamMembers.get(i).getName()+ " " + TeamMembers.get(i).getAge() +"  " + TeamMembers.get(i).getGrade(TeamMembers.get(i)) + "\n");
        }
        return sb.toString();
    }

}