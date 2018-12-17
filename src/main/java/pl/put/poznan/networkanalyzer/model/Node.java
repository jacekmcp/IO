package pl.put.poznan.networkanalyzer.model;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private Integer id;
    private String name;
    private String type;//entry/exit/regular - to może być String, czy coś innego?
    private ArrayList<Integer> outgoing = null;
    private ArrayList<Integer> incoming = null;

    public Node(){}

    public Node(Integer id, String name, String type, ArrayList<Integer> outgoing, ArrayList<Integer> incoming) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.outgoing = outgoing;
        this.incoming = incoming;
    }

    public Node(Integer id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Integer> getOutgoing() {
        return outgoing;
    }

    public void setOutgoing(ArrayList<Integer> outgoing) {
        this.outgoing = outgoing;
    }

    public ArrayList<Integer> getIncoming() {
        return incoming;
    }

    public void setIncoming(ArrayList<Integer> incoming) {
        this.incoming = incoming;
    }

    public void addIncoming(Integer connection){
        this.incoming.add(connection);
    }

    public void addOutgoing(Integer connection){
        this.outgoing.add(connection);
    }

    public void deleteIncoming(Connection connection){ // not sure if this construction works fine. it recognize object via reference, i guess. it's wrong TODO
        this.incoming.remove(connection);
    }

    public void deleteOutgoing(Connection connection){ // same as above
        this.outgoing.remove(connection);
    }
}
