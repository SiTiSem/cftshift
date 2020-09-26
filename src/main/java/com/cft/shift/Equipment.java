package com.cft.shift;

import javax.persistence.*;

@Entity
@Table(name = "EQUIPMENT")
public class Equipment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private Long     id;

    private int     article;
    private String  manufacturer;

    private int     price;
    private int     number;

    public Equipment(){}

    public Equipment(int article, String manufacturer, int price, int number) {
        this.article = article;
        this.manufacturer = manufacturer;
        this.price = price;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setArticle(int article) {
        this.article = article;
    }

    public int getArticle() {
        return article;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getManufacturer() {
        return manufacturer;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
}

@Entity
@Table(name = "COMPUTER")
class Computer extends Equipment {

    private int formFactor; // 0 - десктопы, 1 - неттопы, 2 - моноблоки

    public Computer(){}

    public Computer(int article, String manufacturer, int price, int number, int formFactor) {
        super(article, manufacturer, price, number);
        this.formFactor = formFactor;
    }

    @Override
    public String toString() {
        return String.format(
                "Computer[formFactor='%s']",
                formFactor);
    }

    public void setFormFactor(int formFactor) {
        this.formFactor = formFactor;
    }
    public int getFormFactor() {
        return formFactor;
    }
}

@Entity
@Table(name = "NOTEBOOK")
class Notebook extends Equipment {

    private int size; // 13, 14, 15, 17 дюймовые

    public Notebook() {};

    public Notebook(int article, String manufacturer, int price, int number, int size) {
        super(article, manufacturer, price, number);
        this.size = size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public int getSize() {
        return size;
    }
}

@Entity
@Table(name = "MONITOR")
class Monitor extends Equipment {

    private int diagonal; // диагональ

    public Monitor(){};

    public Monitor(int article, String manufacturer, int price, int number, int diagonal) {
        super(article, manufacturer, price, number);
        this.diagonal = diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }
    public int getDiagonal() {
        return diagonal;
    }

}

@Entity
@Table(name = "DISK")
class Disk extends Equipment {

    private int size; // размер диска

    public Disk(){};

    public Disk(int article, String manufacturer, int price, int number, int size) {
        super(article, manufacturer, price, number);
        this.size = size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public int getSize() {
        return size;
    }

}