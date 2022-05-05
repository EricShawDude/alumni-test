import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class ScripSystem {

    ArrayList<Alumni> members = new ArrayList<>();

    public void addNew(Alumni alumni){
        members.add(alumni);
    }

    public void addMonth(){
        for (Alumni a : members){
            if (a.getRank().equalsIgnoreCase("aspirant") || a.getRank().equalsIgnoreCase("lr") || a.getRank().equalsIgnoreCase("sr") ||  a.getRank().equalsIgnoreCase("mentee")) {
                a.addScrip(1000);
            }

            else if (a.getRank().equalsIgnoreCase("mr") ||  a.getRank().equalsIgnoreCase("mentor")){
                a.addScrip(2000);
            }

            else if (a.getRank().equalsIgnoreCase("hr") ||  a.getRank().equalsIgnoreCase("domini")){
                a.addScrip(4000);
            }

            else if (a.getRank().equalsIgnoreCase("cr") ||  a.getRank().equalsIgnoreCase("executive directorate")){
                a.addScrip(10000);
            }

            else if (a.getRank().equalsIgnoreCase("president")){
                a.addScrip(900000);
            }
        }
        System.out.println("Monthly payment successfully added.");
    }

    public void addPerson(String name, int add){
        Alumni b = null;
        for (Alumni a : members){
            if (a.getUsername().equalsIgnoreCase(name)){
                b = a;
                break;
            }
        }

        if (b != null){
            b.addScrip(add);
        }

        else{
            System.out.println("Something went wrong.");
        }
    }

    public void subtractPerson(String name, int add){
        Alumni b = null;
        for (Alumni a : members){
            if (a.getUsername().equalsIgnoreCase(name)){
                b = a;
                break;
            }
        }

        if (b != null){
            b.subtractScrip(add);
        }

        else{
            System.out.println("Something went wrong.");
        }
    }

    public void check(String name){
        for (Alumni a : members){
            if (a.getUsername().equalsIgnoreCase(name)){
                a.print();
                break;
            }
        }
    }

    public void addUser(String name, String rank){
        members.add(new Alumni(name,rank,0));
        System.out.println(name + " successfully added.");
    }

    public void removeUser(String name){
        for (Alumni a : members){
            if (a.getUsername().equalsIgnoreCase(name)) {
                members.remove(a);
                System.out.println("User successfully removed");
                break;
            }
        }
    }

    public void updateDatabase() throws IOException {
        try {
            FileWriter file = new FileWriter("database.txt");
            new PrintWriter(file);
            for (Alumni a : members) {
                file.write(a.getUsername());
                file.write("\r\n");
                file.write(a.getRank());
                file.write("\r\n");
                file.write(Integer.toString(a.getScripCount()));
                file.write("\r\n");
            }
            file.close();
        }
        catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
     }
    }



}
