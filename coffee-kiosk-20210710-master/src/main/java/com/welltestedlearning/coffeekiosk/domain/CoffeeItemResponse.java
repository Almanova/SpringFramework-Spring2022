package com.welltestedlearning.coffeekiosk.domain;

public class CoffeeItemResponse {
    private long id;
    private String size;
    private String kind;
    private String creamer;
    private String price;

    public CoffeeItemResponse() {

    }

    public CoffeeItemResponse(long id, String size, String kind, String creamer, String price) {
        this.id = id;
        this.size = size;
        this.kind = kind;
        this.creamer = creamer;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getCreamer() {
        return creamer;
    }

    public void setCreamer(String creamer) {
        this.creamer = creamer;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public static CoffeeItemResponse from(CoffeeItem coffeeItem) {
        return new CoffeeItemResponse(coffeeItem.getId(), coffeeItem.size(),
                coffeeItem.kind(), coffeeItem.creamer(), "20.34");
    }
}
