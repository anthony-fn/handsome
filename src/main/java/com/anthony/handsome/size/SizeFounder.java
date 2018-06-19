package com.anthony.handsome.size;

import com.anthony.handsome.common.Tools;
import com.anthony.handsome.counters.FileCountersContainer;

import java.io.File;

public class SizeFounder {

    private String startPath;
    private FileCountersContainer fileContainer = new FileCountersContainer();

    public SizeFounder( String path )
    {
        this.startPath = path;
    }

    private long getFolderLength( File file )
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
    public void start()
    {
        File file = new File(startPath);

        if( !file.exists() )
        {
            System.out.println("Invalid input path: "+startPath);
            System.exit(-1);
        }

        File [] files = file.listFiles();

        for( File subfile : files )
        {
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
