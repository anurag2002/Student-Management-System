package Sports;

import java.util.*;
import java.sql.*;

public class viewEquipmentDetail 
{
    static Scanner sc = new Scanner(System.in);
    viewEquipmentDetail(Statement stmt) throws SQLException
    {
        System.out.print("Enter the Equipment_ID: ");
        String EquipmentID = sc.next();

        String query = "SELECT * FROM Equipments_Details WHERE Equipment_ID = \"" + EquipmentID + "\"";
        ResultSet rs = stmt.executeQuery(query);

        System.out.println();
        boolean flag = true;
        while(rs.next())
        {
            System.out.println("Equipment ID: " + rs.getString("Equipment_ID"));
            System.out.println("Name of Equipment: " + rs.getString("Equipment_Name"));
            System.out.println("Equipments Count: " + rs.getInt("Count"));
            System.out.println();
            flag = false;
        }
        if(flag)
        {
            System.out.println("Equipment Not Found");
        }
    }
}
