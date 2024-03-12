package com.khabalita.springboot.finalseminario.entities;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Table(name ="books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Book extends Base{

    @Column(name = "ISBN")
    private String ISBN;
    @Column(name = "Title")
    private String title;
    @Column(name = "Subtitle")
    private String subTitle;
    @Column(name = "Edition")
    private Long edition;

    @ManyToOne  //muchos libros tienen un autor
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne  //muchos libros tiene un editorial
    @JoinColumn(name = "editorial_id")
    private Editorial editorial;

    @ManyToMany   //muchos libro pueden pertenecer a una o varias categorias
    @JoinTable(
            name = "book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> category;
}
