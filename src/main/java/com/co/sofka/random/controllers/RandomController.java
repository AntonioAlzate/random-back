package com.co.sofka.random.controllers;

import com.co.sofka.random.dtos.RandomDTO;
import com.co.sofka.random.dtos.RequestListDTO;
import com.co.sofka.random.dtos.RequestRangeDTO;
import com.co.sofka.random.services.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
public class RandomController {

    @Autowired
    private RandomService randomService;

    @GetMapping
    public Flux<RandomDTO> getAll(){
        return randomService.findAll();
    }

    @PostMapping("/range")
    public Mono<RandomDTO> generateByRange(@RequestBody RequestRangeDTO rangeDTO){
        return randomService.generateByRange(rangeDTO);
    }

    @PostMapping("/list")
    public Mono<RandomDTO> generateByList(@RequestBody RequestListDTO listDTO){
        return randomService.generateByList(listDTO);
    }
}
