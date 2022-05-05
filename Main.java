import java.lang.reflect.Array;
import java.util.*;
import java.util.Scanner;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        File dataBase = new File("database.txt");
        Scanner data = new Scanner (dataBase);
        boolean monthAdd = false;

        ScripSystem scrip = new ScripSystem();


        // USE FROM EXISTING DATABASE
        while (data.hasNextLine()) {
            String name = "";
            String rank = "";
            int scripCount = 0;
            name = data.nextLine();
            rank = data.nextLine();
            scripCount = Integer.parseInt(data.nextLine());
            scrip.addNew(new Alumni(name, rank, scripCount));
        }
        data.close();

        System.out.println("Type anything to continue.");

        while (scanner.hasNextLine()){
            String action = scanner.nextLine();

           if (action.equalsIgnoreCase("addmonth")){
               if (!monthAdd) {
                   scrip.addMonth();
                   monthAdd = true;
               }
               else if (monthAdd){
                   System.out.println("You have already done the monthly payment!");
               }
           }

           else if (action.equalsIgnoreCase("ADD")){
               System.out.println("Enter the exact username of person to add scrip to");
               System.out.print(">");
               String name = scanner.nextLine();


               System.out.print("\nEnter the amount to add: ");
               int add = Integer.parseInt(scanner.nextLine());
               scrip.addPerson(name,add);
           }

           else if (action.equalsIgnoreCase("deduct")){
               System.out.println("Enter the exact username of person to remove scrip from ");
               System.out.print(">");
               String name = scanner.nextLine();


               System.out.print("\nEnter the amount to remove: ");
               int add = Integer.parseInt(scanner.nextLine());
               scrip.subtractPerson(name,add);
           }

           else if (action.equalsIgnoreCase("check")){
               System.out.println("Enter the exact username of person to check");
               System.out.print(">");
               String name = scanner.nextLine();

               scrip.check(name);
           }

           else if (action.equalsIgnoreCase("adduser")){
               System.out.println("Enter the exact username of person to add");
               System.out.print(">");
               String name = scanner.nextLine();
               System.out.println("Enter their rank");
               System.out.print(">");
               String rank = scanner.nextLine();
               scrip.addUser(name,rank);
           }

           else if (action.equalsIgnoreCase("remuser")){
               System.out.println("Enter the exact username of person to remove");
               System.out.print(">");
               String name = scanner.nextLine();
               scrip.removeUser(name);
           }

           else if (action.equalsIgnoreCase("purchase")){
             // System.out.println("Enter the exact username of person purchasing");
             // System.out.print(">");
             // String name = scanner.nextLine();
             // System.out.println("Enter product name of person purchasing");
             // System.out.print(">");
             // String product = scanner.nextLine();
             // System.out.println("Enter product price ");
             // System.out.print(">");
             // int price = Integer.parseInt(scanner.nextLine());
             System.out.println("Function unimplemented yet. Use deduct feature.");
           }

           else if (action.equalsIgnoreCase("exit")){
               scrip.updateDatabase();
               System.exit(1);
           }

            System.out.println("What do you want to do?");
            System.out.println("Add new user - ADDUSER");
            System.out.println("Remove user - REMUSER");
            System.out.println("Add monthly payment - ADDMONTH");
            System.out.println("Add individual payment - ADD");
            System.out.println("Add purchase - PURCHASE");
            System.out.println("Deduct funds - DEDUCT");
            System.out.println("Check individual funds - CHECK");
            System.out.println("FINISH CHANGES - EXIT");
            System.out.print(">");

        }

    }

}
