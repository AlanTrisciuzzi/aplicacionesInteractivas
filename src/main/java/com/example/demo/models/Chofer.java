package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
@Entity
public class Chofer {
    @Id
    private Integer id;
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;



/*
    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "chofer", joinColumns = @JoinColumn(name = "ID_B"), inverseJoinColumns = @JoinColumn(name = "ID_A"))
    private List<Auto> auto;

 */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "auto_id")
    private Auto auto;


}
