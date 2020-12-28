/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Payroll;
import java.util.*;
import java.io.*;
/**
 *
 * @author Mohammed Yasser
 */
public class Manager implements Serializable{
    //~Data Members~//
    private ArrayList<Trainee> Trainees;
    private ArrayList<TeamLeader> TeamLeaders;
    private String Username;
    private String Password;
    //~Constructors~//
    public Manager(){
        Trainees = new ArrayList();
        TeamLeaders = new ArrayList();
    }
    public Manager(ArrayList<Trainee> Trainees, ArrayList<TeamLeader> TeamLeaders, String Username, String Password){
        this.Trainees = Trainees;
        this.TeamLeaders = TeamLeaders;
        this.Username = Username;
        this.Password = Password;
    }
    //~Getters/Setters~//
    public String getUsername() {
        return Username;
    }
    public String getPassword() {
        return Password;
    }
    public ArrayList<Trainee> getTrainees() {
        return Trainees;
    }
    public ArrayList<TeamLeader> getTeamLeaders() {
        return TeamLeaders;
    }
    //~Methods~//
    //Check the username and password given

    //add trainee, team members, team leaders
    public void addTrainee(Trainee t){
        getTrainees().add(t);
    }
    public void addTeamLeader(TeamLeader tl){
        getTeamLeaders().add(tl);
    }
    public void addTeamMember(TeamLeader tl, TeamMember tm){
        ArrayList<TeamMember> tlist =  tl.getTeamMembers();
        tlist.add(tm);
        tl.setTeamMembers(tlist);
    }
    //edit trainee, team members, team leaders
    public void editTrainee(int i, Trainee New){
        getTrainees().set(i,New);
    }
    public void editTeamLeader(int i, TeamLeader t){
        getTeamLeaders().set(i,t);
    }
    public void editTeamMember(TeamLeader tl, int i, TeamMember tm){
        ArrayList<TeamMember> tlist = tl.getTeamMembers();
        tlist.set(i,tm);
        tl.setTeamMembers(tlist);
    }
    //delete trainee, team members, team leaders
    public void deleteTeamLeader(TeamLeader old, TeamLeader New){
        int index =  getTeamLeaders().indexOf(old);
        New.setTeamMembers(old.getTeamMembers());
        getTeamLeaders().remove(old);
        getTeamLeaders().add(index, New);
    }
    public void deleteTeamMembers(TeamLeader tl,int i){
        ArrayList<TeamMember> tlist = tl.getTeamMembers();
        tlist.remove(i);
        tl.setTeamMembers(tlist);
    }
    public void deleteTrainee(Trainee t){
        getTrainees().remove(t);
    }
    //Display method
    public void displayTrainee(){
        System.out.println("Trainees: ");
        for(int i = 0;i<getTrainees().size();i++){
            System.out.println(getTrainees().get(i).getName() + " " + getTrainees().get(i).getAge() + " " + getTrainees().get(i).getFacultyName() + " " + getTrainees().get(i).getAcademicYear() + " " + getTrainees().get(i).getGPA());
        }
    }
    public void displayTeamLeader(){
        System.out.println("Team Leader: ");
        for(int i = 0;i<getTeamLeaders().size();i++){
            System.out.println(getTeamLeaders().get(i).getId()+ " " +getTeamLeaders().get(i).getName() + " " + getTeamLeaders().get(i).getAge() + getTeamLeaders().get(i).getGrade(getTeamLeaders().get(i)) + " Team members: \n" + getTeamLeaders().get(i).toString());
        }
    }
    public void displayTeamMembers(){
        System.out.println("Team Members: ");
        for(int i = 0;i<getTeamLeaders().size();i++){
            System.out.print(getTeamLeaders().get(i).toString());
        }
    }
}