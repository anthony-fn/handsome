package com.anthony.handsome;

import java.io.File;

public class FileClean {

    public static void getLenth()
    {

    }
    public static void main( String [] args )
    {
        System.out.println("Start");

        File root = new File("//");

        if( root.exists() )
        {
            File [] folders = root.listFiles();

            for( File one : folders )
            {
                if( one.getName().startsWith("."))
                    System.out.println(one.getName() + "\t" + one.length());
            }
        }
    }
}
