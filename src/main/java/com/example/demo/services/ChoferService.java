package com.example.demo.services;

import com.example.demo.models.Chofer;
import com.example.demo.repository.ChoferRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;

import static org.springframework.http.HttpStatus.*;

@Service
public class ChoferService {
    private final ChoferRepository cr;

  //  private ArrayList<Chofer> lista;

    @Autowired
    public ChoferService(ChoferRepository cr) {this.cr = cr;}


    public ResponseEntity addChofer(Chofer chofer){
        // Coneccion con la base
        try{
            cr.save(chofer);
            return ResponseEntity.status(CREATED).build();
        } catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    public Chofer getChofer (int id){
        return cr.findById(id).orElseThrow(()-> new HttpClientErrorException(BAD_REQUEST, "Chofer no encontrado"));
    }

    public ArrayList<Chofer> getAll() { // Enviar a la base de datos
        return (ArrayList<Chofer>) cr.findAll();
    }

    public ResponseEntity deleteChofer(int id) {
        try {
            cr.deleteById(id);
            return ResponseEntity.status(OK).build();
        } catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity updateChofer(@NotNull Integer id, Chofer chofer){
        try {
            Chofer c = cr.findById(id).orElseThrow(()-> new HttpClientErrorException(BAD_REQUEST, "Auto no encontrado"));
            c.setId(chofer.getId());
            c.setNombre(chofer.getNombre());
            c.setApellido(chofer.getApellido());
            c.setDni(chofer.getDni());
            c.setEdad(chofer.getEdad());
            cr.save(c);
            return ResponseEntity.status(OK).build();
        } catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }



}
