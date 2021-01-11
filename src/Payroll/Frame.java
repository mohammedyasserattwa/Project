
package Payroll;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import static javax.swing.JOptionPane.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Frame extends JFrame implements Files {
    //Buttons
    Al al = new Al();

    JButton login = new JButton("Login");
    JButton sign = new JButton("Sign Up");
    JButton trainee = new JButton("Trainee");
    JButton teamleader = new JButton("Team Leader & Team Member");
    JButton manager = new JButton("Manager");
    JButton submit = new JButton("Submit");
    JButton back = new JButton("<--");

    //Manager
    JButton Trainee = new JButton("Trainee");
    JButton TeamLeader = new JButton("Team Leader");
    JButton TeamMember = new JButton("Team Member");
    JButton Add = new JButton("Add");
    JButton Delete = new JButton("Delete");
    JButton Edit = new JButton("Edit");
    JButton view=new JButton("View");


    JLabel welc = new JLabel("Company Payroll");
    JLabel username = new JLabel("Username:");
    JLabel password = new JLabel("Password:");

    JTextField userin = new JTextField(10);
    JPasswordField passin = new JPasswordField(10);
    ////////////////////////////

    public Frame() throws IOException, ClassNotFoundException {
        ///////////////////////////////////////////////////////////
        setTitle("COMPANY");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        ///////////////////////////////////////////////////////////

        welc.setBounds(300, 100, 150, 150);
        welc.setFont(new Font("Serif", Font.ITALIC, 20));
        add(welc);

        login.setBounds(100, 400, 150, 40);
        add(login);

        sign.setBounds(500, 400, 150, 40);
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
        SubButton.addActionListener(al);
        TraineeSubmit.addActionListener(al);
        LeaderSubmit.addActionListener(al);
        EditTrainee.addActionListener(al);
        deleteTrainee.addActionListener(al);
        viewTraineeData.addActionListener(al);
        EditTeamMember.addActionListener(al);
        EditTeamLeader.addActionListener(al);
        deleteTeamMember.addActionListener(al);
        viewTeamMemberData.addActionListener(al);
        ReplaceTeamLeader.addActionListener(al);
        SubmitTeamLeader.addActionListener(al);
        viewTeamLeaderData.addActionListener(al);
        view.addActionListener(al);
        /////////////////////
    }

    //////Welcome Frame//////////
    public void F1() {
        setSize(801, 801);
        add(welc);
        add(login);
        add(sign);

    }

    //Second Frame to choose TeamLeader/TeamMember Manager or Trainee
    public void F2() {
        setSize(805, 805);
        teamleader.setBounds(255, 250, 250, 50);
        add(teamleader);
        trainee.setBounds(160, 400, 100, 50);
        add(trainee);
        manager.setBounds(515, 400, 100, 50);
        add(manager);
        back.setBounds(1, 1, 60, 20);
        add(back);
        //////////////////
    }

    //Entering the Username and Password
    public void F3() {
        username.setBounds(250, 300, 90, 40);
        username.setFont(new Font("Serif", 20, 18));
        add(username);
        userin.setBounds(350, 305, 140, 30);
        add(userin);

        password.setBounds(250, 360, 90, 40);
        password.setFont(new Font("Serif", 20, 18));
        add(password);
        passin.setBounds(350, 365, 140, 30);
        add(passin);

        submit.setBounds(330, 500, 90, 50);
        add(submit);
    }

    //Getting TeamLeader data
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
        salary.setBounds(300, 200, 70, 50);
        salary.setFont(new Font("Serif", 20, 18));
        add(salary);
        JLabel result = new JLabel("$" + chosen.getSalary());
        result.setBounds(370, 200, 150, 50);
        result.setFont(new Font("Serif", 20, 18));
        add(result);
        JLabel team = new JLabel("Your Team Members:  ");
        team.setBounds(180, 250, 300, 50);
        team.setFont(new Font("Serif", 20, 30));
        add(team);


        String column[] = {"ID", "Name", "Age"};
        String data[][] = new String[5][3];

        for (int i = 0; i < chosen.getTeamMembers().size(); i++) {
            data[i][0] = chosen.getTeamMembers().get(i).getId() + "";
            data[i][1] = chosen.getTeamMembers().get(i).getName() + "";
            data[i][2] = chosen.getTeamMembers().get(i).getAge() + "";
        }
        JTable jt = new JTable(data, column);
        JScrollPane sp = new JScrollPane(jt);
        JPanel panel = new JPanel();
        panel.add(sp);
        panel.setBounds(150, 300, 500, 107);
        add(panel);
    }

    //Getting TeamMember data
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
        TeamLeader.setBounds(300, 175, 150, 50);
        TeamLeader.setFont(new Font("Serif", 20, 18));
        add(TeamLeader);

        ArrayList<TeamLeader> teamleaders = Files.readTeamLeader();
        TeamLeader selected = new TeamLeader();
        for (int i = 0; i < teamleaders.size(); i++) {
            for (int j = 0; j < teamleaders.get(i).getTeamMembers().size(); j++) {
                if (chosen.getId() == teamleaders.get(i).getTeamMembers().get(j).getId()) {
                    selected = teamleaders.get(i);
                }
            }
        }
        JLabel tname = new JLabel(selected.getName());
        tname.setBounds(400, 175, 150, 50);
        tname.setFont(new Font("Serif", 20, 18));
        add(tname);

        JLabel result = new JLabel("$" + chosen.getSalary());
        result.setBounds(370, 200, 150, 50);
        result.setFont(new Font("Serif", 20, 18));
        add(result);

        JLabel salary = new JLabel("Salary: ");
        salary.setBounds(300, 200, 70, 50);
        salary.setFont(new Font("Serif", 20, 18));
        add(salary);

    }

    //Getting Trainee data
    public void F6(Trainee chosen) {
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
        TeamLeader.setBounds(300, 175, 150, 50);
        TeamLeader.setFont(new Font("Serif", 20, 18));
        add(TeamLeader);

        JLabel tname = new JLabel(chosen.getFacultyName());
        tname.setBounds(425, 175, 150, 50);
        tname.setFont(new Font("Serif", 20, 18));
        add(tname);

        JLabel NewLabel = new JLabel("Academic Year: ");
        NewLabel.setBounds(300, 200, 150, 50);
        NewLabel.setFont(new Font("Serif", 20, 18));
        add(NewLabel);
//400,200,150,50
        JLabel label1 = new JLabel(chosen.getAcademicYear() + "");
        label1.setBounds(425, 200, 150, 50);
        label1.setFont(new Font("Serif", 20, 18));
        add(label1);

        JLabel gpa = new JLabel("GPA: ");
        gpa.setBounds(300, 225, 50, 50);
        gpa.setFont(new Font("Serif", 20, 18));
        add(gpa);

        JLabel res = new JLabel(chosen.getGPA() + "");
        res.setBounds(350, 225, 50, 50);
        res.setFont(new Font("Serif", 20, 18));
        add(res);


        JLabel salary = new JLabel("Salary: ");
        salary.setBounds(300, 250, 70, 50);
        salary.setFont(new Font("Serif", 20, 18));
        add(salary);

        JLabel result = new JLabel("$" + chosen.getSalary());
        result.setBounds(370, 250, 150, 50);
        result.setFont(new Font("Serif", 20, 18));
        add(result);

    }

    //3 Buttons to choose whether to ADD EDIT or DELETE
    public void F7() {
        //Set bounds for left buttons
        Add.setBounds(0, 230, 150, 100);
        Add.setFont(new Font("Serif", Font.BOLD, 30));
        Edit.setBounds(0, 330, 150, 100);
        Edit.setFont(new Font("Serif", Font.BOLD, 30));
        Delete.setBounds(0, 430, 150, 100);
        Delete.setFont(new Font("Serif", Font.BOLD, 30));
        view.setBounds(0, 530, 150, 100);
        view.setFont(new Font("Serif", Font.BOLD, 30));
        add(Add);
        add(Edit);
        add(Delete);
        add(view);
    }

    //Adding a TeamMember to an existing TeamLeader
    JLabel TmemberName = new JLabel("Name: ");
    JTextField getTmemberName = new JTextField(20);
    JLabel Tmemberage = new JLabel("Age:");
    JTextField getTmemberAge = new JTextField(20);
    JLabel TmemberId = new JLabel("ID: ");
    JTextField getTmemberId = new JTextField(20);
    JLabel TmemberUser = new JLabel("Username: ");
    JTextField getTmemberUser = new JTextField(20);
    JLabel TmemberPass = new JLabel("Password: ");
    JPasswordField getTmemberPass = new JPasswordField(20);
    JLabel TLeaderId = new JLabel("Team Leader ID: ");
    JTextField getTLeaderId = new JTextField(20);
    JButton SubButton = new JButton("Submit");

    public void F8() {
        JLabel TmName = new JLabel("Add Team Member  ");
        TmName.setBounds(150, 30, 460, 100);
        TmName.setFont(new Font("Serif", Font.BOLD, 50));
        add(TmName);


        TmemberName.setFont(new Font("Serif", Font.BOLD, 20));
        TmemberName.setBounds(50, 200, 80, 30);
        add(TmemberName);

        getTmemberName.setBounds(195, 200, 100, 30);
        add(getTmemberName);


        Tmemberage.setFont(new Font("Serif", Font.BOLD, 20));
        Tmemberage.setBounds(50, 250, 80, 30);
        add(Tmemberage);

        getTmemberAge.setBounds(195, 250, 100, 30);
        add(getTmemberAge);


        TmemberId.setFont(new Font("Serif", Font.BOLD, 20));
        TmemberId.setBounds(50, 300, 80, 30);
        add(TmemberId);

        getTmemberId.setBounds(195, 300, 100, 30);
        add(getTmemberId);


        TmemberUser.setFont(new Font("Serif", Font.BOLD, 20));
        TmemberUser.setBounds(50, 350, 100, 30);
        add(TmemberUser);

        getTmemberUser.setBounds(195, 350, 100, 30);
        add(getTmemberUser);


        TmemberPass.setFont(new Font("Serif", Font.BOLD, 20));
        TmemberPass.setBounds(50, 400, 100, 30);
        add(TmemberPass);

        getTmemberPass.setBounds(195, 400, 100, 30);
        add(getTmemberPass);


        TLeaderId.setFont(new Font("Serif", Font.BOLD, 20));
        TLeaderId.setBounds(195, 500, 160, 30);
        add(TLeaderId);

        getTLeaderId.setBounds(365, 500, 100, 30);
        add(getTLeaderId);

        SubButton.setBounds(350, 550, 100, 50);
        add(SubButton);
    }

    //Add Trainee
    JTextField getTacademicYear = new JTextField(20);
    JTextField getTgpa = new JTextField(20);
    JPasswordField getTPass = new JPasswordField(20);
    JTextField getTUser = new JTextField(20);
    JTextField getTName = new JTextField(20);
    JTextField getTAge = new JTextField(20);
    JTextField getTid = new JTextField(20);
    JTextField getTfacultyName = new JTextField(20);
    JButton TraineeSubmit = new JButton("Submit");

    public void F9() {
        JLabel TraineeName = new JLabel("Add Trainee  ");
        TraineeName.setBounds(300, 30, 400, 100);
        TraineeName.setFont(new Font("Serif", Font.BOLD, 50));
        add(TraineeName);

        JLabel Tname = new JLabel("Name: ");
        Tname.setFont(new Font("Serif", Font.BOLD, 20));
        Tname.setBounds(50, 200, 80, 30);
        add(Tname);

        getTName.setBounds(195, 200, 100, 30);
        add(getTName);

        JLabel Tage = new JLabel("Age: ");
        Tage.setFont(new Font("Serif", Font.BOLD, 20));
        Tage.setBounds(50, 250, 80, 30);
        add(Tage);

        getTAge.setBounds(195, 250, 100, 30);
        add(getTAge);

        JLabel Tid = new JLabel("ID: ");
        Tid.setFont(new Font("Serif", Font.BOLD, 20));
        Tid.setBounds(50, 300, 80, 30);
        add(Tid);

        getTid.setBounds(195, 300, 100, 30);
        add(getTid);

        JLabel TfacultyName = new JLabel("Faculty Name: ");
        TfacultyName.setFont(new Font("Serif", Font.BOLD, 20));
        TfacultyName.setBounds(50, 350, 140, 30);
        add(TfacultyName);

        getTfacultyName.setBounds(195, 350, 100, 30);
        add(getTfacultyName);

        JLabel TacademicYear = new JLabel("Academic Year: ");
        TacademicYear.setFont(new Font("Serif", Font.BOLD, 20));
        TacademicYear.setBounds(50, 400, 150, 30);
        add(TacademicYear);

        getTacademicYear.setBounds(195, 400, 100, 30);
        add(getTacademicYear);

        JLabel Tgpa = new JLabel("GPA: ");
        Tgpa.setFont(new Font("Serif", Font.BOLD, 20));
        Tgpa.setBounds(50, 450, 140, 30);
        add(Tgpa);

        getTgpa.setBounds(195, 450, 100, 30);
        add(getTgpa);

        JLabel TUser = new JLabel("Username: ");
        TUser.setFont(new Font("Serif", Font.BOLD, 20));
        TUser.setBounds(50, 500, 100, 30);
        add(TUser);

        getTUser.setBounds(195, 500, 100, 30);
        add(getTUser);

        JLabel TPass = new JLabel("Password: ");
        TPass.setFont(new Font("Serif", Font.BOLD, 20));
        TPass.setBounds(50, 550, 100, 30);
        add(TPass);

        getTPass.setBounds(195, 550, 100, 30);
        add(getTPass);

        TraineeSubmit.setBounds(300, 600, 100, 50);
        add(TraineeSubmit);
    }

    //Adding a TeamLeader with his TeamMembers
    JButton LeaderSubmit = new JButton("Submit");
    JTextField getTlName = new JTextField(20);
    JTextField getTlAge = new JTextField(20);
    JTextField getTlid = new JTextField(20);
    JTextField getTlUser = new JTextField(20);
    JPasswordField getTlPass = new JPasswordField(20);
    //His Team Members
    ArrayList<JTextField> fieldList = new ArrayList<>();

    public void F10() {
        JLabel TeamLeader = new JLabel("Add Team Leader  ");
        TeamLeader.setBounds(400, 30, 430, 100);
        TeamLeader.setFont(new Font("Serif", Font.BOLD, 50));
        add(TeamLeader);

        JLabel Tlname = new JLabel("Name: ");
        Tlname.setFont(new Font("Serif", Font.BOLD, 20));
        Tlname.setBounds(50, 200, 80, 30);
        add(Tlname);

        getTlName.setBounds(195, 200, 100, 30);
        add(getTlName);

        JLabel Tlage = new JLabel("Age: ");
        Tlage.setFont(new Font("Serif", Font.BOLD, 20));
        Tlage.setBounds(50, 250, 80, 30);
        add(Tlage);

        getTlAge.setBounds(195, 250, 100, 30);
        add(getTlAge);

        JLabel Tlid = new JLabel("ID: ");
        Tlid.setFont(new Font("Serif", Font.BOLD, 20));
        Tlid.setBounds(50, 300, 80, 30);
        add(Tlid);

        getTlid.setBounds(195, 300, 100, 30);
        add(getTlid);

        JLabel TlUser = new JLabel("Username: ");
        TlUser.setFont(new Font("Serif", Font.BOLD, 20));
        TlUser.setBounds(350, 200, 100, 30);
        add(TlUser);

        getTlUser.setBounds(460, 200, 100, 30);
        add(getTlUser);

        JLabel TlPass = new JLabel("Password: ");
        TlPass.setFont(new Font("Serif", Font.BOLD, 20));
        TlPass.setBounds(350, 300, 100, 30);
        add(TlPass);

        getTlPass.setBounds(460, 300, 100, 30);
        add(getTlPass);

        JLabel Tlmember = new JLabel("Team Members ");         //id name age
        Tlmember.setBounds(450, 350, 200, 30);
        Tlmember.setFont(new Font("Serif", Font.BOLD, 23));
        add(Tlmember);
        for (int i = 0, j = 0; i < 5; i++, j += 50) {
            JLabel TlmembersName = new JLabel("Name: ");
            TlmembersName.setFont(new Font("Serif", Font.BOLD, 20));
            TlmembersName.setBounds(50, 400 + j, 80, 30);
            add(TlmembersName);
            JTextField getTlmembersName = new JTextField(20);
            fieldList.add(getTlmembersName);
            getTlmembersName.setBounds(135, 400 + j, 100, 30);
            add(getTlmembersName);

            JLabel TlmembersId = new JLabel("ID: ");
            TlmembersId.setFont(new Font("Serif", Font.BOLD, 20));
            TlmembersId.setBounds(265, 400 + j, 40, 30);
            add(TlmembersId);
            JTextField getTlmembersId = new JTextField(20);
            fieldList.add(getTlmembersId);
            getTlmembersId.setBounds(315, 400 + j, 100, 30);
            add(getTlmembersId);

            JLabel TlmembersAge = new JLabel("Age: ");
            TlmembersAge.setFont(new Font("Serif", Font.BOLD, 20));
            TlmembersAge.setBounds(445, 400 + j, 50, 30);
            add(TlmembersAge);
            JTextField getTlmembersAge = new JTextField(20);
            fieldList.add(getTlmembersAge);
            getTlmembersAge.setBounds(505, 400 + j, 100, 30);
            add(getTlmembersAge);

            JLabel TlmembersUser = new JLabel("Username: ");
            TlmembersUser.setFont(new Font("Serif", Font.BOLD, 20));
            TlmembersUser.setBounds(635, 400 + j, 110, 30);
            add(TlmembersUser);
            JTextField getTlmembersUser = new JTextField(20);
            fieldList.add(getTlmembersUser);
            getTlmembersUser.setBounds(755, 400 + j, 100, 30);
            add(getTlmembersUser);

            JLabel TlmembersPass = new JLabel("Password: ");
            TlmembersPass.setFont(new Font("Serif", Font.BOLD, 20));
            TlmembersPass.setBounds(885, 400 + j, 110, 30);
            add(TlmembersPass);
            JPasswordField getTlmembersPass = new JPasswordField(20);
            fieldList.add(getTlmembersPass);
            getTlmembersPass.setBounds(1005, 400 + j, 100, 30);
            add(getTlmembersPass);
        }
        LeaderSubmit.setBounds(505, 700, 100, 40);
        add(LeaderSubmit);
    }

    //Edit Trainee
    JComboBox TraineeCombo;
    JTextField name = new JTextField(20);
    JTextField age = new JTextField(20);
    JTextField FacultyName = new JTextField(20);
    JTextField academicYear = new JTextField(20);
    JTextField GPA = new JTextField(20);
    JButton EditTrainee = new JButton("Submit");
    ArrayList<Trainee> TraineeList = Files.readTrainee();
    ArrayList<String> data = new ArrayList();

    public void F11() {
        JLabel EDITtrainee = new JLabel("Edit Trainee ");
        EDITtrainee.setBounds(225, 10, 430, 90);
        EDITtrainee.setFont(new Font("Serif", Font.BOLD, 50));
        add(EDITtrainee);

        for (int i = 0; i < TraineeList.size(); i++) {
            data.add(TraineeList.get(i).getId() + "  " + TraineeList.get(i).getName());
        }
        JLabel info = new JLabel("Enter the fields you would like to edit: ");
        info.setFont(new Font("Serif", 1, 20));
        info.setBounds(50, 90, 400, 50);
        add(info);

        TraineeCombo = new JComboBox(data.toArray());
        JLabel ComboBox = new JLabel("Trainee: ");
        ComboBox.setFont(new Font("Serif", 1, 20));
        ComboBox.setBounds(50, 150, 100, 30);
        add(ComboBox);

        TraineeCombo.setFont(new Font("Serif", 0, 20));
        TraineeCombo.setBounds(210, 150, 170, 30);
        add(TraineeCombo);

        JLabel Tname = new JLabel("Name: ");
        Tname.setFont(new Font("Serif", Font.BOLD, 20));
        Tname.setBounds(50, 200, 80, 30);
        add(Tname);

        name.setBounds(210, 200, 150, 30);
        add(name);

        JLabel Tage = new JLabel("Age: ");
        Tage.setFont(new Font("Serif", Font.BOLD, 20));
        Tage.setBounds(50, 250, 80, 30);
        add(Tage);

        age.setBounds(210, 250, 150, 30);
        add(age);

        JLabel TfacultyName = new JLabel("Faculty Name: ");
        TfacultyName.setFont(new Font("Serif", Font.BOLD, 20));
        TfacultyName.setBounds(50, 300, 140, 30);
        add(TfacultyName);

        FacultyName.setBounds(210, 300, 150, 30);
        add(FacultyName);

        JLabel TacademicYear = new JLabel("Academic Year: ");
        TacademicYear.setFont(new Font("Serif", Font.BOLD, 20));
        TacademicYear.setBounds(50, 350, 150, 30);
        add(TacademicYear);

        academicYear.setBounds(210, 350, 150, 30);
        add(academicYear);

        JLabel Tgpa = new JLabel("GPA: ");
        Tgpa.setFont(new Font("Serif", Font.BOLD, 20));
        Tgpa.setBounds(50, 400, 80, 30);
        add(Tgpa);

        GPA.setBounds(210, 400, 150, 30);
        add(GPA);

        EditTrainee.setBounds(350, 600, 100, 50);
        add(EditTrainee);
    }

    //Edit Team Member
    JComboBox TeamMemberCombo;
    JTextField TeamMembername = new JTextField(20);
    JTextField TeamMemberage = new JTextField(20);
    JButton EditTeamMember = new JButton("Submit");
    ArrayList<TeamLeader> TeamMemberList = Files.readTeamLeader();
    ArrayList<String> dataTeamMember = new ArrayList();

    public void F12() {
        JLabel EDITteamMember = new JLabel("Edit Team Member ");
        EDITteamMember.setBounds(195, 10, 550, 90);
        EDITteamMember.setFont(new Font("Serif", Font.BOLD, 50));
        add(EDITteamMember);

        JLabel infoTeamM = new JLabel("Enter the fields you would like to edit: ");
        infoTeamM.setFont(new Font("Serif", 1, 20));
        infoTeamM.setBounds(50, 90, 400, 50);
        add(infoTeamM);

        for (int i = 0; i < TeamMemberList.size(); i++) {
            for (int j = 0; j < TeamMemberList.get(i).getTeamMembers().size(); j++) {
                dataTeamMember.add(TeamMemberList.get(i).getTeamMembers().get(j).getId() + "  " + TeamMemberList.get(i).getTeamMembers().get(j).getName());
            }
        }
        TeamMemberCombo = new JComboBox(dataTeamMember.toArray());
        JLabel ComboBox = new JLabel("Team Member: ");
        ComboBox.setFont(new Font("Serif", 1, 20));
        ComboBox.setBounds(50, 150, 180, 30);
        add(ComboBox);

        TeamMemberCombo.setFont(new Font("Serif", 0, 20));
        TeamMemberCombo.setBounds(240, 150, 170, 30);
        add(TeamMemberCombo);

        JLabel TeamMmemberName = new JLabel("Name: ");
        TeamMmemberName.setFont(new Font("Serif", Font.BOLD, 20));
        TeamMmemberName.setBounds(50, 200, 80, 30);
        add(TeamMmemberName);

        TeamMembername.setBounds(240, 200, 150, 30);
        add(TeamMembername);

        JLabel TeamMemberAge = new JLabel("Age: ");
        TeamMemberAge.setFont(new Font("Serif", Font.BOLD, 20));
        TeamMemberAge.setBounds(50, 250, 80, 30);
        add(TeamMemberAge);

        TeamMemberage.setBounds(240, 250, 150, 30);
        add(TeamMemberage);

        EditTeamMember.setBounds(350, 600, 100, 50);
        add(EditTeamMember);

    }

    //Edit Team Leader
    JComboBox LeaderCombo;
    ArrayList<TeamLeader> TeamLeaderList = Files.readTeamLeader();
    ArrayList<String> dataTeamLeader = new ArrayList();
    JTextField EditTeamLeaderName = new JTextField(20);
    JTextField EditTeamLeaderAge = new JTextField(20);
    JButton EditTeamLeader = new JButton("Submit");

    public void F13() {
        JLabel EDITteamLeader = new JLabel("Edit Team Leader ");
        EDITteamLeader.setBounds(195, 10, 550, 90);
        EDITteamLeader.setFont(new Font("Serif", Font.BOLD, 50));
        add(EDITteamLeader);

        JLabel infoTeamL = new JLabel("Enter the fields you would like to edit: ");
        infoTeamL.setFont(new Font("Serif", 1, 20));
        infoTeamL.setBounds(50, 90, 400, 50);
        add(infoTeamL);

        for (int i = 0; i < TeamLeaderList.size(); i++) {
            dataTeamLeader.add(TeamLeaderList.get(i).getId() + "  " + TeamLeaderList.get(i).getName());
        }
        LeaderCombo = new JComboBox(dataTeamLeader.toArray());
        JLabel ComboBox = new JLabel("Team Leader: ");
        ComboBox.setFont(new Font("Serif", 1, 20));
        ComboBox.setBounds(50, 150, 180, 30);
        add(ComboBox);

        LeaderCombo.setFont(new Font("Serif", 0, 20));
        LeaderCombo.setBounds(240, 150, 170, 30);
        add(LeaderCombo);

        JLabel TleaderName = new JLabel("Name: ");
        TleaderName.setFont(new Font("Serif", Font.BOLD, 20));
        TleaderName.setBounds(50, 200, 80, 30);
        add(TleaderName);

        EditTeamLeaderName.setBounds(240, 200, 150, 30);
        add(EditTeamLeaderName);

        JLabel TeamLeaderAge = new JLabel("Age: ");
        TeamLeaderAge.setFont(new Font("Serif", Font.BOLD, 20));
        TeamLeaderAge.setBounds(50, 250, 80, 30);
        add(TeamLeaderAge);

        EditTeamLeaderAge.setBounds(240, 250, 150, 30);
        add(EditTeamLeaderAge);

        EditTeamLeader.setBounds(350, 600, 100, 50);
        add(EditTeamLeader);
    }

    //Button to delete Trainee by entering his ID
    JButton viewTraineeData = new JButton("View Data");
    JButton deleteTrainee = new JButton("Delete");
    JTextField deleteID = new JTextField(20);

    public void F14() {
        JLabel DELETEtrainee = new JLabel("Delete Trainee ");
        DELETEtrainee.setBounds(225, 30, 430, 100);
        DELETEtrainee.setFont(new Font("Serif", Font.BOLD, 50));
        add(DELETEtrainee);

        JLabel ID = new JLabel("Trainee's ID: ");
        ID.setFont(new Font("Serif", Font.BOLD, 20));
        ID.setBounds(250, 150, 120, 30);
        add(ID);

        deleteID.setBounds(380, 150, 100, 30);
        add(deleteID);

        viewTraineeData.setBounds(250, 600, 150, 50);
        viewTraineeData.setFont(new Font("Serif", Font.BOLD, 20));
        add(viewTraineeData);

        deleteTrainee.setBounds(410, 600, 150, 50);
        deleteTrainee.setFont(new Font("Serif", Font.BOLD, 20));
        add(deleteTrainee);
    }

    //Button to delete TeamMember by entering his ID
    JButton viewTeamMemberData = new JButton("View Data");
    JButton deleteTeamMember = new JButton("Delete");
    JTextField deleteTeamMemberID = new JTextField(20);

    public void F15() {
        JLabel DELETETeamMember = new JLabel("Delete Team Member ");
        DELETETeamMember.setBounds(185, 10, 550, 90);
        DELETETeamMember.setFont(new Font("Serif", Font.BOLD, 50));
        add(DELETETeamMember);

        JLabel TeamMemberID = new JLabel("Team Member ID: ");
        TeamMemberID.setFont(new Font("Serif", Font.BOLD, 20));
        TeamMemberID.setBounds(200, 150, 170, 30);
        add(TeamMemberID);

        deleteTeamMemberID.setBounds(380, 150, 100, 30);
        add(deleteTeamMemberID);

        viewTeamMemberData.setBounds(250, 600, 150, 50);
        viewTeamMemberData.setFont(new Font("Serif", Font.BOLD, 20));
        add(viewTeamMemberData);

        deleteTeamMember.setBounds(410, 600, 150, 50);
        deleteTeamMember.setFont(new Font("Serif", Font.BOLD, 20));
        add(deleteTeamMember);
    }

    //Button to delete TeamLeader by entering his ID
    JButton viewTeamLeaderData = new JButton("View Data");
    JButton ReplaceTeamLeader = new JButton("Replace");
    JTextField deleteTeamLeaderID = new JTextField(20);

    public void F16() {
        JLabel DELETETeamLeader = new JLabel("Delete & Replace Team Leader  ");
        DELETETeamLeader.setBounds(200, 30, 520, 100);
        DELETETeamLeader.setFont(new Font("Serif", Font.BOLD, 30));
        add(DELETETeamLeader);

        JLabel TeamLeaderID = new JLabel("Team Leader's ID: ");
        TeamLeaderID.setFont(new Font("Serif", Font.BOLD, 20));
        TeamLeaderID.setBounds(230, 150, 170, 30);
        add(TeamLeaderID);

        deleteTeamLeaderID.setBounds(410, 150, 100, 30);
        add(deleteTeamLeaderID);

        JLabel note = new JLabel("*The current team members will be assigned to the new team leader...");
        note.setFont(new Font("Serif", Font.BOLD, 15));
        note.setBounds(200, 650, 500, 20);
        add(note);

        viewTeamLeaderData.setBounds(250, 680, 150, 50);
        viewTeamLeaderData.setFont(new Font("Serif", Font.BOLD, 20));
        add(viewTeamLeaderData);

        ReplaceTeamLeader.setBounds(410, 680, 150, 50);
        ReplaceTeamLeader.setFont(new Font("Serif", Font.BOLD, 20));
        add(ReplaceTeamLeader);
    }

    //Delet function by replacing old TeamLeader with a new TeamLeader
    JTextField getrepTlName = new JTextField(20);
    JTextField getrepTlAge = new JTextField(20);
    JTextField getrepTlid = new JTextField(20);
    JTextField getrepTlUser = new JTextField(20);
    JPasswordField getrepTlPass = new JPasswordField(20);
    JButton SubmitTeamLeader = new JButton("Submit");

    public void replaceTL() {
        getContentPane().removeAll();
        getContentPane().revalidate();
        setSize(801, 801);
        setSize(800, 800);
        JLabel replacedTeamLeader = new JLabel("Replace Team Leader  ");
        replacedTeamLeader.setBounds(215, 30, 520, 100);
        replacedTeamLeader.setFont(new Font("Serif", Font.BOLD, 30));
        add(replacedTeamLeader);

        JLabel replacedTlname = new JLabel("Name: ");
        replacedTlname.setFont(new Font("Serif", Font.BOLD, 20));
        replacedTlname.setBounds(50, 200, 80, 30);
        add(replacedTlname);

        getrepTlName.setBounds(195, 200, 100, 30);
        add(getrepTlName);

        JLabel replacedTlid = new JLabel("ID: ");
        replacedTlid.setFont(new Font("Serif", Font.BOLD, 20));
        replacedTlid.setBounds(50, 300, 80, 30);
        add(replacedTlid);

        getrepTlid.setBounds(195, 300, 100, 30);
        add(getrepTlid);

        JLabel replacedTlage = new JLabel("Age: ");
        replacedTlage.setFont(new Font("Serif", Font.BOLD, 20));
        replacedTlage.setBounds(50, 250, 80, 30);
        add(replacedTlage);

        getrepTlAge.setBounds(195, 250, 100, 30);
        add(getrepTlAge);

        JLabel replacedTlUser = new JLabel("Username: ");
        replacedTlUser.setFont(new Font("Serif", Font.BOLD, 20));
        replacedTlUser.setBounds(350, 200, 100, 30);
        add(replacedTlUser);

        getrepTlUser.setBounds(460, 200, 100, 30);
        add(getrepTlUser);

        JLabel replacedTlPass = new JLabel("Password: ");
        replacedTlPass.setFont(new Font("Serif", Font.BOLD, 20));
        replacedTlPass.setBounds(350, 300, 100, 30);
        add(replacedTlPass);

        getrepTlPass.setBounds(460, 300, 100, 30);
        add(getrepTlPass);

        SubmitTeamLeader.setBounds(310, 600, 150, 50);
        SubmitTeamLeader.setFont(new Font("Serif", Font.BOLD, 20));
        add(SubmitTeamLeader);


    }

    //View Trainee data
    public void F17(){//int id, String name, int age, String facultyName, int academicYear, double GPA,String Username, String Password
        String column[] = {"ID", "Name", "Age","Faculty Name","Academic Year","GPA","Username","Password"};

        try {
            ArrayList<Trainee>viewTraineeData=Files.readTrainee();
            int y=viewTraineeData.size();
            int height = 27;
            String data[][] = new String[y][8];
            for (int i=0;i<viewTraineeData.size();i++){
                data[i][0]=viewTraineeData.get(i).getId()+"";
                data[i][1]=viewTraineeData.get(i).getName()+"";
                data[i][2]=viewTraineeData.get(i).getAge()+"";
                data[i][3]=viewTraineeData.get(i).getFacultyName()+"";
                data[i][4]=viewTraineeData.get(i).getAcademicYear()+"";
                data[i][5]=viewTraineeData.get(i).getGPA()+"";
                data[i][6]=viewTraineeData.get(i).getUsername()+"";
                data[i][7]=viewTraineeData.get(i).getPassword()+"";
                height += 15;
            }
            JTable jt = new JTable(data, column);
            JScrollPane sp = new JScrollPane(jt);
            jt.setRowHeight(15);
           // JPanel panel = new JPanel();
        int counter = 0;
        int[] width = {75,75,75,100,100,75,75,75};
        for(int Width:width){
            TableColumn Column = jt.getColumnModel().getColumn(counter++);
            Column.setMinWidth(Width);
            Column.setMaxWidth(Width);
            Column.setPreferredWidth(Width);
        }
            jt.setFillsViewportHeight(true);
sp.setBounds(100,300,650,height);
        add(sp);
        setPreferredSize(new Dimension(500,height));
        }
        catch (IOException e) { e.printStackTrace();}
        catch (ClassNotFoundException e) { e.printStackTrace();}
    }

    //Manager choose which one (TeamLeader/TeamMember/Trainee) he wants to ADD EDIT DELETE or VIEW
    public void Role() {
        Trainee.setBounds(100, 100, 200, 50);
        Trainee.setFont(new Font("Serif", Font.BOLD, 20));
        add(Trainee);

        TeamLeader.setBounds(310, 100, 200, 50);
        TeamLeader.setFont(new Font("Serif", Font.BOLD, 20));
        add(TeamLeader);

        TeamMember.setBounds(520, 100, 200, 50);
        TeamMember.setFont(new Font("Serif", Font.BOLD, 20));
        add(TeamMember);
    }

    //Deleting TeamLeader
    TeamLeader chosenTeamLeader = new TeamLeader();
    int indexTeamLeader=0;
    public class Al implements ActionListener {
        int state = 0;
        int select = 0;
        int num = 0;
        int roleState = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            getContentPane().revalidate();

            /////////////Back Button/////////////
            if (e.getSource() == back) {
                if (state == 1) {
                    userin.setText("");
                    passin.setText("");
                    getContentPane().removeAll();
                    getContentPane().revalidate();
                    add(back);
                    F1();
                }
                if (state == 2) {
                    userin.setText("");
                    passin.setText("");
                    getContentPane().removeAll();
                    getContentPane().revalidate();
                    add(back);
                    F2();
                    state--;
                }
                if (state == 3) {                                   ///////////////Need to be seen again///////////////////////
                    getContentPane().removeAll();
                    getContentPane().revalidate();
                    add(back);
                    F8();
                    state = 2;
                }
            }

            /////////////Login/////////////
            if (e.getSource() == login) {
                setSize(801, 801);
                setSize(800, 800);
                getContentPane().removeAll();
                add(back);
                F2();
                state = 1;
            }

            ///////////Checking Username & Password/////////////
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
                setSize(801, 801);
                setSize(800, 800);
                Company x = new Company();
                if (select == 1) {
                    try {
                        Object chosen = x.checkLogintltm(userin.getText(), passin.getText());

                        if (chosen == null) {
                            showMessageDialog(null, "Incorrect Username or Password.");

                        } else {
                            getContentPane().removeAll();
                            add(back);
                            if (chosen instanceof TeamLeader) {
                                TeamLeader j = (TeamLeader) chosen;
                                F4(j);
                            } else {
                                TeamMember j = (TeamMember) chosen;
                                F5(j);
                            }
                        }
                        userin.setText("");
                        passin.setText("");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    }
                }

                if (select == 2) {
                    try {
                        Manager chosen = x.checkLoginm(userin.getText(), passin.getText());
                        if (chosen == null) {
                            userin.setText("");
                            passin.setText("");
                            showMessageDialog(null, "Incorrect Username or Password.");

                        } else {
                            getContentPane().removeAll();
                            add(back);
                            F7();
                        }

                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    }
                }
                if (select == 3) {
                    try {
                        Trainee chosen = x.checkLogintrainee(userin.getText(), passin.getText());
                        if (chosen == null) {
                            showMessageDialog(null, "Incorrect Username or Password.");
                            userin.setText("");
                            passin.setText("");
                        } else {
                            getContentPane().removeAll();
                            add(back);
                            F6(chosen);
                        }
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    }
                }
            }

            //Choosing whether to Add Edit or Delete in a specfic Member
            if (e.getSource() == Trainee) {
                getContentPane().removeAll();
                getContentPane().revalidate();
                setSize(801, 801);
                setSize(800, 800);
                //Add
                if (roleState == 1) {
                    num = 1;
                    add(back);
                    F9();
                    state = 3;
                }
                //EDIT
                else if (roleState == 2) {
                    F11();
                }
                //Delete
                else if (roleState == 3) {
                    F14();
                }
                //View
                else if(roleState==4){
                    F17();
                }
            }
            if (e.getSource() == TeamLeader) {
                //ADD
                if (roleState == 1) {
                    num = 2;
                    getContentPane().removeAll();
                    setSize(1150, 801);
                    F10();
                }
                //EDIT
                else if (roleState == 2) {
                    getContentPane().removeAll();
                    setSize(801, 801);
                    setSize(800, 800);
                    F13();
                }
                //DELETE
                else if (roleState == 3) {
                    getContentPane().removeAll();
                    setSize(801, 801);
                    setSize(800, 800);
                    F16();
                }

            }
            if (e.getSource() == TeamMember) {
                getContentPane().removeAll();
                getContentPane().revalidate();
                setSize(801, 801);
                setSize(800, 800);
                //ADD
                if (roleState == 1) {
                    F8();
                    state = 3;
                }
                //EDIT
                else if (roleState == 2) {
                    F12();
                } else if (roleState == 3) {
                    F15();
                }
            }

            ////////////Adding////////////////
            if (e.getSource() == Add) {
                setSize(801, 801);
                setSize(800, 800);
                Role();
                roleState = 1;
            }
            if (e.getSource() == TraineeSubmit) {
                try {
                    ArrayList<Trainee> TraineeList = Files.readTrainee();
                    int id = Integer.parseInt(getTid.getText());
                    String name = getTName.getText();
                    int age = Integer.parseInt(getTAge.getText());
                    double gpa = Double.parseDouble(getTgpa.getText());
                    String FacultyName = getTfacultyName.getText();
                    String username = getTUser.getText();
                    String password = getTPass.getText();
                    int academicYear = Integer.parseInt(getTacademicYear.getText());
                    boolean check = true;
                    for (int i = 0; i < TraineeList.size(); i++) {
                        if (TraineeList.get(i).getId() == id) {
                            showMessageDialog(null, "Id already in use.");
                            getTid.setText("");
                            check = false;
                        } else if (TraineeList.get(i).getUsername().equalsIgnoreCase(username)) {
                            showMessageDialog(null, "username already in use.");
                            getTUser.setText("");
                            check = false;
                        }
                    }
                    if (check) {
                        TraineeList.add(new Trainee(id, name, age, FacultyName, academicYear, gpa, username, password));
                        Files.writeTrainee(TraineeList);
                        showMessageDialog(null, "Trainee Successfully Added.");
                        getTid.setText("");
                        getTName.setText("");
                        getTAge.setText("");
                        getTgpa.setText("");
                        getTfacultyName.setText("");
                        getTUser.setText("");
                        getTPass.setText("");
                        getTacademicYear.setText("");
                        data.add(id + " " + name);
                        getContentPane().removeAll();
                        setSize(801, 801);
                        setSize(800, 800);
                        F7();
                        getContentPane().revalidate();
                    }
                } catch (IOException el) {
                } catch (ClassNotFoundException c) {
                }
            }
            if (e.getSource() == LeaderSubmit) {
                try {
                    boolean check = true;
                    ArrayList<TeamLeader> Leader = Files.readTeamLeader();
                    if (getTlName.getText().equals("") || getTlid.getText().equals("") || getTlAge.getText().equals("") || getTlUser.getText().equals("") || getTlPass.getText().equals("")) {
                        showMessageDialog(null, "There is a Missing Field");
                        check = false;
                    }
                    int LeaderID = Integer.parseInt(getTlid.getText());
                    String LeaderName = getTlName.getText();
                    int LeaderAge = Integer.parseInt(getTlAge.getText());
                    String LeaderUser = getTlUser.getText();
                    String LeaderPass = getTlPass.getText();
                    for (int i = 0; i < Leader.size(); i++) {
                        if (Leader.get(i).getId() == LeaderID) {
                            showMessageDialog(null, "ID already exists");
                            getTlid.setText("");
                            check = false;
                        } else if (Leader.get(i).getUsername().equalsIgnoreCase(LeaderUser)) {
                            showMessageDialog(null, "Username already exists");
                            getTlUser.setText("");
                            check = false;
                        }
                    }
                    ArrayList<TeamMember> listMembers = new ArrayList<>();
                    for (int i = 0; i < 25; i += 5) {
                        if (fieldList.get(i).getText().equals("") && fieldList.get(i + 1).getText().equals("") && fieldList.get(i + 2).getText().equals("") && fieldList.get(i + 3).getText().equals("") && fieldList.get(i + 4).getText().equals("") && i < 5) {
                            showMessageDialog(null, "Add at least 1 Team Member");
                            check = false;
                            break;
                        }
                        else if ((!fieldList.get(i).getText().equals("") && !fieldList.get(i + 1).getText().equals("") && !fieldList.get(i + 2).getText().equals("") && !fieldList.get(i + 3).getText().equals("") && !fieldList.get(i + 4).getText().equals(""))) {
                            int id = Integer.parseInt(fieldList.get(i + 1).getText());
                            int age = Integer.parseInt(fieldList.get(i + 2).getText());
                            listMembers.add(new TeamMember(fieldList.get(i).getText(), id, age, fieldList.get(i + 3).getText(), fieldList.get(i + 4).getText()));
                            dataTeamMember.add(id+" "+fieldList.get(i).getText());
                        }
                        else if ((!fieldList.get(i).getText().equals("") || !fieldList.get(i + 1).getText().equals("") || !fieldList.get(i + 2).getText().equals("") || !fieldList.get(i + 3).getText().equals("") || !fieldList.get(i + 4).getText().equals(""))) {
                            showMessageDialog(null, "Missing fields.");
                            check=false;
                            break;
                        }
                    }
                    if (check) {
                        Leader.add(new TeamLeader(LeaderName, LeaderID, LeaderAge, listMembers, LeaderUser, LeaderPass));
                        Files.writeTeamLeader(Leader);
                        showMessageDialog(null, "Successfully Saved");
                        dataTeamLeader.add(LeaderID+" "+LeaderName);
                        getContentPane().removeAll();
                        setSize(800, 800);
                        setSize(801, 801);
                        F7();
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
            if (e.getSource() == SubButton) {
                try {
                    ArrayList<TeamLeader> teamLeaders = Files.readTeamLeader();
                    int index;
                    boolean check = false, check2 = true;
                    for (int i = 0; i < teamLeaders.size(); i++) {
                        if ((teamLeaders.get(i).getId() + "").equals(getTLeaderId.getText())) {
                            if (teamLeaders.get(i).getTeamMembers().size() != 5) {
                                String name = getTmemberName.getText();
                                int age = Integer.parseInt(getTmemberAge.getText());
                                int id = Integer.parseInt(getTmemberId.getText());
                                for (int j = 0; j < teamLeaders.get(i).getTeamMembers().size(); j++) {
                                    if (teamLeaders.get(i).getTeamMembers().get(j).getId() == id) {
                                        showMessageDialog(null, "Id already exists");
                                        check2 = false;
                                        getTmemberId.setText("");
                                    }
                                    if (teamLeaders.get(i).getTeamMembers().get(j).getUsername().equals(getTmemberUser.getText())) {
                                        showMessageDialog(null, "Username already exists");
                                        check2 = false;
                                        getTmemberUser.setText("");
                                    }
                                }
                                if (check2) {
                                    teamLeaders.get(i).getTeamMembers().add(new TeamMember(name, id, age, getTmemberUser.getText(), getTmemberPass.getText()));//String name, int id, int age, String Username, String Password

                                    Files.writeTeamLeader(teamLeaders);
                                    showMessageDialog(null, "Team Member Successfully saved in this TeamLeader");
                                    dataTeamMember.add(id+" "+name);
                                    getContentPane().removeAll();
                                    setSize(801, 801);
                                    setSize(800, 800);
                                    F7();
                                    getContentPane().revalidate();
                                }
                            } else {
                                showMessageDialog(null, "The Team is full");
                                //set null to text
                                getTLeaderId.setText("");
                            }
                            check = true;
                        }
                    }
                    if (check == false) {
                        showMessageDialog(null, "TeamLeader not found.");
                    }

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }

            ///////////Edit/////////////////
            if (e.getSource() == Edit) {
                setSize(801, 801);
                setSize(800, 800);
                roleState = 2;
                Role();
            }
            if (e.getSource() == EditTrainee) {
                String str = (String) TraineeCombo.getSelectedItem();
                String id = str.substring(0, str.indexOf(" "));
                Trainee chosen = new Trainee();
                int index = 0;

                for (int i = 0; i < TraineeList.size(); i++) {
                    if (Integer.parseInt(id) == TraineeList.get(i).getId()) {
                        chosen = TraineeList.get(i);
                        index = i;
                        break;
                    }
                }//Save
                String Traineename = (!name.getText().equals("")) ? name.getText() : chosen.getName();
                int TraineeAge = (!age.getText().equals("")) ? Integer.parseInt(age.getText()) : chosen.getAge();
                int academicyear = (!academicYear.getText().equals("")) ? Integer.parseInt(academicYear.getText()) : chosen.getAcademicYear();
                String fn = (!FacultyName.getText().equals("")) ? FacultyName.getText() : chosen.getFacultyName();
                double gpa = (!GPA.getText().equals("")) ? Double.parseDouble(GPA.getText()) : chosen.getGPA();
                Trainee t = new Trainee(chosen.getId(), Traineename, TraineeAge, fn, academicyear, gpa, chosen.getUsername(), chosen.getPassword());
                TraineeList.set(index, t);

                for (int i = 0; i < TraineeList.size(); i++) {
                    if (Integer.parseInt(id) == TraineeList.get(i).getId()) {
                        chosen = TraineeList.get(i);
                        index = i;
                        break;
                    }
                }
                TraineeList.set(index, t);
                try {
                    Files.writeTrainee(TraineeList);
                    showMessageDialog(null, "Successfully Saved.");

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
            if (e.getSource() == EditTeamMember) {
                String str = (String) TeamMemberCombo.getSelectedItem();
                String id = str.substring(0, str.indexOf(" "));
                TeamMember chosen = new TeamMember();
                int indexL = 0;
                int indexM = 0;
                for (int i = 0; i < TeamMemberList.size(); i++) {
                    for (int j = 0; j < TeamMemberList.get(i).getTeamMembers().size(); j++) {
                        if (Integer.parseInt(id) == TeamMemberList.get(i).getTeamMembers().get(j).getId()) {
                            chosen = TeamMemberList.get(i).getTeamMembers().get(j);
                            indexL = i;
                            indexM = j;
                            break;
                        }
                    }
                }//String name, int id, int age, String Username, String Password
                String TeamMemberName = (!TeamMembername.getText().equals("")) ? TeamMembername.getText() : chosen.getName();
                int TeamMemberAge = (!TeamMemberage.getText().equals("")) ? Integer.parseInt(TeamMemberage.getText()) : chosen.getAge();
                TeamMember teamMember = new TeamMember(TeamMemberName, chosen.getId(), TeamMemberAge, chosen.getUsername(), chosen.getPassword());
                TeamMemberList.get(indexL).getTeamMembers().set(indexM, teamMember);
                try {
                    Files.writeTeamLeader(TeamMemberList);
                    showMessageDialog(null, "Successfully Saved.");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
            if (e.getSource() == EditTeamLeader) {
                String str = (String) LeaderCombo.getSelectedItem();
                String id = str.substring(0, str.indexOf(" "));
                TeamLeader chosen = new TeamLeader();
                int index = 0;

                for (int i = 0; i < TeamLeaderList.size(); i++) {
                    if (Integer.parseInt(id) == TeamLeaderList.get(i).getId()) {
                        chosen = TeamLeaderList.get(i);
                        index = i;
                        break;
                    }
                }//String name, int id, int age, ArrayList<TeamMember> TeamMembers, String Username,String Password
                String TeamLeaderName = (!EditTeamLeaderName.getText().equals("")) ? EditTeamLeaderName.getText() : chosen.getName();
                int TeamLeaderAge = (!EditTeamLeaderAge.getText().equals("")) ? Integer.parseInt(EditTeamLeaderAge.getText()) : chosen.getAge();
                TeamLeader teamLeader = new TeamLeader(TeamLeaderName, chosen.getId(), TeamLeaderAge, chosen.getTeamMembers(), chosen.getUsername(), chosen.getPassword());
                TeamLeaderList.set(index, teamLeader);
                try {
                    Files.writeTeamLeader(TeamLeaderList);
                    showMessageDialog(null, "Successfully Saved");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }


            /////////////Delete////////////////
            if (e.getSource() == Delete) {
                setSize(801, 801);
                setSize(800, 800);
                roleState = 3;
                Role();
            }

            //Delete Trainee
            if (e.getSource() == deleteTrainee) {
                int index;
                ArrayList<Trainee> delete = new ArrayList<>();
                try {
                    delete = Files.readTrainee();
                    if (deleteID.getText().equals("")) {
                        showMessageDialog(null, "Wrong ID...");
                    }
                    for (int i = 0; i < delete.size(); i++) {
                        index = i;
                        if (Integer.parseInt(deleteID.getText()) == delete.get(i).getId()) {
                            delete.remove(index);
                            showMessageDialog(null, "Successfully deleted");
                            deleteID.setText("");
                            break;
                        }
                    }
                    Files.writeTrainee(delete);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
            if (e.getSource() == viewTraineeData) {
                boolean check = true;
                setSize(801, 801);
                setSize(800, 800);
                ArrayList<Trainee> deleteTraineeList = new ArrayList();
                Trainee chosen = new Trainee();
                if (deleteID.getText().equals("")) {
                    showMessageDialog(null, "Wrong ID...");
                }
                try {
                    deleteTraineeList = Files.readTrainee();
                    for (int i = 0; i < deleteTraineeList.size(); i++) {
                        getContentPane().revalidate();
                        if (Integer.parseInt(deleteID.getText()) == deleteTraineeList.get(i).getId()) {
                            chosen = deleteTraineeList.get(i);

                            JLabel TraineeName = new JLabel("Name: ");
                            TraineeName.setFont(new Font("Serif", Font.BOLD, 20));
                            TraineeName.setBounds(50, 200, 100, 30);
                            add(TraineeName);
                            JTextField getTraineeName = new JTextField(chosen.getName());
                            getTraineeName.setFont(new Font("Serif", Font.BOLD, 20));
                            getTraineeName.setBounds(210, 200, 120, 30);
                            add(getTraineeName);

                            JLabel Traineeid = new JLabel("ID: ");
                            Traineeid.setFont(new Font("Serif", Font.BOLD, 20));
                            Traineeid.setBounds(50, 250, 100, 30);
                            add(Traineeid);
                            JTextField getTraineeid = new JTextField(String.valueOf(chosen.getId()));
                            getTraineeid.setFont(new Font("Serif", Font.BOLD, 20));
                            getTraineeid.setBounds(210, 250, 120, 30);
                            add(getTraineeid);

                            JLabel Traineeage = new JLabel("Age: ");
                            Traineeage.setFont(new Font("Serif", Font.BOLD, 20));
                            Traineeage.setBounds(50, 300, 100, 30);
                            add(Traineeage);
                            JTextField getTraineeage = new JTextField(String.valueOf(chosen.getAge()));
                            getTraineeage.setFont(new Font("Serif", Font.BOLD, 20));
                            getTraineeage.setBounds(210, 300, 120, 30);
                            add(getTraineeage);

                            JLabel TraineefacultyName = new JLabel("Faculty Name: ");
                            TraineefacultyName.setFont(new Font("Serif", Font.BOLD, 20));
                            TraineefacultyName.setBounds(50, 350, 150, 30);
                            add(TraineefacultyName);
                            JTextField getTraineefacultyName = new JTextField(chosen.getFacultyName());
                            getTraineefacultyName.setFont(new Font("Serif", Font.BOLD, 20));
                            getTraineefacultyName.setBounds(210, 350, 120, 30);
                            add(getTraineefacultyName);

                            JLabel TraineeacademicYear = new JLabel("Academic Year: ");
                            TraineeacademicYear.setFont(new Font("Serif", Font.BOLD, 20));
                            TraineeacademicYear.setBounds(50, 400, 150, 30);
                            add(TraineeacademicYear);
                            JTextField getTraineeacademicYear = new JTextField(String.valueOf(chosen.getAcademicYear()));
                            getTraineeacademicYear.setFont(new Font("Serif", Font.BOLD, 20));
                            getTraineeacademicYear.setBounds(210, 400, 120, 30);
                            add(getTraineeacademicYear);
                            break;
                        }
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }

            //Delete Team Member
            if (e.getSource() == deleteTeamMember) {
                int index;
                ArrayList<TeamLeader> deleteTeamLeader = new ArrayList<>();
                try {
                    deleteTeamLeader = Files.readTeamLeader();
                    if (deleteTeamMemberID.getText().equals("")) {
                        showMessageDialog(null, "Missing ID...");
                    }
                    boolean idcheck = false;
                    for (int i = 0; i < deleteTeamLeader.size(); i++) {
                            for (int j = 0; j < deleteTeamLeader.get(i).getTeamMembers().size(); j++) {
                                index = j;
                                if (Integer.parseInt(deleteTeamMemberID.getText()) == deleteTeamLeader.get(i).getTeamMembers().get(j).getId()) {
                                    if (deleteTeamLeader.get(i).getTeamMembers().size() == 1) {
                                        showMessageDialog(null, "Cannot delete, minimum amount of team members found...");
                                        break;
                                    }
                                     showMessageDialog(null,"hi");
                                    deleteTeamLeader.get(i).getTeamMembers().remove(deleteTeamLeader.get(i).getTeamMembers().get(j));
                                    showMessageDialog(null, "Successfully deleted");
                                    deleteTeamMemberID.setText("");
                                    idcheck = true;
                                    break;
                                }
                            }
                            if (idcheck == true) {
                                break;
                            }
                        }
                    if (idcheck == false) {
                        showMessageDialog(null, "Wrong ID...");
                    }
                    Files.writeTeamLeader(deleteTeamLeader);
                }
                catch (IOException ioException) { ioException.printStackTrace();}
                catch (ClassNotFoundException classNotFoundException) { classNotFoundException.printStackTrace();}
            }
            if (e.getSource() == viewTeamMemberData) {

                setSize(801, 801);
                setSize(800, 800);
                ArrayList<TeamLeader> deleteTeamMemberList = new ArrayList();
                TeamMember chosen = new TeamMember();
                if (deleteTeamMemberID.getText().equals("")) {
                    showMessageDialog(null, "Wrong ID...");
                }
                try {
                    deleteTeamMemberList = Files.readTeamLeader();
                    for (int i = 0; i < deleteTeamMemberList.size(); i++) {
                        for (int j = 0; j < deleteTeamMemberList.get(i).getTeamMembers().size(); j++) {
                            getContentPane().revalidate();

                            if (Integer.parseInt(deleteTeamMemberID.getText()) == deleteTeamMemberList.get(i).getTeamMembers().get(j).getId()) {
                                chosen = deleteTeamMemberList.get(i).getTeamMembers().get(j);

                                JLabel TeamLeaderName = new JLabel("Name: ");
                                TeamLeaderName.setFont(new Font("Serif", Font.BOLD, 20));
                                TeamLeaderName.setBounds(50, 200, 100, 30);
                                add(TeamLeaderName);
                                JTextField getTeamLeaderName = new JTextField(chosen.getName());
                                getTeamLeaderName.setFont(new Font("Serif", Font.BOLD, 20));
                                getTeamLeaderName.setBounds(210, 200, 120, 30);
                                add(getTeamLeaderName);

                                JLabel TeamLeaderid = new JLabel("ID: ");
                                TeamLeaderid.setFont(new Font("Serif", Font.BOLD, 20));
                                TeamLeaderid.setBounds(50, 250, 100, 30);
                                add(TeamLeaderid);
                                JTextField getTeamLeaderid = new JTextField(String.valueOf(chosen.getId()));
                                getTeamLeaderid.setFont(new Font("Serif", Font.BOLD, 20));
                                getTeamLeaderid.setBounds(210, 250, 120, 30);
                                add(getTeamLeaderid);

                                JLabel TeamLeaderAge = new JLabel("Age: ");
                                TeamLeaderAge.setFont(new Font("Serif", Font.BOLD, 20));
                                TeamLeaderAge.setBounds(50, 300, 100, 30);
                                add(TeamLeaderAge);
                                JTextField getTeamLeaderage = new JTextField(String.valueOf(chosen.getAge()));
                                getTeamLeaderage.setFont(new Font("Serif", Font.BOLD, 20));
                                getTeamLeaderage.setBounds(210, 300, 120, 30);
                                add(getTeamLeaderage);
                            }
                        }
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }

            //Delete Team Leader
            if (e.getSource() == ReplaceTeamLeader) {
                int index;
                ArrayList<TeamLeader> replaceTeamLeader = new ArrayList<>();
                try {
                    replaceTeamLeader = Files.readTeamLeader();
                    if (deleteTeamLeaderID.getText().equals("")) {
                        showMessageDialog(null, "Missing ID...");
                    }
                    for (int i = 0; i < replaceTeamLeader.size(); i++) {
                        index = i;
                        if (Integer.parseInt(deleteTeamLeaderID.getText()) == replaceTeamLeader.get(i).getId()) {
                            replaceTL();
                            break;
                        }
                    }
                    Files.writeTeamLeader(replaceTeamLeader);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }

            ArrayList<TeamLeader> deleteTeamLeader = new ArrayList<>();
            if (e.getSource() == viewTeamLeaderData) {//String name, int id, int age, ArrayList<TeamMember> TeamMembers, String Username,String Password
                setSize(801,801);
                setSize(800,800);
                getContentPane().revalidate();
                int n=0;
                //ArrayList<TeamLeader> deleteTeamLeader = new ArrayList<>();
              //  TeamLeader chosen = new TeamLeader();
                if (deleteTeamLeaderID.getText().equals("")) {
                    showMessageDialog(null, "Missing ID...");
                }
                try {
                    deleteTeamLeader = Files.readTeamLeader();
                    for (int i = 0; i < deleteTeamLeader.size(); i++,n++) {
                        if (Integer.parseInt(deleteTeamLeaderID.getText()) == deleteTeamLeader.get(i).getId()) {
                            indexTeamLeader=i;
                            chosenTeamLeader = deleteTeamLeader.get(i);
                            JLabel TeamLeaderName = new JLabel("Name: ");
                            TeamLeaderName.setFont(new Font("Serif", Font.BOLD, 20));
                            TeamLeaderName.setBounds(50, 200, 100, 30);
                            add(TeamLeaderName);
                            JTextField getTeamLeaderName = new JTextField(chosenTeamLeader.getName());
                            getTeamLeaderName.setFont(new Font("Serif", Font.BOLD, 20));
                            getTeamLeaderName.setBounds(210, 200, 120, 30);
                            add(getTeamLeaderName);

                            JLabel TeamLeaderid = new JLabel("ID: ");
                            TeamLeaderid.setFont(new Font("Serif", Font.BOLD, 20));
                            TeamLeaderid.setBounds(50, 250, 100, 30);
                            add(TeamLeaderid);
                            JTextField getTeamLeaderid = new JTextField(String.valueOf(chosenTeamLeader.getId()));
                            getTeamLeaderid.setFont(new Font("Serif", Font.BOLD, 20));
                            getTeamLeaderid.setBounds(210, 250, 120, 30);
                            add(getTeamLeaderid);

                            JLabel TeamLeaderAge = new JLabel("Age: ");
                            TeamLeaderAge.setFont(new Font("Serif", Font.BOLD, 20));
                            TeamLeaderAge.setBounds(50, 300, 100, 30);
                            add(TeamLeaderAge);
                            JTextField getTeamLeaderAge = new JTextField(String.valueOf(chosenTeamLeader.getAge()));
                            getTeamLeaderAge.setFont(new Font("Serif", Font.BOLD, 20));
                            getTeamLeaderAge.setBounds(210, 300, 120, 30);
                            add(getTeamLeaderAge);



                            //Table
                            JLabel Tlmember = new JLabel("Team Members ");
                            Tlmember.setBounds(300, 350, 200, 30);
                            Tlmember.setFont(new Font("Serif", Font.BOLD, 23));
                            add(Tlmember);

                            for (int x = 0, j = 0,y=0; x < 5; x++, j += 50,y++) {
                                JLabel TlmembersName = new JLabel("Name: ");
                                TlmembersName.setFont(new Font("Serif", Font.BOLD, 20));
                                TlmembersName.setBounds(50, 400 + j, 80, 30);
                                add(TlmembersName);
                                JTextField getTlmembersName = new JTextField(20);


                                getTlmembersName.setBounds(135, 400 + j, 100, 30);
                                add(getTlmembersName);

                                JLabel TlmembersId = new JLabel("ID: ");
                                TlmembersId.setFont(new Font("Serif", Font.BOLD, 20));
                                TlmembersId.setBounds(265, 400 + j, 40, 30);
                                add(TlmembersId);
                                JTextField getTlmembersId = new JTextField(20);
                                getTlmembersId.setBounds(315, 400 + j, 100, 30);
                                add(getTlmembersId);

                                JLabel TlmembersAge = new JLabel("Age: ");
                                TlmembersAge.setFont(new Font("Serif", Font.BOLD, 20));
                                TlmembersAge.setBounds(445, 400 + j, 50, 30);
                                add(TlmembersAge);
                                JTextField getTlmembersAge = new JTextField(20);
                                getTlmembersAge.setBounds(505, 400 + j, 100, 30);
                                add(getTlmembersAge);

                                if(y<chosenTeamLeader.getTeamMembers().size()){
                                    getTlmembersName.setText(chosenTeamLeader.getTeamMembers().get(y).getName());
                                    getTlmembersId.setText(""+chosenTeamLeader.getTeamMembers().get(y).getId());
                                    getTlmembersAge.setText(""+chosenTeamLeader.getTeamMembers().get(y).getAge());
                                }
                            }
                        }
                    }
                }
                catch (IOException ioException) { ioException.printStackTrace();}
                catch (ClassNotFoundException classNotFoundException) { classNotFoundException.printStackTrace();}
            }
            if(e.getSource()==SubmitTeamLeader){
                String Name=getrepTlName.getText();
                String id=getrepTlid.getText();
                String age=getrepTlAge.getText();
                String UserName=getrepTlUser.getText();
                String password=getrepTlPass.getText();

                try {
                    deleteTeamLeader = Files.readTeamLeader();
                    boolean check=true;
                    for (int i = 0; i < deleteTeamLeader.size(); i++) {
                        if (deleteTeamLeader.get(i).getId() == Integer.parseInt(id)) {
                            showMessageDialog(null, "ID already exists");
                            getTlid.setText("");
                            check = false;
                        }
                        else if (deleteTeamLeader.get(i).getUsername().equalsIgnoreCase(UserName)) {
                            showMessageDialog(null, "Username already exists");
                            getTlUser.setText("");
                            check = false;
                        }
                    }
                    if (getrepTlName.getText().equals("") || getrepTlid.getText().equals("") || getrepTlAge.getText().equals("") || getrepTlUser.getText().equals("") || getrepTlPass.getText().equals("")) {
                        showMessageDialog(null, "There is a Missing Field");
                        check = false;
                    }
                    if(check) {
                        TeamLeader teamLeader = new TeamLeader(Name, Integer.parseInt(id), Integer.parseInt(age), chosenTeamLeader.getTeamMembers(), UserName, password);
                        deleteTeamLeader.set(indexTeamLeader, teamLeader);
                        Files.writeTeamLeader(deleteTeamLeader);
                        showMessageDialog(null, "Successfully Saved");
                    }
                }
                catch (IOException ioException) { ioException.printStackTrace();}
                catch (ClassNotFoundException classNotFoundException) { classNotFoundException.printStackTrace();}
            }


            ///////////View///////////////////////
            if(e.getSource()==view){
                setSize(801, 801);
                setSize(800, 800);
                roleState = 4;
                Role();
            }

        }
    }
}