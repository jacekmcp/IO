package pl.put.poznan.networkanalyzer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.networkanalyzer.rest"})
public class NetworkAnalyzerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetworkAnalyzerApplication.class, args);
    }
}

//Kukson test commit
//Jacek test commit