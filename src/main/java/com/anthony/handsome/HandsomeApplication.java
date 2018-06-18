package com.anthony.handsome;

import com.anthony.handsome.common.JobConfiguration;
import com.anthony.handsome.size.SizeFounder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.PriorityQueue;
import java.util.Properties;

@SpringBootApplication
public class HandsomeApplication {

    @Autowired
    JobConfiguration jobConfiguration;

    public static void main(String[] args) {

        SpringApplication.run(HandsomeApplication.class, args);

        System.out.println("Start");

        System.out.println(JobConfiguration.getExcludedList());

        SizeFounder size = new SizeFounder("\\");

        size.test();
    }
}
