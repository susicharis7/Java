package DatabaseConnectivity;
import java.sql.*;

class OOP {
    private static final String CONNECTION_STRING = "jdbe:mysql:oop.ibu.edu.ba:3306/oopgroup2";
    private static final String USERNAME = "oopuser";
    private static final String PASSWORD = "ooppassWD";

    Connection connection = null;

    public OOP() {
        try {
            connection = DriverManager.getConnection(
                    CONNECTION_STRING,
                    USERNAME,
                    PASSWORD
            );
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getAnimals(String name, int id) throws SQLException {
        String query = "SELECT * FROM animals WHERE name = ? AND id > ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,name);
        statement.setInt(2,id);

        ResultSet rs = statement.executeQuery();
        while(rs.next()) {
            String animalName = rs.getString("name");
            int animalId = rs.getInt("id");
            String animalType = rs.getString("type");
        }
    }
}

class Main01 {
    public static void main(String[] args) {
        try {

            OOP oopDatabase = new OOP();

            oopDatabase.getAnimals("Lion", 10);

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Runtime error: " + e.getMessage());
        }
    }
}