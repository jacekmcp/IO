package pl.put.poznan.networkanalyzer.model;

import java.util.ArrayList;
import java.util.Objects;

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

    public void clearPath(){
        this.path.clear();
    }

    public void addToPath(Integer val){
        this.path.add(val);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Path path1 = (Path) o;
        return Objects.equals(path, path1.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path);
    }
}