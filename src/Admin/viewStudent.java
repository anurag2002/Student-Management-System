package Admin;

import java.util.*;
import java.sql.*;

public class viewStudent 
{
    static Scanner sc = new Scanner(System.in);
    viewStudent(Statement stmt) throws SQLException
    {
        System.out.print("Enter the URN of Student: ");
        String URN = sc.next();
        viewStudentDetails(stmt, URN);
    }

    viewStudent(Statement stmt, String URN) throws SQLException
    {
        viewStudentDetails(stmt, URN);
    }
    
    public void viewStudentDetails(Statement stmt, String URN) throws SQLException
    {
        System.out.println();
        System.out.println("###########################################################");

        String query = "SELECT * FROM Student_Details WHERE URN = (\"" + URN + "\")";
        ResultSet rs = stmt.executeQuery(query);

        System.out.println();
        boolean flag = true;
        while(rs.next())
        {
            System.out.println("Name of Student: " + rs.getString("Name"));
            System.out.println("URN of Student: " + rs.getString("URN"));
            System.out.println("Branch of Student: " + rs.getString("Branch"));
            flag = false;
        }
        if(flag)
        {
            System.out.println("Student Not Found");
        }
    }


}
