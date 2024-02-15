package ru.artiushenko.charcounterrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
public class CharCounterRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CharCounterRestApplication.class, args);
    }

}
