package Library;

import java.util.*;

import Admin.checkDues;

import java.sql.*;

public class library 
{
    static Scanner sc = new Scanner(System.in);
    public static int choice()
    {
        System.out.println("1. View All Books Details");
        System.out.println("2. View Issued Books");
        System.out.println("3. View Book Detail");
        System.out.println("4. Add Book");
        System.out.println("5. Issue Book");
        System.out.println("6. Return Book");
        System.out.println("7. Check Student Dues");
        System.out.println("8. Exit");
        System.out.print("\nEnter your Choice: ");
        int choice = sc.nextInt();
        
        System.out.println();
        System.out.println("###########################################################\n");

        while(choice < 1 && choice > 8)
        {
            choice = choice();
        }

        return choice;
    }
    public library(Statement stmt) throws SQLException
    {
        System.out.println("###########################################################");
        System.out.println("\nWELCOME TO LIBRARY PANEL\n");
        System.out.println("###########################################################");
        System.out.println();

        int choice = choice();


        while(choice != 8)
        {
            switch(choice)
            {
                case 1:
                    new viewAllBooks(stmt);
                    break;
                case 2:
                    new viewIssuedBooks(stmt);
                    break;
                case 3:
                    new viewBookDetail(stmt);
                    break;
                case 4:
                    new addBook(stmt);
                    break;
                case 5:
                    new issueBook(stmt);
                    break;
                case 6:
                    new returnBook(stmt);
                    break;
                case 7:
                    new checkDues(stmt);
                    break;       
            }
            if(choice != 8)
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
