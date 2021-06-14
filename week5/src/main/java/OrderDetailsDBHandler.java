import java.sql.*;


public class OrderDetailsDBHandler {
    private static Connection connection;
    static String url = "jdbc:mysql://localhost:3306/TemptingMorsels?useSSL=false";
    static String username = "root";
    static String password = "";


    public void addDetails(int orderId, int dessertId, int dessertQuantity, double price,
                    int drinkId, int drinkQuantity, double drinkPrice, double total){
        connect();
        PreparedStatement preparedStatement = null;
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
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void getDetails(){
        connect();
        PreparedStatement preparedStatement = null;
        String query = "SELECT * FROM OrderDetails";
        try {
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

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
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateDetails(int orderDetailId, int orderId, int dessertId, int dessertQuantity, double price,
                              int drinkId, int drinkQuantity, double drinkPrice, double total){
        connect();
        String query = "UPDATE OrderDetails SET order_id = ?, dessert_id = ?, dessert_quantity = ?, " +
                "dessert_price = ?, drink_id = ?, drink_quantity = ?, drink_price = ?, total = ? WHERE orderDetailId = ?";
        PreparedStatement preparedStatement = null;
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
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteDetails(int orderDetailId){
        Connection connection = connect();
        PreparedStatement preparedStatement = null;
        String query = "DELETE FROM OrderDetails WHERE orderDetailId = " + orderDetailId;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    private static Connection connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    private static void log(String string) {
        System.out.println(string);
    }
}

