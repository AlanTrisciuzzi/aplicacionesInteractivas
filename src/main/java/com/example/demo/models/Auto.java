package com.example.demo.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Data
@AllArgsConstructor
@Entity
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Integer id;
    private Double precio;
    private String color;
    private String marca;



/* Esta coneccion se deberia usar si tuviera coneccion de muchos a muchos
    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "auto", joinColumns = @JoinColumn(name = "ID_A"), inverseJoinColumns = @JoinColumn(name = "ID_B"))
    private List<Chofer> chofer;
*/

    @OneToMany(mappedBy = "auto")
    @JsonIgnore // Obligatorio poner el JsonIgnore en la clase principal
    private List<Chofer> chofer;







}
