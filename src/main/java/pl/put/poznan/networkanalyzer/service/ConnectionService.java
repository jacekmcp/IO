package pl.put.poznan.networkanalyzer.service;


import org.springframework.stereotype.Service;
import pl.put.poznan.networkanalyzer.model.Connection;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConnectionService {

    private List<Connection> connections = new ArrayList<Connection>();

    public List<Connection> getAllConnections() {
        return connections;
    }

    public void setConnections(List<Connection> connections) {
        connections = connections;
    }

    public Connection getConnection(String from, String to){
        for(Connection c:connections) {
            if(c.getTo().getId().equals(to) && c.getFrom().getId().equals(from))
                return c;}
        return null;
    }

    public void updateConnection(String from, String to, Connection connection){
        for(Connection c: connections)
        {
            if(c.getFrom().getId().equals(from) && c.getTo().getId().equals(to))
                c.updateConnection(connection.getFrom(), connection.getTo(), connection.getValue());
        }
    }

    public void addConnection(Connection connection){
        connections.add(connection);
    }
}
