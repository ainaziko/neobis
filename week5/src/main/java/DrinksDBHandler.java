import java.sql.*;

public class DrinksDBHandler {
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;
    private static String url = "jdbc:mysql://localhost:3306/TemptingMorsels?useSSL=false";
    private static String username = "root";
    private static String password = "";

    public void addDrink(String drinkName, String drinkDescription, String imgPath, double price){
        String query = "INSERT INTO Soft_Drinks(drink_name, drink_description, imgPath, price) VALUES(?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,drinkName);
            preparedStatement.setString(2, drinkDescription);
            preparedStatement.setString(3, imgPath);
            preparedStatement.setDouble(4, price);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateDrink(int id, String drinkName, String drinkDescription, String imgPath, double price){
        String query = "UPDATE Soft_Drinks SET drink_name = ?, drink_description = ?, imgPath = ?, price = ? WHERE id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, drinkName);
            preparedStatement.setString(2, drinkDescription);
            preparedStatement.setString(3, imgPath);
            preparedStatement.setDouble(4, price);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteDrink(int id){
        String query = "DELETE FROM Soft_Drinks WHERE id = " + id;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ResultSet getDrinks(){
        String query = "SELECT * FROM Soft_Drinks";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String drinkName = resultSet.getString("drink_name");
                String drinkDescription = resultSet.getString("drink_description");
                String imgPath = resultSet.getString("imgPath");
                double price = resultSet.getDouble("price");
                System.out.format("%s, %s, %s, %b\n", drinkName, drinkDescription, imgPath, price);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    private static void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}