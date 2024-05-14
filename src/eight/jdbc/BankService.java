package eight.jdbc;

import java.sql.*;

public class BankService {
    private static Connection con;
    private static BankService bank = new BankService();

    public BankService() {
        try {
            con = DriverManager.getConnection("eight.jdbc:mysql://localhost:3306/mysql","pharhad", "pharhad");
            System.out.println("DB connection OK!");
        } catch (SQLException e) {
            System.out.println("Exception");
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String selectSQL = "select * from match_table";
        try (PreparedStatement ps = con.prepareStatement(selectSQL)) {
            ResultSet resultSet = ps.executeQuery();
            if (!resultSet.next()) {
                System.out.println("no data");
            }

            Match m = new Match(resultSet.getInt(1), resultSet.getBoolean(2), resultSet.getInt(3), resultSet.getInt(4));

            resultSet.close();

            System.out.println(m);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
