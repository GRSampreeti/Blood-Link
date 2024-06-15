package com.example.MP1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.bson.types.ObjectId;

import java.util.List;

@RestController
@RequestMapping("/api/reciver")
public class ReciverController {


    @Autowired
    private  ReciverService reciverService;

    @GetMapping
    public List<Reciver> getAllRecivers() {
        return reciverService.getAllRecivers();
    }

    @PostMapping
    public Reciver createReciver(@RequestBody Reciver reciver) {
        return reciverService.saveReciver(reciver);
    }

    @DeleteMapping("/{id}")
    public void deleteReciver(@PathVariable ObjectId id) {
        reciverService.deleteReciver(id);
    }

}
