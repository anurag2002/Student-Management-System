package Library;

import java.util.*;
import java.sql.*;

public class viewIssuedBooks 
{
    static Scanner sc = new Scanner(System.in);
    viewIssuedBooks(Statement stmt) throws SQLException
    {
        System.out.println("###########################################################");

        String query1 = "SELECT * FROM Book_Issue_List";
        ResultSet rs1 = stmt.executeQuery(query1);

        System.out.println();
        boolean flag = true;
        while(rs1.next())
        {
            System.out.println("Book ID: " + rs1.getString("Book_ID"));
            System.out.println("URN of Issuer: " + rs1.getString("URN"));
            System.out.println("Date of Issue: " + rs1.getDate("Date_of_Issue"));
            System.out.println("Date of Return: " + rs1.getDate("Date_of_Return"));
            System.out.println("Dues: " + rs1.getInt("Count"));
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
