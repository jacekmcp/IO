package pl.put.poznan.networkanalyzer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.networkanalyzer.service.NodeService;
import pl.put.poznan.networkanalyzer.model.Node;

import java.util.List;

/**
 * Controller for nodeService.
 * @see NodeService
 * @author Michal Kukiela
 */
@RestController
@RequestMapping("/node")
public class NodeController {

    private final NodeService nodeService;

    @Autowired
    public NodeController(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    @GetMapping
    public List<Node> getAllNodes(){
        return this.nodeService.getAllNodes();
    }

    @GetMapping("/{id}")
    public Node getOneNode(@PathVariable int id){
        return this.nodeService.getOneNode(id);
    }

    @PostMapping
    public void addNode(@RequestBody Node n){this.nodeService.addNode(n);}

    @PutMapping("/{id}")
    public void updateNode(@PathVariable int id, @RequestBody Node n){this.nodeService.updateNode(id,n);}

    @DeleteMapping("/{id}")
    public void deleteNode(@PathVariable int id){ this.nodeService.deleteNode(id);}
}
