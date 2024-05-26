package com.khabalita.springboot.finalseminario.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name ="books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
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

    @ManyToOne  //muchos libros tienen un editorial
    @JoinColumn(name = "editorial_id")
    private Editorial editorial;

    @ManyToMany   //muchos libros pueden pertenecer a una o mas categorias
    @JoinTable(
            name = "book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> category;
}
