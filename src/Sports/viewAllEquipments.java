package Sports;

import java.util.*;
import java.sql.*;

public class viewAllEquipments 
{
    static Scanner sc = new Scanner(System.in);
    viewAllEquipments(Statement stmt) throws SQLException
    {
        System.out.println("###########################################################");

        String query = "SELECT * FROM Equipments_Details";
        ResultSet rs = stmt.executeQuery(query);

        System.out.println();
        boolean flag = true;
        while(rs.next())
        {
            System.out.println("Equipment ID: " + rs.getString("Equipment_ID"));
            System.out.println("Name of Equipment: " + rs.getString("Equipment_Name"));
            System.out.println("Equipments Count: " + rs.getInt("Count"));
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
