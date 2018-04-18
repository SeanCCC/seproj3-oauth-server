package hello;

import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.io.*;
import org.json.*;

public class Validation {
    private final long rvl;
    private final String result;
    private static Logger logger = Logger.getLogger(Validation.class.getName());

    private int getToken(String id){
        return id.hashCode();
    }

    public Validation(String token) throws IOException {
        FileHandler fileHandler = new FileHandler("./log/Validation.log");
        fileHandler.setLevel(Level.INFO); //Log的層級
        logger.addHandler(fileHandler);
        logger.info(""+token+" requires Validation");
        if(GreetingController.tokenTable.has(token)){
            logger.info(""+token+" is valid");
            this.result = token+" is valid";
            this.rvl = 1;
        }
        else{
            this.result = token+" is not valid";
            this.rvl = 0;
            logger.info(token+" is not valid");
        }
    }

    public long getRvl() {
        return rvl;
    }

    public String getResult() {
        return result;
    }
}
