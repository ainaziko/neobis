package oldVersion;

import java.sql.*;

public class DessertDBHandler {
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    static String url = "jdbc:mysql://localhost:3306/TemptingMorsels?useSSL=false";
    static String username = "root";
    static String password = "";

    public static void main(String[] args) throws SQLException {
        DessertDBHandler dbh = new DessertDBHandler();
        dbh.addDessert("Tiramisu", "delissimo", "path", 100);
        dbh.getAllDesserts();
        dbh.updateDessert(2, "Tiramisuu", "Delissimo", "path", 102);
        connect();
        dbh.getAllDesserts();
        dbh.deleteDessert(2);
        dbh.getAllDesserts();
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }


    public void addDessert(String dName, String dDescription, String imgPath, double price) {
        //connect();
        String query = "INSERT INTO Desserts(dessert_name, dessert_description, imgPath, price) VALUES(?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, dName);
            preparedStatement.setString(2, dDescription);
            preparedStatement.setString(3, imgPath);
            preparedStatement.setDouble(4, price);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateDessert(int id, String dName, String dDescription, String imgPath, double price) {
        //connect();
        String query = "UPDATE Desserts SET dessert_name = ?, dessert_description = ?, imgPath = ?, price = ? WHERE id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, dName);
            preparedStatement.setString(2, dDescription);
            preparedStatement.setString(3, imgPath);
            preparedStatement.setDouble(4, price);
            preparedStatement.setInt(5, id);
            int row = preparedStatement.executeUpdate();
            System.out.println(row);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteDessert(int id) {
        String query = "DELETE FROM Desserts WHERE id = " + id;
        try {
            preparedStatement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ResultSet getAllDesserts() {
        String query = "SELECT * FROM Desserts";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("dessert_name");
                String description = resultSet.getString("dessert_description");
                String imgPath = resultSet.getString("imgPath");
                String price = resultSet.getString("price");
                System.out.format("%s, %s, %s, %s\n", name, description, imgPath, price);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public static void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

