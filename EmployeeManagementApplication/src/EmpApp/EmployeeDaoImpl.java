package EmpApp;

import java.sql.*;

public class EmployeeDaoImpl implements EmployeeDaoIntrf {
    Connection con;

    @Override
    public void createEmployee(Employee emp) {

        try {
            con = DBConnection.createDBConnection();
            String query = "insert into employee values(?,?,?,?)";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, emp.getId());
            pstm.setString(2, emp.getName());
            pstm.setDouble(3, emp.getSalary());
            pstm.setInt(4, emp.getAge());
            int cnt = pstm.executeUpdate();
            if (cnt != 0)
                System.out.println("Employee Inserted Successfully !!!");

            pstm.close();
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void showAllEmployee() {
        try {
            con = DBConnection.createDBConnection();
            String query = "select * from employee";
            System.out.println("Employee Details :");
            System.out.println("---------------------------------------------");

            System.out.format("%s\t%s\t%s\t\t%s\n", "ID", "Name", "Salary", "age");
            System.out.println("---------------------------------------------");
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
                System.out.println("---------------------------------------------");

            }

            result.close();
            stmt.close();
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void showEmployeeBasedOnID(int id) {

        try {
            con = DBConnection.createDBConnection();
            String query = "select * from employee where id=" + id;
            System.out.println("Employee Details :");
            System.out.println("---------------------------------------------");

            System.out.format("%s\t%s\t%s\t\t%s\n", "ID", "Name", "Salary", "age");
            System.out.println("---------------------------------------------");
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
                System.out.println("---------------------------------------------");
            }

            result.close();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void updateEmployee(int id, String name) {

        try {
            con = DBConnection.createDBConnection();
            String query = "update employee set name=? where id=?";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, name);
            pstm.setInt(2, id);
            int cnt = pstm.executeUpdate();
            if (cnt != 0)
                System.out.println("Employee Details updated successfully !!");

            pstm.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void deleteEmployee(int id) {

        try {
            con = DBConnection.createDBConnection();
            String query = "delete from employee where id=?";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            int cnt = pstm.executeUpdate();
            if (cnt != 0)
                System.out.println("Employee Deleted Successfully!!! " + id);

            pstm.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
