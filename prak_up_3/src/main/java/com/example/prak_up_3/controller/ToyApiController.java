package com.example.prak_up_3.controller;

import com.example.prak_up_3.model.ToyModel;
import com.example.prak_up_3.service.ToyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/toys")

public class ToyApiController {
    private final ToyService toyService;

    public ToyApiController(ToyService toyService) {
        this.toyService = toyService;
    }

    @GetMapping
    public List<ToyModel> getAllToys() {
        return toyService.findAllToys();
    }

    @PostMapping
    public ToyModel createToy(@RequestBody ToyModel toy) {
        return toyService.createToy(toy);
    }

    @PutMapping("/{id}")
    public ToyModel updateToy(@PathVariable Long id, @RequestBody ToyModel toy) {
        toy.setId(id);
        return toyService.updateToy(toy);
    }

    @DeleteMapping("/{id}")
    public void deleteToy(@PathVariable Long id) {
        toyService.deleteToy(id);
    }
}
