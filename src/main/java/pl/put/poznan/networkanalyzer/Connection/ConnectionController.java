package pl.put.poznan.networkanalyzer.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ConnectionController {

    @Autowired
    private ConnectionService connectionService;

    @RequestMapping("/connections")
    public List<Connection> getAllConnections() {
        Connection connection1 = new Connection(1,2,3);     //tests
        connectionService.addConnection(connection1);
        return connectionService.getAllConnections();
    }

    @RequestMapping(method= RequestMethod.POST, value="/connections")
    public void LoadConnections(@RequestBody ConnectionService service) {
        for (Connection connection: service.getAllConnections()) {
            connectionService.addConnection(connection);
        }
    }
    @RequestMapping(method = RequestMethod.POST, value="/connections")
    public void addConnection(@RequestBody Connection connection){
        connectionService.addConnection(connection);
    }

}
