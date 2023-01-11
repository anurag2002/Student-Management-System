package Mess;

import java.util.*;
import java.sql.*;

public class viewStudent 
{
    static Scanner sc = new Scanner(System.in);
    viewStudent(Statement stmt) throws SQLException
    {
        System.out.println();
        System.out.print("Enter Student URN: ");
        String URN = sc.next();

        String query = "SELECT * FROM Mess_Details WHERE URN = \"" + URN + "\"";
        ResultSet rs = stmt.executeQuery(query);

        boolean flag = true;
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
            System.out.println("Student Not Found");
            System.out.println("###########################################################");
        }
    }
}
