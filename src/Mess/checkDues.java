package Mess;

import java.util.*;
import java.sql.*;

public class checkDues 
{
    static Scanner sc = new Scanner(System.in);
    checkDues(Statement stmt) throws SQLException
    {
        System.out.print("Enter the URN of Student: ");
        String URN = sc.next();
        System.out.println();
        System.out.println("###########################################################");

        String query = "SELECT Dues FROM Student_Details WHERE URN = (\"" + URN + "\")";
        ResultSet rs = stmt.executeQuery(query);

        System.out.println();
        boolean flag = true;
        while(rs.next())
        {
            flag = false;
            System.out.println("The Dues of student with URN: " + URN + " is " + rs.getInt("Dues"));
        }
        if(flag)
        {
            System.out.println("Student Not Found");
        }
    }
}
