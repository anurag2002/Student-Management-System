package Sports;

import java.util.*;
import java.sql.*;
import java.sql.Date;

public class issueEquipment 
{
    static Scanner sc = new Scanner(System.in);
    issueEquipment(Statement stmt) throws SQLException
    {
        System.out.println();
        System.out.print("Enter the URN of Student: ");
        String URN = sc.next();
        System.out.print("Enter the Equipment_ID");
        String EquipmentID = sc.next();
        long millis = System.currentTimeMillis();
        Date issueDate = new Date(millis);
        System.out.println();

        String query = "INSERT INTO Equipment_Issue_List VALUES ((SELECT Equipment_ID FROM Sports_Equipments_Details WHERE Equipment_ID = \"" + EquipmentID + "\"),(SELECT URN FROM Student_Details WHERE URN = \"" + URN + "\"),\"" + issueDate + "\"," + null + "," + 0 + ")";
        stmt.execute(query);


    }
    
}
