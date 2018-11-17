package pl.put.poznan.networkanalyzer.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

public class ConnectionController {

    @Autowired
    private ConnectionService connectionService;

    @RequestMapping("/connections")
    public List<Connection> getAllConnections() {
        return connectionService.getAllConnections();
    }

    @RequestMapping(value="/connections", method= RequestMethod.POST)
    public void savePerson(@RequestBody ConnectionService service) {
        for (Connection connection: service.getAllConnections()) {
            connectionService.addConnection(connection);
        }
    }
}
