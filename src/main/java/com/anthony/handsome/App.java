package com.anthony.handsome;

import com.anthony.handsome.common.JobConfiguration;
import com.anthony.handsome.common.Tools;
import com.anthony.handsome.counters.FileCountersContainer;

import java.io.File;

public class App {

    private static FileCountersContainer fileContainer = new FileCountersContainer();
    public static long getFolderLength( File file )
    {
        File [] subfiles = file.listFiles();
        long result = 0;
        for( File subfile : subfiles )
        {
            if( subfile.isDirectory() )
            {
                result += getFolderLength( subfile );
            }
            else{

                result += subfile.length();
                fileContainer.addFile(subfile);
            }
        }
        return result;
    }
    public static void main( String [] args )
    {
        String path = "/Users/AnthonyFan/Works/Documents";

        File file = new File(path);

        if( !file.exists() )
        {
            System.out.println("Invalid input path: "+path);
            System.exit(-1);
        }

        File [] files = file.listFiles();

        int i = 0;
        for( File subfile : files )
        {
            i++;
            //System.out.println( " Current: "+ subfile.getPath()+" "+i+" out of "+files.length);
            if( subfile.isDirectory() )
            {
                System.out.println( subfile.getPath() + "\t"+ getFolderLength(subfile)/(1024*1024));
            }
            else{
                System.out.println( subfile.getPath() + "\t"+ subfile.length()/(1024*1024));
            }
        }

        FileCountersContainer afterSort = Tools.sortFileCountainer(fileContainer);

        System.out.println( afterSort.toString(10));
    }
}
