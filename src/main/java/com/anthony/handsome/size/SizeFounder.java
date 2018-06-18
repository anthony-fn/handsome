package com.anthony.handsome.size;

import com.anthony.handsome.common.JobConfiguration;

public class SizeFounder {

    private String startPath;

    public SizeFounder( String path )
    {
        this.startPath = path;
    }

    public void test()
    {
        System.out.println(JobConfiguration.getSizeLayer());
    }
}
