package Payroll;

import java.io.*;
import java.util.ArrayList;

public interface Files {
    public static ArrayList<Manager> readManager() throws IOException, ClassNotFoundException{
        ArrayList<Manager> list = new ArrayList();
        FileInputStream File = new FileInputStream("ManagerList.txt");
        ObjectInputStream Stream = new ObjectInputStream(File);
        list = (ArrayList<Manager>)Stream.readObject();
        return list;
    }
    //Write Object
    public static void writeManager(ArrayList<Manager> manager) throws IOException, ClassNotFoundException{
        ObjectOutputStream Stream = new ObjectOutputStream(new FileOutputStream("ManagerList.txt"));
        Stream.writeObject(manager);
        Stream.close();
    }
    public static ArrayList<Trainee> readTrainee() throws IOException, ClassNotFoundException{
        ArrayList<Trainee> list = new ArrayList();
        FileInputStream File = new FileInputStream("TraineeList.txt");
        ObjectInputStream Stream = new ObjectInputStream(File);
        list = (ArrayList<Trainee>)Stream.readObject();
        return list;
    }
    public static void writeTrainee(ArrayList<Trainee> trainee) throws IOException, ClassNotFoundException{
        ObjectOutputStream Stream = new ObjectOutputStream(new FileOutputStream("TraineeList.txt"));
        Stream.writeObject(trainee);
        Stream.close();
    }
    public static ArrayList<TeamLeader> readTeamLeader() throws IOException, ClassNotFoundException{
        ArrayList<TeamLeader> list = new ArrayList();
        FileInputStream File = new FileInputStream("TeamLandTeamMList.txt");
        ObjectInputStream Stream = new ObjectInputStream(File);
        list = (ArrayList<TeamLeader>)Stream.readObject();
        return list;
    }
    public static void writeTeamLeader(ArrayList<TeamLeader> teamleader) throws IOException, ClassNotFoundException{
        ObjectOutputStream Stream = new ObjectOutputStream(new FileOutputStream("TeamLandTeamMList.txt"));
        Stream.writeObject(teamleader);
        Stream.close();
    }
}