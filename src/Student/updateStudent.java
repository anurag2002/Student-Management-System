package Student;

import java.util.*;
import java.sql.*;

public class updateStudent 
{
    static Scanner sc = new Scanner(System.in);
    updateStudent(Statement stmt, String URN) throws SQLException
    {
        System.out.println();
        System.out.println("###########################################################");

        String query = "SELECT * FROM Student_Details WHERE URN = (\"" + URN + "\")";
        ResultSet rs = stmt.executeQuery(query);

        System.out.println();
        boolean flag = true;
        while(rs.next())
        {
            flag = false;
            System.out.println("1. Name");
            System.out.println("2. URN");
            System.out.println("3. Branch");
            System.out.print("Enter the column index to update: ");
            int col_ind = sc.nextInt();

            String col_name = "", col_update;

            System.out.print("Enter the updated value: ");
            col_update = sc.next();
            String tempURN = URN;
            switch(col_ind)
            {
                case 1:
                    col_name = "Name";
                    break;
                case 2:
                    col_name = "URN";
                    tempURN = col_update;
                    break;
                case 3:
                    col_name = "Branch";
                    break;
            }
            query = "UPDATE Student_Details SET " + col_name + " = \"" + col_update + "\" WHERE URN = \"" + URN + "\"";
            stmt.execute(query);

            System.out.println("###########################################################");
            System.out.println("\nStudent Details Updated\n");
            System.out.println("###########################################################");
            new viewStudent(stmt,tempURN);
        }
        if(flag)
        {
            System.out.println("Student Not Found");
        }
    }
}
