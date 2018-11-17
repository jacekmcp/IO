package pl.put.poznan.networkanalyzer.Connection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConnectionService {

    private List<Connection> Connections;

    public List<Connection> getAllConnections() {
        return Connections;
    }

    public void setConnections(List<Connection> connections) {
        Connections = connections;
    }

    public void addConnection(Connection connection){
        Connections.add(connection);
    }
}
