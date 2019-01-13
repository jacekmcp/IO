package pl.put.poznan.networkanalyzer.service;

import org.springframework.stereotype.Service;
import pl.put.poznan.networkanalyzer.model.Connection;
import pl.put.poznan.networkanalyzer.model.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class is a service for Node objects, implements some functions related to Nodes
 * @see  Node
 * @author  Michal Kukiela
 */
@Service
public class NodeService {

    private ArrayList<Node> nodes = new ArrayList<>();

    /**
     * Get all nodes in whole graph
     * @return list of all nodes
     */
    public ArrayList<Node> getAllNodes(){
        return nodes;
    }

    /**
     * Get one particular node by it's id
     * @param id
     * @return node with given id
     */
    public Node getOneNode(Integer id){
        Node temp = new Node(-1,"TEST","TEST",new ArrayList<>(), new ArrayList<>());
        for (Node n: nodes) {
            if(n.getId().equals(id)){
                temp =  n;
            }
        }
        return temp;
    }

    /**
     * Adds a node to list of all nodes in graph
     * @param n node to add
     */
    public void addNode(Node n){
        nodes.add(n);
    }

    /**
     * Updates node by id
     * @param id
     * @param node  new object Node with new attributes that we want
     */
    public void updateNode(Integer id, Node node){
        for(int i = 0; i<nodes.size(); i++){
            Node n = nodes.get(i);
            if(n.getId().equals(id)){
                nodes.set(i,node);
                return;
            }
        }
    }

    /**
     * Delete node by it's id
     * @param id
     */
    public void deleteNode(Integer id) {
        nodes.removeIf(n -> n.getId().equals(id));
    }

    /**
     * By passing Connection object (with "from" and "to" attributes) it updates outgoing and incoming attributes of
     * nodes, that should be connected by this perticular connection
     * @param connection    connection with filled "from" and "to" attributes
     * @see Connection
     */
    public void setIO(Connection connection) {
        Integer outNode = connection.getFrom();
        Integer inNode = connection.getTo();

        for (Node node: nodes) {
            if(node.getId() == outNode){
                node.addOutgoing(connection.getTo());
            }else if(node.getId() == inNode){
                node.addIncoming(connection.getFrom());
            }
        }
    }
    
}