import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JavaJDBC {
    private static List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
    public static void main(String[] args) {

        //String query = "INSERT INTO employee_payroll (name,salary,start ) VALUES ('Ram',50000.00,'22-05-25')";
        //String query1="UPDATE employee_payroll set gender ='M' where name = 'Ram'";
        String query2="select * from employee_payroll";
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver class loaded and registered");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service? user=root & password=root");
            System.out.println("Connection established with db server");
            statement = connection.createStatement();
            System.out.println("platform created/statement object created");
          //  statement.executeUpdate(query2);
            System.out.println("Data inserted to DB");
            System.out.println("Data selected from DB");
            ResultSet resultset=statement.executeQuery(query2);
            while(resultset.next()){
                int id=resultset.getInt("id");
                String name=resultset.getString("name");
                double salary=resultset.getDouble("salary");
                employeePayrollList.add(new EmployeePayrollData(id,name,salary));
            }
            System.out.println(employeePayrollList);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
