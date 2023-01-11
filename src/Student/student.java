package Student;

import java.util.*;
import java.sql.*;

public class student 
{
    static Scanner sc = new Scanner(System.in);

    public static int choice()
    {
        System.out.println("1. View Student Details");
        System.out.println("2. Update Student Details");
        System.out.println("3. Pay Dues");
        System.out.println("4. Exit");
        System.out.print("\nEnter your Choice: ");
        int choice = sc.nextInt();
        
        System.out.println();
        System.out.println("###########################################################\n");

        while(choice < 1 && choice > 4)
        {
            choice = choice();
        }

        return choice;
    }

    public student(Statement stmt, String uid) throws SQLException
    {
        System.out.println("###########################################################");
        System.out.println("\nWELCOME TO STUDENT PANEL\n");
        System.out.println("###########################################################");
        System.out.println();

        int choice = choice();


        while(choice != 4)
        {
            switch(choice)
            {
                case 1:
                    new viewStudent(stmt, uid);
                    break;
                case 2:
                    new updateStudent(stmt, uid);
                    break;
                case 3:
                    new payDues(stmt, uid);
                    break;
                case 4:
                    break;       
            }
            if(choice != 4)
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
