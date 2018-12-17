package pl.put.poznan.networkanalyzer.rest;

import org.springframework.web.bind.annotation.*;
import pl.put.poznan.networkanalyzer.model.Connection;
import pl.put.poznan.networkanalyzer.service.ConnectionService;
import pl.put.poznan.networkanalyzer.service.NodeService;

import java.util.List;

@RestController
@RequestMapping("/connection")
public class ConnectionController {


    private final ConnectionService connectionService;

    private final NodeService nodeService;

    public ConnectionController(ConnectionService connectionService, NodeService nodeService) {
        this.connectionService = connectionService;
        this.nodeService = nodeService;
    }


    @GetMapping
    public List<Connection> getAllConnections() {
        return connectionService.getAllConnections();
    }

    @GetMapping("/{id}")
    public Connection getConnection(@PathVariable String id) {
        return connectionService.getConnection(Integer.parseInt(id));
    }

    @PostMapping
    public void addConnection(@RequestBody Connection connection){
        connectionService.addConnection(connection);
        nodeService.setIO(connection);
//        connection.setIndex(connectionService.getAllConnections().indexOf(connection)); //no czegos takwigo to ja dawno nie widzialem xD
    }

    @PutMapping("/{id}")
    public String updateConnection(@PathVariable String id, @RequestBody Connection connection){
        if(!connectionService.updateConnection(Integer.parseInt(id), connection)){  //jeśli nie został znaleziony indeks, wykonuje się if
            return "index not found";
        }
        return "connection updated";
    }

    @DeleteMapping("/{id}")
    public void deleteConnection(@PathVariable String id){
        connectionService.deleteConnection(Integer.parseInt(id));
    }

    @PostMapping("/list")
    public void addListOfConnections(@RequestBody List<Connection> connections){
        for (Connection c : connections) {
            connectionService.addConnection(c);
            nodeService.setIO(c);
        }
    }

}
