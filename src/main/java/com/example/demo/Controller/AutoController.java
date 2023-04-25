package com.example.demo.Controller;

import com.example.demo.models.Auto;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.AutoService;

import java.util.List;

@RestController
@RequestMapping("/auto")
public class AutoController {
    @Autowired
    private AutoService as;

    @PostMapping("/addAuto")
    public ResponseEntity addAuto(@RequestBody final @NotNull Auto a){
        return as.addAuto(a);
    }

    @PostMapping("/{id}/update")
    public ResponseEntity updateAuto(@PathVariable final @NotNull Integer id, @RequestBody final  @NotNull Auto a){
        return as.updateAuto(id,a);
    }

    @GetMapping("/{id}")
    public Auto getAuto(@PathVariable final @NotNull Integer id){
        return as.getAuto(id);
    }


    @GetMapping("/getAll")
    public List<Auto> getAll(){
        return as.getAll();
    }


    @PostMapping("/{id}/delete")
    public ResponseEntity deleteAuto (@PathVariable final @NotNull Integer id){
        return as.deleteAuto(id);
    }

}
