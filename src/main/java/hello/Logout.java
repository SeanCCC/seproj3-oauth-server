package hello;

import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.io.*;
import org.json.*;

public class Logout {
    private final long rvl;
    private final String result;
    private static Logger logger = Logger.getLogger(Logout.class.getName());

    private int getToken(String id){
        return id.hashCode();
    }

    public Logout(String token) throws IOException {
        FileHandler fileHandler = new FileHandler("./log/Logout.log");
        fileHandler.setLevel(Level.INFO); //Log的層級
        logger.addHandler(fileHandler);
        logger.info(""+token+" is Logging out");
        if(GreetingController.tokenTable.has(token)){
            GreetingController.tokenTable.remove(token);
            logger.info(""+token+" has Logged out");
            this.result = token+" has logged out";
            this.rvl = 1;
        }
        else{
            this.result = token+" has never logged in";
            this.rvl = -1;
            logger.info(token+" has never logged in");
        }
    }

    public long getRvl() {
        return rvl;
    }

    public String getResult() {
        return result;
    }
}
