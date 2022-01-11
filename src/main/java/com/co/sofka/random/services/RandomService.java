package com.co.sofka.random.services;

import com.co.sofka.random.documents.Random;
import com.co.sofka.random.dtos.RandomDTO;
import com.co.sofka.random.dtos.RequestListDTO;
import com.co.sofka.random.dtos.RequestRangeDTO;
import com.co.sofka.random.repositories.RandomRepository;
import com.co.sofka.random.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class RandomService {

    @Autowired
    RandomRepository repository;

    @Autowired
    MapperUtils mapperUtils;

    public Flux<RandomDTO> findAll(){
        return repository.findAll()
                .map(mapperUtils.mapEntityToRandomDTO());
    }

    public Mono<RandomDTO> generateByRange(RequestRangeDTO rangeDTO){
        Integer min = rangeDTO.getMin();
        Integer max = rangeDTO.getMax();

        String originalList = IntStream.range(min, max + 1)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));

        List<String> list = Stream.of(originalList.split(","))
                .collect(Collectors.toList());

        Collections.shuffle(list);

        String randomList = list.stream().collect(Collectors.joining(","));

        Random random = new Random();
        random.setMin(min);
        random.setMax(max);
        random.setDateTime(LocalDateTime.now());
        random.setOriginalList(originalList);
        random.setRandomList(randomList);

        return repository.save(random).map(mapperUtils.mapEntityToRandomDTO());
    }

    public Mono<RandomDTO> generateByList(RequestListDTO listDTO){

        return Mono.just(new Random()).map(entity -> {
            entity.setDateTime(LocalDateTime.now());
            entity.setOriginalList(listDTO.getList());
            return entity;
        }).map(entity -> {
            List<String> list = Stream.of(listDTO.getList().split(","))
                    .map(p -> p.trim())
                    .collect(Collectors.toList());

            Collections.shuffle(list);

            String randomList = list.stream().collect(Collectors.joining(","));
            entity.setRandomList(randomList);
            return entity;
        }).flatMap(random -> repository.save(random).map(mapperUtils.mapEntityToRandomDTO()));
    }


}
