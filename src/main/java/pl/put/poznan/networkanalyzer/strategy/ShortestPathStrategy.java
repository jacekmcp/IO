package pl.put.poznan.networkanalyzer.strategy;

import java.util.ArrayList;

public interface ShortestPathStrategy {

    public ArrayList<Integer> getShortestPath(int id1,int id2);
}
