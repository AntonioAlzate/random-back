package com.co.sofka.random.repositories;

import com.co.sofka.random.documents.Random;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RandomRepository extends ReactiveCrudRepository<Random, String > {
}
