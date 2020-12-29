/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Payroll;
import java.util.*;
import java.io.*;

public class Company implements Serializable, Files{
    private int id;
    private String name;
    private int age;
    public Company(){
        id = 0;
        name = null;
        age = 0;
        //Ahmed Bassem
    }
    public Company(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    //Read Object
    public Manager checkLoginm(String Username, String Password) throws IOException, ClassNotFoundException {
        ArrayList<Manager> ManagerYasser = new ArrayList();
        Manager Chosen=new Manager();
        ManagerYasser = Files.readManager();
        //Get the Manager
        for(int i = 0;i<ManagerYasser.size();i++){
            if(ManagerYasser.get(i).getUsername().equalsIgnoreCase(Username) && ManagerYasser.get(i).getPassword().equalsIgnoreCase(Password)){
                return ManagerYasser.get(i);
            }
        }
        return null;
    }
    public Trainee checkLogintrainee(String Username, String Password) throws IOException, ClassNotFoundException {
        ArrayList<Trainee> TraineeYasser = new ArrayList();
        Trainee Chosen=new Trainee();
        TraineeYasser = Files.readTrainee();
        //Get the Manager
        for(int i = 0;i<TraineeYasser.size();i++){
            if(TraineeYasser.get(i).getUsername().equalsIgnoreCase(Username) && TraineeYasser.get(i).getPassword().equalsIgnoreCase(Password)){
                return TraineeYasser.get(i);
            }
        }
        return null;
    }
    public Object checkLogintltm(String Username, String Password) throws IOException, ClassNotFoundException {
        ArrayList<TeamLeader> TeamLeaderYasser = new ArrayList();
        TeamLeader Chosen=new TeamLeader();
        TeamLeaderYasser = Files.readTeamLeader();
        //Get the Manager
        for(int i = 0;i<TeamLeaderYasser.size();i++){
            if(TeamLeaderYasser.get(i).getUsername().equalsIgnoreCase(Username) && TeamLeaderYasser.get(i).getPassword().equalsIgnoreCase(Password)){
                return TeamLeaderYasser.get(i);
            }
        }
        for(int i = 0;i<TeamLeaderYasser.size();i++){
            for(int j=0;j<TeamLeaderYasser.get(i).getTeamMembers().size();j++) {
                if (TeamLeaderYasser.get(i).getTeamMembers().get(j).getUsername().equalsIgnoreCase(Username) && TeamLeaderYasser.get(i).getTeamMembers().get(j).getPassword().equalsIgnoreCase(Password)) {
                    return TeamLeaderYasser.get(i).getTeamMembers().get(j);
                }
            }
        }
        return null;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException{
       Frame frame=new Frame();

        //Data for Employees
        int id,age,academicYear;
        double GPA;
        String name,facultyName;
        int payRate;
        double taxRate, WorkingHours;
      //PROTOTYPE DATA//
//    ArrayList<Trainee> TraineeList=new ArrayList();
//    TraineeList.add(new Trainee(496,"Ahmed",19,"CS",2020,2.69,"yasser","mohamed"));
//    TraineeList.add(new Trainee(400,"Yasser",19,"CS",2021,3.02,"marawan","3atef"));
//    TraineeList.add(new Trainee(200,"Lara",19,"CS",2022,4.5,"farah","lara"));
//    Files.writeTrainee(TraineeList);
//    ArrayList<TeamMember> member=new ArrayList();
//    member.add(new TeamMember("Hanien",800,20,"hanien","hanien"));
//    member.add(new TeamMember("Hanien2",801,21,"hanien2","hanien2"));
//    ArrayList<TeamMember> member2=new ArrayList();
//    member.add(new TeamMember("Hanien3",802,22,"atef","atef"));
//    member.add(new TeamMember("Hanien4",803,23,"spiderman","thor"));
//    ArrayList<TeamLeader> leader=new ArrayList();
//    leader.add(new TeamLeader("Farah",455,20,member.size(),member,"lara","laraa"));
//    leader.add(new TeamLeader("Farah2",456,21,member2.size(),member2,"farah","farahhh"));
//    Files.writeTeamLeader(leader);
//    Manager m=new Manager(TraineeList,leader,"ahmed","bassem");
//    ArrayList<Manager> ManagerList = new ArrayList();
//    ManagerList.add(m);
//    Files.writeManager(ManagerList);
//    Scanner scanner = new Scanner(System.in);
//    System.out.println("Enter Username: ");
//    String Username = scanner.nextLine();
//    System.out.println("Enter Password: ");
//    String Password = scanner.nextLine();
//    ArrayList<Manager> ManagerYasser = new ArrayList();
//    Manager Chosen=new Manager();

//        //~//
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter Username: ");
//        String Username = scanner.nextLine();
//        System.out.println("Enter Password: ");
//        String Password = scanner.nextLine();
//        //read the objects in the file
//        ArrayList<Manager> ManagerYasser = new ArrayList();
//        Manager Chosen=new Manager();
//        ManagerYasser = File.readManager();
//        int index = 0;
//
//        //Get the Manager
//        boolean check = false;
//        for(int i = 0;i<ManagerYasser.size();i++){
//           if(ManagerYasser.get(i).checkLogin(Username, Password)){
//               Chosen = ManagerYasser.get(i);
//               index = i;
//               check = true;
//               break;
//           }
//        }
//        if(!check){
//            System.out.println("Username/password incorrect");
//            main(args);
//        }

//
//
//        //Menu//
//        System.out.println("1) Add trainee");
//        System.out.println("2) edit trainee");
//        System.out.println("3) delete trainee");
//        System.out.println("4) view trainee");
//
//        System.out.println("5) Add TeamLeader");
//        System.out.println("6) edit TeamLeader");
//        System.out.println("7) delete TeamLeader");
//        System.out.println("8) view TeamLeader");
//
//        System.out.println("9) Add TeamMember");
//        System.out.println("10) edit TeamMember");
//        System.out.println("11) delete TeamMember");
//        System.out.println("12) view TeamMember");
//
//        System.out.println("13) Edit Salaries for Team Leaders");
//        System.out.println("14) Edit Salaries for Team Members");
//        System.out.println("15) View Salaries for Team Leaders");
//        System.out.println("16) View Salaries for Team Members");
//        System.out.println("17) View Salaries for Trainees");
//        //Variables needed for the menu
//        int x=scanner.nextInt();
//        ArrayList<Trainee> t1=Chosen.getTrainees();
//        int y,select;
//        ArrayList<TeamLeader> t2=Chosen.getTeamLeaders();
//        String temp = "";
//        //Switch case
//        switch(x)
//        {
//            //Case One Add Trainee~~
//            case 1:
//                System.out.println("Enter ID: ");
//                id=scanner.nextInt();
//                temp = scanner.nextLine();
//                System.out.println("Enter Name: ");
//                name=scanner.nextLine();
//                System.out.println("Enter age: ");
//                age=scanner.nextInt();
//                temp = scanner.nextLine();
//                System.out.println("Enter Faculty name: ");
//                facultyName=scanner.nextLine();
//                System.out.println("Enter Academic Year: ");
//                academicYear=scanner.nextInt();
//                temp = scanner.nextLine();
//                System.out.println("Enter GPA: ");
//                GPA=scanner.nextDouble();
//                temp = scanner.nextLine();
//                Chosen.addTrainee(new Trainee(id,name,age,facultyName,academicYear,GPA));
//                break;
//            //Case Two Edit Trainee~~
//            case 2:
//                //Display list~~
//                for (int i = 0; i < t1.size(); i++)
//                {
//                    System.out.println((i+1)+": "+t1.get(i).getId()+" "+t1.get(i).getName());
//                }
//                //input from user
//                select=scanner.nextInt()- 1;
//                temp = scanner.nextLine();
//                //Edit Menu~~~
//                System.out.println("1) Change ID?\n2) Change name?\n3) Change age?\n4) Change FacultyName?\n5) Change AcademicYear?\n6) Change GPA?\n7)Change All? ");
//                y=scanner.nextInt();
//                temp = scanner.nextLine();
//                //choices conditions:
//                switch(y)
//                {
//                    //Case One Edit ID:~~
//                    case 1:
//                        System.out.println("Enter ID: ");
//                        id=scanner.nextInt();
//                        temp = scanner.nextLine();
//                        Chosen.editTrainee(select,new Trainee(id,t1.get(select).getName(),t1.get(select).getAge(),t1.get(select).getFacultyName(),t1.get(select).getAcademicYear(),t1.get(select).getGPA()));
//                        break;
//                    //Case Two Edit Name:~~
//                    case 2:
//                        System.out.println("Enter Name: ");
//                        name=scanner.nextLine();
//                        Chosen.editTrainee(select,new Trainee(t1.get(select).getId(),name,t1.get(select).getAge(),t1.get(select).getFacultyName(),t1.get(select).getAcademicYear(),t1.get(select).getGPA()));
//                        break;
//                    //Case Three Edit Age:~~
//                    case 3:
//                        System.out.println("Enter Age: ");
//                        age=scanner.nextInt();
//                        temp = scanner.nextLine();
//                        Chosen.editTrainee(select,new Trainee(t1.get(select).getId(),t1.get(select).getName(),age,t1.get(select).getFacultyName(),t1.get(select).getAcademicYear(),t1.get(select).getGPA()));
//                        break;
//                    //Case Four Edit Faculty Name:~
//                    case 4:
//                        System.out.println("Enter Faculty Name: ");
//                        facultyName=scanner.nextLine();
//                        Chosen.editTrainee(select,new Trainee(t1.get(select).getId(),t1.get(select).getName(),t1.get(select).getAge(),facultyName,t1.get(select).getAcademicYear(),t1.get(select).getGPA()));
//                       break;
//                    //Case Five Edit Academic Year:~~
//                    case 5:
//                        System.out.println("Enter Academic Year: ");
//                        academicYear=scanner.nextInt();
//                        temp = scanner.nextLine();
//                        Chosen.editTrainee(select,new Trainee(t1.get(select).getId(),t1.get(select).getName(),t1.get(select).getAge(),t1.get(select).getFacultyName(),academicYear,t1.get(select).getGPA()));
//                      break;
//                    //Case Six Edit GPA:~~
//                    case 6:
//                        System.out.println("Enter GPA: ");
//                        GPA=scanner.nextDouble();
//                        temp = scanner.nextLine();
//                        Chosen.editTrainee(select,new Trainee(t1.get(select).getId(),t1.get(select).getName(),t1.get(select).getAge(),t1.get(select).getFacultyName(),t1.get(select).getAcademicYear(),GPA));
//                       break;
//                    //Case Seven Edit the whole data:~~
//                    case 7:
//                        System.out.println("Enter Id: ");
//                        id=scanner.nextInt();
//                        temp = scanner.nextLine();
//                        System.out.println("Enter name: ");
//                        name=scanner.nextLine();
//                        System.out.println("Enter age: ");
//                        age=scanner.nextInt();
//                        temp = scanner.nextLine();
//                        System.out.println("Enter faculty name: ");
//                        facultyName=scanner.nextLine();
//                        System.out.println("Enter academic year: ");
//                        academicYear=scanner.nextInt();
//                        temp = scanner.nextLine();
//                        System.out.println("Enter GPA: ");
//                        GPA=scanner.nextDouble();
//                        temp = scanner.nextLine();
//                        Chosen.editTrainee(select,new Trainee(id,name,age,facultyName,academicYear,GPA));
//                        break;
//                    //Default Case:~
//                    default:
//                        System.out.println("Invalid");
//                }
//                break;
//            //Case Three Delete Trainee:~~
//            case 3:
//                for (int i = 0; i < t1.size(); i++)
//                {
//                    System.out.println((i+1)+": "+t1.get(i).getId()+" "+t1.get(i).getName());
//                }
//                y=scanner.nextInt();
//                temp = scanner.nextLine();
//                Chosen.deleteTrainee(t1.get(y-1));
//                break;
//            //Case Four Display Trainees:~~
//            case 4:
//                Chosen.displayTrainee();
//                break;
//            //Case Five Add Team Leader:~
//            case 5:
//                name = scanner.nextLine();
//                id = scanner.nextInt();
//                temp = scanner.nextLine();
//                age = scanner.nextInt();
//                temp = scanner.nextLine();
//                int TeamCapacity = scanner.nextInt();
//                temp = scanner.nextLine();
//                ArrayList<TeamMember> TeamMembers = new ArrayList();
//                for (int i = 0; i < TeamCapacity; i++)
//                {
//                    String MemberName = scanner.nextLine();
//                    int MemberId = scanner.nextInt();
//                    temp = scanner.nextLine();
//                    int MemberAge = scanner.nextInt();
//                    temp = scanner.nextLine();
//                    TeamMembers.add(new TeamMember(MemberName,MemberId, MemberAge));
//                }
//                TeamLeader t3 = new TeamLeader(name, id,age,TeamCapacity,TeamMembers);
//                Chosen.addTeamLeader(t3);
//                break;
//            //Case Six Edit Team Leader:~
//            case 6:
//                //Display list:~
//                for (int i = 0; i < t2.size(); i++)
//               {
//                  System.out.println((i+1)+": "+t2.get(i).getId()+" "+t2.get(i).getName());
//               }
//                //Inputs:~
//               System.out.println("Enter your option: ");
//               select=scanner.nextInt()-1;
//               temp = scanner.nextLine();
//               System.out.println("1) Change Name?\n2) Change ID?\n3) Change age?\n4) Change TeamCapacity?\n5) Change All?");
//               y=scanner.nextInt();
//               temp = scanner.nextLine();
//            //Edit conditions:~
//            switch(y)
//            {
//                //Case One Edit Name:~~
//                case 1:
//                    System.out.println("Enter Name: ");
//                    name=scanner.nextLine();
//                    Chosen.editTeamLeader(select,new TeamLeader(name,t2.get(select).getId(),t2.get(select).getAge(),t2.get(select).getTeamCapacity(),t2.get(select).getTeamMembers()));
//                    break;
//                //Case Two Edit ID:~~
//                case 2:
//                    System.out.println("Enter ID: ");
//                    id=scanner.nextInt();
//                    temp = scanner.nextLine();
//                    Chosen.editTeamLeader(select,new TeamLeader(t2.get(select).getName(),id,t2.get(select).getAge(),t2.get(select).getTeamCapacity(),t2.get(select).getTeamMembers()));
//                    break;
//                //Case Three Edit Age:~
//                case 3:
//                    System.out.println("Enter Age: ");
//                    age=scanner.nextInt();
//                    temp = scanner.nextLine();
//                    Chosen.editTeamLeader(select,new TeamLeader(t2.get(select).getName(),t2.get(select).getId(),age,t2.get(select).getTeamCapacity(),t2.get(select).getTeamMembers()));
//                    break;
//                //Case Four Edit Team Capacity:~~
//                case 4:
//                    System.out.println("Enter Team Capacity: ");
//                    TeamCapacity=scanner.nextInt();
//                    temp = scanner.nextLine();
//                    Chosen.editTeamLeader(select,new TeamLeader(t2.get(select).getName(),t2.get(select).getId(),t2.get(select).getAge(),TeamCapacity,t2.get(select).getTeamMembers()));
//                   break;
//                //Case Five edit the whole data:~~
//                case 5:
//                    System.out.println("Enter Id: ");
//                    id=scanner.nextInt();
//                    temp = scanner.nextLine();
//                    System.out.println("Enter name: ");
//                    name=scanner.nextLine();
//                    System.out.println("Enter age: ");
//                    age=scanner.nextInt();
//                    temp = scanner.nextLine();
//                    System.out.println("Enter Team Capacity: ");
//                    TeamCapacity=scanner.nextInt();
//                    temp = scanner.nextLine();
//                    Chosen.editTeamLeader(select,new TeamLeader(name,id,age,TeamCapacity,t2.get(select).getTeamMembers()));
//                  break;
//                //Default Case:~~
//                default:
//                    System.out.println("Invalid");
//            }
//                  break;
//            //Case Seven Delete Team Leader:~~
//            case 7:
//                //Display List:~~
//                for (int i = 0; i < t2.size(); i++)
//               {
//                  System.out.println((i+1)+": "+t2.get(i).getId()+" "+t2.get(i).getName());
//               }
//                //inputs:~~
//                select = scanner.nextInt()-1;
//                temp = scanner.nextLine();
//                System.out.println("Enter Id:");
//                id = scanner.nextInt();
//                temp = scanner.nextLine();
//                System.out.println("Enter name:");
//                name = scanner.nextLine();
//                System.out.println("Enter age:");
//                age = scanner.nextInt();
//                temp = scanner.nextLine();
//                //process:~~
//                TeamLeader New;
//                New = new TeamLeader(name,id,age);
//                Chosen.deleteTeamLeader(Chosen.getTeamLeaders().get(select), New);
//                break;
//            //Case Eight display Team Leader:~
//            case 8:
//               Chosen.displayTeamLeader();
//               break;
//            case 9:
//            //Display Team Leaders:
//            for(int i = 0;i<Chosen.getTeamLeaders().size(); i++){
//                System.out.println((i + 1) + "  " +Chosen.getTeamLeaders().get(i).getId() + "  " + Chosen.getTeamLeaders().get(i).getName());
//            }
//            select = scanner.nextInt() - 1;
//            temp = scanner.nextLine();
//            System.out.println("Enter name: ");
//            name = scanner.nextLine();
//            System.out.println("Enter Id:  ");
//            id = scanner.nextInt();
//            temp = scanner.nextLine();
//            System.out.println("Enter Age: ");
//            age = scanner.nextInt();
//            temp = scanner.nextLine();
//            Chosen.addTeamMember(Chosen.getTeamLeaders().get(select)   ,   new TeamMember(name,id,age));
//            break;
//            case 10:
//                //Display Team Leaders:
//              for(int i = 0;i<Chosen.getTeamLeaders().size(); i++){
//                  System.out.println((i + 1) + "  " +Chosen.getTeamLeaders().get(i).getId() + "  " + Chosen.getTeamLeaders().get(i).getName());
//              }
//              select = scanner.nextInt() - 1;
//              temp = scanner.nextLine();
//              for(int i = 0;i<Chosen.getTeamLeaders().get(select).getTeamMembers().size();i++){
//                System.out.println((i+1) + "  " + Chosen.getTeamLeaders().get(select).getTeamMembers().get(i).getId() + "  " + Chosen.getTeamLeaders().get(select).getTeamMembers().get(i).getName());
//              }
//              y = scanner.nextInt();
//              temp = scanner.nextLine();
//              System.out.println("1) Change Name?\n2) Change ID?\n3) Change age?\n4) Change All?");
//              int input=scanner.nextInt();
//              temp = scanner.nextLine();
//              switch(input){
//                  case 1:
//                    System.out.println("Enter Name: ");
//                    name=scanner.nextLine();
//                    Chosen.editTeamMember(Chosen.getTeamLeaders().get(select),y-1,new TeamMember(name,Chosen.getTeamLeaders().get(select).getTeamMembers().get(y-1).getId(),Chosen.getTeamLeaders().get(select).getTeamMembers().get(y-1).getAge()));
//                    break;
//                  case 2:
//                      System.out.println("Enter Id: ");
//                      id = scanner.nextInt();
//                      temp = scanner.nextLine();
//                      Chosen.editTeamMember(Chosen.getTeamLeaders().get(select),y-1, new TeamMember(Chosen.getTeamLeaders().get(select).getTeamMembers().get(y-1).getName(),id,Chosen.getTeamLeaders().get(select).getTeamMembers().get(y-1).getAge()));
//                      break;
//                  case 3:
//                      System.out.println("Enter Age: ");
//                      age = scanner.nextInt();
//                      temp = scanner.nextLine();
//                      Chosen.editTeamMember(Chosen.getTeamLeaders().get(select), y-1, new TeamMember(Chosen.getTeamLeaders().get(select).getTeamMembers().get(y-1).getName(),Chosen.getTeamLeaders().get(select).getTeamMembers().get(y-1).getId(),age));
//                      break;
//                  case 4:
//                      System.out.println("Enter name: ");
//                      name=scanner.nextLine();
//                      System.out.println("Enter Id: ");
//                      id = scanner.nextInt();
//                      temp = scanner.nextLine();
//                      System.out.println("Enter Age: ");
//                      age = scanner.nextInt();
//                      temp = scanner.nextLine();
//                      Chosen.editTeamMember(Chosen.getTeamLeaders().get(select), y-1, new TeamMember(name,id,age));
//                      break;
//                  default:
//                      System.out.println("Invalid");
//              }
//              break;
//            case 11:
//                 //Display Team Leaders:
//              for(int i = 0;i<Chosen.getTeamLeaders().size(); i++){
//                  System.out.println((i + 1) + "  " +Chosen.getTeamLeaders().get(i).getId() + "  " + Chosen.getTeamLeaders().get(i).getName());
//              }
//              select = scanner.nextInt() - 1;
//              temp = scanner.nextLine();
//              for(int i = 0;i<Chosen.getTeamLeaders().get(select).getTeamMembers().size();i++){
//                System.out.println((i+1) + "  " + Chosen.getTeamLeaders().get(select).getTeamMembers().get(i).getId() + "  " + Chosen.getTeamLeaders().get(select).getTeamMembers().get(i).getName());
//              }
//              y = scanner.nextInt();
//              temp = scanner.nextLine();
//              Chosen.deleteTeamMembers(Chosen.getTeamLeaders().get(select), y-1);
//              break;
//            case 12:
//                Chosen.displayTeamMembers();
//                break;
//            case 13:
//                for(int i = 0;i<Chosen.getTeamLeaders().size(); i++){
//                  System.out.println((i + 1) + "  " +Chosen.getTeamLeaders().get(i).getId() + "  " + Chosen.getTeamLeaders().get(i).getName());
//                }
//                select = scanner.nextInt() - 1;
//                temp = scanner.nextLine();
//                System.out.println("1)Change Tax Rate?\n2)Change Pay Rate?\n3)Change Working Hours\n4) Change all?");
//                y= scanner.nextInt();
//                temp = scanner.nextLine();
//                switch(y){
//                    case 1:
//                        System.out.println("Enter the new Tax rate: ");
//                        taxRate = scanner.nextDouble();
//                        temp = scanner.nextLine();
//                        Chosen.getTeamLeaders().get(select).setTaxRate(taxRate);
//                        break;
//                    case 2:
//                        System.out.println("Enter the new Pay rate: ");
//                        payRate = scanner.nextInt();
//                        temp = scanner.nextLine();
//                        Chosen.getTeamLeaders().get(select).setPayRate(payRate);
//                        break;
//                    case 3:
//                        System.out.println("Enter the new Working Hours: ");
//                        WorkingHours = scanner.nextDouble();
//                        temp = scanner.nextLine();
//                        Chosen.getTeamLeaders().get(select).setWorkingHours(WorkingHours);
//                        break;
//                    case 4:
//                        System.out.println("Enter the new Tax rate: ");
//                        taxRate = scanner.nextDouble();
//                        temp = scanner.nextLine();
//                        Chosen.getTeamLeaders().get(select).setTaxRate(taxRate);
//                        System.out.println("Enter the new Pay rate: ");
//                        payRate = scanner.nextInt();
//                        temp = scanner.nextLine();
//                        Chosen.getTeamLeaders().get(select).setPayRate(payRate);
//                        System.out.println("Enter the new Working Hours: ");
//                        WorkingHours = scanner.nextDouble();
//                        temp = scanner.nextLine();
//                        Chosen.getTeamLeaders().get(select).setWorkingHours(WorkingHours);
//                        break;
//                    default:
//                        System.out.println("invalid");
//                }
//                break;
//            case 14:
//                for(int i = 0;i<Chosen.getTeamLeaders().size(); i++){
//                  System.out.println((i + 1) + "  " +Chosen.getTeamLeaders().get(i).getId() + "  " + Chosen.getTeamLeaders().get(i).getName());
//                }
//                select = scanner.nextInt() - 1;
//                temp = scanner.nextLine();
//                for(int i = 0;i<Chosen.getTeamLeaders().get(select).getTeamMembers().size();i++){
//                System.out.println((i+1) + "  " + Chosen.getTeamLeaders().get(select).getTeamMembers().get(i).getId() + "  " + Chosen.getTeamLeaders().get(select).getTeamMembers().get(i).getName());
//              }
//              y = scanner.nextInt()- 1;
//              temp = scanner.nextLine();
//              System.out.println("1)Change Tax Rate?\n2)Change Pay Rate?\n3)Change Working Hours\n4) Change all?");
//                int input1= scanner.nextInt();
//                temp = scanner.nextLine();
//                switch(input1){
//                    case 1:
//                        System.out.println("Enter the new Tax rate: ");
//                        taxRate = scanner.nextDouble();
//                        temp = scanner.nextLine();
//                        Chosen.getTeamLeaders().get(select).getTeamMembers().get(y).setTaxRate(taxRate);
//                        break;
//                    case 2:
//                        System.out.println("Enter the new Pay rate: ");
//                        payRate = scanner.nextInt();
//                        temp = scanner.nextLine();
//                        Chosen.getTeamLeaders().get(select).getTeamMembers().get(y).setPayRate(payRate);
//                        break;
//                    case 3:
//                        System.out.println("Enter the new Working Hours: ");
//                        WorkingHours = scanner.nextDouble();
//                        temp = scanner.nextLine();
//                        Chosen.getTeamLeaders().get(select).getTeamMembers().get(y).setWorkingHours(WorkingHours);
//                        break;
//                    case 4:
//                        System.out.println("Enter the new Tax rate: ");
//                        taxRate = scanner.nextDouble();
//                        temp = scanner.nextLine();
//                        Chosen.getTeamLeaders().get(select).getTeamMembers().get(y).setTaxRate(taxRate);
//                        System.out.println("Enter the new Pay rate: ");
//                        payRate = scanner.nextInt();
//                        temp = scanner.nextLine();
//                        Chosen.getTeamLeaders().get(select).getTeamMembers().get(y).setPayRate(payRate);
//                        System.out.println("Enter the new Working Hours: ");
//                        WorkingHours = scanner.nextDouble();
//                        temp = scanner.nextLine();
//                        Chosen.getTeamLeaders().get(select).getTeamMembers().get(y).setWorkingHours(WorkingHours);
//                        break;
//                    default:
//                        System.out.println("invalid");
//                }
//                break;
//            case 15:
//                System.out.println("Salary list for Team Leaders: ");
//                for(int i = 0;i<Chosen.getTeamLeaders().size();i++){
//                    System.out.println((i + 1) + ") " +Chosen.getTeamLeaders().get(i).getId() + "  " + Chosen.getTeamLeaders().get(i).getName() + "  " + Chosen.getTeamLeaders().get(i).getSalary());
//                }
//                break;
//            case 16:
//                System.out.println("Salary list for Team Members: ");
//                int tem = 1;
//                for(int i = 0;i<Chosen.getTeamLeaders().size();i++){
//                    for(int j = 0;j<Chosen.getTeamLeaders().get(i).getTeamMembers().size();j++){
//                        System.out.println(tem + ") " +Chosen.getTeamLeaders().get(i).getTeamMembers().get(j).getId() + "  " + Chosen.getTeamLeaders().get(i).getTeamMembers().get(j).getName() + "  " + Chosen.getTeamLeaders().get(i).getTeamMembers().get(j).getSalary());
//                        tem++;
//                    }
//                }
//                break;
//            case 17:
//                System.out.println("Salary list for Trainees: ");
//                for(int i = 0;i<Chosen.getTrainees().size();i++){
//                    System.out.println((i+1) + ") " + Chosen.getTrainees().get(i).getName() + " " + Chosen.getTrainees().get(i).getId() + " " + Chosen.getTrainees().get(i).getSalary());
//                }
//                break;
//            default:
//                System.out.println("Invalid");
//    }
//        ManagerYasser.remove(index);
//        ManagerYasser.add(index, Chosen);
//        writeManager(ManagerYasser);
//        System.out.println("Successfully saved");
    }
}