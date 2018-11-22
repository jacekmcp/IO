package pl.put.poznan.networkanalyzer.rest;

import org.springframework.web.bind.annotation.*;
import pl.put.poznan.networkanalyzer.service.NodeService;
import pl.put.poznan.networkanalyzer.model.Node;

import java.util.List;

@RestController
@RequestMapping("/node")
public class NodeController {

//    @Autowired
//    private NodeService nodeService;

    private NodeService nodeService;

    @GetMapping
    public List<Node> getAllNodes(){
        return nodeService.getAllNodes();
    }

    @GetMapping("/{id}")
    public Node getOneNode(@PathVariable String id){
        return nodeService.getOneNode(id);
    }

    @PostMapping
    public void addNode(@RequestBody Node n){nodeService.addNode(n);}

    @PutMapping("/{id}")
    public void updateNode(@PathVariable String id, @RequestBody Node n){nodeService.updateNode(id,n);}

    @DeleteMapping("/{id}")
    public void deleteNode(@PathVariable String id){ nodeService.deleteNode(id);}


}
