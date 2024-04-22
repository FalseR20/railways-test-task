package dev.falser.railways_test_task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;


@SpringBootApplication
public class RailwaysTestTaskApplication {

    public static void main(String[] args) {
        Dotenv.configure().systemProperties().load();
        SpringApplication.run(RailwaysTestTaskApplication.class, args);
    }

}
