package com.example.demo.Controller;


import com.example.demo.models.Chofer;
import com.example.demo.services.ChoferService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chofer")
public class ChoferController {
    @Autowired
    private ChoferService cs;

    @PostMapping("")
    public ResponseEntity addChofer (@RequestBody final @NotNull Chofer c){
        return cs.addChofer(c);
    }

    @PostMapping("/{id}/update")
    public ResponseEntity updateChofer(@PathVariable final @NotNull Integer id, @RequestBody final  @NotNull Chofer c){
        return cs.updateChofer(id,c);
    }

    @GetMapping("/{id}")
    public Chofer getChofer(@PathVariable final @NotNull Integer id){
        return cs.getChofer(id);
    }


    @GetMapping("/getAll")
    public List<Chofer> getAll(){
        return cs.getAll();
    }


    @PostMapping("/{id}/delete")
    public ResponseEntity deleteChofer (@PathVariable final @NotNull Integer id){
        return cs.deleteChofer(id);
    }
}
