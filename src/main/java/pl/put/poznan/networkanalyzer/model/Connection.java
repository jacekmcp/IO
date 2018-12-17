package pl.put.poznan.networkanalyzer.model;

public class Connection {


    /**
     * @param index unique index defining every Connection (starts with 0) tak startuje od zera i jest unikalne jak twoja stara xD
     * @param from Node object - source of the Connection
     * @param to Node object - destination of the Connection
     * @param value given value of a Connection
     * @return
     */

    private Integer index;
    private Integer from;
    private Integer to;
    private Integer value;

    public Connection(Integer from, Integer to, Integer value ){
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

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void updateConnection(Integer from, Integer to, Integer value)
    {
        this.from=from;
        this.to=to;
        this.value=value;
    }
}

