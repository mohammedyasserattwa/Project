
package Payroll;

import javafx.scene.effect.Light;
import javafx.scene.layout.Border;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.metal.MetalComboBoxButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import static javax.swing.JOptionPane.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Frame extends JFrame implements Files {
    //Action Listener:
    Al al = new Al();
    ML ml = new ML();
    //-------------------------------------------Buttons-------------------------------------------------------//
    JButton login = new JButton("Login");
    JButton sign = new JButton("Sign Up");
    JButton trainee = new JButton("Trainee");
    JButton teamleader = new JButton("Team Leader & Team Member");
    JButton manager = new JButton("Manager");
    JButton submit = new JButton("submit");
    Icon backIcon = new ImageIcon("BackButton.png");
    JButton back = new JButton(backIcon);
    //-------------------------------------------Manager-------------------------------------------------------//
    JButton Trainee = new JButton("Trainee");
    JButton TeamLeader = new JButton("Team Leader");
    JButton TeamMember = new JButton("Team Member");
    JButton Add = new JButton("Add");
    JButton Delete = new JButton("Delete");
    JButton Edit = new JButton("Edit");
    JButton view=new JButton("View");

    //username/passwords labels and textfields
    JLabel username = new JLabel("Username:");
    JLabel password = new JLabel("Password:");
    JTextField userin = new JTextField(10);
    JPasswordField passin = new JPasswordField(10);

    //buttons top right
    JButton close = new JButton("x");
    JButton minimize = new JButton("-");
    JButton maximize = new JButton("■");
    JLabel draggable = new JLabel();
    int mx;
    int my;

    //Colors used in the project
    Color Purple = new Color(48,34,91);
    Color LightPurple = new Color(238,223,237);
    Color Pink = new Color(158,123,181);
    ////////////////////////////
    //-------------------------------------------------Images------------------------------------------------------------//
    //Frame 1
    JLabel image = new JLabel(new ImageIcon(ImageIO.read(new File("signin.png"))));
    //Frame 2
    JLabel im = new JLabel(new ImageIcon(ImageIO.read(new File("login.png"))));
    //Frame 3
    JLabel image1 = new JLabel(new ImageIcon(ImageIO.read(new File("username.png"))));
    //------------------------------------------------Constructor---------------------------------------------------//
    public Frame() throws IOException, ClassNotFoundException {
        ///////////////////////////////////////////////////////////
        setTitle("COMPANY PAYROLL");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setLayout(null);

        repaint();
        revalidate();
        setUndecorated(true);
        setVisible(true);
        ///////////////////////////////////////////////////////////
        Buttons(getWidth());
        repaint();
        revalidate();
        F1();
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
        close.addActionListener(al);
        minimize.addActionListener(al);
        maximize.addActionListener(al);
        draggable.addMouseMotionListener(ml);
        draggable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mx = e.getX();
                my = e.getY();
            }
        });

        /////////////////////
    }
    //------------------------------------------Top-Right Buttons---------------------------------------------//
    public void Buttons(int x){
        back.setBorderPainted(false);
        back.setOpaque(false);
        close.setBounds(x-50,0,50,50);
        close.setBackground(new Color(255,216,148));
        close.setFont(new Font("arial bold",1,20));
        close.setForeground(Purple);
        close.setBorder(BorderFactory.createEmptyBorder());
        close.setBorderPainted(false);
        close.setOpaque(false);
        close.addMouseListener(new MouseListener() {
           @Override
           public void mouseClicked(MouseEvent e) {

           }

           @Override
           public void mousePressed(MouseEvent e) {

           }

           @Override
           public void mouseReleased(MouseEvent e) {

           }

           @Override
           public void mouseEntered(MouseEvent e) {
               close.setOpaque(true);
                close.setBackground(Color.red);
                close.setForeground(Color.WHITE);

           }

           @Override
           public void mouseExited(MouseEvent e) {
               close.setOpaque(false);
               close.setForeground(Purple);
           }
       });
        add(close);
        repaint();
        revalidate();


        minimize.setBounds(x-150,0,50,50);
        minimize.setBackground(new Color(42, 25, 82));
        minimize.setFont(new Font("arial bold",1,20));
        minimize.setForeground(Purple);
        minimize.setBorder(BorderFactory.createEmptyBorder());
        minimize.setBorderPainted(false);
        minimize.setOpaque(false);
        add(minimize);
        repaint();
        revalidate();
        maximize.setBounds(x-100,0,50,50);
        maximize.setBackground(new Color(255,216,148));
        maximize.setFont(new Font("arial bold",1,20));
        maximize.setForeground(Purple);
        maximize.setBorder(BorderFactory.createEmptyBorder());
        maximize.setBorderPainted(false);
        maximize.setOpaque(false);
        add(maximize);
        repaint();
        revalidate();
        draggable.setBounds(60,0,x-150,50);
        add(draggable);
    }
    //////////////////////////////////////////////////////////////////////FRAMES//////////////////////////////////////////////////////////////////////////////
    ////////Welcome Frame//////////
    public void F1() {

        setSize(800, 500);
        //set the image to be the background
        setContentPane(image);
        Buttons(800);

        //login button
        login.setBounds(675,440,100,50);
        login.setText("LOGIN >");
        login.setBackground(new Color(255,255,255));
        login.setForeground(Purple);
        login.setOpaque(false);
        login.setFont(new Font("Ariel",1,20));
        login.setBorder(BorderFactory.createEmptyBorder());
        add(login);

        revalidate();
        repaint();
        remove(back);
    }

    //Second Frame to choose TeamLeader/TeamMember Manager or Trainee
    public void F2() {
        //image setup
        setSize(805, 500);
        setContentPane(im);
        Container Back = new Container();
        Back.setBackground(LightPurple);
        revalidate();
        repaint();

        Buttons(805);

        JLabel info = new JLabel("Pick your position");
        info.setForeground(new Color(80,77,77));
        info.setFont(new Font("Myraid Pro",0,20));
        info.setBounds(325,90,350,100);
        add(info);

        teamleader.setBounds(278, 225, 250, 30);
        teamleader.setBackground(new Color(243,240,247));
        teamleader.setOpaque(false);
        teamleader.setForeground(Color.WHITE);
        teamleader.setFont(new Font("Myraid Pro",0,15));
        add(teamleader);
        trainee.setBounds(278, 280, 250, 30);
        trainee.setBackground(new Color(243,240,247));
        trainee.setOpaque(false);
        trainee.setFont(new Font("Myraid Pro",0,15));
        trainee.setForeground(Color.WHITE);
        add(trainee);
        manager.setBounds(278, 335, 250, 30);
        manager.setBackground(new Color(243,240,247));
        manager.setOpaque(false);
        manager.setFont(new Font("Myraid Pro",0,15));
        manager.setForeground(Color.WHITE);
        add(manager);
        back.setBounds(1, 1, 60, 50);
        back.setBackground(new Color(255,255,255));
        add(back);
        //////////////////
    }

    //Entering the Username and Password

    public void F3() {
        //image setup
        setSize(800,500);
        setContentPane(image1);

        Buttons(800);
        //Back Button
        add(back);

        userin.setBounds(375, 240, 120, 20);
        userin.setFont(new Font("Myraid Pro",0,15));
        userin.setBackground(LightPurple);
        userin.setForeground(Purple);
        userin.setBorder(BorderFactory.createEmptyBorder());
        add(userin);


        passin.setBounds(375, 290, 120, 20);
        passin.setFont(new Font("Myraid Pro",0,15));
        passin.setBackground(LightPurple);
        passin.setForeground(Purple);
        passin.setBorder(BorderFactory.createEmptyBorder());
        add(passin);

        submit.setBounds(355, 345, 90, 25);
        submit.setBackground(LightPurple);
        submit.setForeground(Purple);
        submit.setFont(new Font("arial",0,15));
        add(submit);


    }

    //TEAMLEADER ACCOUNT INFO
    public void F4(TeamLeader chosen) {
        //remove any image in the background from the previous frame
        Container c= new Container();
        c.setBackground(Color.WHITE);
        setContentPane(c);
        setBackground(LightPurple);//set background color
        revalidate();
        repaint();

        getContentPane().removeAll();
        setSize(800,500);

        Buttons(805);

        JPanel drag = new JPanel();
        drag.setBounds(0,0,50,500);//set the panel to default value -> 50
        drag.setBackground(Pink);
        add(drag);

        //Buttons in the left panel
        JButton signout  = new JButton("Sign Out");
        JButton Acc = new JButton();
        JButton Team = new JButton("My Team");

        /////////////////////////////LABELS USED FOR ACCOUNT INFO/////////////////////////////////////////
        JLabel AccountInfo = new JLabel("Account Information ");
        JLabel viewname = new JLabel("Name:");
        JLabel TlName = new JLabel(chosen.getName());
        JLabel ID = new JLabel("ID:");
        JLabel Tlid = new JLabel("" + chosen.getId());
        JLabel age = new JLabel("Age: ");
        JLabel num = new JLabel("" + chosen.getAge());
        JLabel salary = new JLabel("Salary: ");
        JLabel result = new JLabel("$" + chosen.getSalary());
        JLabel grade = new JLabel("Grade: ");
        JLabel gr = new JLabel(String.valueOf(chosen.getGrade(new TeamLeader())));
        JPanel panel = new JPanel();
        JLabel myTeam = new JLabel("My Team");
        JLabel teamCapacity = new JLabel(" Your Team Capacity: " + chosen.getTeamCapacity());
        JLabel Welcome = new JLabel("<html><h1 style = \"font-family:muli black;font-size:100;\"><strong>Welcome, </strong></html>");
        JLabel ChLabel = new JLabel("<html></h1><h1 style = \"font-family:muli black;font-size:100;\">"+ chosen.getName() +"</h1></html>");
        ChLabel.setBounds(175,250,500,100);
        add(ChLabel);
        Welcome.setBounds(175,100,500,200);
        add(Welcome);
        JLabel label2 = new JLabel("You can find your account info by dragging the left drawer");
        label2.setBounds(175,350,550,50);
        label2.setFont(new Font("Myraid Pro",0,20));
        add(label2);
        JLabel p = new JLabel();
        JLabel somedeep = new JLabel("Your account info in");
        somedeep.setForeground(Color.white);
        JLabel anotherdeep = new JLabel("addition to the salary");
        anotherdeep.setForeground(Color.white);
        JLabel deep = new JLabel("that is calculated by");
        deep.setForeground(Color.white);
        JLabel deepLast = new JLabel("your manager.");
        deepLast.setForeground(Color.white);
        JLabel infoLogo = new JLabel(new ImageIcon("info.PNG"));
        JLabel infoLogo1 = new JLabel(new ImageIcon("info.PNG"));

        revalidate();
        repaint();
        //-----------------------------------------------ACTION LISTENERS-----------------------------------------------------//
        drag.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                revalidate();
                repaint();
                remove(drag);

                //set drag width when dragged
                if(e.getX() > 50) {
                    if (e.getX() <= 150) {
                        drag.setSize(e.getX(), 500);
                    }
                }
                if(drag.getWidth() <55){
                    drag.setSize(50, 500);
                }
                if(drag.getWidth() > 140){
                    drag.setSize(150,500);
                }

                //add/delete the buttons in the drag panel
                if(e.getX() <= 100){
                    remove(Acc);
                    remove(Team);
                    remove(signout);

                }else{
                    Acc.setBounds(0,150,150,50);
                    Acc.setFont(new Font("Myraid pro",0,15));
                    Acc.setForeground(Color.WHITE);
                    Acc.setText("My Account");
                    Acc.setBackground(new Color(255,255,255));
                    Acc.setOpaque(false);
                    Acc.setBorder(BorderFactory.createEmptyBorder());
                    add(Acc);
                    revalidate();
                    repaint();
                    Team.setBounds(0,200,150,50);
                    Team.setFont(new Font("Myraid pro",0,15));
                    Team.setForeground(Color.WHITE );
                    Team.setBackground(new Color(255,255,255));
                    Team.setOpaque(false);
                    Team.setBorder(BorderFactory.createEmptyBorder());
                    add(Team);
                    revalidate();
                    repaint();
                    signout.setBounds(0,400,150,50);
                    signout.setFont(new Font("Myraid pro",0,15));
                    signout.setForeground(Color.white);
                    signout.setBackground(Color.WHITE);
                    signout.setOpaque(false);
                    signout.setBorder(BorderFactory.createEmptyBorder());
                    add(signout);
                    revalidate();
                    repaint();


                }
                add(drag);
                revalidate();
                repaint();
            }
        });
        //MyAccount infoLogo
        infoLogo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                remove(somedeep);
                remove(anotherdeep);
                remove(deep);
                remove(deepLast);
                revalidate();
                repaint();
                //---------------set the blur background in the info
                p.setBounds(infoLogo.getX(),infoLogo.getY()-25,200,200);
                p.setIcon(new ImageIcon("blur.PNG"));

                //--------------set the info text
                    somedeep.setText("Your account info in");
                    anotherdeep.setText("addition to the salary");
                    deep.setText("that is calculated by");
                    deepLast.setText("your manager.");
                    somedeep.setBounds(p.getX() + 50,p.getY()-30,300,150);
                    anotherdeep.setBounds(somedeep.getX(),somedeep.getY()+20,300,150);
                    deep.setBounds(anotherdeep.getX(),anotherdeep.getY()+20,300,150);
                    deepLast.setBounds(deep.getX(),deep.getY()+20,300,150);
                    add(deep);
                    add(deepLast);
                    add(somedeep);
                    add(anotherdeep);

                add(p);

                revalidate();
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                remove(p);
                remove(somedeep);
                remove(anotherdeep);
                remove(deep);
                remove(deepLast);
                revalidate();
                repaint();
            }
        });
        //MyTeam infoLogo
        infoLogo1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                //remove any instance of the previous text to change the text
                remove(somedeep);
                remove(anotherdeep);
                remove(deep);
                remove(deepLast);

                //blur background
                p.setBounds(infoLogo1.getX(),infoLogo1.getY()-150,200,200);
                p.setIcon(new ImageIcon("blur.PNG"));

                //info text
                somedeep.setText("Your team members");
                anotherdeep.setText("that you are leading and");
                deep.setText("the capacity of your");
                deepLast.setText("team.");
                somedeep.setForeground(Color.WHITE);
                deep.setForeground(Color.WHITE);
                deepLast.setForeground(Color.WHITE);
                anotherdeep.setForeground(Color.WHITE);
                somedeep.setBounds(p.getX() + 50,p.getY()-30,300,150);
                anotherdeep.setBounds(somedeep.getX(),somedeep.getY()+20,300,150);
                deep.setBounds(anotherdeep.getX(),anotherdeep.getY()+20,300,150);
                deepLast.setBounds(deep.getX(),deep.getY()+20,300,150);
                add(deep);
                add(deepLast);
                add(somedeep);
                add(anotherdeep);
                add(p);
                revalidate();
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                remove(p);
                remove(somedeep);
                remove(anotherdeep);
                remove(deep);
                remove(deepLast);
                revalidate();
                repaint();
            }
        });
        //buttons
        //MyAccount Button
        Acc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //remove everything except the drag panel
                remove(Welcome);
                remove(infoLogo);
                remove(infoLogo1);
                remove(ChLabel);
                remove(label2);
                remove(somedeep);
                remove(anotherdeep);
                remove(deep);
                remove(deepLast);
                remove(panel);
                remove(myTeam);
                remove(teamCapacity);
                revalidate();
                repaint();

                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                AccountInfo.setBounds(200, 100, 400, 100);
                AccountInfo.setFont(new Font("Myraid Pro", 0, 34));
                AccountInfo.setForeground(new Color(86,87,89));
                add(AccountInfo);

                infoLogo.setBounds(500,140,25,25);
                add(infoLogo);

                viewname.setBounds(250, 200, 50, 50);
                viewname.setFont(new Font("Myraid Pro", 0, 15));
                viewname.setForeground(new Color(86,87,89));
                add(viewname);


                TlName.setFont(new Font("Myraid Pro", 0, 15));
                TlName.setBounds(450, 200, 100, 50);
                TlName.setForeground(new Color(86,87,89));
                add(TlName);


                ID.setBounds(250, 250, 50, 50);
                ID.setFont(new Font("Myraid Pro", 0, 15));
                ID.setForeground(new Color(86,87,89));
                add(ID);

                Tlid.setFont(new Font("Myraid Pro", 0, 15));
                Tlid.setBounds(450, 250, 100, 50);
                Tlid.setForeground(new Color(86,87,89));
                add(Tlid);


                age.setBounds(250, 300, 50, 50);
                age.setFont(new Font("Myraid Pro", 0, 15));
                age.setForeground(new Color(86,87,89));
                add(age);

                num.setBounds(450, 300, 50, 50);
                num.setFont(new Font("Myraid Pro", 0, 15));
                num.setForeground(new Color(86,87,89));
                add(num);


                salary.setBounds(250, 350, 70, 50);
                salary.setFont(new Font("Myraid Pro", 0, 15));
                salary.setForeground(new Color(86,87,89));
                add(salary);

                result.setBounds(450, 350, 150, 50);
                result.setFont(new Font("Myraid Pro", 0, 15));
                result.setForeground(new Color(86,87,89));

                grade.setBounds(250,400,150,50);
                grade.setFont(new Font("Myraid Pro",0,15));
                grade.setForeground(new Color(86,87,89));
                add(grade);

                gr.setBounds(450,400,150,50);
                gr.setFont(new Font("Myraid Pro",0,15));
                gr.setForeground(new Color(86,87,89));
                add(gr);

                add(result);
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                revalidate();
                repaint();
            }
        });
        Team.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //removal stage
                remove(Welcome);
                remove(infoLogo);
                remove(somedeep);
                remove(anotherdeep);
                remove(deep);
                remove(deepLast);
                remove(ChLabel);
                remove(label2);
                remove(AccountInfo);
                remove(viewname);
                remove(TlName);
                remove(ID);
                remove(Tlid);
                remove(age);
                remove(num);
                remove(salary);
                remove(result);
                remove(grade);
                remove(gr);
                revalidate();
                repaint();

                /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                myTeam.setBounds(200, 100, 200, 100);
                myTeam.setFont(new Font("Myraid Pro", 0, 40));
                myTeam.setForeground(new Color(86,87,89));
                add(myTeam);


                teamCapacity.setBounds(400,325,155,50);
                teamCapacity.setFont(new Font("Myraid Pro", 0,15));
                teamCapacity.setBackground(Pink);
                teamCapacity.setOpaque(true);
                teamCapacity.setForeground(Color.WHITE);

                infoLogo1.setBounds(375,140,25,25);

                add(infoLogo1);

                add(teamCapacity);
                revalidate();
                repaint();

                //jtable header
                String column[] = {"ID", "Name", "Age"};
                //-------------JTable data
                String data[][] = new String[5][3];
                for (int i = 0; i < chosen.getTeamMembers().size(); i++) {
                    data[i][0] = chosen.getTeamMembers().get(i).getId() + "";
                    data[i][1] = chosen.getTeamMembers().get(i).getName() + "";
                    data[i][2] = chosen.getTeamMembers().get(i).getAge() + "";
                }
                //-------------Initialization
                JTable jt = new JTable(data, column);
                JScrollPane sp = new JScrollPane(jt);
                //Header Background Color
                JTableHeader head = jt.getTableHeader();
                head.setBorder(BorderFactory.createEmptyBorder());
                jt.setBorder(BorderFactory.createEmptyBorder());
                head.setBackground(Pink);
                head.setForeground(Color.WHITE);
                //add the scrollpane to the panel
                panel.add(sp);
                panel.setBounds(250, 200, 452, 107);
                panel.setOpaque(false);
                add(panel);
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                revalidate();
                repaint();
            }
        });
        signout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(JOptionPane.showConfirmDialog(null,"Are you sure?","Sign Out", YES_NO_OPTION) == YES_OPTION){
                    userin.setText("");
                    passin.setText("");
                    getContentPane().removeAll();
                    getContentPane().revalidate();
                    F1();
                }
            }
        });
    }

    //TEAMMMEMBER ACCOUNT INFO
    public void F5(TeamMember chosen) throws IOException, ClassNotFoundException {
        //REMOVE ANY IMAGE FROM THE PREVIOUS FRAME
        getContentPane().removeAll();
        setSize(800,500);
        Container c= new Container();
        c.setBackground(LightPurple);
        setContentPane(c);
        setBackground(LightPurple);
        revalidate();
        repaint();

        Buttons(805);
        //DRAG PANEL
        JPanel drag = new JPanel();
        drag.setBounds(0,0,50,500);
        drag.setBackground(Pink);
        add(drag);
        //BUTTONS
        JButton signout  = new JButton("Sign Out");
        JButton Acc = new JButton();

        //MY ACCOUNT INFO
        JLabel AccountInfo = new JLabel("Account Information ");
        JLabel viewname = new JLabel("Name:");
        JLabel TlName = new JLabel(chosen.getName());
        JLabel ID = new JLabel("ID:");
        JLabel Tlid = new JLabel("" + chosen.getId());
        JLabel age = new JLabel("Age: ");
        JLabel num = new JLabel("" + chosen.getAge());
        JLabel salary = new JLabel("Salary: ");
        JLabel result = new JLabel("$" + chosen.getSalary());
        JLabel grade = new JLabel("Grade: ");
        JLabel gr = new JLabel(String.valueOf(chosen.getGrade(new TeamMember())));

        //WELCOME
        JPanel panel = new JPanel();
        JLabel Welcome = new JLabel("<html><h1 style = \"font-family:muli black;font-size:100;\"><strong>Welcome, </strong></html>");
        JLabel ChLabel = new JLabel("<html></h1><h1 style = \"font-family:muli black;font-size:100;\">"+ chosen.getName() +"</h1></html>");
        ChLabel.setBounds(175,250,500,100);
        add(ChLabel);
        Welcome.setBounds(175,100,500,200);
        add(Welcome);
        JLabel label2 = new JLabel("You can find your account info by dragging the left drawer");
        label2.setBounds(175,350,550,50);
        label2.setFont(new Font("Myraid Pro",0,20));
        add(label2);

        //INFO ICON
        JLabel p = new JLabel();
        JLabel somedeep = new JLabel("Your account info in");
        somedeep.setForeground(Color.white);
        JLabel anotherdeep = new JLabel("addition to the salary");
        anotherdeep.setForeground(Color.white);
        JLabel deep = new JLabel("that is calculated by");
        deep.setForeground(Color.white);
        JLabel deepLast = new JLabel("your manager.");
        deepLast.setForeground(Color.white);
        JLabel infoLogo = new JLabel(new ImageIcon("info.PNG"));

        revalidate();
        repaint();

        drag.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                revalidate();
                repaint();
                remove(drag);

                if(e.getX() > 50) {
                    if (e.getX() <= 150) {
                        drag.setSize(e.getX(), 500);
                    }
                }
                if(drag.getWidth() <55){
                    drag.setSize(50, 500);
                }
                if(drag.getWidth() > 140){
                    drag.setSize(150,500);
                }

                if(e.getX() <= 100){
                    remove(Acc);
                    remove(signout);

                }else{
                    Acc.setBounds(0,150,150,50);
                    Acc.setFont(new Font("Myraid pro",0,15));
                    Acc.setForeground(Color.WHITE);
                    Acc.setText("My Account");
                    Acc.setBackground(new Color(255,255,255));
                    Acc.setOpaque(false);
                    Acc.setBorder(BorderFactory.createEmptyBorder());
                    add(Acc);
                    revalidate();
                    repaint();
                    signout.setBounds(0,400,150,50);
                    signout.setFont(new Font("Myraid pro",0,15));
                    signout.setForeground(Color.white);
                    signout.setBackground(Color.WHITE);
                    signout.setOpaque(false);
                    signout.setBorder(BorderFactory.createEmptyBorder());
                    add(signout);
                    revalidate();
                    repaint();


                }

                add(drag);
                revalidate();
                repaint();
            }
        });
        infoLogo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                somedeep.setText("Your account info in");
                anotherdeep.setText("addition to the salary");
                deep.setText("that is calculated by");
                deepLast.setText("your manager.");
                p.setBounds(infoLogo.getX(),infoLogo.getY()-25,200,200);
                p.setIcon(new ImageIcon("blur.PNG"));
                somedeep.setBounds(p.getX() + 50,p.getY()-30,300,150);
                anotherdeep.setBounds(somedeep.getX(),somedeep.getY()+20,300,150);
                deep.setBounds(anotherdeep.getX(),anotherdeep.getY()+20,300,150);
                deepLast.setBounds(deep.getX(),deep.getY()+20,300,150);
                add(deep);
                add(deepLast);
                add(somedeep);
                add(anotherdeep);
                add(p);
                revalidate();
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                remove(p);
                remove(somedeep);
                remove(anotherdeep);
                remove(deep);
                remove(deepLast);
                revalidate();
                repaint();
            }
        });
        //buttons
        Acc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(Welcome);
                remove(ChLabel);
                remove(label2);
                remove(infoLogo);
                remove(somedeep);
                remove(anotherdeep);
                remove(deep);
                remove(deepLast);
                remove(panel);
                revalidate();
                repaint();

                AccountInfo.setBounds(200, 50, 400, 100);
                AccountInfo.setFont(new Font("Myraid Pro", 0, 34));
                AccountInfo.setForeground(new Color(86,87,89));
                add(AccountInfo);

                infoLogo.setBounds(500,90,25,25);
                add(infoLogo);

                viewname.setBounds(250, 150, 50, 50);
                viewname.setFont(new Font("Myraid Pro", 0, 15));
                viewname.setForeground(new Color(86,87,89));
                add(viewname);


                TlName.setFont(new Font("Myraid Pro", 0, 15));
                TlName.setBounds(450, 150, 100, 50);
                TlName.setForeground(new Color(86,87,89));
                add(TlName);


                ID.setBounds(250, 200, 50, 50);
                ID.setFont(new Font("Myraid Pro", 0, 15));
                ID.setForeground(new Color(86,87,89));
                add(ID);

                Tlid.setFont(new Font("Myraid Pro", 0, 15));
                Tlid.setBounds(450, 200, 100, 50);
                Tlid.setForeground(new Color(86,87,89));
                add(Tlid);


                age.setBounds(250, 250, 50, 50);
                age.setFont(new Font("Myraid Pro", 0, 15));
                age.setForeground(new Color(86,87,89));
                add(age);

                num.setBounds(450, 250, 50, 50);
                num.setFont(new Font("Myraid Pro", 0, 15));
                num.setForeground(new Color(86,87,89));
                add(num);


                salary.setBounds(250, 300, 70, 50);
                salary.setFont(new Font("Myraid Pro", 0, 15));
                salary.setForeground(new Color(86,87,89));
                add(salary);

                result.setBounds(450, 300, 150, 50);
                result.setFont(new Font("Myraid Pro", 0, 15));
                result.setForeground(new Color(86,87,89));
                add(result);

                JLabel TeamLeader = new JLabel("Team Leader: ");
                TeamLeader.setBounds(250, 350, 150, 50);
                TeamLeader.setFont(new Font("Myraid Pro", 0, 15));
                TeamLeader.setForeground(new Color(86,87,89));
                add(TeamLeader);
                ArrayList<TeamLeader> teamleaders = null;
                try {
                    teamleaders = Files.readTeamLeader();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
                TeamLeader selected = new TeamLeader();
                for (int i = 0; i < teamleaders.size(); i++) {
                    for (int j = 0; j < teamleaders.get(i).getTeamMembers().size(); j++) {
                        if (chosen.getId() == teamleaders.get(i).getTeamMembers().get(j).getId()) {
                            selected = teamleaders.get(i);
                        }
                    }
                }
                JLabel tname = new JLabel(selected.getName());
                tname.setBounds(450, 350, 150, 50);
                tname.setFont(new Font("Myraid Pro", 0, 15));
                tname.setForeground(new Color(86,87,89));
                add(tname);

                grade.setBounds(250,400,150,50);
                grade.setFont(new Font("Myraid Pro",0,15));
                grade.setForeground(new Color(86,87,89));
                add(grade);

                gr.setBounds(450,400,150,50);
                gr.setFont(new Font("Myraid Pro",0,15));
                gr.setForeground(new Color(86,87,89));
                add(gr);

                revalidate();
                repaint();
            }
        });
        signout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(JOptionPane.showConfirmDialog(null,"Are you sure?","Sign Out", YES_NO_OPTION) == YES_OPTION){
                    userin.setText("");
                    passin.setText("");

                    F1();
                }
            }
        });
    }

    //TRAINEE ACCOUNT
    public void F6(Trainee chosen) {
        getContentPane().removeAll();
        setSize(800,500);
        Container c= new Container();
        c.setBackground(Color.WHITE);
        setContentPane(c);
        setBackground(LightPurple);
        revalidate();
        repaint();

        Buttons(805);
        JPanel drag = new JPanel();

        JButton signout  = new JButton("Sign Out");
        JButton Acc = new JButton();
        JButton Team = new JButton("My Team");
        drag.setBounds(0,0,50,500);
        drag.setBackground(Pink);


        add(drag);
        drag.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                revalidate();
                repaint();
                remove(drag);

                if(e.getX() > 50) {
                    if (e.getX() <= 150) {
                        drag.setSize(e.getX(), 500);
                    }
                }

                else if(drag.getWidth() <55){
                    drag.setSize(50, 500);
                }
                if(drag.getWidth() > 140){
                    drag.setSize(150,500);
                }
                if(e.getX() <= 100){
                    remove(Acc);
                    remove(Team);
                    remove(signout);

                }else{
                    Acc.setBounds(0,150,150,50);
                    Acc.setFont(new Font("Myraid pro",0,15));
                    Acc.setForeground(Color.WHITE);
                    Acc.setText("My Account");
                    Acc.setBackground(new Color(255,255,255));
                    Acc.setOpaque(false);
                    Acc.setBorder(BorderFactory.createEmptyBorder());
                    add(Acc);
                    revalidate();
                    repaint();
                    signout.setBounds(0,400,150,50);
                    signout.setFont(new Font("Myraid pro",0,15));
                    signout.setForeground(Color.white);
                    signout.setBackground(Color.WHITE);
                    signout.setOpaque(false);
                    signout.setBorder(BorderFactory.createEmptyBorder());
                    add(signout);
                    revalidate();
                    repaint();


                }
                add(drag);
                revalidate();
                repaint();
            }
        });
        JLabel AccountInfo = new JLabel("Account Information ");
        JLabel viewname = new JLabel("Name:");
        JLabel TlName = new JLabel(chosen.getName());
        JLabel ID = new JLabel("ID:");
        JLabel Tlid = new JLabel("" + chosen.getId());
        JLabel age = new JLabel("Age: ");
        JLabel num = new JLabel("" + chosen.getAge());
        JLabel salary = new JLabel("Salary: ");
        JLabel result = new JLabel("$" + chosen.getSalary());

        JLabel Welcome = new JLabel("<html><h1 style = \"font-family:muli black;font-size:100;\"><strong>Welcome, </strong></html>");
        JLabel ChLabel = new JLabel("<html></h1><h1 style = \"font-family:muli black;font-size:100;\">"+ chosen.getName() +"</h1></html>");
        ChLabel.setBounds(175,250,500,100);
        add(ChLabel);
        Welcome.setBounds(175,100,500,200);
//        Welcome.setFont(new Font("arial black",1,50));
        add(Welcome);
        JLabel label2 = new JLabel("You can find your account info by dragging the left drawer");
        label2.setBounds(175,350,550,50);
        label2.setFont(new Font("Myraid Pro",0,20));
        add(label2);
        JLabel p = new JLabel();
        JLabel somedeep = new JLabel("Your account info in");
        somedeep.setForeground(Color.white);
        JLabel anotherdeep = new JLabel("addition to the salary");
        anotherdeep.setForeground(Color.white);
        JLabel deep = new JLabel("that is calculated by");
        deep.setForeground(Color.white);
        JLabel deepLast = new JLabel("your manager.");
        deepLast.setForeground(Color.white);
        JLabel infoLogo = new JLabel(new ImageIcon("info.PNG"));

        revalidate();
        repaint();
        infoLogo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                somedeep.setText("Your account info in");
                anotherdeep.setText("addition to the salary");
                deep.setText("that is calculated by");
                deepLast.setText("your manager.");
                p.setBounds(infoLogo.getX(),infoLogo.getY()-25,200,200);
                p.setIcon(new ImageIcon("blur.PNG"));
                somedeep.setBounds(p.getX() + 50,p.getY()-30,300,150);
                anotherdeep.setBounds(somedeep.getX(),somedeep.getY()+20,300,150);
                deep.setBounds(anotherdeep.getX(),anotherdeep.getY()+20,300,150);
                deepLast.setBounds(deep.getX(),deep.getY()+20,300,150);
                add(deep);
                add(deepLast);
                add(somedeep);
                add(anotherdeep);
                add(p);
                revalidate();
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                remove(p);
                remove(somedeep);
                remove(anotherdeep);
                remove(deep);
                remove(deepLast);
                revalidate();
                repaint();
            }
        });
        //buttons
        Acc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(Welcome);
                remove(infoLogo);
                remove(ChLabel);
                remove(somedeep);
                remove(anotherdeep);
                remove(deep);
                remove(deepLast);
                remove(label2);
                revalidate();
                repaint();
                AccountInfo.setBounds(200, 10, 400, 100);
                AccountInfo.setFont(new Font("Myraid Pro", 0, 34));
                AccountInfo.setForeground(new Color(86,87,89));
                add(AccountInfo);

                infoLogo.setBounds(500,50,25,25);
                add(infoLogo);

                viewname.setBounds(250, 100, 50, 50);
                viewname.setFont(new Font("Myraid Pro", 0, 15));
                viewname.setForeground(new Color(86,87,89));
                add(viewname);


                TlName.setFont(new Font("Myraid Pro", 0, 15));
                TlName.setBounds(450, 100, 100, 50);
                TlName.setForeground(new Color(86,87,89));
                add(TlName);


                ID.setBounds(250, 150, 50, 50);
                ID.setFont(new Font("Myraid Pro", 0, 15));
                ID.setForeground(new Color(86,87,89));
                add(ID);

                Tlid.setFont(new Font("Myraid Pro", 0, 15));
                Tlid.setBounds(450, 150, 100, 50);
                Tlid.setForeground(new Color(86,87,89));
                add(Tlid);


                age.setBounds(250, 200, 50, 50);
                age.setFont(new Font("Myraid Pro", 0, 15));
                age.setForeground(new Color(86,87,89));
                add(age);

                num.setBounds(450, 200, 50, 50);
                num.setFont(new Font("Myraid Pro", 0, 15));
                num.setForeground(new Color(86,87,89));
                add(num);


                salary.setBounds(250, 250, 70, 50);
                salary.setFont(new Font("Myraid Pro", 0, 15));
                salary.setForeground(new Color(86,87,89));
                add(salary);

                result.setBounds(450, 250, 150, 50);
                result.setFont(new Font("Myraid Pro", 0, 15));
                result.setForeground(new Color(86,87,89));
                add(result);

                JLabel faculty = new JLabel("Faculty name:");
                faculty.setBounds(250,300,150,50);
                faculty.setFont(new Font("Myraid Pro", 0,15));
                faculty.setForeground(new Color(86,87,89));
                add(faculty);

                JLabel fname = new JLabel(chosen.getFacultyName());
                fname.setBounds(450,300,150,50);
                fname.setFont(new Font("Myraid Pro",0,15));
                fname.setForeground(new Color(86,87,89));
                add(fname);

                JLabel gpa = new JLabel("GPA:");
                gpa.setBounds(250,350,150,50);
                gpa.setFont(new Font("Myraid Pro",0,15));
                gpa.setForeground(new Color(86,87,89));
                add(gpa);

                JLabel gnum = new JLabel(chosen.getGPA()+"");
                gnum.setBounds(450,350,150,50);
                gnum.setFont(new Font("Myraid Pro",0,15));
                gnum.setForeground(new Color(86,87,89));
                add(gnum);

                JLabel academic = new JLabel("Academic year:");
                academic.setBounds(250,400,150,50);
                academic.setFont(new Font("Myraid Pro",0,15));
                academic.setForeground(new Color(86,87,89));
                add(academic);

                JLabel aname = new JLabel(chosen.getAcademicYear()+"");
                aname.setBounds(450,400,150,50);
                aname.setFont(new Font("Myraid Pro",0,15));
                aname.setForeground(new Color(86,87,89));
                add(aname);

                revalidate();
                repaint();
            }
        });
        signout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(JOptionPane.showConfirmDialog(null,"Are you sure?","Sign Out", YES_NO_OPTION) == YES_OPTION){
                    userin.setText("");
                    passin.setText("");

                    F1();
                }
            }
        });
    }

    //3 Buttons to choose whether to ADD EDIT or DELETE
    public void F7() {
        setSize(800,675);
        Buttons(800);
        setBackground(LightPurple);
        revalidate();
        repaint();
        add(back);
        //Colrors & width/height for the buttons
        int height = 80;
        int width = 250;
        Color c = new Color(158,123,181);

        Add.setBounds(100, 150, width, height);
        Add.setFont(new Font("Myraid Pro", Font.BOLD, 30));
        Add.setForeground(Color.WHITE);
        Add.setBackground(c);
        Edit.setBounds(450, 150, width, height);
        Edit.setFont(new Font("Myraid Pro", Font.BOLD, 30));
        Edit.setBackground(c);
        Edit.setForeground(Color.WHITE);
        Delete.setBounds(100, 350, width, height);
        Delete.setFont(new Font("Myraid Pro", Font.BOLD, 30));
        Delete.setBackground(c);
        Delete.setForeground(Color.WHITE);
        view.setBounds(450, 350, width, height);
        view.setFont(new Font("Myraid Pro", Font.BOLD, 30));
        view.setBackground(c);
        view.setForeground(Color.WHITE);
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
        setSize(800,700);
        Buttons(800);
        JLabel TmName = new JLabel("Add Team Member  ");
        TmName.setBounds(220, 50, 460, 100);
        TmName.setFont(new Font("Myraid Pro", Font.BOLD, 40));
        add(TmName);


        TmemberName.setFont(new Font("Serif", Font.BOLD, 20));
        TmemberName.setBounds((800/2)-165, 200, 80, 30);
        add(TmemberName);

        getTmemberName.setBounds(TmemberName.getX()+150, 200, 150, 30);
        add(getTmemberName);


        Tmemberage.setFont(new Font("Serif", Font.BOLD, 20));
        Tmemberage.setBounds((800/2)-165, 250, 80, 30);
        add(Tmemberage);

        getTmemberAge.setBounds(Tmemberage.getX() + 150, 250, 150, 30);
        add(getTmemberAge);


        TmemberId.setFont(new Font("Serif", Font.BOLD, 20));
        TmemberId.setBounds((800/2)-165, 300, 80, 30);
        add(TmemberId);

        getTmemberId.setBounds(TmemberId.getX() + 150, 300, 150, 30);
        add(getTmemberId);


        TmemberUser.setFont(new Font("Serif", Font.BOLD, 20));
        TmemberUser.setBounds((800/2)-165, 350, 100, 30);
        add(TmemberUser);

        getTmemberUser.setBounds(TmemberUser.getX() + 150, 350, 150, 30);
        add(getTmemberUser);


        TmemberPass.setFont(new Font("Serif", Font.BOLD, 20));
        TmemberPass.setBounds((800/2)-165, 400, 100, 30);
        add(TmemberPass);

        getTmemberPass.setBounds(TmemberPass.getX() + 150, 400, 150, 30);
        add(getTmemberPass);


        TLeaderId.setFont(new Font("Serif", Font.BOLD, 20));
        TLeaderId.setBounds((800/2)-165, 450, 160, 30);
        add(TLeaderId);

        getTLeaderId.setBounds(TLeaderId.getX() + 150, 450, 150, 30);
        add(getTLeaderId);

        SubButton.setBounds(((800/2)-50), 550, 100, 50);
        SubButton.setFont(new Font("Myraid Pro",0,20));
        SubButton.setBackground(Pink);
        SubButton.setForeground(Color.WHITE);
        SubButton.setBorder(BorderFactory.createEmptyBorder());
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
        Buttons(800);
        JLabel TraineeName = new JLabel("Add Trainee  ");
        TraineeName.setBounds((800/2)-110, 30, 300, 100);
        TraineeName.setFont(new Font("Myraid Pro", Font.BOLD, 40));
        add(TraineeName);


        int x = 295;
        JLabel Tname = new JLabel("Name: ");
        Tname.setFont(new Font("Serif", Font.BOLD, 20));
        Tname.setBounds(x, 200, 80, 30);
        add(Tname);

        getTName.setBounds(x+145, 200, 100, 30);
        add(getTName);

        JLabel Tage = new JLabel("Age: ");
        Tage.setFont(new Font("Serif", Font.BOLD, 20));
        Tage.setBounds(x, 250, 80, 30);
        add(Tage);

        getTAge.setBounds(x+145, 250, 100, 30);
        add(getTAge);

        JLabel Tid = new JLabel("ID: ");
        Tid.setFont(new Font("Serif", Font.BOLD, 20));
        Tid.setBounds(x, 300, 100, 30);
        add(Tid);

        getTid.setBounds(x+145, 300, 100, 30);
        add(getTid);

        JLabel TfacultyName = new JLabel("Faculty Name: ");
        TfacultyName.setFont(new Font("Serif", Font.BOLD, 20));
        TfacultyName.setBounds(x, 350, 140, 30);
        add(TfacultyName);

        getTfacultyName.setBounds(x+145, 350, 100, 30);
        add(getTfacultyName);

        JLabel TacademicYear = new JLabel("Academic Year: ");
        TacademicYear.setFont(new Font("Serif", Font.BOLD, 20));
        TacademicYear.setBounds(x, 400, 150, 30);
        add(TacademicYear);

        getTacademicYear.setBounds(x+145, 400, 100, 30);
        add(getTacademicYear);

        JLabel Tgpa = new JLabel("GPA: ");
        Tgpa.setFont(new Font("Serif", Font.BOLD, 20));
        Tgpa.setBounds(x, 450, 140, 30);
        add(Tgpa);

        getTgpa.setBounds(x+145, 450, 100, 30);
        add(getTgpa);

        JLabel TUser = new JLabel("Username: ");
        TUser.setFont(new Font("Serif", Font.BOLD, 20));
        TUser.setBounds(x, 500, 100, 30);
        add(TUser);

        getTUser.setBounds(x+145, 500, 100, 30);
        add(getTUser);

        JLabel TPass = new JLabel("Password: ");
        TPass.setFont(new Font("Serif", Font.BOLD, 20));
        TPass.setBounds(x, 550, 100, 30);
        add(TPass);

        getTPass.setBounds(x+145, 550, 100, 30);
        add(getTPass);

        TraineeSubmit.setBounds((800/2)-50, 650, 100, 50);
        TraineeSubmit.setFont(new Font("Myraid Pro",0,20));
        TraineeSubmit.setBackground(Pink);
        TraineeSubmit.setForeground(Color.WHITE);
        TraineeSubmit.setBorder(BorderFactory.createEmptyBorder());
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
        Buttons(1150);
        JLabel TeamLeader = new JLabel("Add Team Leader");
        TeamLeader.setBounds((1150/2)-215, 30, 430, 100);
        TeamLeader.setFont(new Font("Myraid Pro", Font.BOLD, 50));
        add(TeamLeader);

        int x = 300;
        JLabel Tlname = new JLabel("Name: ");
        Tlname.setFont(new Font("Serif", Font.BOLD, 20));
        Tlname.setBounds(x, 200, 80, 30);
        add(Tlname);

        getTlName.setBounds(Tlname.getX() + 100, 200, 150, 30);
        add(getTlName);

        JLabel Tlage = new JLabel("Age: ");
        Tlage.setFont(new Font("Serif", Font.BOLD, 20));
        Tlage.setBounds(x, 250, 80, 30);
        add(Tlage);

        getTlAge.setBounds(Tlage.getX() + 100, 250, 150, 30);
        add(getTlAge);

        JLabel Tlid = new JLabel("ID: ");
        Tlid.setFont(new Font("Serif", Font.BOLD, 20));
        Tlid.setBounds(x, 300, 80, 30);
        add(Tlid);

        getTlid.setBounds(Tlid.getX() + 100, 300, 150, 30);
        add(getTlid);

        JLabel TlUser = new JLabel("Username: ");
        TlUser.setFont(new Font("Serif", Font.BOLD, 20));
        TlUser.setBounds(x+300, 200, 100, 30);
        add(TlUser);

        getTlUser.setBounds(x+410, 200, 150, 30);
        add(getTlUser);

        JLabel TlPass = new JLabel("Password: ");
        TlPass.setFont(new Font("Serif", Font.BOLD, 20));
        TlPass.setBounds(x+300, 300, 100, 30);
        add(TlPass);

        getTlPass.setBounds(x+410, 300, 150, 30);
        add(getTlPass);

        JLabel Tlmember = new JLabel("Team Members ");
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
        LeaderSubmit.setBounds((1150/2)-50, 700, 100, 60);
        LeaderSubmit.setFont(new Font("Myraid Pro",0,20));
        LeaderSubmit.setBackground(Pink);
        LeaderSubmit.setForeground(Color.WHITE);
        LeaderSubmit.setBorder(BorderFactory.createEmptyBorder());
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

    public void F11() throws IOException, ClassNotFoundException {
        Buttons(800);
        int y = 250;
        int x = 240;
        int tx = x+190;
        JLabel EDITtrainee = new JLabel("Edit Trainee ");
        EDITtrainee.setBounds((800/2)-125, 10, 430, 90);
        EDITtrainee.setFont(new Font("Serif", Font.BOLD, 50));
        add(EDITtrainee);
        TraineeList = Files.readTrainee();
        for (int i = 0; i < TraineeList.size(); i++) {
            data.add(TraineeList.get(i).getId() + "  " + TraineeList.get(i).getName());
        }
        JLabel info = new JLabel("Enter the fields you would like to edit: ");
        info.setFont(new Font("Serif", 1, 20));
        info.setBounds(x, y-50, 400, 50);
        add(info);

        TraineeCombo = new JComboBox(data.toArray());
        TraineeCombo.setBackground(LightPurple);
        JLabel ComboBox = new JLabel("Trainee: ");
        ComboBox.setFont(new Font("Serif", 1, 20));
        ComboBox.setBounds(x, y, 100, 30);
        add(ComboBox);

        TraineeCombo.setFont(new Font("Serif", 0, 20));
        TraineeCombo.setBounds(tx, y, 170, 30);
        add(TraineeCombo);

        JLabel Tname = new JLabel("Name: ");
        Tname.setFont(new Font("Serif", Font.BOLD, 20));
        Tname.setBounds(x, y+=50, 80, 30);
        add(Tname);

        name.setBounds(tx, y, 150, 30);
        add(name);

        JLabel Tage = new JLabel("Age: ");
        Tage.setFont(new Font("Serif", Font.BOLD, 20));
        Tage.setBounds(x, y+=50, 80, 30);
        add(Tage);

        age.setBounds(tx, y, 150, 30);
        add(age);

        JLabel TfacultyName = new JLabel("Faculty Name: ");
        TfacultyName.setFont(new Font("Serif", Font.BOLD, 20));
        TfacultyName.setBounds(x, y+=50, 140, 30);
        add(TfacultyName);

        FacultyName.setBounds(tx, y, 150, 30);
        add(FacultyName);

        JLabel TacademicYear = new JLabel("Academic Year: ");
        TacademicYear.setFont(new Font("Serif", Font.BOLD, 20));
        TacademicYear.setBounds(x, y+=50, 150, 30);
        add(TacademicYear);

        academicYear.setBounds(tx, y, 150, 30);
        add(academicYear);

        JLabel Tgpa = new JLabel("GPA: ");
        Tgpa.setFont(new Font("Serif", Font.BOLD, 20));
        Tgpa.setBounds(x, y+=50, 80, 30);
        add(Tgpa);

        GPA.setBounds(tx, y, 150, 30);
        add(GPA);

        EditTrainee.setBounds((800/2)-50, y+=100, 100, 50);
        EditTrainee.setBackground(Pink);
        EditTrainee.setForeground(Color.WHITE);
        EditTrainee.setBorder(BorderFactory.createEmptyBorder());
        add(EditTrainee);
    }

    //Edit Team Member
    JComboBox TeamMemberCombo;
    JTextField TeamMembername = new JTextField(20);
    JTextField TeamMemberage = new JTextField(20);
    JButton EditTeamMember = new JButton("Submit");
    ArrayList<TeamLeader> TeamMemberList = Files.readTeamLeader();
    ArrayList<String> dataTeamMember = new ArrayList();
    JSpinner Hours = new JSpinner(new SpinnerNumberModel(0,0,360,0.5));
    JSpinner Tax = new JSpinner(new SpinnerNumberModel(0,0,0.25,0.01));
    JSpinner Pay = new JSpinner(new SpinnerNumberModel(0,0,0.50,0.01));
    public void F12() throws IOException, ClassNotFoundException {
        Buttons(800);
        JLabel EDITteamMember = new JLabel("Edit Team Member ");
        EDITteamMember.setBounds(195, 50, 550, 90);
        EDITteamMember.setFont(new Font("Serif", Font.BOLD, 50));
        add(EDITteamMember);

        JLabel infoTeamM = new JLabel("Enter the fields you would like to edit: ");
        infoTeamM.setFont(new Font("Serif", 1, 20));

        dataTeamMember.clear();
        TeamMemberList = Files.readTeamLeader();
        for (int i = 0; i < TeamMemberList.size(); i++) {
            for (int j = 0; j < TeamMemberList.get(i).getTeamMembers().size(); j++) {
                dataTeamMember.add(TeamMemberList.get(i).getTeamMembers().get(j).getId() + "  " + TeamMemberList.get(i).getTeamMembers().get(j).getName());
            }
        }
        TeamMemberCombo = new JComboBox(dataTeamMember.toArray());
        int y = 250;
        int x = 240;
        infoTeamM.setBounds(x, y-50, 400, 50);
        add(infoTeamM);
        JLabel ComboBox = new JLabel("Team Member: ");
        ComboBox.setFont(new Font("Serif", 1, 20));
        ComboBox.setBounds(x, y, 180, 30);

        add(ComboBox);

        TeamMemberCombo.setFont(new Font("Serif", 0, 20));
        TeamMemberCombo.setBounds(x+190, y, 170, 30);
        TeamMemberCombo.setBackground(LightPurple);
        TeamMemberCombo.setOpaque(true);
        add(TeamMemberCombo);

        JLabel TeamMmemberName = new JLabel("Name: ");
        TeamMmemberName.setFont(new Font("Serif", Font.BOLD, 20));
        TeamMmemberName.setBounds(x, y+50, 80, 30);
        add(TeamMmemberName);

        TeamMembername.setBounds(x+190, y+50, 150, 30);
        add(TeamMembername);
        Font font  = new Font("Serif", Font.BOLD, 20);
        JLabel TeamMemberAge = new JLabel("Age: ");
        TeamMemberAge.setFont(font);
        TeamMemberAge.setBounds(x, y+100, 80, 30);
        add(TeamMemberAge);

        TeamMemberage.setBounds(x+190, y+100, 150, 30);
        add(TeamMemberage);

        JLabel WorkingHours = new JLabel("Working Hours: ");
        WorkingHours.setFont(font);
        WorkingHours.setBounds(x,y+150,150,30);
        add(WorkingHours);


        Hours.setBounds(x+190,y+150,80,30);
        add(Hours);



        JLabel TaxRate = new JLabel("Tax-Rate: ");
        TaxRate.setFont(font);
        TaxRate.setBounds(x,y+200,150,30);
        add(TaxRate);


        Tax.setBounds(x+190,y+200,80,30);
        add(Tax);

        JLabel PayRate = new JLabel("Pay-Rate: ");
        PayRate.setFont(font);
        PayRate.setBounds(x,y+250,150,30);
        add(PayRate);


        Pay.setBounds(x+190,y+250,80,30);
        add(Pay);

        EditTeamMember.setBounds(350, 600, 100, 50);
        EditTeamMember.setFont(new Font("Myraid Pro",0,20));
        EditTeamMember.setBackground(Pink);
        EditTeamMember.setForeground(Color.WHITE);
        EditTeamMember.setBorder(BorderFactory.createEmptyBorder());
        add(EditTeamMember);

    }

    //Edit Team Leader
    JComboBox LeaderCombo;
    ArrayList<TeamLeader> TeamLeaderList = Files.readTeamLeader();
    ArrayList<String> dataTeamLeader = new ArrayList();
    JTextField EditTeamLeaderName = new JTextField(20);
    JTextField EditTeamLeaderAge = new JTextField(20);
    JButton EditTeamLeader = new JButton("Submit");
    JSpinner TeamLeaderHours = new JSpinner(new SpinnerNumberModel(0,0,360,0.5));
    JSpinner TeamLeaderTax = new JSpinner(new SpinnerNumberModel(0,0,0.75,0.01));
    JSpinner TeamLeaderPay = new JSpinner(new SpinnerNumberModel(0,0,0.9,0.01));
    public void F13() throws IOException, ClassNotFoundException {
        Buttons(800);
        int y = 250;
        int x = 240;
        JLabel EDITteamLeader = new JLabel("Edit Team Leader ");
        EDITteamLeader.setBounds(195, 50, 550, 90);
        EDITteamLeader.setFont(new Font("Serif", Font.BOLD, 50));
        add(EDITteamLeader);

        JLabel infoTeamL = new JLabel("Enter the fields you would like to edit: ");
        infoTeamL.setFont(new Font("Serif", 1, 20));
        infoTeamL.setBounds(x, y-50, 400, 50);
        add(infoTeamL);


        TeamLeaderList = Files.readTeamLeader();
        for (int i = 0; i < TeamLeaderList.size(); i++) {
            dataTeamLeader.add(TeamLeaderList.get(i).getId() + "  " + TeamLeaderList.get(i).getName());
        }
        LeaderCombo = new JComboBox(dataTeamLeader.toArray());
        LeaderCombo.setBackground(LightPurple);
        JLabel ComboBox = new JLabel("Team Leader: ");
        ComboBox.setFont(new Font("Serif", 1, 20));
        ComboBox.setBounds(x, y, 180, 30);
        add(ComboBox);

        LeaderCombo.setFont(new Font("Serif", 0, 20));
        LeaderCombo.setBounds(x+190, y, 170, 30);
        add(LeaderCombo);

        JLabel TleaderName = new JLabel("Name: ");
        TleaderName.setFont(new Font("Serif", Font.BOLD, 20));
        TleaderName.setBounds(x, y+50, 80, 30);
        add(TleaderName);

        EditTeamLeaderName.setBounds(x+190, y+50, 150, 30);
        add(EditTeamLeaderName);

        JLabel TeamLeaderAge = new JLabel("Age: ");
        TeamLeaderAge.setFont(new Font("Serif", Font.BOLD, 20));
        TeamLeaderAge.setBounds(x, y+100, 80, 30);
        add(TeamLeaderAge);
        Font font = new Font("Serif", Font.BOLD, 20);

        EditTeamLeaderAge.setBounds(x+190, y+100, 150, 30);
        add(EditTeamLeaderAge);

        JLabel WorkingHours = new JLabel("Working Hours: ");
        WorkingHours.setFont(font);
        WorkingHours.setBounds(x,y+150,150,30);
        add(WorkingHours);


        TeamLeaderHours.setBounds(x+190,y+150,80,30);
        add(TeamLeaderHours);



        JLabel TaxRate = new JLabel("Tax-Rate: ");
        TaxRate.setFont(font);
        TaxRate.setBounds(x,y+200,150,30);
        add(TaxRate);


        TeamLeaderTax.setBounds(x+190,y+200,80,30);
        add(TeamLeaderTax);

        JLabel PayRate = new JLabel("Pay-Rate: ");
        PayRate.setFont(font);
        PayRate.setBounds(x,y+250,150,30);
        add(PayRate);


        TeamLeaderPay.setBounds(x+190,y+250,80,30);
        add(TeamLeaderPay);



        EditTeamLeader.setBounds((800/2)-50, y+350, 100, 50);
        EditTeamLeader.setBackground(Pink);
        EditTeamLeader.setForeground(Color.WHITE);
        EditTeamLeader.setBorder(BorderFactory.createEmptyBorder());
        add(EditTeamLeader);
    }

    //Button to delete Trainee by entering his ID
    JButton viewTraineeData = new JButton("View Data");
    JButton deleteTrainee = new JButton("Delete");
    JTextField deleteID = new JTextField(20);

    public void F14() {
        Buttons(800);
        JLabel DELETEtrainee = new JLabel("Delete Trainee ");
        DELETEtrainee.setBounds(225, 30, 430, 100);
        DELETEtrainee.setFont(new Font("Serif", Font.BOLD, 50));
        add(DELETEtrainee);


        JLabel ID = new JLabel("Trainee's ID: ");
        ID.setFont(new Font("Serif", Font.BOLD, 20));
        ID.setBounds(250, 150, 120, 30);
        add(ID);

        deleteID.setBounds(380, 150, 100, 30);
        deleteID.setFont(new Font("serif",0,20));
        add(deleteID);

        viewTraineeData.setBounds(200, 600, 150, 50);
        viewTraineeData.setFont(new Font("Serif", Font.BOLD, 20));
        viewTraineeData.setForeground(Color.WHITE);
        viewTraineeData.setBackground(Pink);
        viewTraineeData.setBorder(BorderFactory.createEmptyBorder());
        add(viewTraineeData);

        deleteTrainee.setBounds(430, 600, 150, 50);
        deleteTrainee.setFont(new Font("Serif", Font.BOLD, 20));
        deleteTrainee.setForeground(Color.WHITE);
        deleteTrainee.setBackground(Pink);
        deleteTrainee.setBorder(BorderFactory.createEmptyBorder());
        add(deleteTrainee);
    }

    //Button to delete TeamMember by entering his ID
    JButton viewTeamMemberData = new JButton("View Data");
    JButton deleteTeamMember = new JButton("Delete");
    JTextField deleteTeamMemberID = new JTextField(20);

    public void F15() {
        Buttons(800);
        setSize(800,600);
        JLabel DELETETeamMember = new JLabel("Delete Team Member ");
        DELETETeamMember.setBounds(185, 40, 550, 90);
        DELETETeamMember.setFont(new Font("Serif", Font.BOLD, 50));
        add(DELETETeamMember);

        JLabel TeamMemberID = new JLabel("Team Member ID: ");
        TeamMemberID.setFont(new Font("Serif", Font.BOLD, 20));
        TeamMemberID.setBounds(220, 150, 170, 30);
        add(TeamMemberID);

        deleteTeamMemberID.setBounds(400, 150, 100, 30);
        add(deleteTeamMemberID);

        viewTeamMemberData.setBounds(200, 450, 150, 50);
        viewTeamMemberData.setFont(new Font("Serif", Font.BOLD, 20));
        viewTeamMemberData.setForeground(Color.WHITE);
        viewTeamMemberData.setBackground(Pink);
        viewTeamMemberData.setBorder(BorderFactory.createEmptyBorder());
        add(viewTeamMemberData);

        deleteTeamMember.setBounds(450, 450, 150, 50);
        deleteTeamMember.setFont(new Font("Serif", Font.BOLD, 20));
        deleteTeamMember.setForeground(Color.WHITE);
        deleteTeamMember.setBackground(Pink);
        deleteTeamMember.setBorder(BorderFactory.createEmptyBorder());
        add(deleteTeamMember);
    }

    //Button to delete TeamLeader by entering his ID
    JButton viewTeamLeaderData = new JButton("View Data");
    JButton ReplaceTeamLeader = new JButton("Replace");
    JTextField deleteTeamLeaderID = new JTextField(20);

    public void F16() {
        setSize(800,800);
        Buttons(800);
        JLabel DELETETeamLeader = new JLabel("Delete & Replace Team Leader  ");
        DELETETeamLeader.setBounds(200, 30, 520, 100);
        DELETETeamLeader.setFont(new Font("Serif", Font.BOLD, 30));
        add(DELETETeamLeader);

        JLabel TeamLeaderID = new JLabel("Team Leader's ID: ");
        TeamLeaderID.setFont(new Font("Serif", Font.BOLD, 20));
        TeamLeaderID.setBounds(250, 150, 170, 30);
        add(TeamLeaderID);

        deleteTeamLeaderID.setBounds(420, 150, 100, 30);
        add(deleteTeamLeaderID);

        JLabel note = new JLabel("*The current team members will be assigned to the new team leader...");
        note.setFont(new Font("Serif", Font.BOLD, 15));
        note.setBounds(200, 650, 500, 20);
        add(note);

        viewTeamLeaderData.setBounds(250, 680, 150, 50);
        viewTeamLeaderData.setFont(new Font("Serif", Font.BOLD, 20));
        viewTeamLeaderData.setBackground(Pink);
        viewTeamLeaderData.setForeground(Color.WHITE);
        viewTeamLeaderData.setBorder(BorderFactory.createEmptyBorder());
        add(viewTeamLeaderData);

        ReplaceTeamLeader.setBounds(410, 680, 150, 50);
        ReplaceTeamLeader.setFont(new Font("Serif", Font.BOLD, 20));
        ReplaceTeamLeader.setForeground(Color.WHITE);
        ReplaceTeamLeader.setBackground(Pink);
        ReplaceTeamLeader.setBorder(BorderFactory.createEmptyBorder());
        add(ReplaceTeamLeader);
        revalidate();
        repaint();
    }

    //Delete function by replacing old TeamLeader with a new TeamLeader
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
        setSize(800, 600);
        Buttons(800);
        JLabel replacedTeamLeader = new JLabel("Replace Team Leader  ");
        replacedTeamLeader.setBounds((800/2) - 150, 30, 300, 100);
        replacedTeamLeader.setFont(new Font("Serif", Font.BOLD, 30));
        add(replacedTeamLeader);
        int x = 260;
        int y = 200;
        int tx =  x + 150;
        JLabel replacedTlname = new JLabel("Name: ");
        replacedTlname.setFont(new Font("Serif", Font.BOLD, 20));
        replacedTlname.setBounds(x, y, 80, 30);
        add(replacedTlname);

        getrepTlName.setBounds(tx, y, 100, 30);
        getrepTlName.setText("");
        add(getrepTlName);

        JLabel replacedTlid = new JLabel("ID: ");
        replacedTlid.setFont(new Font("Serif", Font.BOLD, 20));
        replacedTlid.setBounds(x, y+=50, 80, 30);
        add(replacedTlid);

        getrepTlid.setBounds(tx, y, 100, 30);
        getrepTlid.setText("");
        add(getrepTlid);

        JLabel replacedTlage = new JLabel("Age: ");
        replacedTlage.setFont(new Font("Serif", Font.BOLD, 20));
        replacedTlage.setBounds(x, y+=50, 80, 30);
        add(replacedTlage);

        getrepTlAge.setBounds(tx, y, 100, 30);
        getrepTlAge.setText("");
        add(getrepTlAge);

        JLabel replacedTlUser = new JLabel("Username: ");
        replacedTlUser.setFont(new Font("Serif", Font.BOLD, 20));
        replacedTlUser.setBounds(x, y+=50, 100, 30);
        add(replacedTlUser);

        getrepTlUser.setBounds(tx, y, 100, 30);
        getrepTlUser.setText("");
        add(getrepTlUser);

        JLabel replacedTlPass = new JLabel("Password: ");
        replacedTlPass.setFont(new Font("Serif", Font.BOLD, 20));
        replacedTlPass.setBounds(x, y+=50, 100, 30);
        add(replacedTlPass);

        getrepTlPass.setBounds(tx, y, 100, 30);
        getrepTlPass.setText("");
        add(getrepTlPass);

        SubmitTeamLeader.setBounds((800/2)-75, 500, 150, 50);
        SubmitTeamLeader.setFont(new Font("Serif", Font.BOLD, 20));
        SubmitTeamLeader.setForeground(Color.WHITE);
        SubmitTeamLeader.setBackground(Pink);
        SubmitTeamLeader.setBorder(BorderFactory.createEmptyBorder());

        add(SubmitTeamLeader);


    }

    //View Trainee data
    public void F17(){//int id, String name, int age, String facultyName, int academicYear, double GPA,String Username, String Password
        setSize(800,500);
        Buttons(800);
        JLabel VIEWteamLeader = new JLabel("View  Trainees ");
        VIEWteamLeader.setBounds(800/2 - 150, 50, 300, 90);
        VIEWteamLeader.setFont(new Font("Serif", Font.BOLD, 40));
        add(VIEWteamLeader);

        String column[] = {"ID", "Name", "Age","Faculty Name","Academic Year","GPA","Salary","Username","Password"};
        try {
            ArrayList<Trainee>viewTraineeData=Files.readTrainee();
            int y=viewTraineeData.size();
            int height = 27;
            String data[][] = new String[y][9];
            for (int i=0;i<viewTraineeData.size();i++){
                data[i][0]=viewTraineeData.get(i).getId()+"";
                data[i][1]=viewTraineeData.get(i).getName()+"";
                data[i][2]=viewTraineeData.get(i).getAge()+"";
                data[i][3]=viewTraineeData.get(i).getFacultyName()+"";
                data[i][4]=viewTraineeData.get(i).getAcademicYear()+"";
                data[i][5]=viewTraineeData.get(i).getGPA()+"";
                data[i][6]=viewTraineeData.get(i).getSalary()+"";
                data[i][7]=viewTraineeData.get(i).getUsername()+"";
                data[i][8]=viewTraineeData.get(i).getPassword()+"";
                height += 15;
            }
            JTable jt = new JTable(data, column);
            JScrollPane sp = new JScrollPane(jt);
            jt.setRowHeight(15);
            int counter = 0;
            int[] width = {75,75,75,100,100,75,75,75,75};
            for(int Width:width){
                TableColumn Column = jt.getColumnModel().getColumn(counter++);
                Column.setMinWidth(Width);
                Column.setMaxWidth(Width);
                Column.setPreferredWidth(Width);
            }
            jt.setFillsViewportHeight(true);
            JTableHeader head = jt.getTableHeader();
            head.setBorder(BorderFactory.createEmptyBorder());
            jt.setBorder(BorderFactory.createEmptyBorder());
            head.setBackground(Pink);
            head.setForeground(Color.WHITE);
            sp.setBounds(30,250,725,height);
            add(sp);
        }
        catch (IOException e) { e.printStackTrace();}
        catch (ClassNotFoundException e) { e.printStackTrace();}
    }

    //View TeamLeader
    public void F18(){//String name, int id, int age, ArrayList<TeamMember> TeamMembers, String Username,String Password)
        setSize(800,500);
        Buttons(800);
        JLabel VIEWteamLeader = new JLabel("View Team Leaders ");
        VIEWteamLeader.setBounds(185, 30, 550, 90);
        VIEWteamLeader.setFont(new Font("Serif", Font.BOLD, 50));
        add(VIEWteamLeader);

        String column[] = {"ID", "Name", "Age","Salary","Grade","Username","Password"};
        try {
            ArrayList<TeamLeader>viewTeamLeaderData=Files.readTeamLeader();
            int y=viewTeamLeaderData.size();
            int height = 27;
            String data[][] = new String[y][7];
            for (int i=0;i<viewTeamLeaderData.size();i++){
                data[i][0]=viewTeamLeaderData.get(i).getId()+"";
                data[i][1]=viewTeamLeaderData.get(i).getName()+"";
                data[i][2]=viewTeamLeaderData.get(i).getAge()+"";
                data[i][3]=viewTeamLeaderData.get(i).getSalary()+"";
                data[i][4]=viewTeamLeaderData.get(i).getGrade(new TeamLeader()) + "";
                data[i][5]=viewTeamLeaderData.get(i).getUsername()+"";
                data[i][6]=viewTeamLeaderData.get(i).getPassword()+"";
                height += 15;
            }
            JTable jt = new JTable(data, column);
            JTableHeader head = jt.getTableHeader();
            head.setBorder(BorderFactory.createEmptyBorder());
            jt.setBorder(BorderFactory.createEmptyBorder());
            head.setBackground(Pink);
            head.setForeground(Color.WHITE);
            JScrollPane sp = new JScrollPane(jt);
            jt.setRowHeight(15);
            int counter = 0;

            int[] width = {75,75,75,75,75,75,75};
            for(int Width:width){
                TableColumn Column = jt.getColumnModel().getColumn(counter++);
                Column.setMinWidth(Width);
                Column.setMaxWidth(Width);
                Column.setPreferredWidth(Width);
            }
            jt.setFillsViewportHeight(true);
            sp.setBounds(150,250,525,height);
            add(sp);
        }
        catch (IOException e) { e.printStackTrace();}
        catch (ClassNotFoundException e) { e.printStackTrace();}
    }

    //View TeamMembers
    public void F19(){//String name, int id, int age, String Username, String Password
        setSize(800,500);
        Buttons(800);
        JLabel VIEWteamLeader = new JLabel("View Team Members ");
        VIEWteamLeader.setBounds(175, 30, 550, 90);
        VIEWteamLeader.setFont(new Font("Serif", Font.BOLD, 50));
        add(VIEWteamLeader);

        String column[] = {"ID", "Name", "Age","Salary","Username","Password"};
        try {
            ArrayList<TeamLeader>viewTeamMembers=Files.readTeamLeader();
            int y=0;
            for(int i=0;i<viewTeamMembers.size();i++){
                y+=viewTeamMembers.get(i).getTeamMembers().size();
            }

            int height = 27;
            int counter=0;
            String data[][] = new String[y][6];
            for(int j=0;j<viewTeamMembers.size();j++) {
                for (int i = 0; i < viewTeamMembers.get(j).getTeamMembers().size(); i++) {
                    data[counter][0] = viewTeamMembers.get(j).getTeamMembers().get(i).getId() + "";
                    data[counter][1] = viewTeamMembers.get(j).getTeamMembers().get(i).getName() + "";
                    data[counter][2] = viewTeamMembers.get(j).getTeamMembers().get(i).getAge() + "";
                    data[counter][3] = viewTeamMembers.get(j).getTeamMembers().get(i).getSalary() + "";
                    data[counter][4] = viewTeamMembers.get(j).getTeamMembers().get(i).getUsername() + "";
                    data[counter][5] = viewTeamMembers.get(j).getTeamMembers().get(i).getPassword() + "";
                    height += 15;
                    counter++;
                }
            }
            JTable jt = new JTable(data, column);
            JScrollPane sp = new JScrollPane(jt);
            JTableHeader head = jt.getTableHeader();
            head.setBorder(BorderFactory.createEmptyBorder());
            jt.setBorder(BorderFactory.createEmptyBorder());
            head.setBackground(Pink);
            head.setForeground(Color.WHITE);
            jt.setRowHeight(15);
            counter = 0;
            int[] width = {75,75,75,75,75,75};
            for(int Width:width){
                TableColumn Column = jt.getColumnModel().getColumn(counter++);
                Column.setMinWidth(Width);
                Column.setMaxWidth(Width);
                Column.setPreferredWidth(Width);
            }
            jt.setFillsViewportHeight(true);
            sp.setBounds(175,250,450,height);
            add(sp);
        }
        catch (IOException e) { e.printStackTrace();}
        catch (ClassNotFoundException e) { e.printStackTrace();}
    }

    //Manager choose which one (TeamLeader/TeamMember/Trainee) he wants to ADD EDIT DELETE or VIEW
    public void Role() {
        JPanel p = new JPanel();
        p.setBounds(86,475,648,150);
        Color c = new Color(158,123,181);
        p.setBackground(c.darker());
        Trainee.setBounds(100, 550, 200, 50);
        Trainee.setFont(new Font("Myraid Pro", Font.BOLD, 20));
        Trainee.setBackground(Color.WHITE);
        Trainee.setForeground(Color.LIGHT_GRAY.darker().darker());
        add(Trainee);

        TeamLeader.setBounds(310, 550, 200, 50);
        TeamLeader.setFont(new Font("Myraid Pro", Font.BOLD, 20));
        TeamLeader.setBackground(Color.WHITE);
        TeamLeader.setForeground(Color.LIGHT_GRAY.darker().darker());
        add(TeamLeader);

        TeamMember.setBounds(520, 550, 200, 50);
        TeamMember.setFont(new Font("Myraid Pro", Font.BOLD, 20));
        TeamMember.setBackground(Color.WHITE);
        TeamMember.setForeground(Color.LIGHT_GRAY.darker().darker());
        add(TeamMember);
        add(p);
    }
    //Mouse Listener
    public class ML extends MouseMotionAdapter{
        @Override
        public void mouseDragged(MouseEvent e) {
            int coordinateX = e.getXOnScreen();
            int coordinateY = e.getYOnScreen();
            setLocation(coordinateX-mx-60,coordinateY-my);
            revalidate();
        }
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
            JLabel labelUse = new JLabel();
            labelUse.setBounds(314,475,300,50);
            labelUse.setFont(new Font("Myraid Pro",1,20));
            labelUse.setForeground(Color.WHITE);
            add(labelUse);
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
                    if(JOptionPane.showConfirmDialog(null,"Are you sure?","", YES_NO_OPTION) == YES_OPTION){
                        userin.setText("");
                        passin.setText("");
                        getContentPane().removeAll();
                        getContentPane().revalidate();
                        add(back);
                        F2();
                        state--;
                    }
                    else{}
                }
                if (state == 3) {
                    getContentPane().removeAll();
                    setSize(800,800);
                    revalidate();
                    repaint();
                    state--;
                    add(back);
                    F7();

                }
                if(state == 4){
                    getContentPane().removeAll();
                    revalidate();
                    repaint();
                    state--;
                    add(back);
                    F16();
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

                User x = new User();
                if (select == 1) {
                    try {
                        Object chosen = x.checkLogintltm(userin.getText(), passin.getText());

                        if (chosen == null) {
                            showMessageDialog(null, "Incorrect Username or Password.");
                            setSize(800,500);
                        } else {
                            getContentPane().removeAll();
                            JLabel l = new JLabel();
                            l.setBackground(LightPurple);
                            setContentPane(l);
                            setSize(800,800);
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
                            JLabel l = new JLabel();
                            l.setBackground(LightPurple);
                            setContentPane(l);
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
                            JLabel l = new JLabel();
                            l.setBackground(LightPurple);
                            setContentPane(l);
                            setSize(800,800);
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
                state = 3;
                if (roleState == 1) {
                    num = 1;
                    add(back);
                    F9();

                }
                //EDIT
                else if (roleState == 2) {
                    add(back);
                    try {
                        F11();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    }
                }
                //Delete
                else if (roleState == 3) {
                    add(back);
                    F14();
                }
                //View
                else if(roleState==4){
                    add(back);
                    F17();
                }
            }
            if (e.getSource() == TeamLeader) {
                //ADD
                state = 3;
                if (roleState == 1) {
                    num = 2;

                    getContentPane().removeAll();
                    setSize(1150, 801);
                    add(back);
                    F10();
                }
                //EDIT
                else if (roleState == 2) {

                    getContentPane().removeAll();
                    setSize(801, 801);
                    setSize(800, 800);
                    add(back);
                    try {
                        F13();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    }
                }
                //DELETE
                else if (roleState == 3) {

                    getContentPane().removeAll();
                    setSize(801, 801);
                    setSize(800, 800);
                    add(back);
                    F16();
                }
                //VIEW
                else if(roleState==4){

                    getContentPane().removeAll();
                    setSize(801, 801);
                    setSize(800, 800);
                    add(back);
                    F18();
                }

            }
            if (e.getSource() == TeamMember) {
                getContentPane().removeAll();
                getContentPane().revalidate();
                setSize(801, 801);
                setSize(800, 800);
                //ADD
                state = 3;
                if (roleState == 1) {
                    add(back);
                    F8();

                }
                //EDIT
                else if (roleState == 2) {
                    add(back);
                    try {
                        F12();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    }
                }
                //DELETE
                else if (roleState == 3) {
                    add(back);
                    F15();
                }
                //VIEW
                else if(roleState==4){
                    add(back);
                    F19();
                }
            }
            //Tool Buttons//
            if(e.getSource() == close){
                System.exit(0);
            }
            //minimize button
            if(e.getSource() == minimize){
                setState(ICONIFIED);
            }
            //maximize button
            if(e.getSource() == maximize){
                if (getExtendedState() == MAXIMIZED_BOTH) {
                    setExtendedState(NORMAL);
                } else {
                    setExtendedState(MAXIMIZED_BOTH);
                }
            }

            ////////////Adding////////////////
            if (e.getSource() == Add) {
                state = 3;
                getContentPane().removeAll();
                revalidate();
                setSize(801, 801);
                setSize(800, 800);
                add(back);
                F7();
                labelUse.setText("Pick a position to add");
                add(labelUse);
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
                state = 3;
                getContentPane().removeAll();
                revalidate();
                setSize(801, 801);
                setSize(800, 800);
                add(back);
                F7();
                labelUse.setText("Pick a position to edit");
                add(labelUse);
                revalidate();
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

                try {
                    Files.writeTrainee(TraineeList);
                    showMessageDialog(null, "Successfully Saved.");
                    TraineeCombo.removeAllItems();
                    data.clear();
                    name.setText("");
                    age.setText("");
                    academicYear.setText("");
                    FacultyName.setText("");
                    GPA.setText("");
                    getContentPane().removeAll();
                    F7();

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
                    boolean CheckHours = ((Double) Hours.getValue() != 0.0) ? true : false;
                    boolean CheckTax = ((Double) Tax.getValue() != 0.0) ? true : false;
                    boolean CheckPay = ((Double) Pay.getValue() != 0.0) ? true : false;

                if(CheckHours == true)
                    TeamMemberList.get(indexL).getTeamMembers().get(indexM).setWorkingHours((Double)Hours.getValue());
                if(CheckPay == true)
                    TeamMemberList.get(indexL).getTeamMembers().get(indexM).setPayRate((Double)Pay.getValue());
                if(CheckTax == true)
                    TeamMemberList.get(indexL).getTeamMembers().get(indexM).setTaxRate((Double)Tax.getValue());

                try {
                    Files.writeTeamLeader(TeamMemberList);
                    showMessageDialog(null, "Successfully Saved.");
                    for(int i= 0;i< TeamMemberCombo.getItemCount();i++){
                        TeamMemberCombo.removeItemAt(i);
                    }

                    TeamMembername.setText("");
                    TeamMemberage.setText("");
                    Hours.setValue(0.0);
                    Tax.setValue(0.0);
                    Pay.setValue(0.0);

                    getContentPane().removeAll();
                    F7();

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
                boolean CheckHours = ((Double)TeamLeaderHours.getValue() != 0)? true:false;
                boolean CheckTax = ((Double)TeamLeaderTax.getValue() != 0)?true:false;
                boolean CheckPay = ((Double)TeamLeaderPay.getValue() != 0)?true:false;
                if(CheckHours == true)
                    TeamLeaderList.get(index).setWorkingHours((Double)TeamLeaderHours.getValue());
                if(CheckTax == true)
                    TeamLeaderList.get(index).setTaxRate((Double)TeamLeaderTax.getValue());
                if(CheckPay == true)
                    TeamLeaderList.get(index).setPayRate((Double)TeamLeaderPay.getValue());
                try {
                    Files.writeTeamLeader(TeamLeaderList);
                    showMessageDialog(null, "Successfully Saved");
                    LeaderCombo.removeAllItems();
                    dataTeamLeader.clear();
                    EditTeamLeaderName.setText("");
                    EditTeamLeaderAge.setText("");
                    TeamLeaderHours.setValue(0);
                    TeamLeaderTax.setValue(0);
                    TeamLeaderPay.setValue(0);
                    getContentPane().removeAll();
                    F7();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }


            /////////////Delete////////////////
            if (e.getSource() == Delete) {
                state = 3;
                getContentPane().removeAll();
                revalidate();
                setSize(801, 801);
                setSize(800, 800);
                add(back);
                F7();
                labelUse.setText("Pick a position to delete");
                add(labelUse);

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
                            getContentPane().removeAll();
                            state = 2;
                            F7();
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
                            int x = 250;
                            int y = 250;
                            int tx = x+140;
                            JLabel TraineeName = new JLabel("Name: ");
                            TraineeName.setFont(new Font("Serif", Font.BOLD, 20));
                            TraineeName.setBounds(x, y, 100, 30);
                            add(TraineeName);
                            JTextField getTraineeName = new JTextField(chosen.getName());
                            getTraineeName.setFont(new Font("Serif", 0, 20));
                            getTraineeName.setBounds(tx, y, 120, 30);
                            add(getTraineeName);

                            JLabel Traineeid = new JLabel("ID: ");
                            Traineeid.setFont(new Font("Serif", Font.BOLD, 20));
                            Traineeid.setBounds(x, y+=50, 100, 30);
                            add(Traineeid);
                            JTextField getTraineeid = new JTextField(String.valueOf(chosen.getId()));
                            getTraineeid.setFont(new Font("Serif", 0, 20));
                            getTraineeid.setBounds(tx, y, 120, 30);
                            add(getTraineeid);

                            JLabel Traineeage = new JLabel("Age: ");
                            Traineeage.setFont(new Font("Serif", Font.BOLD, 20));
                            Traineeage.setBounds(x, y+=50, 100, 30);
                            add(Traineeage);
                            JTextField getTraineeage = new JTextField(String.valueOf(chosen.getAge()));
                            getTraineeage.setFont(new Font("Serif", 0, 20));
                            getTraineeage.setBounds(tx, y, 120, 30);
                            add(getTraineeage);

                            JLabel TraineefacultyName = new JLabel("Faculty Name: ");
                            TraineefacultyName.setFont(new Font("Serif", Font.BOLD, 20));
                            TraineefacultyName.setBounds(x, y+=50, 150, 30);
                            add(TraineefacultyName);
                            JTextField getTraineefacultyName = new JTextField(chosen.getFacultyName());
                            getTraineefacultyName.setFont(new Font("Serif", 0, 20));
                            getTraineefacultyName.setBounds(tx, y, 120, 30);
                            add(getTraineefacultyName);

                            JLabel TraineeacademicYear = new JLabel("Academic Year: ");
                            TraineeacademicYear.setFont(new Font("Serif", Font.BOLD, 20));
                            TraineeacademicYear.setBounds(x, y+=50, 150, 30);
                            add(TraineeacademicYear);
                            JTextField getTraineeacademicYear = new JTextField(String.valueOf(chosen.getAcademicYear()));
                            getTraineeacademicYear.setFont(new Font("Serif",0, 20));
                            getTraineeacademicYear.setBounds(tx, y, 120, 30);
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
                                    idcheck = true;
                                    break;
                                }
                                deleteTeamLeader.get(i).getTeamMembers().remove(deleteTeamLeader.get(i).getTeamMembers().get(j));
                                showMessageDialog(null, "Successfully deleted");
                                idcheck = true;
                                deleteTeamMemberID.setText("");
                                getContentPane().removeAll();
                                state = 2;
                                F7();

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
                revalidate();
                repaint();
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

                                int x = 250;
                                int y = 250;
                                int tx = x + 140;
                                JLabel TeamLeaderName = new JLabel("Name: ");
                                TeamLeaderName.setFont(new Font("Serif", Font.BOLD, 20));
                                TeamLeaderName.setBounds(x, y, 100, 30);
                                add(TeamLeaderName);
                                JTextField getTeamLeaderName = new JTextField(chosen.getName());
                                getTeamLeaderName.setFont(new Font("Serif", Font.BOLD, 20));
                                getTeamLeaderName.setBounds(tx, y, 120, 30);
                                add(getTeamLeaderName);

                                JLabel TeamLeaderid = new JLabel("ID: ");
                                TeamLeaderid.setFont(new Font("Serif", Font.BOLD, 20));
                                TeamLeaderid.setBounds(x, y+=50, 100, 30);
                                add(TeamLeaderid);
                                JTextField getTeamLeaderid = new JTextField(String.valueOf(chosen.getId()));
                                getTeamLeaderid.setFont(new Font("Serif", Font.BOLD, 20));
                                getTeamLeaderid.setBounds(tx, y, 120, 30);
                                add(getTeamLeaderid);

                                JLabel TeamLeaderAge = new JLabel("Age: ");
                                TeamLeaderAge.setFont(new Font("Serif", Font.BOLD, 20));
                                TeamLeaderAge.setBounds(x, y+=50, 100, 30);
                                add(TeamLeaderAge);
                                JTextField getTeamLeaderage = new JTextField(String.valueOf(chosen.getAge()));
                                getTeamLeaderage.setFont(new Font("Serif", Font.BOLD, 20));
                                getTeamLeaderage.setBounds(tx, y, 120, 30);
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
                state = 4;
                int index;

                ArrayList<TeamLeader> replaceTeamLeader = new ArrayList<>();
                try {
                    replaceTeamLeader = Files.readTeamLeader();
                    if (deleteTeamLeaderID.getText().equals("")) {
                        showMessageDialog(null, "Missing ID...");
                        deleteTeamLeaderID.setText("");
                    }
                    for (int i = 0; i < replaceTeamLeader.size(); i++) {
                        index = i;
                        if (Integer.parseInt(deleteTeamLeaderID.getText()) == replaceTeamLeader.get(i).getId()) {
                            deleteTeamLeaderID.setText("");
                            replaceTL();
                            add(back);
                            break;
                        }
                    }
                    Files.writeTeamLeader(replaceTeamLeader);
                    dataTeamLeader.clear();
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
                            Tlmember.setBounds(320, 350, 200, 30);
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
                                TlmembersId.setBounds(320, 400 + j, 40, 30);
                                add(TlmembersId);
                                JTextField getTlmembersId = new JTextField(20);
                                getTlmembersId.setBounds(370, 400 + j, 100, 30);
                                add(getTlmembersId);

                                JLabel TlmembersAge = new JLabel("Age: ");
                                TlmembersAge.setFont(new Font("Serif", Font.BOLD, 20));
                                TlmembersAge.setBounds(550, 400 + j, 50, 30);
                                add(TlmembersAge);
                                JTextField getTlmembersAge = new JTextField(20);
                                getTlmembersAge.setBounds(600 , 400 + j, 100, 30);
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
                        dataTeamLeader.clear();
                        showMessageDialog(null, "Successfully Saved");
                        getContentPane().removeAll();
                        state = 2;
                        F7();
                    }
                }
                catch (IOException ioException) { ioException.printStackTrace();}
                catch (ClassNotFoundException classNotFoundException) { classNotFoundException.printStackTrace();}
            }


            ///////////View///////////////////////
            if(e.getSource()==view){
                state = 3;
                getContentPane().removeAll();
                revalidate();
                setSize(801, 801);
                setSize(800, 800);
                add(back);
                F7();
                labelUse.setText("Pick a position to view");
                add(labelUse);
                roleState = 4;
                Role();
            }

        }
    }
}
