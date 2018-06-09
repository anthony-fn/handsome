package com.anthony.handsome.duplicate;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class DuplicateChecker {
    private String name = "";
    private List<String> paths = new LinkedList<String>();

    public DuplicateChecker( File file )
    {
        this.setName(file.getName());
        paths.add(file.getPath());
    }

    public boolean isDuplicated()
    {
        return paths.size() > 1 ? true : false;
    }
    public int getDuplicateNumber()
    {
        return paths.size();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPaths() {
        return paths;
    }

    public void setPaths(List<String> paths) {
        this.paths = paths;
    }
}
