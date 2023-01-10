package Library;

import java.util.*;
import java.sql.*;

public class viewAllBooks 
{
    static Scanner sc = new Scanner(System.in);
    viewAllBooks(Statement stmt) throws SQLException
    {
        System.out.println("###########################################################");

        String query = "SELECT * FROM Books_Details";
        ResultSet rs = stmt.executeQuery(query);

        System.out.println();
        boolean flag = true;
        while(rs.next())
        {
            System.out.println("Book ID: " + rs.getString("Book_ID"));
            System.out.println("Name of Book: " + rs.getString("Book_Name"));
            System.out.println("Book Author: " + rs.getString("Author"));
            System.out.println("Books Count: " + rs.getInt("Count"));
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
