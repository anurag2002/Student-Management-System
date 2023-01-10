package Sports;

import java.util.*;
import java.sql.*;

public class addEquipment 
{
    static Scanner sc = new Scanner(System.in);
    addEquipment(Statement stmt) throws SQLException
    {
        System.out.println();
        System.out.println("Enter the Equipment Details Here: ");
        System.out.print("Equipment ID: ");
        String EquipmentID = sc.next();
        System.out.print("Equipment Name: ");
        String name = sc.next();
        System.out.print("Count: ");
        int count = sc.nextInt();

        insertEquipment(stmt, EquipmentID, name, count);
    }

    void insertEquipment(Statement stmt, String EquipmentID, String name, int count) throws SQLException
    {
        String query = "SELECT Equipment_ID FROM Sports_Equipment_Details";
        ResultSet rs = stmt.executeQuery(query);
        
        boolean flag = true;
        while(rs.next())
        {
            if(rs.getString(1).equals(EquipmentID))
            {
                flag = false;
            }
        }

        if(flag)
        {
            query = "INSERT INTO Sports_Equipment_Details (\"" + EquipmentID + "\",\"" + name + "\"," + count + ")";
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
