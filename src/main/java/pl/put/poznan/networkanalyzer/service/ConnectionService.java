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
            if (c.getConnectionIndex().equals(index))
                return c;
        }
        return null;
    }

    public boolean updateConnection(Integer index, Connection connection) {
        for (Connection c : connections) {
            if (c.getConnectionIndex()== index) {
                c.setFrom(connection.getFrom());
                c.setTo(connection.getTo());
                c.setValue(connection.getValue());
                return true;  //updated
            }
        }
        return false; //not updated
    }

    public void addConnection(Connection connection) {
        connection.setConnectionIndex(connection.getUniqueIndexNumber());
        connections.add(connection);
    }

    public void deleteConnection(Integer index) {
        for (Connection c : connections) {
            if (c.getConnectionIndex() == index) {
                connections.remove(c);
                return;
            }

        }
    }

    public Connection getConnectionByNodes(Integer id1, Integer id2){
        Connection con = new Connection();
        con.setValue(-1);
        for(Connection c: connections){
            if(c.getFrom()==id1 && c.getTo()==id2){
                con = c;
            }
        }
        return con;
    }
}
