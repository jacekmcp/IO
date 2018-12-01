package pl.put.poznan.networkanalyzer.rest;

import org.springframework.web.bind.annotation.*;
import pl.put.poznan.networkanalyzer.model.Connection;
import pl.put.poznan.networkanalyzer.service.ConnectionService;

import java.util.List;

@RestController
@RequestMapping("/connection")
public class ConnectionController {

   // @Autowired
    private ConnectionService connectionService;

    @GetMapping
    public List<Connection> getAllConnections() {return connectionService.getAllConnections();}

    @PostMapping
    public void addConnection(@RequestBody Connection connection){connectionService.addConnection(connection);
    }

//    @PostMapping
//    public void LoadConnections(@RequestBody ConnectionService service) {
//        for (Connection connection: service.getAllConnections()) {
//            connectionService.addConnection(connection);
//        }
//    }
//    @PutMapping
//    public void updateConnection()


}
