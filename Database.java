import java.util.*;
import java.sql.*;
class Database{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String cod ,nam,ct,ag;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/invariants","root","harsh@123");
            System.out.println("Connection Stablished Succesfully");
            Statement s = con.createStatement();
            ResultSet rs;
            int ch,op,cnt;
            String ss;
            do
            {
                System.out.println(" MAIN - MENU\n");
                System.out.println("1 . New Record");
                System.out.println("2 . Edit Employee Record");
                System.out.println("3 . Display All Record");
                System.out.println("4 . Display search Record");
                System.out.println("5 . Delete Specified Record");
                System.out.println("6 . Create New Table");
                System.out.println("7 .  Append data from one table to another");
                System.out.println("8 .  Delete table");
                System.out.println("9 . Exit table\n");
                System.out.print("Enter Operation (1-9) = " );
                op=sc.nextInt();
                sc.nextLine();
                switch (op) {
                    case 1 :
                           System.out.println("Enter Employee code ");
                           cod=sc.nextLine();
                           System.out.println("Enter Employee Name");
                           nam=sc.nextLine();
                           System.out.println("Enter city name ");
                           ct=sc.nextLine();
                           System.out.println("Enter Employee age ");
                           ag =sc.nextLine();
                           ss= "insert into staff values ('"+cod+"','"+nam+"','"+ct+"','"+ag+"')";
                           s.executeUpdate(ss);
                           break;
                    case 2: 
                            System.out.println("Enter Employee code for modify = ");
                            cod=sc.nextLine();
                            cnt= 0;
                            rs = s.executeQuery("select * from staff where code = '"+cod+"'");
                            while(rs.next())
                           {
                                  System.out.printf("%-5s\t%-15s\t%-15s\t%s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                                  cnt++;
                           }
                           if(cnt == 0)
                           System.out.println(cod +" employee code not available in table");
                           else
                             {
                                 System.out.print("Enter  New Employee Name ");
                                 nam=sc.nextLine();
                                 s.executeUpdate("Update staff set name = '"+nam+"' where code = '"+cod+"'");
                             }
                                break;
                   case 3:
                           rs = s.executeQuery("Select * from staff");
                           while(rs.next()) // takes one record at a time 
                          {
                              //System.out.println(rs.getString(1)+" "+ rs.getString(2)+ "  "+ rs.getString(3) + " "+ rs.getString(4));
                               // System.out.println(rs.getInt(1)+" "+ rs.getString(2)+ "  "+ rs.getString(3) + " "+ rs.getInt(4));
                                System.out.printf("%-5s\t%-15s\t%-15s\t%s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
    
                          }
                            break;
                    case 4: 
                            System.out.println("Enter Employee code for Search= ");
                            cod=sc.nextLine();
                            cnt= 0;
                            rs = s.executeQuery("select * from staff where code = '"+cod+"'");
                            while(rs.next())
                           {
                                  System.out.printf("%-5s\t%-15s\t%-15s\t%s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                                  cnt++;
                           }
                           if(cnt == 0)
                           System.out.println(cod +" employee code not available in table");
                            break;
                    case 5: 
                            System.out.println("Enter Employee code for delete = ");
                            cod=sc.nextLine();
                            cnt= 0;
                            rs = s.executeQuery("select * from staff where code = '"+cod+"'");
                            while(rs.next())
                           {
                                  System.out.printf("%-5s\t%-15s\t%-15s\t%s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                                  cnt++;
                           }
                           if(cnt == 0)
                           System.out.println(cod +" Employee code not available in table");
                          else
                             {
                                 s.executeUpdate("Delete from staff where code = '"+cod+"'");
                             }
                                break;  
                    case 6 :
                        ss = "create table if not exists staffback(code varchar(4),name varchar(20),city varchar(20),age int(3));" ;
                         s.executeUpdate(ss);
                        System.out.println("Table created successfully");
                         break;
                   case 7:
                        System.out.println("Enter city name for backup ");
                        ct=sc.nextLine();
                        cnt = 0;
                        rs = s.executeQuery("Select * from staff where city = '"+ct+"'");
                        while(rs.next())
                        {
                            cnt ++;
                        }
                        if(cnt ==0)
                            System.out.println("record not found ");
                        else
                        {
                           ss=  "insert into staffback select code ,name,city,age from staff where city = '"+ct+"'";
                           s.executeUpdate(ss);
                        }
                        break;
                        case 8 :
                            s.executeUpdate("drop table staffback ");
                            System.out.print("Backup file Deleted");
                            break;
                       case 9 :
                         System.out.print("no operation \n");
                         break;     
                                     

                 default :
                              System.out.print("Invalid operation");
                              break;
        
                }
                        System.out.print("Repeat loop 1-yes = ");
                        ch=sc.nextInt();
            }

              while (ch==1);  
        }
        catch(Exception e)
        {
            System.out.print("Connection Failed");
        }
    }
}