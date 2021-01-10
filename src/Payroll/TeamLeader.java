
package Payroll;
import java.util.*;

public class TeamLeader extends Employees{
    //--------------Data Members-------------//
    private int TeamCapacity=5;
    private ArrayList<TeamMember> TeamMembers;
    //-------------Constructors------------//
    public TeamLeader(){
        TeamMembers = new ArrayList(0);
        super.setPosition("Team Leader");
        super.setPayRate(40);
        super.setTaxRate(0.10);
        super.setWorkingHours(50);
    }
    public TeamLeader(String name, int id, int age, ArrayList<TeamMember> TeamMembers, String Username,String Password){
        super(id, name, age,Username,Password);
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