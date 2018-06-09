package com.anthony.handsome.counters;

import java.util.Comparator;
import java.util.Map;

public class FileCountersComparator implements Comparator<Map.Entry<String, FileCounters>> {
    @Override
    public int compare(Map.Entry<String, FileCounters> o1, Map.Entry<String, FileCounters> o2) {
        Integer source = new Integer(o1.getValue().getCounter());
        Integer target = new Integer(o2.getValue().getCounter());
        return target.compareTo(source);
    }
}
