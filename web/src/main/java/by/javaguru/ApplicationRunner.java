package by.javaguru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(DatabaseConfig.class)
@ServletComponentScan
public class ApplicationRunner {
    public static void main(String[] args) {

        SpringApplication.run(ApplicationRunner.class, args);

    }
}
