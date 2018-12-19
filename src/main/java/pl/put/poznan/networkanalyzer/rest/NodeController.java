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

    @GetMapping("/{id}")
    public Node getOneNode(@PathVariable Integer id){
        return nodeService.getOneNode(id);
    }

    @GetMapping
    public List<Node> getAllNodes(){
        return nodeService.getAllNodes();
    }

    @PostMapping
    public void addNode(@RequestBody Node n){nodeService.addNode(n);}

    @PutMapping("/{id}")
    public void updateNode(@PathVariable Integer id, @RequestBody Node n){nodeService.updateNode(id,n);}

    @DeleteMapping("/{id}")
    public void deleteNode(@PathVariable Integer id){ nodeService.deleteNode(id);}

    @PostMapping("/list")
    public void addListNode(@RequestBody List<Node> nodes){
        for(Node item:nodes){
            nodeService.addNode(item);
        }
    }

}
