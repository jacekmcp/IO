package pl.put.poznan.networkanalyzer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.networkanalyzer.Service.NodeService;
import pl.put.poznan.networkanalyzer.model.Node;

import java.util.List;

@RestController
public class NodeController {

    private NodeService nodeService;

    @RequestMapping("/nodes")
    public List<Node> getAllNodes(){
        return this.nodeService.getAllNodes();
    }

    @RequestMapping("/nodes/{id}")
    public Node getOneNode(@PathVariable String id){
        return this.nodeService.getOneNode(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/nodes")
    public void addNode(@RequestBody Node n){this.nodeService.addNode(n);}

    @RequestMapping(method = RequestMethod.PUT, value = "/nodes/{id}")
    public void updateNode(@PathVariable String id, @RequestBody Node n){this.nodeService.updateNode(id,n);}

    @RequestMapping(method = RequestMethod.DELETE, value = "/nodes/{id}")
    public void deleteNode(@PathVariable String id){ this.nodeService.deleteNode(id);}


}
