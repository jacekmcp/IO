package pl.put.poznan.networkanalyzer.model;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private Integer id;
    private String name;
    private String type;//entry/exit/regular - to może być String, czy coś innego?
    private ArrayList<Connection> outgoing = null;
    private ArrayList<Connection> incoming = null;


    public Node(Integer id, String name, String type, ArrayList<Connection> outgoing, ArrayList<Connection> incoming) {
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

    public Node() {}

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

    public ArrayList<Connection> getOutgoing() {
        return outgoing;
    }

    public void setOutgoing(ArrayList<Connection> outgoing) {
        this.outgoing = outgoing;
    }

    public ArrayList<Connection> getIncoming() {
        return incoming;
    }

    public void setIncoming(ArrayList<Connection> incoming) {
        this.incoming = incoming;
    }

    public void addIncoming(Connection connection){
        this.incoming.add(connection);
    }

    public void addOutgoing(Connection connection){
        this.outgoing.add(connection);
    }

    public void deleteIncoming(Connection connection){ // not sure if this construction works fine. it recognize object via reference, i guess. it's wrong TODO
        this.incoming.remove(connection);
    }

    public void deleteOutgoing(Connection connection){ // same as above
        this.outgoing.remove(connection);
    }
}
