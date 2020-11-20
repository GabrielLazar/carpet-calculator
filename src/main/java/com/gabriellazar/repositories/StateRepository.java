package com.gabriellazar.repositories;

import com.gabriellazar.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface StateRepository extends JpaRepository<State,Integer> {
}
