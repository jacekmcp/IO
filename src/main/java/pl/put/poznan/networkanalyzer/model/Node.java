package pl.put.poznan.networkanalyzer.model;

import pl.put.poznan.networkanalyzer.model.Connection;

import java.util.List;

public class Node {

    private String id;
    private String name;
    private String type;//entry/exit/regular - to może być String, czy coś innego?
    private List<Connection> outgoing = null;
    private List<Connection> incoming = null;


    public Node(String id, String name, String type, List<Connection> outgoing, List<Connection> incoming) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.outgoing = outgoing;
        this.incoming = incoming;
    }

    public Node(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Node() {    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public List<Connection> getOutgoing() {
        return outgoing;
    }

    public void setOutgoing(List<Connection> outgoing) {
        this.outgoing = outgoing;
    }

    public List<Connection> getIncoming() {
        return incoming;
    }

    public void setIncoming(List<Connection> incoming) {
        this.incoming = incoming;
    }
}
