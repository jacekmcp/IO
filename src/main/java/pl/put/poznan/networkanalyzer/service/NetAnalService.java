package pl.put.poznan.networkanalyzer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.put.poznan.networkanalyzer.model.Connection;
import pl.put.poznan.networkanalyzer.model.Node;

import java.util.ArrayList;

@Service
public class NetAnalService {

    private final
    ConnectionService connectionService;

    private final
    NodeService nodeService;

    private ArrayList<Connection> connections;

    private ArrayList<Node> nodes;

    @Autowired
    public NetAnalService(ConnectionService connectionService, NodeService nodeService) {
        this.connectionService = connectionService;
        this.nodeService = nodeService;

        this.connections = connectionService.getAllConnections();
        this.nodes = nodeService.getAllNodes();
    }


//    public ArrayList<Connection> findBestRoute(Node startNode, Node endNode){
//
//    }




}
