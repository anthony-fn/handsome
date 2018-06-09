package com.anthony.handsome.counters;

import com.anthony.handsome.common.Tools;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class FileCounters {

    private String fileName;
    private List<String> paths = new LinkedList<>();

    public FileCounters(File file )
    {
        this.setFileName(file.getName());
        try {
            this.addPath(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String listPaths()
    {
        StringBuilder sb = new StringBuilder();
        for( String path : paths )
        {
            sb.append(path + System.getProperty("line.separator"));
        }

        return sb.toString();
    }
    public void addPath( File file ) throws Exception {
        String path = Tools.getFilePath(file);
        if( file.getName().equals(this.getFileName()) )
        {
            if( paths.contains(path) )
            {
                throw new Exception("Adding a same file to the counter : "+ file.getPath());
            }
            else{
                paths.add(path);
            }
        }
        else
            throw new Exception("Why adding a file "+file.getName() + " to a counter named " + this.getFileName());
    }
    public int getCounter()
    {
        return paths.size();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<String> getPaths() {
        return paths;
    }

    public void setPaths(List<String> paths) {
        this.paths = paths;
    }
}
