package hypermedia.jax_rs.entity;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class Laptop {

    private long id;
    private String model;
    private int ram;
    private int hd;
    private int price;
    private Map<String, URI> links = new HashMap<>();

    public Laptop() {
    }

    public Laptop(long id, String model, int ram, int hd, int price) {
        this.id = id;
        this.model = model;
        this.ram = ram;
        this.hd = hd;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHd() {
        return hd;
    }

    public void setHd(int hd) {
        this.hd = hd;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Map<String, URI> getLinks() {
        return links;
    }

    public void setLinks(Map<String, URI> links) {
        this.links = links;
    }
}
