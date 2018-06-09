package com.anthony.handsome.counters;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileCountersContainer {

    private Map<String, FileCounters> counters = null;

    public FileCountersContainer()
    {
        counters = new LinkedHashMap<>();
    }

    public Map<String, FileCounters> getCounters()
    {
        return this.counters;
    }

    public FileCountersContainer( Map<String, FileCounters> result )
    {
        this.counters = result;
    }

    public boolean isEmpty()
    {
        if( counters == null || counters.isEmpty() )
            return true;
        else
            return false;
    }

    public void addFile( File file )
    {
        /*if( !file.exists() )
        {
            return;
        }*/

        if( counters.containsKey(file.getName()) )
        {
            try {
                counters.get(file.getName()).addPath(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            counters.put(file.getName(), new FileCounters(file));
        }
    }


    public String toString(int layers)
    {
        Iterator<Map.Entry<String, FileCounters>> iterator= counters.entrySet().iterator();
        StringBuilder sb = new StringBuilder();
        int rounds = 0;
        if( layers == -1 )
        {
            rounds = counters.size();
        }
        else
            rounds = layers;

        int index = 0;
        while(iterator.hasNext())
        {
            if( index == rounds )
                break;
            index ++;
            Map.Entry entry = iterator.next();
            FileCounters counter = (FileCounters)entry.getValue();
            sb.append( entry.getKey() + ":" + counter.getCounter()+System.getProperty("line.separator"));
            sb.append( counter.listPaths());

        }

        return sb.toString();
    }

}
