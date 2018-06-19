package com.anthony.handsome.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ConfigInfo {

    @Value("${counter.ExcludedPaths}")
    private String counterExcludes;

    @Value("${size.Layer}")
    private int layer;

    public void setCounterExcludes( String counterExcludes )
    {
        this.counterExcludes = counterExcludes;
    }

    public String getCounterExcludes()
    {
        return counterExcludes;
    }

    public int getLayer()
    {return layer;}

    public void setLayer( int layer )
    {
        this.layer = layer;
    }

    /*@PostConstruct
    public void post()
    {
        System.out.println(this.toString());
    }*/

    @Override
    public String toString()
    {
        return "Configurations: {"
                + " Size.Layer: "+layer
                +" Counter.excluedFolders: "+counterExcludes
                +"}";
    }


}
