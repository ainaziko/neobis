import java.sql.*;

public class DessertDBHandler {
    private static Connection connection;
    private static ResultSet resultSet;
    static String url = "jdbc:mysql://localhost:3306/TemptingMorsels?useSSL=false";
    static String username = "root";
    static String password = "";



    public void addDessert(String dName, String dDescription, String imgPath, double price){
        connect();
        PreparedStatement preparedStatement = null;
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
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public ResultSet getDessert(){
        connect();
        PreparedStatement preparedStatement = null;
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


    public void update(int id, String dName, String dDescription, String imgPath, double price){
        connect();
        PreparedStatement preparedStatement = null;
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
        PreparedStatement preparedStatement = null;
        String query = "DELETE FROM Desserts WHERE id = " + id;
        try {
            preparedStatement.executeUpdate(query);
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
/*    public ResultSet getDessertR(){
        connect();
        PreparedStatement preparedStatement = null;
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
    }*/
