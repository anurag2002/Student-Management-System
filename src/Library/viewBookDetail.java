package Library;

import java.util.*;
import java.sql.*;

public class viewBookDetail 
{
    static Scanner sc = new Scanner(System.in);
    viewBookDetail(Statement stmt) throws SQLException
    {
        System.out.print("Enter the Book_ID: ");
        String bookID = sc.next();

        String query = "SELECT * FROM Books_Details WHERE Book_ID = \"" + bookID + "\"";
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
            flag = false;
        }
        if(flag)
        {
            System.out.println("Book Not Found");
        }
    }
}
