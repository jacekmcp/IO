package pl.put.poznan.networkanalyzer.model;

public class Connection {

    private Integer index;
    private Node from;
    private Node to;
    private Integer value;

    public Connection(Node from, Node to, Integer value ){
        this.from=from;
        this.to=to;
        this.value=value;
    }
    public Connection(){}

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Node getFrom() {
        return from;
    }

    public void setFrom(Node from) {
        this.from = from;
    }

    public Node getTo() {
        return to;
    }

    public void setTo(Node to) {
        this.to = to;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void updateConnection(Node from, Node to, Integer value)
    {
        this.from=from;
        this.to=to;
        this.value=value;
    }
}

