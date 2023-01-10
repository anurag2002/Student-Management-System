package Library;

import java.util.*;
import java.sql.*;
import java.sql.Date;

public class returnBook 
{
    static Scanner sc = new Scanner(System.in);
    returnBook(Statement stmt) throws SQLException
    {
        System.out.println();
        System.out.print("Enter the URN of Student: ");
        String URN = sc.next();
        System.out.print("Enter the Book_ID");
        String bookID = sc.next();
        long millis = System.currentTimeMillis();
        Date returnDate = new Date(millis);
        System.out.println();
        int dues = 0;

        String query = "SELECT Book_ID, URN, Date_of_Issue FROM Book_Issue_List WHERE URN = \"" + URN + "\" AND Book_ID = \"" + bookID + "\"";
        ResultSet rs = stmt.executeQuery(query);

        boolean flag = true;
        while(rs.next())
        {
            Date issueDate = rs.getDate("Date_of_Issue");

            long issueDateinMS = issueDate.getTime();
            long returnDateinMS = returnDate.getTime();

            long timeDiff = Math.abs(returnDateinMS - issueDateinMS);

            int days = (int)(timeDiff/(1000*60*60*24));

            if(days > 14)
            {
                dues = (days-14)*5;
            }
            flag = false;
            query = "UPDATE Books_Details SET Date_of_Return = \"" + returnDate + "\", Dues = \"" + dues + "\" WHERE Book_ID = \"" + bookID + "\" AND URN = \"" + URN + "\"";
            stmt.executeUpdate(query);
        }
        if(flag)
        {
            System.out.println("NOT FOUND");
        }


    }
    
}
