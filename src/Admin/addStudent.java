package Admin;

import java.util.*;
import java.sql.*;

public class addStudent 
{
    static Scanner sc = new Scanner(System.in);
    addStudent(Statement stmt) throws SQLException
    {

        System.out.println();
        System.out.println("Enter your Details Here: ");
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("URN: ");
        String URN = sc.next();
        System.out.print("Branch: ");
        String branch = sc.next();

        insertStudent(stmt, name, URN, branch);

        sc.close();
    }

    void insertStudent(Statement stmt, String name, String URN, String Branch) throws SQLException
    {
        String query = "SELECT URN FROM Student_Details";
        ResultSet rs = stmt.executeQuery(query);
        
        boolean flag = true;
        while(rs.next())
        {
            if(rs.getString(1).equals(URN))
            {
                flag = false;
            }
        }

        if(flag)
        {
            query = "INSERT INTO Student_Details (\"" + name + "\",\"" + URN + "\",\"" + Branch + "\")";
            stmt.execute(query);
            query = "INSERT INTO users_list (\"" + URN + "\",\"" + URN + "\",\"" + 5 + "\")";
            stmt.execute(query);
        }
        else
        {
            System.out.println("###########################################################");
            System.out.println("ALREADY IN THE DATABASE");
            System.out.println("###########################################################");
        }
    }

}
