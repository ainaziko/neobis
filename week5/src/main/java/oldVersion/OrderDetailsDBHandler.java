package oldVersion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailsDBHandler {
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    private static String url = "jdbc:mysql://localhost:3306/TemptingMorsels?useSSL=false";
    private static String username = "root";
    private static String password = "";

    public void addOrderDetails(int orderId, int dessertId, int dessertQuantity, double price,
                                int drinkId, int drinkQuantity, double drinkPrice, double total){
        String query = "INSERT INTO OrderDetails(order_id, dessert_id, dessert_quantity, dessert_price, drink_id, drink_quantity, drink_price, total) VALUES(?,?,?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,orderId);
            preparedStatement.setInt(2, dessertId);
            preparedStatement.setInt(3, dessertQuantity);
            preparedStatement.setDouble(4, price);
            preparedStatement.setInt(5, drinkId);
            preparedStatement.setInt(6, drinkQuantity);
            preparedStatement.setDouble(7, drinkPrice);
            preparedStatement.setDouble(8, total);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateOrderDetails(int orderDetailId, int orderId, int dessertId, int dessertQuantity, double price,
                                   int drinkId, int drinkQuantity, double drinkPrice, double total){
        String query = "UPDATE OrderDetails SET order_id = ?, dessert_id = ?, dessert_quantity = ?, " +
                "dessert_price = ?, drink_id = ?, drink_quantity = ?, drink_price = ?, total = ? WHERE orderDetailId = ?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,orderId);
            preparedStatement.setInt(2, dessertId);
            preparedStatement.setInt(3, dessertQuantity);
            preparedStatement.setDouble(4, price);
            preparedStatement.setInt(5, drinkId);
            preparedStatement.setInt(6, drinkQuantity);
            preparedStatement.setDouble(7, drinkPrice);
            preparedStatement.setDouble(8, total);
            preparedStatement.setInt(9, orderDetailId);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteOrderDetails(int orderDetailId){
        String query = "DELETE FROM OrderDetails WHERE orderDetailId = " + orderDetailId;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ResultSet getOrderDetails(){
        String query = "SELECT * FROM OrderDetails";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int orderDetailId = resultSet.getInt("orderDetailId");
                int order_id = resultSet.getInt("order_id");
                int dessert_id = resultSet.getInt("dessert_id");
                int dessert_quantity = resultSet.getInt("dessert_quantity");
                double dessert_price = resultSet.getDouble("dessert_price");
                int drink_id = resultSet.getInt("drink_id");
                int drink_quantity = resultSet.getInt("drink_quantity");
                double drink_price = resultSet.getDouble("drink_price");
                double total = resultSet.getDouble("total");
                System.out.println(orderDetailId + ", " + order_id + ", " + dessert_id + ", " + dessert_quantity + ", " + dessert_price + ", " + drink_id
                + ", " + drink_quantity + ", " + drink_price + ", " + total);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
}
