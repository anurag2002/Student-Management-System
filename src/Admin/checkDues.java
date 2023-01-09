package Admin;

import java.util.*;
import java.sql.*;

public class checkDues 
{
    static Scanner sc = new Scanner(System.in);
    public checkDues(Statement stmt) throws SQLException
    {
        int dues = 0;
        System.out.print("Enter the URN of Student: ");
        String URN = sc.next();
        String query = "SELECT Dues FROM Mess_Details WHERE URN = \"" + URN + "\"";
        ResultSet rs = stmt.executeQuery(query);
        
        while(rs.next())
        {
            dues = dues + rs.getInt(1);
        }

        query = "SELECT Dues FROM Book_Issue_List WHERE URN = \"" + URN + "\"";
        rs = stmt.executeQuery(query);
        
        while(rs.next())
        {
            dues = dues + rs.getInt(1);
        }

        query = "SELECT Dues FROM Equipment_Issue_List WHERE URN = \"" + URN + "\"";
        rs = stmt.executeQuery(query);
        
        while(rs.next())
        {
            dues = dues + rs.getInt(1);
        }
        
        System.out.println("The Net Dues of Student with URN: " + URN + " is: " + dues);
    }
}
