package pl.put.poznan.networkanalyzer.Service;

import org.springframework.stereotype.Service;
import pl.put.poznan.networkanalyzer.model.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class NodeService {

    private ArrayList<Node> nodes = new ArrayList<>(Arrays.asList(
            new Node("1","nazwa","entry",null,null)
    ));



    public List<Node> getAllNodes(){
        return nodes;
    }

    public Node getOneNode(String id){
        for (Node n: nodes) {
            if(n.getId().equals(id)){
                return n;
            }
        }
        return null;
    }

    public void addNode(Node n){
        nodes.add(n);
    }

    public void updateNode(String id, Node node){
        for(int i = 0; i<nodes.size(); i++){
            Node n = nodes.get(i);
            if(n.getId().equals(id)){
                nodes.set(i,node);
                return;
            }
        }
    }

    public void deleteNode(String id) {
        nodes.removeIf(n -> n.getId().equals(id));
    }
}
