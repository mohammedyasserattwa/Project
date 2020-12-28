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

    public void F4(TeamLeader chosen){
        JLabel viewname=new JLabel("Name:");
        viewname.setBounds(350,50,50,50);
        viewname.setFont(new Font("Serif",20,18));
        add(viewname);
        JLabel TlName=new JLabel(chosen.getName());
        TlName.setFont(new Font("Serif",20,18));
        TlName.setBounds(410,50,100,50);
        add(TlName);

        JLabel ID=new JLabel("ID:");
        ID.setBounds(350,75,50,50);
        ID.setFont(new Font("Serif",20,18));
        add(ID);
        JLabel Tlid=new JLabel(""+chosen.getId());
        Tlid.setFont(new Font("Serif",20,18));
        Tlid.setBounds(410,75,100,50);
        add(Tlid);

//      JLabel age=new JLabel("Age:");
//      age.setBounds(350,100,50,50);
//      age.setFont(new Font("Serif",20,18));
//      add(age);
//      JLabel num=new JLabel(""+chosen.getAge());
//      num.setBounds(410,100,50,50);
//      num.setFont(new Font("Serif",20,18));
//      add(num);

    }
    public void F5(Object chosen){

    }
    public void F6(Trainee chosen){

    }
    public void F7(Manager chosen){

    }
    public class Al implements ActionListener  {
        int state=0;
        int select=0;
        @Override
        public void actionPerformed(ActionEvent e) {
            //Back Button
            if (e.getSource() == back) {
                if (state == 1) {
//                    remove(teamleader);
//                    remove(trainee);
//                    remove(manager);
//                    remove(back);
                    getContentPane().removeAll();
                    F1();
                }
                if (state == 2) {
//                    remove(username);
//                    remove(userin);
//                    remove(password);
//                    remove(passin);
//                    remove(submit);
                    getContentPane().removeAll();
                    F2();
                    state--;
                }

            }

            if (e.getSource() == login) {
                setSize(801, 801);
                setSize(800, 800);
//                remove(welc);
//                remove(login);
//                remove(sign);
                getContentPane().removeAll();
                F2();
                state = 1;
            }

            if (e.getSource() == teamleader) {
                setSize(801, 801);
                setSize(800, 800);
//                remove(manager);
//                remove(teamleader);
//                remove(trainee);
                getContentPane().removeAll();
                F3();
                state = 2;
                select = 1;
            }


            if (e.getSource() == manager) {
                setSize(801, 801);
                setSize(800, 800);
//                remove(manager);
//                remove(teamleader);
//                remove(trainee);
                getContentPane().removeAll();
                F3();
                state = 2;
                select = 2;
            }

            if (e.getSource() == trainee) {
                setSize(801, 801);
                setSize(800, 800);
//                remove(manager);
//                remove(teamleader);
//                remove(trainee);
                getContentPane().removeAll();
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
                            userin.setText("");passin.setText("");
                        }
                        else{
//                            remove(username);
//                            remove(userin);
//                            remove(password);
//                            remove(passin);
//                            remove(submit);
                            getContentPane().removeAll();
                            if(chosen instanceof TeamLeader){
                                TeamLeader j=(TeamLeader)chosen;
                                F4(j);
                            }
                            else {
                                TeamMember j=(TeamMember)chosen;
                                F5(j);
                            }
                        }
                    }
                    catch (IOException ioException) { ioException.printStackTrace();}
                    catch (ClassNotFoundException classNotFoundException) { classNotFoundException.printStackTrace();}
                }

                if (select == 2) {
                    try {
                        Manager chosen=x.checkLoginm(userin.getText(),passin.getText());
                        if(chosen==null) {
                            showMessageDialog(null, "Incorrect Username or Password.");
                            userin.setText("");passin.setText("");
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
                    } catch (IOException ioException) { ioException.printStackTrace();}
                    catch (ClassNotFoundException classNotFoundException) {classNotFoundException.printStackTrace();}
                }



            }
        }
    }
}