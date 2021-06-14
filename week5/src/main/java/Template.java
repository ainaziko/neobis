import java.sql.*;

public class Template {
    private static Connection connection;
    static String url = "jdbc:mysql://localhost:3306/TemptingMorsels?useSSL=false";
    static String username = "root";
    static String password = "";

    public static void main(String[] args) {
        Template db = new Template();
        db.add("Mitsy", "Queen", "queen@gmail.com", "NY");
        db.update(7, "Jane", "Queen", "janeq@gmail.com", "Washington DC");
        db.get();
        db.delete(5);
        db.get();
    }

    public void add(String firstname, String lastname, String email, String city){
        connect();
        PreparedStatement preparedStatement = null;
        String insertQueryStatement = "INSERT  INTO  Customers(firstname, lastname, email, city)  VALUES  (?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(insertQueryStatement);
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, city);
            preparedStatement.executeUpdate();
            log(firstname + " is added successfully");
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

    public void get(){
        connect();
        PreparedStatement preparedStatement = null;
        String query = "SELECT * FROM Customers";
        try {
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                String city = resultSet.getString("city");
                System.out.format("%d, %s, %s, %s, %s\n", id, firstname, lastname, email, city);
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

    public void update(int id, String firstname, String lastname, String email, String city){
        connect();
        String query = "UPDATE Customers SET firstname = (?) , lastname = (?), email = (?), city = (?) WHERE id = (?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, city);
            preparedStatement.setInt(5, id);
            int rows = preparedStatement.executeUpdate();
            System.out.println("rows updated " + rows);
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

    public void delete(int id){
        Connection connection = connect();
        String deleteQuery = "DELETE FROM Customers WHERE id = " + id;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.executeUpdate();
            //preparedStatement.executeUpdate(deleteQuery);
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
