import data.Bid;
import data.Product;

import java.sql.*;

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
        Bid bid = new Bid();
        bid.setBiddersName(biddersName);
        bid.setBidAmount(bidAmount);
        bid.setProductName(productName);

        try {
       // check if the bid already exists
            String checkBidQuery = "SELECT * FROM bids WHERE productName = ?";
            PreparedStatement checkBid = connection.prepareStatement(checkBidQuery);
            checkBid.setString(1, bid.getProductName());
            ResultSet bidResult = checkBid.executeQuery();

            if (!bidResult.next()) {


                String insertBidQuery = "INSERT INTO bids (biddersName, productName, sellerName, bidAmount) VALUES (?, ?, ?, ?)";
                PreparedStatement insertBid = connection.prepareStatement(insertBidQuery);
                insertBid.setString(1, bid.getBiddersName());
                insertBid.setString(2, bid.getProductName());
                insertBid.setString(3, sellerName);
                insertBid.setDouble(4, bid.getBidAmount());
                insertBid.executeUpdate();
                return "SUCCESS";
            }
            } catch(SQLException e){
                e.printStackTrace();
            }
            return "FAILURE";
        }


    // Should get and return data from the db - probably requires changes to struts.xml
    public String getBids() {
        return "SUCCESS";
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
        Product product = new Product();
        product.setProductName(productName);
        product.setPrice(price);
        product.setSellerName(sellerName);
        try {

            String checkUserQuery = "SELECT * FROM products WHERE productName = ?";
            PreparedStatement checkUser = connection.prepareStatement(checkUserQuery);
            checkUser.setString(1, productName);
            ResultSet output = checkUser.executeQuery();
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



    public String getUsers() {
        return "SUCCESS";
    }

    public String getUser() {
        return "SUCCESS";
    }


}
