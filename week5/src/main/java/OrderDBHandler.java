import java.sql.*;


public class OrderDBHandler {
    private static Connection connection;
    private static ResultSet resultSet;
    static String url = "jdbc:mysql://localhost:3306/TemptingMorsels?useSSL=false";
    static String username = "root";
    static String password = "";


    public void addOrder(int customerId, String orderDate, boolean payed){
        connect();
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO Orders(customer_id, order_date, payed) VALUES(?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, customerId);
            preparedStatement.setString(2, orderDate);
            preparedStatement.setBoolean(3, payed);
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

    public ResultSet getOrders(){
        connect();
        PreparedStatement preparedStatement = null;
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
        } finally {
            try {
                if(resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultSet;
    }

    public void updateOrder(int orderId, int customerId, String orderDate, boolean payed){
        connect();
        PreparedStatement preparedStatement = null;
        String query = "UPDATE Orders SET customer_id = ?, order_date = ?, payed = ? WHERE order_id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, customerId);
            preparedStatement.setString(2, orderDate);
            preparedStatement.setBoolean(3, payed);
            preparedStatement.setInt(4, orderId);
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

    public void deleteOrder(int orderId){
        Connection connection = connect();
        PreparedStatement preparedStatement = null;
        String query = "DELETE FROM Orders WHERE order_id = " + orderId;
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

