import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

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
    public String login(){

        if(username.equals("admin") && password.equals("admin")) {
            // tell the frontend whos logged in
            session.put("current_user", username);
            return "SUCCESS";
        }
        return "FAILURE";
    }

    public String register(){

        // if user doesnt exist, create it and login
        // put 2 buttons on the same form
        return "FAILURE";
    }

    @Override
    public void setSession(Map map) {
        this.session = map;

    }
}
