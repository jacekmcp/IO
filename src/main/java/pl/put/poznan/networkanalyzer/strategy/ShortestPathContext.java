package pl.put.poznan.networkanalyzer.strategy;

import pl.put.poznan.networkanalyzer.service.ConnectionService;
import pl.put.poznan.networkanalyzer.service.NodeService;

import java.util.ArrayList;

public class ShortestPathContext {

    private ShortestPathStrategy strategy;

    public ShortestPathContext(NodeService ns, ConnectionService cs){
        strategy = new BFS(ns,cs);
    }

    public void set(ShortestPathStrategy strategy){
        this.strategy = strategy;
    }

    public ArrayList<Integer> shortestPath(int a, int b){
        return strategy.getShortestPath(a,b);
    }
}
