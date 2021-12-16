package com.spec.demo;

public class Model {
    //!!!!!! These cannot be static! I spent a couple of hours trying to figure out why my models always returned the values of the last instantiation of Model. Because they were static!
    private final String type;
    private final String purpose;

    public Model(String type, String purpose) {
        this.type = type;
        this.purpose = purpose;
    }

    public String getType() {return type;}
//    public void setType(String type) {this.type = type;}

    public String getPurpose() {return purpose;}
//    public void setPurpose(String purpose) {this.purpose = purpose;}

    @Override
    public String toString() {
        return String.format("Model {" +
                "type = %s,%n" +
                "purpose = %s }%n", type, purpose);
    }
}
