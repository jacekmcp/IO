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

    public void greedy(int id1,int id2) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(id1);
        while(!stack.isEmpty()){
            open.add(stack.getFirst());
            for(Integer item: nodeService.getOneNode(stack.getFirst()).getOutgoing()){
                stack.add(item);
                if(item == id2){
                    break;
                }
            }
            stack.sort((a,b) ->{
                if(connectionService.getConnectionByNodes(id1,a).getValue()>connectionService.getConnectionByNodes(id1,b).getValue()){
                    return a;
                } else {
                    return b;
                }
            });
            int temp = stack.getFirst();
            stack.clear();
            stack.add(temp);
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
        } else if(type.equals("greedy")){
            greedy(id1,id2);
            path.setFullPath(open);
        }
        path.setFullCost(calculateCost(path.getPath()));
        return path;
    }

}
