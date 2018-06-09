package com.anthony.handsome.common;

import org.junit.Test;
import com.anthony.handsome.common.Tools;

import java.io.File;

public class ToolsTest {

    @Test
    public void getFilePathTest()
    {
        File abc = new File("/Users/AnthonyFan/Desktop/startup.sh");
        try {
            String result = Tools.getFilePath(abc);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
