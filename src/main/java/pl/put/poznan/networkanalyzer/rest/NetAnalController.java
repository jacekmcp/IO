package pl.put.poznan.networkanalyzer.rest;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class NetAnalController {

    @RequestMapping("/dupa")
    public String dupa(){
        return "dupa ramona";

    }


}
