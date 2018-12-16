package pl.put.poznan.networkanalyzer.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.networkanalyzer.model.Connection;
import pl.put.poznan.networkanalyzer.model.Node;
import pl.put.poznan.networkanalyzer.service.NetAnalService;

import java.util.ArrayList;

@RestController
@RequestMapping("/net-anal")
public class NetAnalController {

    private final
    NetAnalService netAnalService;


    @Autowired
    public NetAnalController(NetAnalService netAnalService) {
        this.netAnalService = netAnalService;
    }

    @GetMapping("/{id1}/{id2}")
    public ArrayList<Node> searchGraph(@PathVariable("id1") Integer id1, @PathVariable("id2") Integer id2){
        return netAnalService.findBestRoute(id1, id2);
    }


}
