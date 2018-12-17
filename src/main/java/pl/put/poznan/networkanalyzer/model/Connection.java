package pl.put.poznan.networkanalyzer.model;

public class Connection {


    /**
     * @param index unique index defining every Connection
     * @param from Node object - source of the Connection
     * @param to Node object - destination of the Connection
     * @param value given value of a Connection
     * @return
     */
    private static Integer indexNumber =0;
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

    public static Integer getIndexNumber() {
        return indexNumber;
    }

    public static Integer getIndexNumberToAddConnection() {
        return indexNumber++;
    }

    public static void setIndexNumber(Integer indexNumber) {
            Connection.indexNumber = indexNumber;
    }

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

