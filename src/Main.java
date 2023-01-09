import java.util.*;
import java.sql.*;
import Admin.*;

public class Main
{
    static Scanner sc = new Scanner(System.in);
    static int userVerify(Statement stmt, String uid, String pass) throws SQLException
    {
        ResultSet rs = stmt.executeQuery("SELECT * FROM users_list");
        while(rs.next())
        {
            if(rs.getString(1).equals(uid))
            {
                if(!rs.getString(2).equals(pass))
                {
                    System.out.println("###########################################################");
                    System.out.println("                     PASSWORD INCORRECT                     ");
                    System.out.println("###########################################################");
                    return 0;
                }
                else
                {
                    System.out.println("\n###########################################################\n");
                    System.out.println("                    USER LOGIN SUCCESSFULL                 ");
                    System.out.println("\n###########################################################\n");
                    return rs.getInt(3);
                }
            }
        }
        System.out.println("###########################################################");
        System.out.println("                   USER NOT REGISTERED                      ");
        System.out.println("###########################################################");

        return 0;
    }
    
    static int userID(Statement stmt) throws SQLException
    {

        System.out.print("Enter your User ID: ");
        String uid = sc.next();
        System.out.print("Enter your Password: ");
        String pass = sc.next();

        int role = userVerify(stmt, uid, pass);
        
        sc.close();
        return role;
    }
    public static void main(String[] args) 
    {

        try 
        {
            String url = "jdbc:mysql://localhost/student_database";
            String user = "root";
            String password = "9810541660";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url , user, password);
            Statement stmt = conn.createStatement();    

            System.out.println("###########################################################");
            System.out.println("\nWelcome\n");
            System.out.println("###########################################################");
            System.out.println();

            int role = userID(stmt);

            while(role == 0)
            {
                role = userID(stmt);
            }

            switch(role)
            {
                case 1:
                    admin ad = new admin(stmt);
                    break;
                case 2:
                    library(stmt);
                    break;
                case 3:
                    sports(stmt);
                    break;
                case 4:
                    mess(stmt);
                    break;
                case 5:
                    student(stmt);
                    break;
            }

            sc.close();
        } 
        catch (Exception e) 
        {
            // TODO: handle exception
        }

    }
}