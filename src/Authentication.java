import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.*;
import java.util.Map;

public class Authentication extends ActionSupport implements SessionAware {

    public Map<String, String> session;
    public String username;
    public String password;

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
    public String login() throws SQLException {
        Connection connection;
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ecommerce?serverTimezone=UTC","root", "rootroot1");
        try {
            String checkUserQuery = "SELECT * FROM users WHERE username = ?";
            PreparedStatement checkUser = connection.prepareStatement(checkUserQuery);
            checkUser.setString(1, username);
            ResultSet output = checkUser.executeQuery();

            if (output.next()) {
                // tell the frontend whos logged in
                session.put("current_user", username);
                return "SUCCESS";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "FAILURE";
    }

    public String register() throws SQLException {

        Connection connection;
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ecommerce?serverTimezone=UTC","root", "rootroot1");

        // if user doesnt exist, create it and login


        try {
            String checkUserQuery = "SELECT * FROM users WHERE username = ?";
            PreparedStatement checkUser = connection.prepareStatement(checkUserQuery);
            checkUser.setString(1, username);
            ResultSet output = checkUser.executeQuery();

            if (!output.next()) {
                String createUserQuery = ("INSERT into users (username, password) VALUES (?, ?)");
                PreparedStatement createUser = connection.prepareStatement(createUserQuery);
                createUser.setString(1, username);
                createUser.setString(2, password);
                createUser.executeUpdate();
                return "SUCCESS";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        // put 2 buttons on the same form
        return "FAILURE";
    }
// clear the session
    public String logoff() {
        if (session != null) {
            session.clear();

        }
        return "SUCCESS";
    }

    @Override
    public void setSession(Map map) {
        this.session = map;

    }
}
