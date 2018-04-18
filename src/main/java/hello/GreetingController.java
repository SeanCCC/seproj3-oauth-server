package hello;

import java.io.*;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.json.*;

@RestController
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();
    public static JSONObject idpwd = new JSONObject();
    public static JSONObject tokenTable = new JSONObject();

    private static void initidpwd(){
        idpwd.put("test1","test1");
        idpwd.put("test2","test2");
    }

    @RequestMapping("/login")
    public Login login(@RequestParam(value="id", defaultValue="") String id, @RequestParam(value="pwd", defaultValue="") String pwd) throws IOException {
        initidpwd();
        return new Login(id, pwd);
    }

    @RequestMapping("/logout")
    public Logout logout(@RequestParam(value="token", defaultValue="") String token) throws IOException {
        return new Logout(token);
    }

    @RequestMapping("/valid")
    public Validation validation(@RequestParam(value="token", defaultValue="") String token) throws IOException {
        return new Validation(token);
    }
}
