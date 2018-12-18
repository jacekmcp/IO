package pl.put.poznan.networkanalyzer.service;

import org.springframework.stereotype.Service;
import pl.put.poznan.networkanalyzer.model.Connection;
import java.util.ArrayList;

@Service
public class ConnectionService {

    private ArrayList<Connection> connections = new ArrayList<Connection>();

    public ArrayList<Connection> getAllConnections() {
        return connections;
    }


    public Connection getConnection(Integer index) {
        for (Connection c : connections) {
            if (c.getConnectionIndex() == index)
                return c;
        }
        return null;
    }

    public boolean updateConnection(Integer index, Connection connection) {
        for (Connection c : connections) {
            if (c.getConnectionIndex() == index) {
                c.setFrom(connection.getFrom());
                c.setTo(connection.getTo());
                c.setValue(connection.getValue());
                return true;
            }
        }
        return false;
    }

    public void addConnection(Connection connection) {
        connection.setConnectionIndex(connection.getUniqueIndexNumber());
        connections.add(connection);
    }

    public void deleteConnection(Integer index) {
        for (Connection c : connections) {
            if (c.getConnectionIndex() == index) {
                connections.remove(c);
            }
        }
    }
}
