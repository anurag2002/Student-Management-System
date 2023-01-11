package Mess;

import java.util.*;
import java.sql.*;

public class updateStudent 
{
    static Scanner sc = new Scanner(System.in);
    updateStudent(Statement stmt) throws SQLException
    {
        System.out.print("Enter the URN of Student: ");
        String URN = sc.next();
        System.out.println();
        System.out.println("###########################################################");

        String query = "SELECT * FROM Mess_Details WHERE URN = (\"" + URN + "\")";
        ResultSet rs = stmt.executeQuery(query);

        System.out.println();
        boolean flag = true;
        while(rs.next())
        {
            flag = false;
            System.out.println("1. URN");
            System.out.println("2. No of Days");
            System.out.println("3. Dues");
            System.out.print("Enter the column index to update: ");
            int col_ind = sc.nextInt();

            String col_name = "", col_update;

            System.out.print("Enter the updated value: ");
            col_update = sc.next();
            switch(col_ind)
            {
                case 1:
                    col_name = "URN";
                    break;
                case 2:
                    col_name = "No_of_days";
                    break;
                case 3:
                    col_name = "Dues";
                    break;
            }
            query = "UPDATE Mess_Details SET " + col_name + " = \"" + col_update + "\" WHERE URN = \"" + URN + "\"";
            stmt.execute(query);

            System.out.println("###########################################################");
            System.out.println("\nStudent Details Updated\n");
            System.out.println("###########################################################");
        }
        if(flag)
        {
            System.out.println("Student Not Found");
        }
    }
}
