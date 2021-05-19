package com.github.luminato.citiesapi.states.repositories;

import com.github.luminato.citiesapi.states.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {

}
