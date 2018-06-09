package com.anthony.handsome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.PriorityQueue;
import java.util.Properties;

@SpringBootApplication
public class HandsomeApplication {

    public static void main(String[] args) {

        SpringApplication.run(HandsomeApplication.class, args);

        System.out.println("Start");


        Properties pros = System.getProperties();

        for( String name :pros.stringPropertyNames() )
        {
            System.out.println(name + " : "+pros.getProperty(name));
        }

        pros.propertyNames();
    }
}
