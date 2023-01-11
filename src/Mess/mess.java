package Mess;

import java.util.*;
import java.sql.*;

public class mess 
{
    static Scanner sc = new Scanner(System.in);
    
    public static int choice()
    {
        System.out.println("1. View Student Details");
        System.out.println("2. View All Students");
        System.out.println("3. Add Student");
        System.out.println("4. Update Student Details");
        System.out.println("5. Check Student Dues");
        System.out.println("6. Exit");
        System.out.print("\nEnter your Choice: ");
        int choice = sc.nextInt();
        
        System.out.println();
        System.out.println("###########################################################\n");

        while(choice < 1 && choice > 6)
        {
            choice = choice();
        }

        return choice;
    }
    
    public mess(Statement stmt) throws SQLException
    {
        System.out.println("###########################################################");
        System.out.println("\nWELCOME TO MESS PANEL\n");
        System.out.println("###########################################################");
        System.out.println();

        int choice = choice();


        while(choice != 6)
        {
            switch(choice)
            {
                case 1:
                    new viewStudent(stmt);
                    break;
                case 2:
                    new viewAllStudents(stmt);
                    break;
                case 3:
                    new addStudent(stmt);
                    break;
                case 4:
                    new updateStudent(stmt);
                    break;
                case 5:
                    new checkDues(stmt);
                    break;
                       
            }
            if(choice != 6)
            {
                choice = choice();
            }
            else
            {
                break;
            }
        }

        System.out.println("###########################################################");
        System.out.println("\nEXITING....\n");
        System.out.println("###########################################################");
    }
}
