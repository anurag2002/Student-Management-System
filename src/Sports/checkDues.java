package Sports;

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

        String query = "SELECT Dues FROM Equipment_Issue_List WHERE URN = \"" + URN + "\"";
        ResultSet rs = stmt.executeQuery(query);

        int dues = 0;
        while(rs.next())
        {
            dues = dues + rs.getInt("Dues");
        }

        System.out.println("The Total Dues of Student with URN " + URN + " is " + dues);
    }
}
