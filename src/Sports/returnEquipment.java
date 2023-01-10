package Sports;

import java.util.*;
import java.sql.*;
import java.sql.Date;

public class returnEquipment 
{
    static Scanner sc = new Scanner(System.in);
    returnEquipment(Statement stmt) throws SQLException
    {
        System.out.println();
        System.out.print("Enter the URN of Student: ");
        String URN = sc.next();
        System.out.print("Enter the Equipment_ID");
        String EquipmentID = sc.next();
        long millis = System.currentTimeMillis();
        Date returnDate = new Date(millis);
        System.out.println();
        int dues = 0;

        String query = "SELECT Equipment_ID, URN, Date_of_Issue FROM Equipment_Issue_List WHERE URN = \"" + URN + "\" AND Equipment_ID = \"" + EquipmentID + "\"";
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
            query = "UPDATE Equipment_Issue_List SET Date_of_Return = \"" + returnDate + "\", Dues = \"" + dues + "\" WHERE Equipment_ID = \"" + EquipmentID + "\" AND URN = \"" + URN + "\"";
            stmt.executeUpdate(query);
        }
        if(flag)
        {
            System.out.println("NOT FOUND");
        }


    }
    
}
