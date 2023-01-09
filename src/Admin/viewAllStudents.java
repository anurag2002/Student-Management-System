package Admin;

import java.util.*;
import java.sql.*;

public class viewAllStudents 
{
    static Scanner sc = new Scanner(System.in);
    viewAllStudents(Statement stmt) throws SQLException
    {
        System.out.println("###########################################################");

        String query = "SELECT * FROM Student_Details";
        ResultSet rs = stmt.executeQuery(query);

        System.out.println();
        boolean flag = true;
        while(rs.next())
        {
            System.out.println("Name of Student: " + rs.getString("Name"));
            System.out.println("URN of Student: " + rs.getString("URN"));
            System.out.println("Branch of Student: " + rs.getString("Branch"));
            System.out.println();
            System.out.println("###########################################################\n");
            flag = false;
        }
        if(flag)
        {
            System.out.println("Student Database Empty");
        }
    }    
}
