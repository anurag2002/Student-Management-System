package Library;

import java.util.*;
import java.sql.*;

public class addBook 
{
    static Scanner sc = new Scanner(System.in);
    addBook(Statement stmt) throws SQLException
    {
        System.out.println();
        System.out.println("Enter the Book Details Here: ");
        System.out.print("Book ID: ");
        String bookID = sc.next();
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Author: ");
        String author = sc.next();
        System.out.print("Count: ");
        int count = sc.nextInt();

        insertBook(stmt, bookID, name, author, count);
    }

    void insertBook(Statement stmt, String bookID, String name, String author, int count) throws SQLException
    {
        String query = "SELECT Book_ID FROM Book_Details";
        ResultSet rs = stmt.executeQuery(query);
        
        boolean flag = true;
        while(rs.next())
        {
            if(rs.getString(1).equals(bookID))
            {
                flag = false;
            }
        }

        if(flag)
        {
            query = "INSERT INTO Book_Details (\"" + bookID + "\",\"" + name + "\",\"" + author + "\"," + count + ")";
            stmt.execute(query);
        }
        else
        {
            System.out.println("###########################################################");
            System.out.println("ALREADY IN THE DATABASE");
            System.out.println("###########################################################");
        }
    }
}
