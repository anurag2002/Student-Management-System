package Library;

import java.util.*;
import java.sql.*;
import java.sql.Date;

public class issueBook 
{
    static Scanner sc = new Scanner(System.in);
    issueBook(Statement stmt) throws SQLException
    {
        System.out.println();
        System.out.print("Enter the URN of Student: ");
        String URN = sc.next();
        System.out.print("Enter the Book_ID");
        String bookID = sc.next();
        long millis = System.currentTimeMillis();
        Date issueDate = new Date(millis);
        System.out.println();

        String query = "INSERT INTO Book_Issue_List VALUES ((SELECT Book_ID FROM Books_Details WHERE Book_ID = \"" + bookID + "\"),(SELECT URN FROM Student_Details WHERE URN = \"" + URN + "\"),\"" + issueDate + "\"," + null + "," + 0 + ")";
        stmt.execute(query);

        query = "UPDATE Book_Details SET Count = (SELECT (Count-1) FROM Books_Details WHERE Book_ID = \"" + bookID + "\") WHERE Book_ID = \"" + bookID + "\"";
        stmt.execute(query);
    }
    
}
