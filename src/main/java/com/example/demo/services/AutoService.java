package com.example.demo.services;


import com.example.demo.models.Auto;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.repository.AutoRepository;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;

import static org.springframework.http.HttpStatus.*;

@Service
public class AutoService {

    private final AutoRepository ar;


    private ArrayList<Auto> lista;
    @Autowired
    public AutoService(AutoRepository ar){
        this.ar = ar;
    }


    public ResponseEntity addAuto (Auto auto){
        // Coneccion a la base de datos
        try{
            ar.save(auto);
            return ResponseEntity.status(CREATED).build();
        } catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    public Auto getAuto(int id){
        return ar.findById(id).orElseThrow(() -> new HttpClientErrorException(BAD_REQUEST, "Auto no encontrado"));
    }

    /* GET AUTO POR ID
        for (int i = 0; i < lista.size(); i ++){
            Autos a = lista.get(i);
            if (a.getId() == id){
                return a;
            }
        }*/

    public ArrayList<Auto> getAll() { // Enviar a la base de datos
        return (ArrayList<Auto>) ar.findAll();
    }


    public ResponseEntity deleteAuto(int id) {
        try {
            ar.deleteById(id);
            return ResponseEntity.status(OK).build();
        } catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity updateAuto(@NotNull Integer id, Auto auto){
        try {
            Auto a = ar.findById(id).orElseThrow(()-> new HttpClientErrorException(BAD_REQUEST, "Auto no encontrado"));
            a.setId(auto.getId());
            a.setColor(auto.getColor());
            a.setMarca(auto.getMarca());
            a.setPrecio(auto.getPrecio());
            ar.save(a);
            return ResponseEntity.status(OK).build();
        } catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

}
