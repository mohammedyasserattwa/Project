package Payroll;
//import javafx.scene.input.KeyCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import static javax.swing.JOptionPane.*;
import java.util.ArrayList;
import static java.awt.Color.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Frame extends JFrame implements Files {
    //Buttons
    Al al=new Al();

    JButton login=new JButton("Login");
    JButton sign=new JButton("Sign Up");
    JButton trainee=new JButton("Trainee");
    JButton teamleader=new JButton("Team Leader & Team Member");
    JButton manager=new JButton("Manager");
    JButton submit= new JButton("Submit");
    JButton back=new JButton("<--");

    //Manager
    JButton Trainee = new JButton("Trainee");
    JButton TeamLeader = new JButton("Team Leader");
    JButton TeamMember = new JButton("Team Member");
    JButton Add = new JButton("Add");
    JButton Delete = new JButton("Delete");
    JButton Edit = new JButton("Edit");


    JLabel welc=new JLabel("Company Payroll");
    JLabel username= new JLabel("Username:");
    JLabel password= new JLabel("Password:");

    JTextField userin=new JTextField(10);
    JPasswordField passin=new JPasswordField(10);
    ////////////////////////////

    public Frame()
    {
        ///////////////////////////////////////////////////////////
        setTitle("COMPANY");
        setSize(800,800);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        ///////////////////////////////////////////////////////////

        welc.setBounds(300,100,150,150);
        welc.setFont(new Font("Serif",Font.ITALIC,20));
        add(welc);
        /////////////////////

        login.setBounds(100,400,150,40);
        add(login);
        sign.setBounds(500,400,150,40);
        add(sign);
        /////////////////////

        login.addActionListener(al);
        back.addActionListener(al);
        teamleader.addActionListener(al);
        trainee.addActionListener(al);
        manager.addActionListener(al);
        submit.addActionListener(al);
        Trainee.addActionListener(al);
        TeamLeader.addActionListener(al);
        TeamMember.addActionListener(al);
        Add.addActionListener(al);
        Delete.addActionListener(al);
        Edit.addActionListener(al);
        /////////////////////
    }

    public void F1(){
        setSize(801,801);
        add(welc);
        add(login);
        add(sign);

    }

    public void F2 (){
        setSize(805,805);
        teamleader.setBounds(255,250,250,50);
        add(teamleader);
        trainee.setBounds(160,400,100,50);
        add(trainee);
        manager.setBounds(515,400,100,50);
        add(manager);
        back.setBounds(1,1,60,20);
        add(back);
        //////////////////
    }

    public void F3(){
        username.setBounds(250,300,90,40);
        username.setFont(new Font("Serif",20,18));
        add(username);
        userin.setBounds(350,305,140,30);
        add(userin);

        password.setBounds(250,360,90,40);
        password.setFont(new Font("Serif",20,18));
        add(password);
        passin.setBounds(350,365,140,30);
        add(passin);

        submit.setBounds(330,500,90,50);
        add(submit);
    }

    public void F4(TeamLeader chosen) {
        JLabel AccountInfo = new JLabel("Account Info ");
        AccountInfo.setBounds(25, 15, 300, 100);
        AccountInfo.setFont(new Font("Serif", Font.BOLD, 40));
        add(AccountInfo);

        JLabel viewname = new JLabel("Name:");
        viewname.setBounds(300, 100, 50, 50);
        viewname.setFont(new Font("Serif", 20, 18));
        add(viewname);
        JLabel TlName = new JLabel(chosen.getName());
        TlName.setFont(new Font("Serif", 20, 18));
        TlName.setBounds(360, 100, 100, 50);
        add(TlName);

        JLabel ID = new JLabel("ID:");
        ID.setBounds(300, 125, 50, 50);
        ID.setFont(new Font("Serif", 20, 18));
        add(ID);
        JLabel Tlid = new JLabel("" + chosen.getId());
        Tlid.setFont(new Font("Serif", 20, 18));
        Tlid.setBounds(360, 125, 100, 50);
        add(Tlid);

        JLabel age = new JLabel("Age: ");
        age.setBounds(300, 150, 50, 50);
        age.setFont(new Font("Serif", 20, 18));
        add(age);
        JLabel num = new JLabel("" + chosen.getAge());
        num.setBounds(360, 150, 50, 50);
        num.setFont(new Font("Serif", 20, 18));
        add(num);

        JLabel Tcapacity = new JLabel("Team capacity: ");
        Tcapacity.setBounds(300, 175, 150, 50);
        Tcapacity.setFont(new Font("Serif", 20, 18));
        add(Tcapacity);
        JLabel TeamCapacity = new JLabel("" + chosen.getTeamCapacity());
        TeamCapacity.setBounds(430, 175, 50, 50);
        TeamCapacity.setFont(new Font("Serif", 20, 18));
        add(TeamCapacity);

        JLabel salary = new JLabel("Salary: ");
        salary.setBounds(300,200,70,50);
        salary.setFont(new Font("Serif", 20, 18));
        add(salary);
        JLabel result = new JLabel("$" + chosen.getSalary());
        result.setBounds(370,200,150,50);
        result.setFont(new Font("Serif", 20, 18));
        add(result);
        JLabel team = new JLabel("Your Team Members:  ");
        team.setBounds(180,250,300,50);
        team.setFont(new Font("Serif", 20, 30));
        add(team);


        String column[] = {"ID", "Name", "Age"};
        String data[][] = new String[5][3];

        for (int i = 0; i < chosen.getTeamMembers().size(); i++) {
            data[i][0] = chosen.getTeamMembers().get(i).getId() + "";
            data[i][1] = chosen.getTeamMembers().get(i).getName() + "";
            data[i][2] = chosen.getTeamMembers().get(i).getAge() + "";
        }

        JTable jt=new JTable(data,column);
        JScrollPane sp=new JScrollPane(jt);
        JPanel panel = new JPanel();
        panel.add(sp);
        panel.setBounds(150,300,500,107);
        add(panel);
    }
    public void F5(TeamMember chosen) throws IOException, ClassNotFoundException {
        JLabel AccountInfo = new JLabel("Account Info ");
        AccountInfo.setBounds(25, 15, 300, 100);
        AccountInfo.setFont(new Font("Serif", Font.BOLD, 40));
        add(AccountInfo);

        JLabel viewname = new JLabel("Name:");
        viewname.setBounds(300, 100, 50, 50);
        viewname.setFont(new Font("Serif", 20, 18));
        add(viewname);
        JLabel TlName = new JLabel(chosen.getName());
        TlName.setFont(new Font("Serif", 20, 18));
        TlName.setBounds(360, 100, 100, 50);
        add(TlName);

        JLabel ID = new JLabel("ID:");
        ID.setBounds(300, 125, 50, 50);
        ID.setFont(new Font("Serif", 20, 18));
        add(ID);
        JLabel Tlid = new JLabel("" + chosen.getId());
        Tlid.setFont(new Font("Serif", 20, 18));
        Tlid.setBounds(360, 125, 100, 50);
        add(Tlid);

        JLabel age = new JLabel("Age: ");
        age.setBounds(300, 150, 50, 50);
        age.setFont(new Font("Serif", 20, 18));
        add(age);
        JLabel num = new JLabel("" + chosen.getAge());
        num.setBounds(360, 150, 50, 50);
        num.setFont(new Font("Serif", 20, 18));
        add(num);

        JLabel TeamLeader = new JLabel("TeamLeader: ");
        TeamLeader.setBounds(300,175,150,50);
        TeamLeader.setFont(new Font("Serif", 20, 18));
        add(TeamLeader);

        ArrayList<TeamLeader> teamleaders = Files.readTeamLeader();
        TeamLeader selected = new TeamLeader();
        for(int i = 0;i<teamleaders.size();i++){
            for(int j = 0;j<teamleaders.get(i).getTeamMembers().size();j++){
                if(chosen.getId() == teamleaders.get(i).getTeamMembers().get(j).getId()){
                    selected =  teamleaders.get(i);
                }
            }
        }
        JLabel tname = new JLabel(selected.getName());
        tname.setBounds(400,175,150,50);
        tname.setFont(new Font("Serif", 20, 18));
        add(tname);

        JLabel result = new JLabel("$" + chosen.getSalary());
        result.setBounds(370,200,150,50);
        result.setFont(new Font("Serif", 20, 18));
        add(result);

        JLabel salary = new JLabel("Salary: ");
        salary.setBounds(300,200,70,50);
        salary.setFont(new Font("Serif", 20, 18));
        add(salary);

    }
    public void F6(Trainee chosen){
        JLabel AccountInfo = new JLabel("Account Info ");
        AccountInfo.setBounds(25, 15, 300, 100);
        AccountInfo.setFont(new Font("Serif", Font.BOLD, 40));
        add(AccountInfo);

        JLabel viewname = new JLabel("Name:");
        viewname.setBounds(300, 100, 50, 50);
        viewname.setFont(new Font("Serif", 20, 18));
        add(viewname);
        JLabel TlName = new JLabel(chosen.getName());
        TlName.setFont(new Font("Serif", 20, 18));
        TlName.setBounds(360, 100, 100, 50);
        add(TlName);

        JLabel ID = new JLabel("ID:");
        ID.setBounds(300, 125, 50, 50);
        ID.setFont(new Font("Serif", 20, 18));
        add(ID);
        JLabel Tlid = new JLabel("" + chosen.getId());
        Tlid.setFont(new Font("Serif", 20, 18));
        Tlid.setBounds(360, 125, 100, 50);
        add(Tlid);

        JLabel age = new JLabel("Age: ");
        age.setBounds(300, 150, 50, 50);
        age.setFont(new Font("Serif", 20, 18));
        add(age);
        JLabel num = new JLabel("" + chosen.getAge());
        num.setBounds(360, 150, 50, 50);
        num.setFont(new Font("Serif", 20, 18));
        add(num);

        JLabel TeamLeader = new JLabel("Faculty Name: ");
        TeamLeader.setBounds(300,175,150,50);
        TeamLeader.setFont(new Font("Serif", 20, 18));
        add(TeamLeader);

        JLabel tname = new JLabel(chosen.getFacultyName());
        tname.setBounds(425,175,150,50);
        tname.setFont(new Font("Serif", 20, 18));
        add(tname);

        JLabel NewLabel = new JLabel("Academic Year: ");
        NewLabel.setBounds(300,200,150,50);
        NewLabel.setFont(new Font("Serif", 20, 18));
        add(NewLabel);
//400,200,150,50
        JLabel label1 = new JLabel(chosen.getAcademicYear()+"");
        label1.setBounds(425,200,150,50);
        label1.setFont(new Font("Serif", 20, 18));
        add(label1);

        JLabel gpa = new JLabel("GPA: ");
        gpa.setBounds(300,225,50,50);
        gpa.setFont(new Font("Serif", 20, 18));
        add(gpa);

        JLabel res = new JLabel(chosen.getGPA()+"");
        res.setBounds(350,225,50,50);
        res.setFont(new Font("Serif", 20, 18));
        add(res);


        JLabel salary = new JLabel("Salary: ");
        salary.setBounds(300,250,70,50);
        salary.setFont(new Font("Serif", 20, 18));
        add(salary);

        JLabel result = new JLabel("$" + chosen.getSalary());
        result.setBounds(370,250,150,50);
        result.setFont(new Font("Serif", 20, 18));
        add(result);

    }
    public void F7(Manager chosen){
            //Set bounds for left buttons
            Add.setBounds(0,230,150,100);
            Add.setFont(new Font("Serif",Font.BOLD,30));
            Edit.setBounds(0,330,150,100);
            Edit.setFont(new Font("Serif",Font.BOLD,30));
            Delete.setBounds(0,430,150,100);
            Delete.setFont(new Font("Serif",Font.BOLD,30));
            add(Add);
            add(Edit);
            add(Delete);
    }
    public void F8(){
        //Set bounds for left buttons
        Add.setBounds(0,230,150,100);
        Add.setFont(new Font("Serif",Font.BOLD,30));
        Edit.setBounds(0,330,150,100);
        Edit.setFont(new Font("Serif",Font.BOLD,30));
        Delete.setBounds(0,430,150,100);
        Delete.setFont(new Font("Serif",Font.BOLD,30));
        add(Add);
        add(Edit);
        add(Delete);
    }


    public void Add(int num){
        if(num ==1){
            JLabel TraineeName = new JLabel("Name: ");
            TraineeName.setBounds(200,200,50,50);
            JTextField getName = new JTextField();
            getName.setBounds(280,200,75,50);


            JLabel TraineeID = new JLabel("ID: ");
            TraineeID.setBounds(200,225,50,50);
            JTextField getID = new JTextField();
            getID.setBounds(280,225,75,50);


            JLabel TraineeAge = new JLabel("Age: ");
            TraineeAge.setBounds(200,250,50,50);
            JTextField getAge = new JTextField();
            getAge.setBounds(280,250,75,50);


            JLabel TraineeAY = new JLabel("Academic Year: ");
            TraineeAY.setBounds(200,275,150,50);
            JTextField getAY = new JTextField();
            getAY.setBounds(380,275,75,50);


            JLabel TraineeFN = new JLabel("Faculty name: ");
            TraineeFN.setBounds(200,300,150,50);
            JTextField getFN = new JTextField();
            getFN.setBounds(380,300,75,50);


            JLabel TraineeGPA = new JLabel("GPA: ");
            TraineeGPA.setBounds(200,325,50,50);
            JTextField getGPA = new JTextField();
            getGPA.setBounds(280,325,75,50);

            
        }
        else if(num == 2){

        }
    }
    public class Al implements ActionListener  {
        int state=0;
        int select=0;
        int num = 0;
        @Override
        public void actionPerformed(ActionEvent e) {
            //Back Button
            getContentPane().revalidate();
            if (e.getSource() == back) {
                if (state == 1) {
                    userin.setText("");passin.setText("");
                    getContentPane().removeAll();
                    getContentPane().revalidate();
                    add(back);
                    F1();
                }
                if (state == 2) {
                    userin.setText("");passin.setText("");
                    getContentPane().removeAll();
                    getContentPane().revalidate();
                    add(back);
                    F2();
                    state--;
                }
                if(state==3){                                   ///////////////Need to be seen again///////////////////////
                    getContentPane().removeAll();
                    getContentPane().revalidate();
                    add(back);
                    F8();
                    state=2;
                }

            }

            if (e.getSource() == login) {
                setSize(801, 801);
                setSize(800, 800);
                getContentPane().removeAll();
                add(back);
                F2();
                state = 1;
            }
            if(e.getSource() == Add){
                setSize(801,801);
                setSize(800,800);
                getContentPane().removeAll();
                getContentPane().revalidate();
                Trainee.setBounds(100,100,200,50);
                Trainee.setFont(new Font("Serif",Font.BOLD,20));
                add(Trainee);

                TeamLeader.setBounds(310,100,200,50);
                TeamLeader.setFont(new Font("Serif",Font.BOLD,20));
                add(TeamLeader);

                TeamMember.setBounds(520,100,200,50);
                TeamMember.setFont(new Font("Serif",Font.BOLD,20));
                add(TeamMember);

            }

            if(e.getSource() == Trainee){
                getContentPane().removeAll();
                getContentPane().revalidate();
                num = 1;
                add(back);

                setSize(801,801);
                setSize(800,800);
                JLabel TraineeName = new JLabel("Add Trainee  ");
                TraineeName.setBounds(300,30,400,100);
                TraineeName.setFont(new Font("Serif",Font.BOLD,50));
                add(TraineeName);

                JLabel Tname = new JLabel("Name: ");
                Tname.setFont(new Font("Serif",Font.BOLD,20));
                Tname.setBounds(50,200,80,30);
                add(Tname);
                JTextField getTName = new JTextField(20);
                getTName.setBounds(195,200,100,30);
                add(getTName);

                JLabel Tage = new JLabel("Age: ");
                Tage.setFont(new Font("Serif",Font.BOLD,20));
                Tage.setBounds(50,250,80,30);
                add(Tage);
                JTextField getTAge = new JTextField(20);
                getTAge.setBounds(195,250,100,30);
                add(getTAge);

                JLabel Tid = new JLabel("ID: ");
                Tid.setFont(new Font("Serif",Font.BOLD,20));
                Tid.setBounds(50,300,80,30);
                add(Tid);
                JTextField getTid = new JTextField(20);
                getTid.setBounds(195,300,100,30);
                add(getTid);

                JLabel TfacultyName = new JLabel("Faculty Name: ");
                TfacultyName.setFont(new Font("Serif",Font.BOLD,20));
                TfacultyName.setBounds(50,350,140,30);
                add(TfacultyName);
                JTextField getTfacultyName = new JTextField(20);
                getTfacultyName.setBounds(195,350,100,30);
                add(getTfacultyName);

                JLabel TacademicYear = new JLabel("Academic Year: ");
                TacademicYear.setFont(new Font("Serif",Font.BOLD,20));
                TacademicYear.setBounds(50,400,150,30);
                add(TacademicYear);
                JTextField getTacademicYear = new JTextField(20);
                getTacademicYear.setBounds(195,400,100,30);
                add(getTacademicYear);

                JLabel Tgpa = new JLabel("GPA: ");
                Tgpa.setFont(new Font("Serif",Font.BOLD,20));
                Tgpa.setBounds(50,450,140,30);
                add(Tgpa);
                JTextField getTgpa = new JTextField(20);
                getTgpa.setBounds(195,450,100,30);
                add(getTgpa);

                JLabel TUser = new JLabel("Username: ");
                TUser.setFont(new Font("Serif",Font.BOLD,20));
                TUser.setBounds(50,500,100,30);
                add(TUser);
                JTextField getTUser= new JTextField(20);
                getTUser.setBounds(195,500,100,30);
                add(getTUser);

                JLabel TPass = new JLabel("Password: ");
                TPass.setFont(new Font("Serif",Font.BOLD,20));
                TPass.setBounds(50,550,100,30);
                add(TPass);
                JTextField getTPass = new JTextField(20);
                getTPass.setBounds(195,550,100,30);
                add(getTPass);
                state=3;


            }

            if(e.getSource() == TeamLeader){
                num = 2;
                getContentPane().removeAll();
                setSize(1150,801);

                JLabel TeamLeader = new JLabel("Add Team Leader  ");
                TeamLeader.setBounds(400,30,430,100);
                TeamLeader.setFont(new Font("Serif",Font.BOLD,50));
                add(TeamLeader);

                JLabel Tlname = new JLabel("Name: ");
                Tlname.setFont(new Font("Serif",Font.BOLD,20));
                Tlname.setBounds(50,200,80,30);
                add(Tlname);
                JTextField getTlName = new JTextField(20);
                getTlName.setBounds(195,200,100,30);
                add(getTlName);

                JLabel Tlage = new JLabel("Age: ");
                Tlage.setFont(new Font("Serif",Font.BOLD,20));
                Tlage.setBounds(50,250,80,30);
                add(Tlage);
                JTextField getTlAge = new JTextField(20);
                getTlAge.setBounds(195,250,100,30);
                add(getTlAge);

                JLabel Tlid = new JLabel("ID: ");
                Tlid.setFont(new Font("Serif",Font.BOLD,20));
                Tlid.setBounds(50,300,80,30);
                add(Tlid);
                JTextField getTlid = new JTextField(20);
                getTlid.setBounds(195,300,100,30);
                add(getTlid);

                JLabel TlUser = new JLabel("Username: ");
                TlUser.setFont(new Font("Serif",Font.BOLD,20));
                TlUser.setBounds(350,200,100,30);
                add(TlUser);
                JTextField getTlUser= new JTextField(20);
                getTlUser.setBounds(460,200,100,30);
                add(getTlUser);

                JLabel TlPass = new JLabel("Password: ");
                TlPass.setFont(new Font("Serif",Font.BOLD,20));
                TlPass.setBounds(350,300,100,30);
                add(TlPass);
                JTextField getTlPass = new JTextField(20);
                getTlPass.setBounds(460,300,100,30);
                add(getTlPass);


                JLabel Tlmember = new JLabel("Team Members ");         //id name age
                Tlmember.setBounds(450,350,200,30);
                Tlmember.setFont(new Font("Serif",Font.BOLD,23));
                add(Tlmember);
                for (int i=0,j=0;i<5;i++,j+=50){
                    JLabel TlmembersName = new JLabel("Name: ");
                    TlmembersName.setFont(new Font("Serif",Font.BOLD,20));
                    TlmembersName.setBounds(50,400+j,80,30);
                    add(TlmembersName);
                    JTextField getTlmembersName = new JTextField(20);
                    getTlmembersName.setBounds(135,400+j,100,30);
                    add(getTlmembersName);

                    JLabel TlmembersId = new JLabel("ID: ");
                    TlmembersId.setFont(new Font("Serif",Font.BOLD,20));
                    TlmembersId.setBounds(265,400+j,40,30);
                    add(TlmembersId);
                    JTextField getTlmembersId = new JTextField(20);
                    getTlmembersId.setBounds(315,400+j,100,30);
                    add(getTlmembersId);

                    JLabel TlmembersAge = new JLabel("Age: ");
                    TlmembersAge.setFont(new Font("Serif",Font.BOLD,20));
                    TlmembersAge.setBounds(445,400+j,50,30);
                    add(TlmembersAge);
                    JTextField getTlmembersAge = new JTextField(20);
                    getTlmembersAge.setBounds(505,400+j,100,30);
                    add(getTlmembersAge);

                    JLabel TlmembersUser = new JLabel("Username: ");
                    TlmembersUser.setFont(new Font("Serif",Font.BOLD,20));
                    TlmembersUser.setBounds(635,400+j,110,30);
                    add(TlmembersUser);
                    JTextField getTlmembersUser = new JTextField(20);
                    getTlmembersUser.setBounds(755,400+j,100,30);
                    add(getTlmembersUser);

                    JLabel TlmembersPass = new JLabel("Password: ");
                    TlmembersPass.setFont(new Font("Serif",Font.BOLD,20));
                    TlmembersPass.setBounds(885,400+j,110,30);
                    add(TlmembersPass);
                    JTextField getTlmembersPass = new JTextField(20);
                    getTlmembersPass.setBounds(1005,400+j,100,30);
                    add(getTlmembersPass);
                }

            }

            if(e.getSource() == TeamMember){
                getContentPane().removeAll();
                getContentPane().revalidate();

                setSize(801,801);
                setSize(800,800);
                JLabel TmName = new JLabel("Add Team Member  ");
                TmName.setBounds(150,30,460,100);
                TmName.setFont(new Font("Serif",Font.BOLD,50));
                add(TmName);

                JLabel TmemberName = new JLabel("Name: ");
                TmemberName.setFont(new Font("Serif",Font.BOLD,20));
                TmemberName.setBounds(50,200,80,30);
                add(TmemberName);
                JTextField getTmemberName = new JTextField(20);
                getTmemberName.setBounds(195,200,100,30);
                add(getTmemberName);

                JLabel Tmemberage = new JLabel("Age: ");
                Tmemberage.setFont(new Font("Serif",Font.BOLD,20));
                Tmemberage.setBounds(50,250,80,30);
                add(Tmemberage);
                JTextField getTmemberAge = new JTextField(20);
                getTmemberAge.setBounds(195,250,100,30);
                add(getTmemberAge);

                JLabel TmemberId = new JLabel("ID: ");
                TmemberId.setFont(new Font("Serif",Font.BOLD,20));
                TmemberId.setBounds(50,300,80,30);
                add(TmemberId);
                JTextField getTmemberId = new JTextField(20);
                getTmemberId.setBounds(195,300,100,30);
                add(getTmemberId);

                JLabel TmemberUser = new JLabel("Username: ");
                TmemberUser.setFont(new Font("Serif",Font.BOLD,20));
                TmemberUser.setBounds(50,350,100,30);
                add(TmemberUser);
                JTextField getTmemberUser= new JTextField(20);
                getTmemberUser.setBounds(195,350,100,30);
                add(getTmemberUser);

                JLabel TmemberPass = new JLabel("Password: ");
                TmemberPass.setFont(new Font("Serif",Font.BOLD,20));
                TmemberPass.setBounds(50,400,100,30);
                add(TmemberPass);
                JTextField getTmemberPass = new JTextField(20);
                getTmemberPass.setBounds(195,400,100,30);
                add(getTmemberPass);

                JLabel TLeaderId = new JLabel("Team Leader ID: ");
                TLeaderId.setFont(new Font("Serif",Font.BOLD,20));
                TLeaderId.setBounds(195,500,160,30);
                add(TLeaderId);
                JTextField getTLeaderId = new JTextField(20);
                getTLeaderId.setBounds(365,500,100,30);
                add(getTLeaderId);
                state=3;

                num = 3;
            }

            if (e.getSource() == teamleader) {
                setSize(801, 801);
                setSize(800, 800);
                getContentPane().removeAll();
                add(back);
                F3();
                state = 2;
                select = 1;
            }


            if (e.getSource() == manager) {
                setSize(801, 801);
                setSize(800, 800);
                getContentPane().removeAll();
                add(back);
                F3();
                state = 2;
                select = 2;
            }

            if (e.getSource() == trainee) {
                setSize(801, 801);
                setSize(800, 800);
                getContentPane().removeAll();
                add(back);
                F3();
                state = 2;
                select = 3;

            }
            if (e.getSource() == submit) {
                setSize(801,801);
                setSize(800,800);
                Company x = new Company();
                if (select == 1) {
                    try {
                        Object chosen=x.checkLogintltm(userin.getText(),passin.getText());

                        if(chosen==null) {
                            showMessageDialog(null, "Incorrect Username or Password.");

                        }

                        else{
                            getContentPane().removeAll();
                            add(back);
                            if(chosen instanceof TeamLeader){
                                TeamLeader j=(TeamLeader)chosen;
                                F4(j);
                            }
                            else {
                                TeamMember j=(TeamMember)chosen;
                                F5(j);
                            }
                        }
                        userin.setText("");passin.setText("");
                    }
                    catch (IOException ioException) { ioException.printStackTrace();}
                    catch (ClassNotFoundException classNotFoundException) { classNotFoundException.printStackTrace();}
                }

                if (select == 2) {
                    try {
                        Manager chosen=x.checkLoginm(userin.getText(),passin.getText());
                        if(chosen==null) {
                            userin.setText("");passin.setText("");
                            showMessageDialog(null, "Incorrect Username or Password.");

                        }
                        else {
                            getContentPane().removeAll();
                            add(back);
                            F7(chosen);
                        }

                    }
                    catch (IOException ioException) { ioException.printStackTrace();}
                    catch (ClassNotFoundException classNotFoundException) { classNotFoundException.printStackTrace();}
                }
                if (select == 3) {
                    try {
                        Trainee chosen= x.checkLogintrainee(userin.getText(),passin.getText());
                        if(chosen==null) {
                            showMessageDialog(null, "Incorrect Username or Password.");
                            userin.setText("");passin.setText("");
                        }
                        else {
                            getContentPane().removeAll();
                            add(back);
                            F6(chosen);
                        }
                    } catch (IOException ioException) { ioException.printStackTrace();}
                    catch (ClassNotFoundException classNotFoundException) {classNotFoundException.printStackTrace();}
                }



            }
        }
    }
}