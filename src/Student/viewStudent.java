package Student;

import java.util.*;
import java.sql.*;

public class viewStudent 
{
    static Scanner sc = new Scanner(System.in);
    viewStudent(Statement stmt, String URN) throws SQLException
    {
        System.out.println();
        String query = "SELECT * FROM Student_Details WHERE URN = \"" + URN + "\"";
        ResultSet rs = stmt.executeQuery(query);
        
        boolean flag = true;
        while(rs.next())
        {
            flag = false;
            System.out.println("Name: " + rs.getString(1));
            System.out.println("URN: " + rs.getString(2));
            System.out.println("Branch: " + rs.getString(3));
            System.out.println();
            System.out.println("###########################################################");
        }

        if(flag)
        {
            System.out.println("###########################################################");
            System.out.println("\nSTUDENT DETAILS NOT FOUND\n");
            System.out.println("###########################################################");
            System.out.println();
        }
    }
}
