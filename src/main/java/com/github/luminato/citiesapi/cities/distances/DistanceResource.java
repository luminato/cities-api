package com.github.luminato.citiesapi.cities.distances;


import com.github.luminato.citiesapi.cities.distances.services.DistanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;

@RestController
@RequestMapping("/distances")
public class DistanceResource {
    Logger log = LoggerFactory.getLogger(DistanceResource.class);

    private final DistanceService service;

    public DistanceResource(DistanceService service){
        this.service = service;
    }

   @GetMapping("/by-points")
    public ResponseEntity byPoints(@RequestParam(name = "from") final Long city1,
                                   @RequestParam(name = "to") final Long city2){
        log.info("byPoints");
        Double milhas = service.distanceByPointsInMiles(city1, city2);
        return ResponseEntity.ok().body("Distancia: "+milhas);

   }

    @GetMapping("/by-cube")
    public ResponseEntity byCube(@RequestParam(name = "from") final Long city1,
                         @RequestParam(name = "to") final Long city2) {
        log.info("byCube");
        Double metros = service.distanceByCubeInMeters(city1, city2);
        double km = metros/1000;
        DecimalFormat df = new DecimalFormat("0.00");
        df.setMaximumFractionDigits(2);
        return ResponseEntity.ok().body("Distância: " + df.format(km) + " km");
    }




}
