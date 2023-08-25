package com.api_calculation.client;

import com.api_calculation.persistence.entity.Tank;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;



import java.util.List;
import java.util.Optional;


@FeignClient(name = "ms-infotank", url = "localhost:8001")
public interface TankClientRest {

    @GetMapping
    public List<Tank> findAll();


    @GetMapping("/tank/byId/{id}")
    public Optional<Tank> findById(@PathVariable("id") Long id);
}
