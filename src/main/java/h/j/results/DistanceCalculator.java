package h.j.results;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class DistanceCalculator {
    private String []destination_addresses;
    private String []origin_addresses;
    private String status;
    private Rows[] rows;

    public String[] getDestination_addresses() {
        return destination_addresses;
    }

    public void setDestination_addresses(String[] destination_addresses) {
        this.destination_addresses = destination_addresses;
    }

    public String[] getOrigin_addresses() {
        return origin_addresses;
    }

    public void setOrigin_addresses(String[] origin_addresses) {
        this.origin_addresses = origin_addresses;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Rows[] getRows() {
        return rows;
    }

    public void setRows(Rows[] rows) {
        this.rows = rows;
    }

    @Override
    public String toString(){
        int i=1;
        String ro= " ";
        for (Rows rows:this.getRows() ) {
            ro += i+ ": " + rows.toString()+ " ";
            i++;
        };
        return ro;
    }
}
