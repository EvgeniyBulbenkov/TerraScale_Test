package ru.bugred.shop.RestApi.entities;

import java.io.Serializable;

public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    int id;
    String name;
    String section;
    String description;
    String color;
    String[] size;
    double prize;
    String params;
    String photo;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSection() {
        return section;
    }

    public String getDescription() {
        return description;
    }

    public String getColor() {
        return color;
    }

    public String[] getSize() {
        return size;
    }

    public double getPrize() {
        return prize;
    }

    public String getParams() {
        return params;
    }

    public String getPhoto() {
        return photo;
    }


    private Product(Builder builder) {
        this.id = builder.id;
         this.name = builder.name;
         this.section = builder.section;
         this.description = builder.description;
         this.color = builder.color;
         this.size = builder.size;
         this.prize = builder.prize;
         this.params = builder.params;
         this.photo = builder.photo;

    }

    public static class Builder {
        int id;
        String name;
        String section;
        String description;
        String color;
        String[] size;
        double prize;
        String params;
        String photo;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSection(String section) {
            this.section = section;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setSize(String[] size) {
            this.size = size;
            return this;
        }

        public Builder setPrize(double prize) {
            this.prize = prize;
            return this;
        }

        public Builder setParams(String params) {
            this.params = params;
            return this;
        }

        public Builder setPhoto(String photo) {
            this.photo = photo;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
