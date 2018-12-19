package pl.put.poznan.networkanalyzer.model;

import java.util.ArrayList;

public class Path{
    ArrayList<Integer> path;
    Integer cost;

    public Path(ArrayList<Integer> path, Integer cost) {
        this.path = path;
        this.cost = cost;
    }

    public Path(){
        this.path = new ArrayList<>();
        this.cost = 0;
    }

    public ArrayList<Integer> getPath() {
        return path;
    }

    public void setPath(Integer path) {
        this.path.add(path);
    }

    public void setFullPath(ArrayList<Integer> path){
        this.path = path;
    }

    public void setFullCost(Integer cost){
        this.cost = cost;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost += cost;
    }
}