package com.example.obrestdatajpa.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "books")
@ApiModel("Entidad libro para representar un libro")
public class Book {

    // atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Clave ficticia autoincremental tipo Long")
    private Long id;
    private String title;
    private String author;
    private Integer pages;
    @ApiModelProperty("Precio en rupias, con dos decimales utilizando . como separador")
    private Double price;
    private LocalDate releaseDate;
    private boolean online;

    // constructores

    public Book(){

    }

    public Book(Long id, String title, String author, Integer pages, Double price, LocalDate releaseDate, boolean online) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
        this.releaseDate = releaseDate;
        this.online = online;
    }

    // getter y setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }


    // toString

    @Override
    public String toString() {
        return "com.example.obrestdatajpa.entities.Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                ", online=" + online +
                '}';
    }
}
