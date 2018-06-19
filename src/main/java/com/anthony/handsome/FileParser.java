package com.anthony.handsome;

import com.anthony.handsome.exception.HandsomeError;
import com.anthony.handsome.exception.HandsomeException;
import com.anthony.handsome.common.Tools;
import com.anthony.handsome.counters.FileCountersContainer;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FileParser {

    private String startPath;

    private Map<String, Integer> layers = new HashMap<String, Integer>();

    private FileCountersContainer fileContainer = new FileCountersContainer();
    public FileParser( String path )
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

    public void parse() throws HandsomeException {
        File file = new File(startPath);

        if( !file.exists() )
        {
            throw new HandsomeException(HandsomeError.INVALID_PATH, startPath);
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
