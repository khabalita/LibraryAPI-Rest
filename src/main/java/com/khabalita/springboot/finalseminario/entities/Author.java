package com.khabalita.springboot.finalseminario.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "authors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Author extends Base{

    @Column(name = "Name")
    private String name;
    @Column(name = "Lastname")
    private String lastName;
    @Column(name = "Nac")
    private String nationality;
    @JsonFormat(pattern = "yyyy-MM-dd") //formato para utilizar json
    @Column(name = "Birthdate")
    private Date birthdate;

}
