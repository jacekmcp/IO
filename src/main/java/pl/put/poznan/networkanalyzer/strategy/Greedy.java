package pl.put.poznan.networkanalyzer.strategy;

import pl.put.poznan.networkanalyzer.model.Path;
import pl.put.poznan.networkanalyzer.service.ConnectionService;
import pl.put.poznan.networkanalyzer.service.NodeService;

import java.util.ArrayList;
import java.util.Comparator;

public class Greedy implements ShortestPathStrategy{

    private Path path;
    private NodeService nodeService;
    private ConnectionService connectionService;

    public Greedy(NodeService nodeService, ConnectionService connectionService) {
        this.nodeService = nodeService;
        this.connectionService = connectionService;
        this.path = new Path();
    }


    public boolean greedy(int id1,int id2){
        path.addToPath(id1);
        ArrayList<Integer> pom = nodeService.getOneNode(id1).getOutgoing();
        if(pom.isEmpty()){
            return false;
        } else {
            pom.sort(Comparator.comparingInt(o -> connectionService.getConnectionByNodes(id1, o).getValue()));
            return greedy(pom.get(0),id2);
        }
    }

    public ArrayList<Integer> getShortestPath(int a, int b){
        greedy(a,b);
        return path.getPath();
    }
}
