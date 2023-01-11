package Student;

import java.util.*;
import java.sql.*;

public class payDues 
{
    static Scanner sc = new Scanner(System.in);
    static void libDues(Statement stmt, String URN) throws SQLException
    {
        System.out.print("Pay Dues [Y/N]: ");
        String choice = sc.next();
        if(choice.equals("Y") || choice.equals("y"))
        {
            String query = "UPDATE Book_Issue_List SET Dues = " + 0 + " WHERE URN = \"" + URN + "\"";
            stmt.execute(query);
        }
    }

    static void sportDues(Statement stmt, String URN) throws SQLException
    {
        System.out.print("Pay Dues [Y/N]: ");
        String choice = sc.next();
        if(choice.equals("Y") || choice.equals("y"))
        {
            String query = "UPDATE Equipment_Issue_List SET Dues = " + 0 + " WHERE URN = \"" + URN + "\"";
            stmt.execute(query);
        }
    }

    static void messDues(Statement stmt, String URN) throws SQLException
    {
        System.out.print("Pay Dues [Y/N]: ");
        String choice = sc.next();
        if(choice.equals("Y") || choice.equals("y"))
        {
            String query = "UPDATE Mess_Details SET Dues = " + 0 + " WHERE URN = \"" + URN + "\"";
            stmt.execute(query);
        }
    }

    payDues(Statement stmt, String URN) throws SQLException
    {
        System.out.println("1. Pay Library Dues");
        System.out.println("2. Pay Sports Dues");
        System.out.println("3. Pay Mess Dues");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch(choice)
        {
            case 1:
                libDues(stmt, URN);
                break;
            case 2:
                sportDues(stmt, URN);
                break;
            case 3:
                messDues(stmt, URN);
                break;
            case 4:
                break;
        }
    }
}
