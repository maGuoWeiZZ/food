package com.food.po;

public class Foods {

    private Integer id;
    private String name;
    private String type;
    private Double price;
    private String state;
    private Integer monthCount;
    private String imgPath;

    public Foods() {
    }

    public Foods(Integer id) {
        this.id = id;
    }

    public Foods(Integer id, String name, String type, Double price, String state, Integer monthCount, String imgPath) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.state = state;
        this.monthCount = monthCount;
        this.imgPath = imgPath;
    }

    public Foods(String name, String type, Double price, String state, Integer monthCount, String imgPath) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.state = state;
        this.monthCount = monthCount;
        this.imgPath = imgPath;
    }

    public Foods(Integer id,String name, String type, Double price, String state, Integer monthCount) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.state = state;
        this.monthCount = monthCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getMonthCount() {
        return monthCount;
    }

    public void setMonthCount(Integer monthCount) {
        this.monthCount = monthCount;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "Foods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", state='" + state + '\'' +
                ", monthCount=" + monthCount +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
