package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by szl on 2016/4/12.
 */
@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private MessagePrinter printer;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        printer.printAction();
        printer.printMessage();
    }
}
