package com.co.sofka.random.utils;

import com.co.sofka.random.documents.Random;
import com.co.sofka.random.dtos.RandomDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperUtils {


    public Function<Random, RandomDTO> mapEntityToRandomDTO() {
        return entity -> new RandomDTO(
                entity.getId(),
                entity.getDateTime(),
                entity.getMin(),
                entity.getMax(),
                entity.getOriginalList(),
                entity.getRandomList()
        );
    }
}
