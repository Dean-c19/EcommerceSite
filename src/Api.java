import data.Bid;
import data.Product;
import data.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Api {

    private String biddersName;
    private double bidAmount;

    public String getBiddersName() {
        return biddersName;
    }

    public void setBiddersName(String biddersName) {
        this.biddersName = biddersName;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }
    // Should add a bid to the db and return a success message
    public String placeBid() throws SQLException {
        Connection connection;
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ecommerce?serverTimezone=UTC", "root", "rootroot1");
        // create a new bid object
        Bid bid = new Bid();
        bid.setBiddersName(biddersName);
        bid.setBidAmount(bidAmount);
        bid.setProductName(productName);

        try {
       // get the seller name
            String getSellerQuery = "SELECT sellerName FROM products WHERE productName = ?";
            PreparedStatement getSeller = connection.prepareStatement(getSellerQuery);
            getSeller.setString(1, bid.getProductName());
            ResultSet sellerResult = getSeller.executeQuery();

            String sellerName = null;
            //gets the seller name from the prodcts table and sets it to the sellerName
            if (sellerResult.next()) {
                sellerName = sellerResult.getString("sellerName");
            }
                // insert the bid into the bids table
                String insertBidQuery = "INSERT INTO bids (biddersName, productName, sellerName, bidAmount) VALUES (?, ?, ?, ?)";
                PreparedStatement insertBid = connection.prepareStatement(insertBidQuery);
                insertBid.setString(1, bid.getBiddersName());
                insertBid.setString(2, bid.getProductName());
                insertBid.setString(3, sellerName);
                insertBid.setDouble(4, bid.getBidAmount());

                int rowsAffected = insertBid.executeUpdate();
                // if the bid is successfully added to the db, return success
               if (rowsAffected > 0) {
                   return "SUCCESS";
               } else {
                       return "FAILURE";
                   }
               } catch (SQLException e) {
                   e.printStackTrace();
               }


            return "FAILURE";
        }


    private String productName;
    private int price;
    private String sellerName;
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
    public String getProductForSale() throws SQLException {
        Connection connection;
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ecommerce?serverTimezone=UTC", "root", "rootroot1");
        // create a new product object
        Product product = new Product();
        product.setProductName(productName);
        product.setPrice(price);
        product.setSellerName(sellerName);
        try {
            // check if the product already exists
            String checkUserQuery = "SELECT * FROM products WHERE productName = ?";
            PreparedStatement checkUser = connection.prepareStatement(checkUserQuery);
            checkUser.setString(1, productName);
            ResultSet output = checkUser.executeQuery();
            // if the product doesnt exist, add it to the db
            if (!output.next()) {

                String insertProductQuery = "INSERT INTO products (productName, price, sellerName) VALUES (?, ?, ?)";
                PreparedStatement insertProduct = connection.prepareStatement(insertProductQuery);
                insertProduct.setString(1, product.getProductName());
                insertProduct.setInt(2, product.getPrice());
                insertProduct.setString(3, sellerName);
                insertProduct.executeUpdate();
                return "SUCCESS";


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

         return "FAILURE";
    }


    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    // view other profile but also acts as view my profile wehn you login or register
    public String viewOtherProfile() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ecommerce?serverTimezone=UTC", "root", "rootroot1");

        try {


            // get user details
            String query = "SELECT username, password FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            // f user is found, set username and password to the values in the db
            if (resultSet.next()) {
                username = resultSet.getString("username");
                password = resultSet.getString("password");

                return "SUCCESS";
            } else {

                return "FAILURE";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "FAILURE";
        }
    }
// array list to store allUsers
    private List<User> allUsers = new ArrayList<>();

    // getter for allUsers
    public List<User> getAllUsers() {
        return allUsers;
    }

    public String viewAllUsers() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ecommerce?serverTimezone=UTC", "root", "rootroot1");

        try {
            // get all users from the db
            String query = "SELECT username, password FROM users";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();



            // loop through the result set and add each user to the list
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                // add the user to the list
                allUsers.add(new User(username, password));
            }

            return "SUCCESS";
        } catch (SQLException e) {
            e.printStackTrace();
            return "FAILURE";
        }
    }
    // array list to store all products
    private List<Product> allItems = new ArrayList<>();

    // getter for allItems
    public List<Product> getAllItems() {
        return allItems;
    }

    public String viewAllItems() throws SQLException {


        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ecommerce?serverTimezone=UTC", "root", "rootroot1");

        try {
            // get all products from the db
            String query = "SELECT productName, price, sellerName FROM products";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // loop through the result set and add each product to the list
            while (resultSet.next()) {
                String productName = resultSet.getString("productName");
                int price = resultSet.getInt("price");
                String sellerName = resultSet.getString("sellerName");

                // add the product to the list
                allItems.add(new Product(productName, price, sellerName));
            }

            return "SUCCESS";
        } catch (SQLException e) {
            e.printStackTrace();
            return "FAILURE";
        }
    }
}
