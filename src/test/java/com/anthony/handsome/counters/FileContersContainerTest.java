package com.anthony.handsome.counters;

import com.anthony.handsome.common.Tools;
import org.junit.Test;
import com.anthony.handsome.counters.*;

import java.io.File;

public class FileContersContainerTest {

    @Test
    public void testOrder()
    {
        try {
            FileCountersContainer container = new FileCountersContainer();

            container.addFile(new File("/test1/a"));
            container.addFile(new File("/test2/a"));
            container.addFile(new File("/test3/a"));
            container.addFile(new File("/test2/b"));
            container.addFile(new File("/test1/c"));
            container.addFile(new File("/test2/c"));

            System.out.println("before sort");
            System.out.print( container.toString(-1));
            FileCountersContainer sorted = Tools.sortFileCountainer(container);

            System.out.println("after sort");
            System.out.print( sorted.toString(-1));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
