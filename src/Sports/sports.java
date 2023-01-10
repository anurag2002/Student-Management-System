package Sports;

import java.util.*;
import java.sql.*;

public class sports 
{
    static Scanner sc = new Scanner(System.in);
    
    public static int choice()
    {
        System.out.println("1. View All Equipments Details");
        System.out.println("2. View Issued Equipments");
        System.out.println("3. View Equipment Detail");
        System.out.println("4. Add Equipment");
        System.out.println("5. Issue Equipment");
        System.out.println("6. Return Equipment");
        System.out.println("7. Check Student Dues");
        System.out.println("8. Exit");
        System.out.print("\nEnter your Choice: ");
        int choice = sc.nextInt();
        
        System.out.println();
        System.out.println("###########################################################\n");

        while(choice < 1 && choice > 8)
        {
            choice = choice();
        }

        return choice;
    }

    public sports(Statement stmt) throws SQLException
    {
        System.out.println("###########################################################");
        System.out.println("\nWELCOME TO SPORTS PANEL\n");
        System.out.println("###########################################################");
        System.out.println();

        int choice = choice();


        while(choice != 8)
        {
            switch(choice)
            {
                case 1:
                    new viewAllEquipments(stmt);
                    break;
                case 2:
                    new viewIssuedEquipments(stmt);
                    break;
                case 3:
                    new viewEquipmentDetail(stmt);
                    break;
                case 4:
                    new addEquipment(stmt);
                    break;
                case 5:
                    new issueEquipment(stmt);
                    break;
                case 6:
                    new returnEquipment(stmt);
                    break;
                case 7:
                    new checkDues(stmt);
                    break;       
            }
            if(choice != 8)
            {
                choice = choice();
            }
            else
            {
                break;
            }
        }

        System.out.println("###########################################################");
        System.out.println("\nEXITING....\n");
        System.out.println("###########################################################");

    }
}
