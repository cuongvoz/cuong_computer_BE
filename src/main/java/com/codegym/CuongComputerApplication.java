package com.codegym;

import com.codegym.config.SpringConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import java.util.*;

@SpringBootApplication
@Import(SpringConfig.class)
public class CuongComputerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CuongComputerApplication.class, args);
    }

}
