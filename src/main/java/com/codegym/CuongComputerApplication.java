package com.codegym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CuongComputerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CuongComputerApplication.class, args);

//            Short s1 = 200;
//            int s2 = 400;
//            Long s3 = (long) s1 + s2; //line n1
//        System.out.println(s3);
//            String s4 = String.valueOf(s3 * s2); //line n2
//            System.out.print("sum is " + s4);

//        Kết quả sẽ là gì ?
//                A. sum is 600
//        B. Compilation fails line n1
//        C. Compilation fails line n2
//        D. ClassCastException is thrown at line n1
//        E. ClassCastException is thrown at line n2
    }

}
