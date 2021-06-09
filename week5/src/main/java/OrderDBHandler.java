import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDBHandler {
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    private static String url = "jdbc:mysql://localhost:3306/TemptingMorsels?useSSL=false";
    private static String username = "root";
    private static String password = "";

    public void addOrder(int customerId, String orderDate, boolean payed){
        String query = "INSERT INTO Orders(customer_id, order_date, payed) VALUES(?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, customerId);
            preparedStatement.setString(2, orderDate);
            preparedStatement.setBoolean(3, payed);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateOrder(int orderId, int customerId, String orderDate, boolean payed){
        String query = "UPDATE Orders SET customer_id = ?, order_date = ?, payed = ? WHERE order_id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, customerId);
            preparedStatement.setString(2, orderDate);
            preparedStatement.setBoolean(3, payed);
            preparedStatement.setInt(4, orderId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteOrder(int orderId){
        String query = "DELETE FROM Orders WHERE order_id = " + orderId;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ResultSet getOrders(){
        String query = "SELECT * FROM Orders";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int order_id = resultSet.getInt("order_id");
                int customer_id = resultSet.getInt("customer_id");
                String order_date = resultSet.getString("order_date");
                boolean payed = resultSet.getBoolean("payed");
                System.out.println(order_id + ", " + customer_id + ", " + order_date + ", " + payed);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
}