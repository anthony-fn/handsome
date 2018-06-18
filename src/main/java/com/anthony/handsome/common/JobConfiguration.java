package com.anthony.handsome.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class JobConfiguration {

    @Autowired
    private ConfigInfo configInfo;

    private static String excludedList;
    private static int layer;

    public static String getExcludedList()
    {
        return excludedList;
    }

    @PostConstruct
    public void init()
    {
        if( configInfo == null )
            configInfo = new ConfigInfo();
        //System.out.println(configInfo.getCounterExcludes());
        excludedList = configInfo.getCounterExcludes();
        layer = configInfo.getLayer();
    }

    public static int getSizeLayer()
    {
        return layer;
    }
}
