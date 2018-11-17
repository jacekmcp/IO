package pl.put.poznan.networkanalyzer.Connection;

public class Connection {

    private int from;
    private int to;
    private int value;

    public Connection(int from, int to, int value){
         this.from=from;
         this.to=to;
         this.value=value;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
