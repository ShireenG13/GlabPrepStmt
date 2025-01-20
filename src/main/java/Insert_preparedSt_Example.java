import java.sql.*;
public class Insert_preparedSt_Example {
   public static void main(String[] args) {
       Connection con = null;
       PreparedStatement prepStmt = null;
       ResultSet rs = null;
       String dburl = "jdbc:mysql://localhost:3306/classicmodels";
       String user = "root";
       String password = "root";
       try{

           // Prepared Statement with Insert Statement
           con = DriverManager.getConnection(dburl,user,password);
           System.out.println("Connection establsihed successfully");
           /*String sqlQuery ="INSERT INTO employees (officeCode, firstName, lastName, email, extension, reportsTo, VacationHours, employeeNumber, jobTitle ) VALUES(?,?,?,?,?,?,?,?,?)";
           prepStmt = con.prepareStatement(sqlQuery);
           prepStmt.setInt(1, 6);
           prepStmt.setString(2, "Jamil");
           prepStmt.setString(3, "fink");
           prepStmt.setString(4, "JJ@gmail.com");
           prepStmt.setString(5, "2759");
           prepStmt.setInt(6, 1143);
           prepStmt.setInt(7, 9);
           prepStmt.setInt(8,3000);
           prepStmt.setString(9, "Manager");
           int affectedRows = prepStmt.executeUpdate();
           System.out.println("Affected rows: " + affectedRows);

           /* ------ Lets pull data from the database for an inserted record ------*/
           // Query which needs parameters
          /* prepStmt = con.prepareStatement("select * from employees where employeeNumber=?");
           prepStmt.setInt(1, 0003);
           rs = prepStmt.executeQuery();
           while (rs.next()){
               System.out.println(rs.getString("firstName"));
               System.out.println(rs.getString("lastName"));
               System.out.println(rs.getString("email"));
               System.out.println(rs.getString("officeCode"));

           } */
           //Prepared Statement for Update Statements
           String sql = "update employees set firstName=?, lastName=? where employeeNumber=?";
           prepStmt = con.prepareStatement(sql);
           prepStmt.setString(1, "Gary");
           prepStmt.setString(2, "Larson");
           prepStmt.setLong(3,0003);
           int rowsAffected = prepStmt.executeUpdate();

           //Select Statement with Prepared Statement to pull the updated record
           prepStmt = con.prepareStatement("select * from employees where employeeNumber = ?");
           prepStmt.setInt(1, 0003);
           rs = prepStmt.executeQuery();
           while(rs.next()){
               System.out.println(rs.getString("firstName"));
               System.out.println(rs.getString("lastName"));
               System.out.println(rs.getString("email"));
               System.out.println(rs.getString("officeCode"));
           }



       }catch(SQLException e){
           e.printStackTrace();
       }
       try{
           prepStmt.close();
           con.close();
       }catch(SQLException e){
           e.printStackTrace();
       }
   }
}
