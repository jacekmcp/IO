package pl.put.poznan.networkanalyzer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.put.poznan.networkanalyzer.model.Connection;
import pl.put.poznan.networkanalyzer.model.Node;
import pl.put.poznan.networkanalyzer.model.Path;

import java.util.*;

@Service
public class NetAnalService {

    private final
    ConnectionService connectionService;

    private final
    NodeService nodeService;

    private List<Connection> connections;
    private List<Node> nodes;

    private ArrayList<Integer> open = new ArrayList<>();
    private ArrayList<Integer> closed = new ArrayList<>();
    private Map<Integer, Integer> nodesToMap;

    private Path path = new Path();


    @Autowired
    public NetAnalService(ConnectionService connectionService, NodeService nodeService) {
        this.connectionService = connectionService;
        this.nodeService = nodeService;

        this.connections = connectionService.getAllConnections();
        this.nodes = nodeService.getAllNodes();
    }

    /**
     * @version 3.0
     * Jako administrator sieci przemysłowej mogę znaleźć ścieżkę z entry do exit o najmniejszej sumarycznej wartości wykorzystując przeszukiwanie wszerz, aby znaleźć najbardziej opłacalne przejście przez sieć
     * Jako administrator sieci przemysłowej jestem w stanie znaleźć ścieżkę z entry do exit o najmniejszej sumarycznej wartości wykorzystując przeszukiwanie w głąb, aby znaleźć najbardziej opłacalne przejście przez sieć
     * @param source
     * @param dest
     * @param type
     * @return
     */
    public ArrayList<Integer> BFSPath(Integer source, Integer dest, String type){
        ArrayList<Integer> shortestPathList = new ArrayList<Integer>();
        HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();

        if (source == dest)
            return null;
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> pathStack = new Stack<>();

        queue.add(source);
        pathStack.add(source);
        visited.put(source, true);

        while(!queue.isEmpty()){
            int u = queue.poll();
            List<Integer> adjList = nodeService.getOneNode(u).getOutgoing();

            for(int v:adjList){
                if(!visited.containsKey(v)){
                    if(type == "BFS"){
                        queue.add(v);
                    } else {
                        ((LinkedList<Integer>) queue).addLast(v);
                    }
                    visited.put(v,true);
                    pathStack.add(v);
                    if(u==dest) break;
                }
            }
        }

        int node, currentSrc = dest;
        shortestPathList.add(dest);
        while (!pathStack.isEmpty()){
            node = pathStack.pop();
            if(connectionService.getConnectionByNodes(node,currentSrc).getValue()>0){
                shortestPathList.add(node);
                currentSrc = node;
                if(node == source) break;
            }
        }

        return shortestPathList;
    }

    /**
     * @version 4.0
     * Jako administrator sieci przemysłowej jestem w stanie znaleźć ścieżkę z entry do exit o najmniejszej sumarycznej wartości wykorzystując algorytm zachłanny, aby znaleźć opłacalne przejście przez sieć w krótkim czasie
     * @param id1
     * @param id2
     * @return
     */
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

    public int calculateCost(ArrayList<Integer> spath){
        int sum = 0;
        for(int i=0;i<spath.size()-1;i++){
            sum+=connectionService.getConnectionByNodes(spath.get(i+1),spath.get(i)).getValue();
        }
        return sum;
    }

    public Path findBestRoute(Integer id1, Integer id2, String type){
        path.clearPath();
        if(type.equals("BFS")){
            path.setFullPath(BFSPath(id1,id2,"BFS"));
        } else if(type.equals("DFS")){
            path.setFullPath(BFSPath(id1,id2,"DFS"));
        } else if(type.equals("GREEDY")){
            greedy(id1,id2);
        }
        path.setFullCost(calculateCost(path.getPath()));
        return path;
    }

}
