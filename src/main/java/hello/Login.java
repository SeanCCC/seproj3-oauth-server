package hello;

import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.io.*;
import org.json.*;

public class Login {
    private final long rvl;
    private final String result;
    private static Logger logger = Logger.getLogger(Login.class.getName());

    private int getToken(String id){
        return id.hashCode();
    }

    public Login(String id, String pwd) throws IOException {
        FileHandler fileHandler = new FileHandler("./log/Login.log");
        fileHandler.setLevel(Level.INFO); //Log的層級
        logger.addHandler(fileHandler);
        logger.info(""+id+" is trying to login");
        if(GreetingController.tokenTable.has(String.valueOf(getToken(id)))){
            this.rvl = 0;
            this.result = ""+id+" has already logged in";
            logger.info(""+id+" has already logged in");
        }
        else if(GreetingController.idpwd.has(id)) {
            String corPwd = GreetingController.idpwd.get(id).toString();
            System.out.println(corPwd);
            if(pwd.equals(corPwd)){
                this.rvl = 1;
                int token = getToken(id);
                this.result = "Login Success, bring the token to the login service by adding the param token="+token;
                GreetingController.tokenTable.put(String.valueOf(token),id);
                logger.info(""+id+":Login Success and add token to table");
            }
            else {
                this.rvl = -1;
                this.result = "Login failed: wrong accoung or pwd";
                logger.info(""+id+":Login failed: wrong accoung or pwd");
            }

        }
        else {
            this.rvl = -1;
            this.result = "Login failed: wrong accoung or pwd";
            logger.info(""+id+":Login failed: wrong accoung or pwd");
        }
        logger.info("reporting the result:"+this.result);
    }

    public long getRvl() {
        return rvl;
    }

    public String getResult() {
        return result;
    }
}
