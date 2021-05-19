package com.github.luminato.citiesapi.countries.repositories;

import com.github.luminato.citiesapi.countries.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
