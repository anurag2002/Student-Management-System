package Mess;

import java.util.*;
import java.sql.*;

public class addStudent 
{
    static Scanner sc = new Scanner(System.in);
    addStudent(Statement stmt) throws SQLException
    {
        System.out.print("Enter the URN of Student: ");
        String URN = sc.next();
        System.out.print("Enter the No of days the student ate in the month: ");
        int days = sc.nextInt();
        System.out.print("Enter the Dues: ");
        int dues = sc.nextInt();

        boolean flag = true;
        String query = "SELECT URN FROM Mess_Details WHERE URN = \"" + URN + "\"";
        ResultSet rs = stmt.executeQuery(query);

        while(rs.next())
        {
            flag = false;
        }

        if(flag)
        {
            query = "INSERT INTO Mess_Details VALUES ((SELECT URN FROM Student_Details WHERE URN = \"" + URN + "\")," + days + ", " + dues + ")";
            stmt.execute(query);
        }
        else
        {
            System.out.println("###########################################################");
            System.out.println("\nSTUDENT ALREADY IN THE DATABASE\n");
            System.out.println("###########################################################");
            System.out.println();
        }
    }
}
