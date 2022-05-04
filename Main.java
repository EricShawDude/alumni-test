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
            System.out.println(name);
            rank = data.nextLine();
            System.out.println(rank);
            scripCount = Integer.parseInt(data.nextLine());
            System.out.println(scripCount);
            scrip.addNew(new Alumni(name, rank, scripCount));
        }
        data.close();

        System.out.println("Type anything to continue.");

        while (scanner.hasNextLine()){


            String action = scanner.nextLine();

           if (action.equalsIgnoreCase("addmonth")){
               if (!monthAdd) {
                   scrip.addMonth();
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

           else if (action.equalsIgnoreCase("exit")){
               scrip.updateDatabase();
               System.exit(1);
           }

            System.out.println("What do you want to do?");
            System.out.println("Add monthly payment - ADDMONTH");
            System.out.println("Add individual payment - ADD");
            System.out.println("Deduct funds - DEDUCT");
            System.out.println("Check individual funds - CHECK");
            System.out.println("FINISH CHANGES - EXIT");
            System.out.print(">");

        }

    }

}
