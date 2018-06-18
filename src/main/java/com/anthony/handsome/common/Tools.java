package com.anthony.handsome.common;

import com.anthony.handsome.counters.FileCounters;
import com.anthony.handsome.counters.FileCountersComparator;
import com.anthony.handsome.counters.FileCountersContainer;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.*;

public class Tools {

    public static void showProperties()
    {
        Properties pros = System.getProperties();

        for( String name :pros.stringPropertyNames() )
        {
            System.out.println(name + " : "+pros.getProperty(name));
        }
    }

    public static String getFilePath(File file) throws Exception {
        /*if( file == null || !file.exists() )
        {
            throw new Exception("File input is not valid");
        }*/

        String name = file.getName();
        String path = file.getPath();
        int starter = path.lastIndexOf(name);
        return path.substring(0, starter);
    }

    public static FileCountersContainer sortFileCountainer(FileCountersContainer input)
    {
        if( input == null || input.isEmpty() )
            return null;
        Map<String, FileCounters> originMap = input.getCounters();
        Map<String, FileCounters> sortedMap = new LinkedHashMap<>();
        List<Map.Entry<String, FileCounters> > entryList = new ArrayList<>(originMap.entrySet());
        Collections.sort( entryList, new FileCountersComparator() );

        Iterator<Map.Entry<String, FileCounters>> iter = entryList.iterator();
        Map.Entry<String, FileCounters> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }

        return new FileCountersContainer(sortedMap);
    }
}
