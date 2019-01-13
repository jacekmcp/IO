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
        if (isUnique(connection)){
        connection.setConnectionIndex(connection.getUniqueIndexNumber());
        connections.add(connection);
        }
        else{
            System.out.println("Trying to add already existing or self-connected connection: From "+ connection.getFrom() + " To " + connection.getTo()+ ". Operation not executed");
        }
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
        Connection con = new Connection(id1,id2,-1);
        con.setValue(-1);
        for(Connection c: connections){
            if(c.getFrom()==id1 && c.getTo()==id2){
                con = c;
            }
        }
        return con;
    }

    public boolean isUnique(Connection connection) {
        if (connection.getTo().equals(connection.getFrom())) return false;
        for (Connection c : connections) {
            if ((c.getFrom().equals(connection.getFrom()) && c.getTo().equals(connection.getTo()))) {
                return false;
            }}
        return true;}
}
