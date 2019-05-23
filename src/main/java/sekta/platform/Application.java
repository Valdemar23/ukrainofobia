package sekta.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by FreeFly on 11.05.2016.
 */
@SpringBootApplication
//@ComponentScan(basePackages = {"sekta.platform.web.controller"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
