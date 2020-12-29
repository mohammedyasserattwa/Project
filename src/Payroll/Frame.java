package Payroll;
import javafx.scene.input.KeyCode;

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
                JPanel panel = new JPanel();
             //   Trainee.setBounds(100,100,250,50);
                Trainee.setFont(new Font("Serif",Font.BOLD,20));
                panel.add(Trainee);
             //   TeamLeader.setBounds(300,100,250,50);
                TeamLeader.setFont(new Font("Serif",Font.BOLD,20));
                panel.add(TeamLeader);
                //TeamMember.setBounds(500,100,250,50);
                TeamMember.setFont(new Font("Serif",Font.BOLD,20));
                panel.setBounds(100,130,750,50);

                panel.add(TeamMember);
                panel.setVisible(true);
                add(panel);
//                add(TeamLeader);
//                add(TeamMember);
//                add(Trainee);

            }
            if(e.getSource() == Trainee){
                num = 1;
            }
            if(e.getSource() == TeamLeader){
                num = 2;
            }
            if(e.getSource() == TeamMember){
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