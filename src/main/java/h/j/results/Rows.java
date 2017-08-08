package h.j.results;

public class Rows {
    public Elements[] getElements() {
        return elements;
    }

    public void setElements(Elements[] elements) {
        this.elements = elements;
    }

    private Elements[] elements;

    @Override
public String toString(){
    String el="";
        for (Elements element:this.getElements()) {
           el +=element.toString();
        }
        return el;
    }
}