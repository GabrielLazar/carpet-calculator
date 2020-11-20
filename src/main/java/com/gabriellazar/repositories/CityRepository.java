package com.gabriellazar.repositories;

import com.gabriellazar.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface CityRepository extends JpaRepository<City,Integer> {

    Optional<City> findByCityName(String name);
}
