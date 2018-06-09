package com.anthony.handsome.tools;

import java.io.File;

public class CleanGit {

    public static boolean shouldBeDeleted( File file )
    {
        if( file.isDirectory() && (file.getName().startsWith(".git") || file.getName().startsWith(".svn")) )
        {
            return true;
        }
        return false;
    }
    public static void deleteNecessary( File file )
    {
        if(shouldBeDeleted(file))
        {
            System.out.println(file.getPath());
            file.delete();
            file.deleteOnExit();

        }
        else if ( file.isDirectory() )
        {
            File [] files = file.listFiles();
            {
                for( File tobeDeleted : files )
                {
                    deleteNecessary(tobeDeleted);
                    
                }
            }
        }
    }

    public static void main( String [] args )
    {
        String path = "/Users/AnthonyFan/Mine/Codes/handsome";

        File file = new File(path);

        if( !file.exists() )
        {
            System.out.println("Invalid input path: "+path);
            System.exit(-1);
        }

        File [] files = file.listFiles();

        for( File check : files )
        {
            deleteNecessary(check);
        }
    }
}
