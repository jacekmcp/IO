package pl.put.poznan.networkanalyzer.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.networkanalyzer.model.Path;
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

    @GetMapping("/bfs/{id1}/{id2}")
    public Path getBFS(@PathVariable("id1") Integer id1, @PathVariable("id2") Integer id2){
        return netAnalService.findBestRoute(id1,id2,"BFS");
    }

    @GetMapping("/dfs/{id1}/{id2}")
    public Path getDFS(@PathVariable("id1") Integer id1, @PathVariable("id2") Integer id2){
        return netAnalService.findBestRoute(id1,id2,"DFS");
    }

}
