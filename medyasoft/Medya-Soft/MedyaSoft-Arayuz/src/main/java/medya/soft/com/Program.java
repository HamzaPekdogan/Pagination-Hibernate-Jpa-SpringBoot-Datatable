package medya.soft.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
public class Program extends SpringBootServletInitializer implements WebApplicationInitializer {
    /**
     * Main metod.
     * @param args Ana metod parametreleri.
     */
    public static void main(String[] args) {

        SpringApplication.run(Program.class, args);
    }
}
