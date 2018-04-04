package hello;

import java.io.*;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/infixEval")
    public Greeting greeting(@RequestParam(value="exp", defaultValue="-1") String exp) throws IOException {
        System.out.println(exp);
        return new Greeting(counter.incrementAndGet(),
                            exp);
    }
}
