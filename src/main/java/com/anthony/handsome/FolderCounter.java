package com.anthony.handsome;

import java.io.File;
import java.util.TreeMap;

public class FolderCounter {
    private String path = "";

    private TreeMap<String, FolderCounter> folderCounter = new TreeMap<>();
    private TreeMap<String, Long> fileCounter = new TreeMap<>();

    private long size = 0;


    private void addSubFile(File file ) throws Exception {
        if( !file.isFile() )
        {
            throw new Exception("This should not happen" + file.getName() );
        }

        if( fileCounter.containsKey(file.getName()) )
        {
            throw new Exception("This should not happen" + file.getName() );
        }
        else{
            fileCounter.put(file.getName(), file.length());
        }
    }

    private void addSubFolder( FolderCounter subFolder ) throws Exception {
        if( folderCounter.containsKey(subFolder.getPath()) )
        {
            throw new Exception( "This should not happen " + subFolder.getPath());
        }
        subFolder.parseContent();
        folderCounter.put(subFolder.getPath(), subFolder);
    }

    public String toString( int i )
    {
        String prefix = "";
        for( int j = 0; j < i; j ++ )
        {
            prefix += " ";
        }

        StringBuilder sb = new StringBuilder();


        return sb.toString();
    }

    public void parseContent() throws Exception {

        File file = new File(path);
        if( file.isDirectory() )
        {
            File [] files = file.listFiles();

            for( File subfile : files )
            {
                if( subfile.isFile() )
                {
                    this.addSubFile(file);
                }
                else if( subfile.isDirectory() )
                {
                    FolderCounter subFolder = new FolderCounter(subfile.getName());

                }
            }
        }
        else if( file.isFile() )
        {
            this.addSubFile(file);
        }
        else{
            throw new Exception("This should not happen "+file.getName());
        }
    }
    public FolderCounter( String path )
    {
        this.setPath(path);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }


}
