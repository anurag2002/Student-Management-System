package Mess;

import java.util.*;
import java.sql.*;

public class viewAllStudents 
{
    static Scanner sc = new Scanner(System.in);
    viewAllStudents(Statement stmt) throws SQLException
    {
        boolean flag = true;
        String query = "SELECT * FROM Mess_Details";
        ResultSet rs = stmt.executeQuery(query);

        System.out.println("###########################################################");

        while(rs.next())
        {
            System.out.println("URN of Student: " + rs.getString("URN"));
            System.out.println("No of Days: " + rs.getInt("No_of_days"));
            System.out.println("Dues: " + rs.getInt("Dues"));
            System.out.println();
            System.out.println("###########################################################");
            flag = false;
        }

        if(flag)
        {
            System.out.println("###########################################################");
            System.out.println("No Student");
            System.out.println("###########################################################");
        }
    }
}
