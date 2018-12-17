package pl.put.poznan.networkanalyzer.service;


import org.springframework.stereotype.Service;
import pl.put.poznan.networkanalyzer.model.Connection;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConnectionService {

    private ArrayList<Connection> connections = new ArrayList<Connection>();
    private NodeService nodeService = new NodeService();


    public ArrayList<Connection> getAllConnections() {
        return connections;
    }


    public Connection getConnection(Integer index) {
        for (Connection c : connections) {
            if (c.getIndex() == index)
                return c;
        }
        return null;
    }

    public boolean updateConnection(Integer index, Connection connection) {
        for (Connection c : connections) {
            if (c.getIndex() == index) {
                c.setFrom(connection.getFrom());
                c.setTo(connection.getTo());
                c.setValue(connection.getValue());
                return true;
            }
        }
        return false;
    }

    public void addConnection(Connection connection) {
        connection.setIndex(this.getUniqId());
        connections.add(connection);
    }

    public void deleteConnection(Integer index) {
        for (Connection c : connections) {
            if (c.getIndex() == index) {
                connections.remove(c);
            }
        }
    }


    private int getUniqId() {
        int max = -1;

        for (Connection connection : connections) {
            if (connection.getIndex() > max) max = connection.getIndex();
        }

        return max + 1;
    }

}
