import java.sql.*;


public class CustomerDBHandler {
    static Connection connection;
    static PreparedStatement preparedStatement;
    static String url = "jdbc:mysql://localhost:3306/TemptingMorsels?useSSL=false";
    static String username = "root";
    static String password = "";

    public static void main(String[] args) {
        try {
            makeDBConnection();

            log("\n---------- Adding new customers to DB ----------");
            addCustomerToDB("Mike", "Jones", "mike@gmail.com","NY");
            addCustomerToDB("Jack", "Taylor", "jack@gmail.com", "Washington");;

            log("\n---------- Let's get Data from DB ----------");
            getCustomersFromDB();

            updateCustomer(1, "Mike", "Jake", "mikej@gmail.com");

            log("deleted ");
            deleteCustomerFromDB(1);
            getCustomersFromDB();

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addCustomerToDB(String firstname, String lastname, String email, String city){
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
        }
    }


    private static void updateCustomer(int id, String firstname, String lastname, String email) throws SQLException {
        String updateQuery = "UPDATE Customers SET firstname = (?) , lastname = (?), email = (?) WHERE id = (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
        preparedStatement.setString(1, firstname);
        preparedStatement.setString(2, lastname);
        preparedStatement.setString(3, email);
        preparedStatement.setInt(4, id);
        int rows = preparedStatement.executeUpdate();
        System.out.println("rows updated " + rows);
    }


    public static void deleteCustomerFromDB(int id){
        String deleteQuery = "DELETE FROM Customers WHERE id = " + id;
        try {
            preparedStatement.executeUpdate(deleteQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void getCustomersFromDB(){
        String getQueryStatement = "SELECT * FROM Customers";
        try {
            preparedStatement = connection.prepareStatement(getQueryStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                String city = resultSet.getString("city");
                System.out.format("%s, %s, %s, %s\n", firstname, lastname, email, city);
            }
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void makeDBConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            log("MySQL JDBC Driver is registered");
        } catch (ClassNotFoundException e) {
            log("JDBC Driver is not found.");
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(url, username, password);
            if(connection != null){
                log("Connected successfully. Time to push data.");
            } else {
                log("Failed to make connection.");
            }
        } catch (SQLException throwables) {
            log("MySQL connection is failed");
            throwables.printStackTrace();
        }
    }

    private static void log(String string) {
        System.out.println(string);
    }
}