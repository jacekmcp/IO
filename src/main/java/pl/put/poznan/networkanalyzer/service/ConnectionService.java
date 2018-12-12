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
    

    public Connection getConnection(Integer index){
        for(Connection c:connections) {
            if(c.getIndex()==index)
                return c;}
        return null;
    }

    public boolean updateConnection(Integer index, Connection connection){
        for(Connection c: connections)
        {
            if(c.getIndex()==index) {
                c.setFrom(connection.getFrom());
                c.setTo(connection.getTo());
                c.setValue(connection.getValue());
                return true;
            }
        }
        return false;
    }

    public void addConnection(Connection connection){
        connections.add(connection);
    }

    public void deleteConnection(Integer index) {
        for(Connection c: connections) {
            if(c.getIndex()==index) {
            connections.remove(c);}
        }
    }

    public void addListOfConnections(List<Connection> connectionsList) {
        for(Connection c: connectionsList){
            connections.add(c);
            c.setIndex(connections.indexOf(c));
        }
    }
}
